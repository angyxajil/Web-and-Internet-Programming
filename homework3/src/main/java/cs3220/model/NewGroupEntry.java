package cs3220.model;

public class NewGroupEntry {

	private int id;
	private int numOfStudents = 0;

	private String name;

	public NewGroupEntry(String name) {
	}

	public NewGroupEntry() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// method to get the number of students in a group
	public int getNumOfStudents() {
		return numOfStudents;
	}

	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}

	// method to increase the amount of students when new student added
	public void addStudent() {
		this.numOfStudents++;
	}

}