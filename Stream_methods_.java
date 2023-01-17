package streamsPr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BiFunction;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamsMain {
	
	
	public static void main(String[] args) {
		String[] srStrings = "123 781 9 12 88 15 4 6 20".split(" ");
		int sum = (int) Arrays.stream(srStrings)
		.map(n -> Integer.parseInt(n))
		.filter(x -> x > 8 && x %2 ==0)
		.mapToInt(n -> n)
		.summaryStatistics().getSum();
		
		Arrays.stream(srStrings)
		.map( n -> Integer.parseInt(n))
		.sorted()
		.forEach(System.out::println);
		
	}
	
	public static void mainsasd(String[] args) throws IOException {
		IntStream.generate(new IntSupplier() {
			int a = 0;
			@Override
			public int getAsInt() {
				// TODO Auto-generated method stub
				return ++a;
			}
		})
		.limit(200)
		.forEach(System.out::println);
	}
	
	
	
	public static void mainsss(String[] args) {
		//sum of even nums greater than 8
		String[] argStrings = "1 2 3 4 5 6 7 8 9 10 11 12".split(" ");
		String[] argStrings2 = "1 2 3 4 5 6 7 8 9 asa 10 11 12".split(" ");
		long sum = Stream.of(argStrings)
			.map(Integer::parseInt)
			.filter(x -> x % 2 == 0)
			.filter(x -> x > 8)
			.mapToInt(n->n)
			.summaryStatistics()
			.getSum();
//		System.out.print(sum);
		BiFunction<Stream<String>,Predicate<Integer>,Stream<Integer>> evenGreaterEight = 
				(str,prd) -> {
						return str
							.filter(x -> {
								try{
									Integer.parseInt(x);
									return true;
								}catch (Exception e) {
									return false;
								}
							})
							.map(Integer::parseInt)
							.filter(prd);			
				};
		(evenGreaterEight.apply(Stream.of(argStrings2), n -> n > 8 && n %2 ==0)).forEach(System.out::println);
		
	}
	public static void mainCollect(String[] args) {
		int[] arr = IntStream.iterate(1, n -> n*2)
		.limit(10)
		.toArray();	
		
		String[] strarr = Stream.of("ter","sds","sdsd")
				.toArray(n -> new String[n]);
		
		System.out.println(Arrays.toString(strarr));
		//------------
		
		
		List<Integer> arsdr = IntStream.iterate(1, n -> n+1).limit(10)
//		.boxed()
//		orrrr
//		.mapToObj(n->n)
		//orrrrr
		.mapToObj(n->Integer.valueOf(n))
		.collect(Collectors.toList())
		;
		
		
		}
	
	public static void mainConcat(String[] args) {
		IntStream.concat(IntStream.of(5), IntStream.of(9,2,32,3))
		.takeWhile(x -> x < 32)
		.forEach(System.out::println);
	}
	
	public static void mainTakeSrop(String[] args) {
//		IntStream.range(0, 10)
		IntStream.rangeClosed(0, 100)
		.takeWhile(x -> x < 49)
		.dropWhile(x -> x < 20)
		.forEach(x -> System.out.println(x));
	}
	
	public static void mainFilter(String[] args) {
		Stream.of("hello","Asd","darkness","there","are")
		.filter(x -> x.length() > 4)
		.forEach(System.out::println);
	}
	
	
	public static void mainnn(String[] args) {
		IntStream.iterate(1, n->n+1)
		.limit(20)
		.mapToObj(num -> num+" "+"hello")
		.forEach(System.out::println);
		System.out.println("--------------------");
	}
	
	public static void main6(String[] args) {
		IntStream.iterate(1, n->n+1)
		.limit(20)
		.map(n->n*2)
		.boxed() // int -> Integer
		.forEach(System.out::println);
		System.out.println("--------------------");
		
		Stream.of("helo", "darkness","my old","friend")
		.map(txt -> txt.length())
		.forEach(System.out::println);;
		
		System.out.println("--------------------");
		
		IntStream.iterate(1, n->n+1)
		.limit(9)
		.mapToObj(n -> n+" "+" hello") // intStream to String Stream
		.forEach(System.out::println);
		System.out.println("--------------------");
		
	}
	
	
	
	public static void main5(String[] args) {
		IntStream.iterate(1, n -> n+1)
		.limit(50)
		.forEach(System.out::println);
		//--------------------------
		System.out.println("---------------------");
		
		long c = IntStream.iterate(1, n->n+1)
		.limit(50)
		.count();
		
		IntSummaryStatistics st = IntStream.iterate(1, n->n+1)
				.limit(50)
				.summaryStatistics();
		
		var min = IntStream.iterate(1, n->n+1)
				.limit(50)
				.summaryStatistics().getMin();
		OptionalInt opt = IntStream.iterate(1, n->n+1)
				.limit(50)
				.min();
		
		System.out.println(c);
		System.out.println(st);
		System.out.println(min);
		System.out.println(opt);
		
		
		System.out.println(Optional.empty().orElse(50));
		System.out.println(Optional.of(55).orElseGet(()->44));
		
		
		
	}
	
	
	public static void main4(String[] args) {
//		System.out.println(Long.MAX_VALUE);
		long max = Long.MAX_VALUE;
		float sameMax = max;
		System.out.println(max);
		System.out.printf("%f%n",sameMax);
		
	}
	
	
	public static void main3(String[] args) {
		int[] value = {0};
		Stream.generate(()-> ++value[0])
		.forEach(System.out::println);
		;
	}
	
	
	
	public static void main2(String[] args) {
		
		IntStream.generate(new IntSupplier() {
			int value = 0;
			@Override
			public int getAsInt() {
				// TODO Auto-generated method stub
				return ++value;
			}
		})
		.skip(5)
		.limit(50)
		.forEach(System.out::println);
		

	}
	
	
	public static void main1(String[] args) throws IOException{
		Stream<Integer> basicStream = Stream.of(1,2,3,4);
		basicStream.forEach(System.out::println);
		
		System.out.println("---------------------------");
//		basicStream.forEach(t -> System.out.println(t));
		IntStream.of(5,312,3,-23).forEach(System.out::println);
		
		//----------
		System.out.println("---------------------------");
		
		ArrayList<Integer> arrayList = new ArrayList<>(List.of(1,2,4,5));
		arrayList.stream().forEach(System.out::println);
		
		
		System.out.println("---------------------------");
		int[] arr = {1,2,4,5};
		Arrays.stream(arr).forEach(System.out::println);
		
		System.out.println("---------------------------");
		
		//--------------------------------
		Files.lines(Path.of("src/streamsPr","streamsMain.java"))
			.forEach(System.out::println);
 		
		
	}
}
