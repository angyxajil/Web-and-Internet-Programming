package cs3220.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private String name;

	private List<Faculty> faculty;

	public Department() {
		faculty = new ArrayList<Faculty>();
	}

	public Department(String name) {
		this();
		this.name = name;
		faculty = new ArrayList<Faculty>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Faculty> getFaculty() {
		return faculty;
	}

	public void setFaculty(List<Faculty> faculty) {
		this.faculty = faculty;
	}

}