
packagefindsuitablejob; 

public enum Position  
{
    FREELANCER(7000),
    UNIVERSITY(4000),
	HOSPITAL(5000),
    ITCOMPANY(2700);

	private int salary; 

	public int getSalary() { 
		return salary;
	}

	Position(int salary) {
		this.salary = salary;
	}
}
