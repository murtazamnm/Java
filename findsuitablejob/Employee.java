package findsuitablejob;

import java.util.Objects;

public class Employee implements Employable, Comparable<Employee> { 
	private String employeeName; 
    private int salary = 0;

    private Employee(String employeeName , int salary) { 
	if (employeeName == null )  throw new IllegalArgumentException();
        this.employeeName = employeeName;
        this.salary = salary;
    } 
	 
	public int compareTo(Employee e){   
		if(salary == e.salary)  
		return 0;  
		else if(salary > e.salary)  
		return 1;  
		else  
			return -1;  
	}  

    public static Employee make(String data) {      
        String[] parts = data.split(",");
        if (parts.length == 2)
            try {
                int wage = Integer.parseInt(parts[1]);
                if (!parts[0].isEmpty() && wage > 0)
                    return new Employee(parts[0], wage);
            } catch (NumberFormatException e) {
            }
        return null;
    }


	public String getEmployeeName() {
		return employeeName;
	}

	public int getSalary() { 
		return salary;
	}

	
	public String toString() 
    {
        return "The employee name is " + employeeName + " , and he got " + salary
				+ "Dollars as monthly salary.";
    }

    @Override
    public boolean equals(Object that)  
    {
        if (that == this) return true;
        if (that == null) return false;

        if (that instanceof Employee)
        {
        	Employee other = (Employee)that;
            return Objects.equals(employeeName, other.employeeName)
            && Objects.equals(salary, other.salary);
        }

        return false;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(employeeName, salary);
    }
 
	@Override 
    public void getHiredAt(Position p){ 
		salary += p.getSalary();
	}
	
	@Override
	public double getSalaryIncrease (double increaseRate) { 
		if (increaseRate < 1.1 ) throw new IllegalArgumentException();
		return ( increaseRate * salary) ;	
	}
 }
