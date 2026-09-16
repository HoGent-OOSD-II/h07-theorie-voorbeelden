package domein;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
	private String firstName;
	private String lastName;
	private double salary;
	private String department;

	public Employee(String firstName, String lastName, double salary, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.department = department;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public final void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public final void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public String getName() {
		return String.format("%s %s", getFirstName(), getLastName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(firstName, other.firstName) 
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return String.format("%-8s %-8s %8.2f   %s", getFirstName(), getLastName(), getSalary(), getDepartment());
	}

	@Override
	public int compareTo(Employee e) {
		int lastNameCompare = lastName.compareTo(e.lastName);
		return (lastNameCompare == 0) ? firstName.compareTo(e.firstName) : lastNameCompare;
	}

}