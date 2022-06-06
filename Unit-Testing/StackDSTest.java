import java.util.NoSuchElementException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class StackDSTest {
    @Test 
    public void checkPushLastPopFirst(){
        StackDS st = new StackDS();
        st.push(2);
        st.push(9);
        st.push(4);
        assertEquals(4,st.pop());
    }
    @Test
    public void checkIsEmpty(){
        StackDS st = new StackDS();
        assertEquals(true,st.empty());
    }
    @Test
    public void oneIsNotEmpty(){
        StackDS st = new StackDS();
        st.push(12);
        assertEquals(false,st.empty());
    }
    @Test(expected = NoSuchElementException.class)
    public void popEmptyStack(){
        StackDS st = new StackDS();
        st.pop();
    }
    @Test
    public void sizeCornerCase(){
        StackDS st = new StackDS();
        assertEquals(0,st.size());
        st.push(22);
        assertEquals(1,st.size());
    }
    @Test
    public void lastPopEmpty(){
        StackDS st = new StackDS();
        st.push(24);
        st.pop();
        assertEquals(true,st.empty());
    }
}
