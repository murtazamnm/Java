package problem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercises {
	ArrayList<String> data = new ArrayList<>();
	public Exercises(ArrayList<String> data) {
		this.data = data;
	}
	public int calcFrankfurt(){
		if(data.isEmpty()) return 0;
		long c = data.stream()
		.filter(x -> x.split(" ")[1].equals("Frankfurt"))
		.count();
		return (int)c;
	}
	public String mostPassengers() {
		if(data.isEmpty()) return "The file is empty";
		List<String> flight = data.stream()
								.sorted((a, b) -> Integer.compare(Integer.parseInt(a.split(" ")[2]), Integer.parseInt(b.split(" ")[2])))
						        .collect(Collectors.toCollection(ArrayList::new));	
		return flight.get(flight.size()-1);
	}
	public String lessThanHundred(){
		if(data.isEmpty()) return "There is no flight with passengers less than 100.";
		List<String> lesThanHund = data.stream()
									.filter(x -> Integer.parseInt(x.split(" ")[2]) < 100)
									.collect(Collectors.toCollection(ArrayList::new));
		if(lesThanHund.isEmpty()) return "There is no flight with passengers less than 100.";
		return lesThanHund.get(0);
	}
	
	public String mostTotalPassengers() {
		if(data.isEmpty()) return "The file is empty";
		int count = 0;
		ArrayList<String> names = new ArrayList<>();
		for(int i = 0 ; i < data.size();i++) {
			if(!names.contains(data.get(i).split(" ")[0])) {
				names.add(data.get(i).split(" ")[0]);
			}
			
		}
		List<String> counted = names.stream().map((String x) -> x + " " + 
				(int)data.stream()
				.filter(z -> z.split(" ")[0].equals(x))
				.mapToInt(z -> Integer.parseInt(z.split(" ")[2]))
				.summaryStatistics()
				.getSum())
				.sorted((a, b) -> Integer.compare(Integer.parseInt(a.split(" ")[1]), Integer.parseInt(b.split(" ")[1])))
		        .collect(Collectors.toCollection(ArrayList::new));	
		return counted.get(counted.size()-1);
	}
	
}
