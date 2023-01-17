import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
class fibTest {

	@Test
	void testIsZero() {
		assertEquals(1,fib.fib(0), () -> "because 0 is 0");
	}
	@Test
	void letsDoall() {
		assertAll(
				() -> assertEquals(1,fib.fib(0)),
				() -> assertEquals(1,fib.fib(1))
				
				);
	}
	@Test
	void fibException() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> fib.fib(-1));
		assertEquals("Negative...", ex.getMessage());
		
	}
	@ParameterizedTest(name="fibonacci of ({0}) = {1}")
	@CsvSource({"0,1","1,1","5,8"})
	void fibPair(int n,int exp) {
		assertEquals(exp, fib.fib(n));
	}
	
	@Test
	void fibsS() {
		assertEquals(3,fib.fibSereies(10)[3]);
		assertArrayEquals(new int[] {1,1,2,3,5}, fib.fibSereies(5));
	}
	
	
}
