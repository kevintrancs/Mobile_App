
public class Programmer extends Employee{
	
	boolean busPass = false;
	
	public Programmer(String name, boolean busPass){
		this.name = name;
		this.salary += 20000.00;
		this.busPass = busPass;
	}

	@Override
	public void reportOwnSalary() {
		if(busPass)
			System.out.println("I am a Programmer and I make " + df.format(this.salary) + " per year." + "I do get a bus pass");
		System.out.println("I am a Programmer and I make " + df.format(this.salary) + " per year. " + "I do not get a bus pass");
	}

	@Override
	public String toString() {
		return "My name is " + this.name;
	}

}
