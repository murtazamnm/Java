import java.util.ArrayList;
import java.util.NoSuchElementException;
public class StackDS{
    private ArrayList<Integer> stack;
    public StackDS(){
        stack = new ArrayList<Integer>();
    }

    public void push(int element){
        stack.add(element);
    }
    public int pop(){
        if(stack.isEmpty()) { throw new NoSuchElementException();}
        int element = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return element;
    }
    public boolean empty(){
        return stack.isEmpty();
    }
    public int size(){
        return stack.size();
    }
}
