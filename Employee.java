package homework;

class Employee implements Comparable<Employee>{
	private String id;
	private String name;
	private double salary;
	private String department;
	private String position;
	private int yearsOfService;
	
	// Default constructor
	public Employee() {
		id = null;
		name = null;
		salary = 0.0;
		department = null;
		position = null;
		yearsOfService = 0;
	}
	
	// Constructor w/ info
	public Employee(String id, String name, double salary, String department, String position, int yearsOfService){
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.position = position;
		this.yearsOfService = yearsOfService;
	}
	
	// Set methods
	public void setID(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setYears(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}
	
	// Get methods
	public String getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public String getDepartment() {
		return department;
	}
	public String getPosition() {
		return position;
	}
	public int getYears() {
		return yearsOfService;
	}
	
	// compareTo method for ID numbers
	public int compareTo(Employee e) {
		return id.compareTo(e.id);	// String class compareTo method
	}
	
	// toString method
	public String toString() {
		String result;
		result = id + "\t" + name + "\t" + salary + "\t" + department + "\t" + position + "\t" + yearsOfService;
		return result;
	}
}
