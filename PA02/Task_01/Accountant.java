
public class Accountant extends Employee{
	
	double parking_allowance;
	
	public Accountant(String name, double allowance){
		this.name = name;
		this.parking_allowance = allowance;
	}

	@Override
	public void reportOwnSalary() {
		System.out.println("I am an accountant and I make " + df.format(this.salary) + " per year." + " My parking allowance is " + df.format(this.parking_allowance));
	}

	@Override
	public String toString() {
		return "My name is " + this.name;

	}

	public double doubleGetAllowance(){
		return this.parking_allowance;
	}
	
	public void setAllowance(double n){
		this.parking_allowance = n;
	}

}
