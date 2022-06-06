package java.findsuitablejob;

public class Contract {  
	protected String degree;
	protected int numberOfEmployees;
    protected int contractPeriod;

	protected static int goalSalary = 4000;

	public static final int MAX_PERIOD_MONTH = 12; 
	public static final int MIN_PERIOD_MONTH = 6;

	public Contract() {   //0.5 mark
		this("Master", 20, 12 );
	}

	public Contract(String degree, int numberOfEmployees,int contractPeriod) { 
		if (!isBetween(contractPeriod, MIN_PERIOD_MONTH, MAX_PERIOD_MONTH ))  throw new IllegalArgumentException();
		if (!isBetween(numberOfEmployees, 15, 40))  throw new IllegalArgumentException();
		
		this.degree = degree;
		this.numberOfEmployees = numberOfEmployees; 
		this.contractPeriod = contractPeriod;
	
	}

	private boolean isBetween(int number, int min, int max) {
		return min <= number && number <= max;
	}

	public void setGoalSalary(int x) { 
		goalSalary = x;
	}
	
	public String toString() { 
		return "the number of employees in this contract are :" + numberOfEmployees + "they are holding" + degree +" degree,and the period of this contract is:" + contractPeriod + "months.";
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public String getDegree() { 
		return degree;
	}

	public int getContractPeriod() {
		return contractPeriod;
	}
}
