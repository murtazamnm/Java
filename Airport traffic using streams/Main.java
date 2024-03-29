package problem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> data = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));){
            String l;
            while((l = br.readLine()) != null){
                data.add(l);
            }
        }
        catch(IOException e){
            System.err.println(e);
        }
		Traffic tr = new Traffic(data);
		System.out.println(tr.calcFrankfurt());
		System.out.println(tr.mostPassengers());
		System.out.println(tr.lessThanHundred());
		System.out.println(tr.mostTotalPassengers());
	}
	
}
