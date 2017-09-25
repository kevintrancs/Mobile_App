

/**
* This program executes a bunch of employees stuff
* All extra is included 
* CPSC 312-02, Fall 2017
* Programming Assignment #3
* No sources to cite.
* 
* @author Kevin Tran
* @version v0.2 9/15/17
*/


import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<Employee> e_list = new ArrayList<Employee>();
		e_list.add(new Programmer("Kevin Tran", false));
		e_list.add(new Programmer("Ima Nerd", true));
		e_list.add(new Lawyer("Kenny Dewitt", 10));
		e_list.add(new Lawyer("Dan. D Lyon", 0));
		e_list.add(new Lawyer("Willie Makit", 100));
		e_list.add(new Accountant("Hal E. Luya", 17.00));
		e_list.add(new Accountant("Midas Wel", 45.50));
		e_list.add(new Accountant("Doll R. Bill", 2.50));
		
		for (Employee e : e_list) {
			System.out.println(e.toString());
			e.reportOwnSalary();

		}

	}

}
