findsuitablejob.Contract` class representing a contract, has the following fields: 
`degree` of type `String`, `numberOfEmployees` of type `int` , `contractPeriod` of type `int` .
- It also has a static field: `goalSalary`. this should set to `4000` initially.
- all fields of `Contract` class are accessible to the descendants of `Contract`, but not to any other class.
  -getters for all of them, and a setter only for `goalSalary`.
- `Contract` has two constructors:
  1. A constructor that takes the `degree`, `numberOfEmployees` and `contractPeriod` as parameters and sets the corresponding fields.
      - In it, the following conditions hold:
        - `contractPeriod` is at least 6 and not more than 12 months, (for this create two constants( outside the constructor) that hold values 6 and 12 of type `int`.
        - `numberOfEmployees` is at least 15 and not more than 40 .
      - If either one is incorrect, throws an `IllegalArgumentException`.
      - To make it easier to check those conditions, we make a static method `isBetween(number, min, max)` that returns whether `number` is between `min` and `max`.
  2. A constructor that takes no parameters. It calls the previously defined constructor with the following values:
      - `degree`: "Master"
      - `numberOfEmployees` : 20
      - `contractPeriod` : 12
- Overriden `toString()` method and gives it a suitable implementation.

# --
An enum `findsuitablejob.Position` which includes the four positions: FREELANCER, UNIVERSITY, HOSPITAL and ITCOMPANY.

- Each of these enum values have one associated value that indicate `salary` of type `int`, as following: `FREELANCER` has `7000`, `UNIVERSITY` has `4000`, `HOSPITAL` has `5000` and `ITCOMPANY` has `2700`.
  - getter for `salary`.
  - a constructor for `Position` enum that takes `salary` as argument and sets its value.
  
# --
the interface `findsuitablejob.Employable` with the method `getHiredAt()` that takes a `Position` and the method `getSalaryIncrease()` that takes `increaseRate` of type `double` as a parameter.

# --
the class `findsuitablejob.Employee` that implements `Employable`. It has the fields: `employeeName` of type `String` and `salary` of type `int` set to `0`.

- The employee's constructor has `private` access modifier, it takes its `employeeName` and `salary` and set their values, both fields have getters, but no setters.
  The constructor should throw an `IllegalArgumentException` if `employeeName` is null.

- a static method `make` of type `Employee` which takes `data` of type `String` as argument, `data` is in the form `name,salary`.If the line does not have this structure or if the salary is smaller than zero,
  returns null, otherwise converts the salary to `int` and Catches the proper Exception. The 'make' method returns an Employee initialized of name and salary that you extracted from the `data`. 
- Overriden `equals()` which return equality of 'Employee's object depending on `name` and `salary`, 
- Overriden `hashcode()` and `toString()` methods.
- The implementation of `getHiredAt()` method increases the 'salary' by the enum value, while the implementation of `getSalaryIncrease()` throws an `IllegalArgumentException` if the `increaseRate` is less than (1.1).This method returns the result of multiplying given argument value by the `salary`.

- The class `Employee` also implements `Comparable<Employee>` interface , an implementation to `compareTo()` method is given in such way that it make the comparision according to the `salary` value.


# --
`findsuitablejob.EmpAgency`, a child class of `Contract`.

- It has a field called `employees`, a list of `Employee`s.
- Its only constructor takes `degree`, `contractPeriod` and an arbitrary number of `Employee`s and stores them in its fields.
- Method `load()` takes `filePath` of type `String` and return an Array of 'Employee's , it will read from input file line by line, each line  will be passed to Employee.make to create an employee.  If a line is `null` it skips it.
- Method `hire()` that takes a `Position` as argument and it go through `employees` list and adds them to a list 'filtered'. The list of hired employees is sorted in ascending order depending on `salary` value. 
 If an employee's salary after being hired, is equal or less than the `goalSalary` , he is hired with `getHiredAt()` method and removed from `employees` and. `Iterator` is used to achieve that.
- Method `getMaxIncrease()` which takes an argument of type `double` and throws `IllegalStateException` if the number of employees is `zero`, otherwise it will calculate the increasing of the salary of each employee in `employees` list depending on the given argument, and it will return maximum increase value among them ('maxIncrease' of type double).
- Overriden `toString()` in `EmpAgency` which prints employees.
