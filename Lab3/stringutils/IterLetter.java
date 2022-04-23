package stringutils;

public class IterLetter {
    private String str;
    private int counter ;

    public IterLetter(String str) { //sara
        if (str == null) {
            throw new IllegalArgumentException("The string should not be a null value!");
        }
        this.str = str;
        this.counter = 0;
    }

    public void restart() {
        counter = 0;
    }

    public boolean hasNext() {
        return counter < str.length();
    }

    public void printNext() {
        if (hasNext()) {
            System.out.println(str.charAt(counter++));
        }
    }
}