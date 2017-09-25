
public class Lawyer extends Employee {

	int shares;

	public Lawyer(String name, int shares) {
		this.name = name;
		this.shares = shares;
		this.salary += 30000;
	}

	@Override
	public void reportOwnSalary() {
		System.out.println("I am a lawyer and I make " + df.format(this.salary) + " per year." + " My shares is " + this.shares);
	}

	@Override
	public String toString() {
		return "My name is " + this.name;
	}

	public void setShares(int n) {
		this.shares = n;
	}

	public int getShares() {
		return this.shares;
	}

}
