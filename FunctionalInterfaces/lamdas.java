import java.awt.Point;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;

// Lambdas (anonymous functions)

@FunctionalInterface
interface MyRunnable2 {
    // public abstract void run();
    void run();
    // void run2();
}

interface ManyParams {
	void f(int par1, String par2, Double par3, List<Boolean> par4, Set<Map<Point, ConcurrentHashMap<Long, Void>>> par5);
}

interface MyPrintIface {
	void myPrint(String s);
}

interface AlmostTheSameButDifferent1 { void f(); }
interface AlmostTheSameButDifferent2 { void g(); }
interface AlmostTheSameButDifferent3 { void h(); }

public class Lambdas {
	static void impl(int par1, String par2, Double par3, List<Boolean> par4, Set<Map<Point, ConcurrentHashMap<Long, Void>>> par5) {
		System.out.println("I'm complex");
	}

	static void m() {}

	private static int value3 = 0;

	public static void main(String[] args) {
		int[] value = {0};
    	IntSupplier oneTwoThree = () -> ++value[0];

		System.out.println(oneTwoThree.getAsInt());
		System.out.println(oneTwoThree.getAsInt());
		System.out.println(oneTwoThree.getAsInt());
		System.out.println(oneTwoThree.getAsInt());

	
//		Runnable    : () -> ()
//		Supplier<T> : () -> T
//		IntSupplier : () -> int
//		Consumer<T> : T  -> ()
//		Function<T1, T2> : T1 -> T2
//		IntFunction<T> : int -> T
//		BiFunction : (T1, T2) -> T3
//		Predicate : T -> boolean
		Consumer<String> printIt = System.out::println;
		// infer   type inference
		Consumer<String> printIt2 = s -> System.out.println(s);
		Consumer<String> printIt3 = (s) -> System.out.println(s);
		Consumer<String> printIt4 = (String s) -> System.out.println(s);
		Consumer<String> printIt5 = (var s) -> System.out.println(s);

		IntConsumer doubledPrinter = n -> System.out.println(2 * n);

		printIt.accept("hello world");
		doubledPrinter.accept(10);

		Function<Integer, String> textify = n -> n + ", " + n;
		Function<Integer, String> textifyV1 = (Integer n) -> n + ", " + n;
		System.out.println(textify.apply(123));
		IntFunction<String> textify2 = n -> n + ", " + n;
		IntFunction<String> textify2V2 = (int n) -> n + ", " + n;
		System.out.println(textify2.apply(123));
		IntUnaryOperator op = (int n) -> 2*n + 1;
		int retval = op.applyAsInt(123);
		System.out.println(retval);
	}

    public static void main7(String[] args) {
    	Supplier<Integer> oneTwoThree = new Supplier<>() {
    		int value = 0;
			@Override
			public Integer get() {
				return ++value;
			}
		};

		System.out.println(oneTwoThree.get());
		System.out.println(oneTwoThree.get());
		System.out.println(oneTwoThree.get());
		System.out.println(oneTwoThree.get());
		System.out.println(oneTwoThree.get());
		System.out.println(oneTwoThree.get());

		// Local variable value2 defined in an enclosing scope must be final or effectively final
		// The final local variable value2 cannot be assigned. It must be blank and not using a compound assignment
		int[] value2 = {0};
    	Supplier<Integer> oneTwoThreeV2 = () -> ++value2[0];

		System.out.println(oneTwoThreeV2.get());
		System.out.println(oneTwoThreeV2.get());
		System.out.println(oneTwoThreeV2.get());
		System.out.println(oneTwoThreeV2.get());
		value2[0] = -1_000_000;
		System.out.println(oneTwoThreeV2.get());

 //    	value2 = new int[] {};

    	Supplier<Integer> oneTwoThreeV3 = () -> ++value3;
    
    }

    public static void main6(String[] args) {
    	// anonymous class
    	Runnable counter4 = new Runnable() {
			@Override
			public void run() {
				int localVariable = 325;
				for (int i = 0; i < 100; i++) {
					System.out.println(i);
				}
			}
		};
    	// anonymous class
    	Runnable counter5 = new Runnable() {
			@Override
			public void run() {
				int localVariable = 325;
				for (int i = 0; i < 100; i++) {
					System.out.println(i);
				}
			}
		};
		
		System.out.println(counter4.getClass().getName());
		System.out.println(counter5.getClass().getName());
    }

    public static void main5(String[] args) {
    	AlmostTheSameButDifferent1 a1 = () -> {};
    	AlmostTheSameButDifferent2 a2 = () -> {};
//    	var a3 = () -> {};

    	var aNumber = 123;
    	var aString = "123";
    	var aList   = List.of(1, 2);
    	
    	Runnable counter = new MyCountingRunnable();
    	counter.run();
        
    	Runnable counter2222 = new MyCountingRunnable2();
    	counter2222.run();
        
    	Runnable counter3 = () -> {
    		int localVariable = 325;
    		for (int i = 0; i < 100; i++) {
    			System.out.println(i);
    		}
    	};
        
//    	Runnable impossible = new Runnable();
    	
        
    	Runnable counter2 = () -> {
    		for (int i = 0; i < 100; i++) {
    			System.out.println(i);
    		}
    	};
    	counter2.run();

    	System.out.println(counter.getClass().getName());
    	System.out.println(counter2.getClass().getName());
    }

    public static void main4(String[] args) {
    	Runnable r = () -> {
    		System.out.println("Runnable here");
    	};
    	
    	r.run();
    	r.run();
    	r.run();
    	
    	
    	java.util.function.Supplier<Integer> simply123 = () -> 123;
    	Supplier<Integer> simply1234 = () -> 1234;
    	int evenMoreUseful = 123;
    	Integer evenMoreUsefulInteger = 123;

    	System.out.println(simply123.get() + simply1234.get());
    	System.out.println(simply123.get() + simply1234.get());
    	System.out.println(simply123.get() + simply1234.get());
    	System.out.println(simply123.get() + simply1234.get());
    	System.out.println(simply123.get() + simply1234.get());
    	System.out.println(simply123.get() + simply1234.get());
    	System.out.println(simply123.get() + simply1234.get());
    }

    public static void main3(String[] args) {
    	ManyParams mp1 = (a, b, c, d, e) -> impl(2 * a, b, c, d, e);
    	mp1.f(0, null, null, null, null);
    	
    	ManyParams mp2 = Lambdas::impl;

    	MyPrintIface mpi = txt -> System.out.println(txt);
//    	MyPrintIface mpi = System.out::println;
    	mpi.myPrint("abcdefg");
    }

    public static void main2(String[] args) {
//        say("HW");

    	// Fira Code
        MyRunnable r1 = () -> {
            System.out.println("dsafdsafa");
            System.out.println("dsafdsafa");
        };
        MyRunnable r2 = () -> System.out.println("dsafdsafa");
        // method reference
        MyRunnable r3 = Lambdas::m;
        MyRunnable r4 = () -> Lambdas.m();

        r1.run();
        r2.run();
        r3.run();
        r4.run();

//        ? say = txt -> System.out.println(txt);
//        say.apply("txt");

//        ? mul3add1 = n -> 3 * n + 1;

//        doItThreeTimes(System.out::println);
//        doItThreeTimes(txt -> System.out.println(txt));
    }

    void say(String txt) {
        System.out.println(txt);
    }
}
