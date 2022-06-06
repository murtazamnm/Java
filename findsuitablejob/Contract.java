// 7 Marks + 1.5 Marks for all Packaging
	  
package exam.findsuitablejob;

public class Contract {  // 1 M
	protected String degree;
	protected int numberOfEmployees;
    protected int contractPeriod;

	protected static int goalSalary = 4000;

	public static final int MAX_PERIOD_MONTH = 12; //0.5 M 
	public static final int MIN_PERIOD_MONTH = 6;

	public Contract() {   //0.5 mark
		this("Master", 20, 12 );
	}

	public Contract(String degree, int numberOfEmployees,int contractPeriod) { //1.5 M
		if (!isBetween(contractPeriod, MIN_PERIOD_MONTH, MAX_PERIOD_MONTH ))  throw new IllegalArgumentException();
		if (!isBetween(numberOfEmployees, 15, 40))  throw new IllegalArgumentException();
		
		this.degree = degree;
		this.numberOfEmployees = numberOfEmployees; 
		this.contractPeriod = contractPeriod;
	
	}

	private boolean isBetween(int number, int min, int max) { //0.5
		return min <= number && number <= max;
	}

	public void setGoalSalary(int x) { //0.5 M
		goalSalary = x;
	}
	
	public String toString() {  //1 M
		return "the number of employees in this contract are :" + numberOfEmployees + "they are holding" + degree +" degree,and the period of this contract is:" + contractPeriod + "months.";
	}

	public int getNumberOfEmployees() { //0.5 M
		return numberOfEmployees;
	}

	public String getDegree() { //0.5
		return degree;
	}

	public int getContractPeriod() { //0.5
		return contractPeriod;
	}
}
