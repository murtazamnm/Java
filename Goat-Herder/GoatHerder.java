package solutions.threading;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class GoatHerder {
	static int plankLength = 20;
	static int commonGoatPos = plankLength / 2;

	public static void main(String[] args) throws InterruptedException {
//		int goatPosA = 0;
//		int goatPosB = plankLength;

		BiFunction<Integer, Integer, Thread> makeGoat =
			(speed, power) ->
				// goat's actions
				new Thread(() -> {
					while (goatAreStillOnThePlank()) {
						waitABit(speed);
						if (!goatAreStillOnThePlank())   break;
						doPush(power);
					}

					// "I won"
				});

		Thread goat1 = makeGoat.apply(100, 1);
		Thread goat2 = makeGoat.apply(80, -1);

		goat1.start();
		goat2.start();
		goat1.join();
		goat2.join();

		System.out.println("Final pos: " + commonGoatPos);
	}

	private static void doPush(Integer power) {
		synchronized (GoatHerder.class) {
			commonGoatPos += power;
		}

		System.out.println(power + " pushed to " + commonGoatPos);
	}

	private static void waitABit(Integer speed) {
		try {
			int millis = ThreadLocalRandom.current().nextInt(speed, 2 * speed);
//			TimeUnit.MILLISECONDS.sleep(speed);
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static boolean goatAreStillOnThePlank() {
		synchronized (GoatHerder.class) {
			return 0 <= commonGoatPos && commonGoatPos <= plankLength;
		}
	}
}
