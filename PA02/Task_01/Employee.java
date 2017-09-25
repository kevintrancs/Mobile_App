import java.text.DecimalFormat;

abstract public class Employee {

	String name;
	double salary = 40000.00;
	DecimalFormat df = new DecimalFormat("0.00");

	public abstract void reportOwnSalary();

	/**
	A toString override
	*
	* @return STring
	*/

	@Override
	public  String toString(){
		return "I am an employee";
	}

	/**
	Just a bunch of setters and getters
	*
	* @return intended value 
	*/

	public void setName(String n) {
		this.name = n;
	}

	public void setSalary(double n) {
		this.salary = n;
	}

	public String getName() {
		return this.name;
	}

	public double getSalary() {
		return this.salary;
	}

}
