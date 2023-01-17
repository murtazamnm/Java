package genalg;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static java.util.stream.Stream.generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenAlg {
	private static char genRndChar() {
		return (char)ThreadLocalRandom.current().nextInt('a', 'z');
	}

	public static void main(String[] args) {
		var hiddenText = "abcdefgh";

		Function<String, Integer> fitnessValue = txt ->
			IntStream.range(0, hiddenText.length())
			.map(i -> txt.charAt(i) == hiddenText.charAt(i) ? -1 : 0)
			.sum();

		String bestEntity = GenAlg.genalgV2(10, 200, 3, 20, 6,
			() -> IntStream.range(0, hiddenText.length())
					.mapToObj(i -> "" + genRndChar())
					.collect(Collectors.joining()),
			(txt1, txt2) ->
				IntStream.range(0, hiddenText.length())
					.mapToObj(i -> "" + (ThreadLocalRandom.current().nextBoolean() ? txt1.charAt(i) : txt2.charAt(i)))
					.collect(Collectors.joining()),
			txt ->
				IntStream.range(0, hiddenText.length())
				.mapToObj(i -> "" + (ThreadLocalRandom.current().nextInt(100) == 0 ? genRndChar() : txt.charAt(i)))
				.collect(Collectors.joining()),
			fitnessValue
			);

		System.out.println(fitnessValue.apply(bestEntity) + " " + bestEntity);
	}

	public static void main2(String[] args) {
		var hiddenText = "abcdefgh";

		GenAlg.genalg(10, 20, 3, 20, 6,
			() -> IntStream.range(0, hiddenText.length())
					.mapToObj(i -> "" + genRndChar())
					.collect(Collectors.joining()),
			(txt1, txt2) ->
				IntStream.range(0, hiddenText.length())
					.mapToObj(i -> "" + (ThreadLocalRandom.current().nextBoolean() ? txt1.charAt(i) : txt2.charAt(i)))
					.collect(Collectors.joining()),
			txt ->
				IntStream.range(0, hiddenText.length())
				.mapToObj(i -> "" + (ThreadLocalRandom.current().nextInt(100) == 0 ? genRndChar() : txt.charAt(i)))
				.collect(Collectors.joining()),
			txt ->
				IntStream.range(0, hiddenText.length())
				.map(i -> txt.charAt(i) == hiddenText.charAt(i) ? -1 : 0)
				.sum()
			);
	}

	public static <Entity> Entity genalgV2(
			int entityCount,
			int numberOfRounds,
			int numberOfCrossovers,
			int mutationProbability,
			int numberOfKeptEntities,
			Supplier<Entity> createEntity,
			BiFunction<Entity, Entity, Entity> doCrossover,
			Function<Entity, Entity> doMutation,
			Function<Entity, Integer> fitnessValue
		) {
		List<Entity> entitys =
//			range(0, entityCount).mapToObj(i -> createEntity.get()).collect(Collectors.toList());
			generate(createEntity).limit(numberOfKeptEntities).collect(toList());

		for (int i = 0; i < numberOfRounds; i++) {
			entitys = genAlgRoundV2(entityCount, numberOfCrossovers, mutationProbability, numberOfKeptEntities,
					createEntity, doCrossover, doMutation, fitnessValue, entitys);

			printEntities(fitnessValue, entitys);
		}

		return entitys.stream().sorted(comparing(fitnessValue)).findFirst().get();
	}

	public static <Entity> List<Entity> genAlgRoundV2(
			int entityCount,
			int numberOfCrossovers,
			int mutationProbability,
			int numberOfKeptEntities,
			Supplier<Entity> createEntity,
			BiFunction<Entity, Entity, Entity> doCrossover,
			Function<Entity, Entity> doMutation,
			Function<Entity, Integer> fitnessValue,
			List<Entity> entitys
		) {
		return Stream.concat(
			Stream.concat(
				// crossover
				range(0, numberOfCrossovers).mapToObj(i -> {
					var idx1 = ThreadLocalRandom.current().nextInt(entitys.size());
					var idx2 = ThreadLocalRandom.current().nextInt(entitys.size());
					return doCrossover.apply(entitys.get(idx1), entitys.get(idx2));
				}),

				entitys.stream().map(doMutation)
			)
			.sorted(comparing(fitnessValue))
			.limit(numberOfKeptEntities),

			generate(createEntity).limit(entityCount - numberOfKeptEntities)
		)
		.collect(toList());
	}

	public static <Entity> Entity genalg(
			int entityCount,
			int numberOfRounds,
			int numberOfCrossovers,
			int mutationProbability,
			int numberOfKeptEntities,
			Supplier<Entity> createEntity,
			BiFunction<Entity, Entity, Entity> doCrossover,
			Function<Entity, Entity> doMutation,
			Function<Entity, Integer> fitnessValue
		) {
		List<Entity> entitys = new ArrayList<>();
		for (int i = 0; i < entityCount; i++) {
			entitys.add(createEntity.get());
		}

		for (int i = 0; i < numberOfRounds; i++) {
			entitys = genAlgRound(entityCount, numberOfCrossovers, mutationProbability, numberOfKeptEntities,
					createEntity, doCrossover, doMutation, fitnessValue, entitys);
		}

		Collections.sort(entitys, comparing(fitnessValue));
		return entitys.get(0);
	}

	private static <Entity> List<Entity> genAlgRound(int entityCount, int numberOfCrossovers, int mutationProbability,
			int numberOfKeptEntities, Supplier<Entity> createEntity, BiFunction<Entity, Entity, Entity> doCrossover,
			Function<Entity, Entity> doMutation, Function<Entity, Integer> fitnessValue, List<Entity> entitys) {
		// crossovers
		for (int j = 0; j < numberOfCrossovers; j++) {
			var idx1 = ThreadLocalRandom.current().nextInt(entityCount);
			var idx2 = ThreadLocalRandom.current().nextInt(entityCount);
			Entity newEntity = doCrossover.apply(entitys.get(idx1), entitys.get(idx2));
			entitys.add(newEntity);
		}

		// mutations
		for (int j = 0; j < entitys.size(); j++) {
			if (ThreadLocalRandom.current().nextInt(1_000_000) < mutationProbability) {
				Entity newEntity = doMutation.apply(entitys.get(j));
				entitys.set(j, newEntity);
			}
		}

		// keep the best numberOfKeptEntities
		Collections.sort(entitys, comparing(fitnessValue));
		entitys = entitys.subList(0, numberOfKeptEntities);

		printEntities(fitnessValue, entitys);

		// fill up
		for (int k = 0; k < entityCount - numberOfKeptEntities; k++) {
			entitys.add(createEntity.get());
		}
		return entitys;
	}

	private static <Entity> void printEntities(Function<Entity, Integer> fitnessValue, List<Entity> entitys) {
		for (Entity entity : entitys) {
			System.out.println(fitnessValue.apply(entity) + " " + entity);
		}
		System.out.println("------------------------");
	}
}
