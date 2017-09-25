public class Car implements Driveable {

	String make;
	String model;
	int year;
	int odometerReading;

	public Car(String make, String model, int year, int odometerReading) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.odometerReading = odometerReading;
	}

	@Override
	public void drive(double milesDriven) {
		this.odometerReading += milesDriven;

	}

	public String toString() {
		return this.year + " " + this.make + " " + this.model + " " + "with " + this.odometerReading + " miles.";
	}

	public void setMake(String n) {
		this.make = n;

	}

	public void setModel(String n) {
		this.model = n;
	}

	public void setYear(int n) {
		this.year = n;
	}

	public void setOdometeReading(int odo) {
		this.odometerReading = odo;
	}
	
	public int getOdometer(){
		return this.odometerReading;
	}
	
	public String getMake(){
		return this.make;
	}
	
	public String getModel(){
		return this.model;
	}
	
	public int getYear(){
		return this.year;
	}

}
