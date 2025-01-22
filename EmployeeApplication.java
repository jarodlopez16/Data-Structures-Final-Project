package homework;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Heap<Obj extends Comparable<Obj>>
{
	private ArrayList<Obj> list = new ArrayList<>();

	// Default heap
	public Heap() {}
	
	// Heap from an array of objects
	public Heap(Obj[] entries) {
		for(int j = 0; j < entries.length; j++) {
			addEntry(entries[j]);
		}
	}
	
	// Method to add to heap
	public void addEntry(Obj newEntry) {
		list.add(newEntry);
		int currIndex = list.size() -1; // Current Index
		
		while(currIndex > 0) {
			int parentIndex = (currIndex -1)/2;
			if(list.get(currIndex).compareTo(list.get(parentIndex)) > 0) {
				Obj temporary = list.get(currIndex);
				list.set(currIndex, list.get(parentIndex));
				list.set(parentIndex, temporary);
			}
			else {
				break; }
			
			currIndex = parentIndex;
		}
	}
	
	// Method to remove root
	public Obj removeRoot() {
		if (list.size() == 0) return null;
		
		Obj removeEntry = list.get(0);
		list.set(0, list.get(list.size() -1));
		list.remove(list.size()-1);
		
		int currIndex = 0;
		while(currIndex < list.size()) {
			int leftChildIndex = 2 * currIndex + 1;
			int rightChildIndex = 2 * currIndex + 2;
			
			// Find which child is greater
			if(leftChildIndex >= list.size()) break;
			int maxIndex = leftChildIndex;
			if (rightChildIndex < list.size()) {
				if(list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
				}
			}
			
			// If current node is less than max, then swap
			if(list.get(currIndex).compareTo(list.get(maxIndex)) < 0) {
				Obj temporary = list.get(maxIndex);
				list.set(maxIndex, list.get(currIndex));
				list.set(currIndex, temporary);
				currIndex = maxIndex;
			}
			else {
				break;	}
		}
		
		return removeEntry;
	}
	
	// Method to retrieve heap size
	public int getSize() {
		return list.size();
	}
	
	// Method to print heap information
	public void printHeap() {
		for(int j = 0; j <= getSize()-1; j++) {
			System.out.println("(Index, Data): (" + j + ", " + list.get(j) + ")");
		}
	}
	
}

public class EmployeeApplication {
	
	public static void main(String[] args) {

		try {
			
			// Create list of employees
			ArrayList<Employee> employees = new ArrayList<>();
			
			// To read Employee.txt file
			File infile = new File("Employee.txt");
			Scanner scan = new Scanner(infile);
			
			// Scan Employee.txt for information on each employee
			while(scan.hasNextLine()){
				String id = scan.nextLine();
				String name = scan.nextLine();
				double salary = Double.parseDouble(scan.nextLine());
				String department = scan.nextLine();
				String position = scan.nextLine();
				int yearsOfService = Integer.parseInt(scan.nextLine());
				
				Employee emp = new Employee(id, name, salary, department, position, yearsOfService);
				employees.add(emp);
			}
			
			scan.close();
			
			// Create heap for employees
			Heap<Employee> empHeap = new Heap<>();
			
			// Add employees to heap
			for(int j = 0; j < employees.size(); j++) {
			    empHeap.addEntry(employees.get(j));
			}
			
			// Sort the Employees
			for (int j = employees.size() -1; j >= 0; j--) {
			    employees.set(j, empHeap.removeRoot());
			}
			
			try {
				// Create file to write to
				FileWriter outfile = new FileWriter("SortedEmployee.txt");
				
				// Write to SortedEmployee.txt
				for(Employee emp : employees) {
					outfile.write(emp.getID() + "\n");
					outfile.write(emp.getName() + "\n");
					outfile.write(emp.getSalary() + "\n");
					outfile.write(emp.getDepartment() + "\n");
					outfile.write(emp.getPosition() + "\n");
					outfile.write(emp.getYears() + "\n\n");
				}
					
				outfile.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
}