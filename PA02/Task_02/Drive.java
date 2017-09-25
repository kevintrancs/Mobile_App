/**
 * PA_Task2 - With All Extra Credit
 * @author Kevin Tran
 *  9/15/17
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Drive {

	public static void main(String[] args) {
		Random rand = new Random();

		List<Car> car_list = new ArrayList<Car>();
		car_list.add(new Car("Toyota", "Prius", 1990, rand.nextInt(300000) + 1));
		car_list.add(new Car("Toyota", "Camry", 1996, rand.nextInt(300000) + 1));
		car_list.add(new Car("Lexus", "carcar", 1982, rand.nextInt(300000) + 1));
		car_list.add(new Car("BMW", "Xii", 1990, rand.nextInt(300000) + 1));
		car_list.add(new Car("BMW", "expensive_one", 2003, rand.nextInt(300000) + 1));
		car_list.add(new Car("Chevy", "Cav", 2002, rand.nextInt(300000) + 1));
		car_list.add(new Car("Subaru", "Impres", 2005, rand.nextInt(300000) + 1));
		car_list.add(new Car("Ford", "Fiesta", 2008, rand.nextInt(300000) + 1));
		car_list.add(new Car("Ford", "F150", 2009, rand.nextInt(300000) + 1));
		car_list.add(new Car("Toyota", "Celica", 1905, rand.nextInt(300000) + 1));
		
		sort(car_list);

		for (Car c : car_list) {
			System.out.println(c.toString());
			if(Math.random() < 0.5)
				c.drive(rand.nextInt(100000) + 150000);
		}

		System.out.println("--------After Driving--------");
		System.out.println("");
		
		for (Car c : car_list)
			System.out.println(c.toString());
		
		sort(car_list);

		System.out.println("--------After insertion sort--------");
		System.out.println("");

		for (Car c : car_list)
			System.out.println(c.toString());

	}
	
	/**
	 * 
	 * Insertion sort, simple sort...
	 * @param list
	 */
	
	public static void sort(List<Car> list){
		
		int i, j;
		for (i = 1; i < list.size(); i++) {
			Car tmp = list.get(i);
			j = i;
			while ((j > 0) && (list.get(j - 1).getOdometer() > tmp.getOdometer())) {
				list.set(j, list.get(j - 1));
				j--;
			}
			list.set(j, tmp);
		}
		
	}


}
