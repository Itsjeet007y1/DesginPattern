package design.patterns.structural;

import java.util.ArrayList;
import java.util.List;

// Component
interface Employee {
	void showDetails();
}

// Leaf
class Developer implements Employee {
	
	private String name;

	public Developer(String name) {
		this.name = name;
	}

	@Override
	public void showDetails() {
		System.out.println("Developer: " + name);
	}
}

// Leaf
class Manager implements Employee {
	
	private String name;

	public Manager(String name) {
		this.name = name;
	}

	@Override
	public void showDetails() {
		System.out.println("Manager: "+ name);
	}
	
}

// Composite
class TeamLead implements Employee {
	
	private String name;
	private List<Employee> teamMembers = new ArrayList<Employee>();

	public TeamLead(String name) {
		super();
		this.name = name;
	}

	public void addMember(Employee employee) {
		teamMembers.add(employee);
	}

	@Override
	public void showDetails() {
		System.out.println("Team Lead: "+ name);
		System.out.println("Team members:");
		teamMembers.forEach(member -> {
			member.showDetails();
		});
	}
}

public class CompositeExample {
	public static void main(String[] args) {
		Developer dev1 = new Developer("Rahul");
		Developer dev2 = new Developer("Abhinendra");
		Manager manager = new Manager("Santosh");
		TeamLead teamLead = new TeamLead("Jitendra Kumar");
		teamLead.addMember(dev1);
		teamLead.addMember(dev2);
		teamLead.addMember(manager);
		teamLead.showDetails();
	}
}
