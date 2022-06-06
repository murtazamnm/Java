package exam.findsuitablejob;

import java.io.*; //1
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections; 

public class EmpAgency extends Contract { 
	private List<Employee> employees = new ArrayList<>();

	public EmpAgency(String degree,int contractPeriod, Employee... employees) { 
		super(degree, employees.length, contractPeriod); 
		for (Employee emp: employees) {
			this.employees.add(emp);
		}
	}

	public static Employee[] load(String filePath){		
		List<Employee> emp = new ArrayList<>();   
        try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
			
            for (String line = reader.readLine(); line != null ; line = reader.readLine()) {
				 emp.add(Employee.make(line));
            }
        } catch (IOException e) {System.out.println(e);}
		return emp.toArray(new Employee[emp.size()]); 
	}


	public void hire(Position p) { 
		int i= this.getNumberOfEmployees();
		//Collections.sort(employees);
		for (Iterator<Employee> iter = employees.iterator(); iter.hasNext() && i>0 ; ) {
			Employee emp = iter.next();			
			Collections.sort(employees);
			if (emp.getSalary() <= goalSalary) {  // if the employee has a smaller salary e hire him
				emp.getHiredAt(p);		
				iter.remove();
				--i;
			}
		}
	}
	
	@Override
	public String toString() {  
		return employees.size() + " employees: " + employees;
	}

	public double getMaxIncrease(double increaseRate) {  
		if (employees.size() == 0)  throw new IllegalStateException();
		
		double maxIncrease = employees.get(0).getSalaryIncrease(increaseRate);
		for (Employee emp : employees) {
			double employeeIncrease = emp.getSalaryIncrease(increaseRate);
			if (employeeIncrease > maxIncrease) {
				maxIncrease = employeeIncrease;
			}
		}
		return maxIncrease;
	}
	
}

