package threads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class threadMain {
	
	public static void main(String[] args) throws InterruptedException {
		
		Function<String, Thread> giveThreadFunction = (txt) -> {
			return new Thread(
					() -> {
							IntStream.range(1, 100)
							.mapToObj(n -> txt +" "+n)
							.forEach(System.out::println);
						});
					};
					
			Thread[] threads = IntStream.range(1, 10)
					.mapToObj(n -> giveThreadFunction.apply("Thread"+n))
					.toArray(Thread[]::new); //Thread[]::new
		 
			Arrays.stream(threads)
			.forEach(thr -> thr.start());
			Arrays.stream(threads)
			.forEach(thr -> thr.join());
	}
	
	
	public static void main1(String[] args) throws InterruptedException {
		Thread t1 = new Thread(()->{
			for (int i = 0; i < 20; i++) {
				System.out.println("Hello "+i);
			}
			
		});
		Thread t2 = new Thread(()->{
			for (int i = 0; i < 20; i++) {
				System.out.println("Welcome "+i);
			}
			
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Main Finished");
	}
}
