import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.ArrayList;
public class ProblemOne{
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"));){
            String l;
            while((l = br.readLine()) != null){
                data.add(l);
            }
        }
        catch(FileNotFoundException e){
            System.err.println(e);
        }
        catch(IOException e){
            System.err.println(e);
        }
        Exercise1 e1 = new Exercise1();
        Exercise2 e2 = new Exercise2();
        Exercise3 e3 = new Exercise3();
        Exercise4 e4 = new Exercise4();
        System.out.println(e1.countFlights(data,"Frankfurt"));
        System.out.println(e2.countPassengers(data));
        System.out.println(e3.lessThanHundred(data));
        System.out.println(e4.mostPassengers(data));
    }
}
class Exercise1{
    public int countFlights(ArrayList<String> data, String st){
        int count = 0;
        for(int i = 0; i < data.size(); i++){
            if(st.equals(data.get(i).split(" ")[1])){
                count++;
            }
        }
        return count;
    }
}
class Exercise2{
    public String countPassengers(ArrayList<String> data){
        if(data.isEmpty()){
            return "The File is Empty";
        }
        int mostP = 0;
        String result = "";
        for(int i = 0; i < data.size(); i++){
            if(Integer.parseInt(data.get(i).split(" ")[2]) > mostP ){
                mostP = Integer.parseInt(data.get(i).split(" ")[2]);
                result = data.get(i);
            }
        }
        return result;
    }
}
class Exercise3{
    public String lessThanHundred(ArrayList<String> data){
        int ind = 0;
        Boolean found = false;
        for(int i = 0; i < data.size(); i++){
            if(Integer.parseInt(data.get(i).split(" ")[2]) < 100 ){
                ind = i;
                found = true;
                break;
            }
        }
        if(found){
            return data.get(ind);
        }
        return "There is no flight with passengers less than 100.";
    }
}
class Exercise4{
    public String mostPassengers(ArrayList<String> data){
        if(data.isEmpty()){
            return "The File is Empty";
        }
        ArrayList<String> Flights = new ArrayList<>();
        for(int i = 0; i < data.size();i++){
            if(Flights.contains(data.get(i).split(" ")[0])){

            }
            else{
                Flights.add(data.get(i).split(" ")[0]);
            }
        }
        int sum = 0;
        for(int i = 0; i < Flights.size();i++){
            for(int j = 0; j < data.size();j++){
                if(Flights.get(i).equals(data.get(j).split(" ")[0])){
                    sum+=Integer.parseInt(data.get(j).split(" ")[2]);
                }
            }
            Flights.set(i, Flights.get(i)+" "+Integer.toString(sum));
            sum=0;
        }
        String f = "";
        int max = 0;
        for(int i = 0;i<Flights.size();i++){
            if(Integer.parseInt(Flights.get(i).split(" ")[1]) > max){
                max = Integer.parseInt(Flights.get(i).split(" ")[1]);
                f = Flights.get(i);
            }
        }
        return f;
    }
}
