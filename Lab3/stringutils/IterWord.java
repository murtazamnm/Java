public class IterWord{
    private String str;
    private int counter;
    public IterWord(String str){
        this.str = str;
        this.counter = 0;
    }
    public void printNext(){
        
        if (hasNext()) {
            System.out.println(str.split()[counter++]);
        }
    }
    public void restart(){
        counter = 0;
    }
    public boolean hasNext(){
        if(hasNext()){
            return counter < str.split().length;
        }
    }
}