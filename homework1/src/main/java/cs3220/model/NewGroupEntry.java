package cs3220.model;

public class NewGroupEntry {

	static int idSeed = 1;
	private int id;
	private int numOfStudents = 0;

	private String name;

	public NewGroupEntry(String name) {
		this.id = idSeed++;
		this.name = name;
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

	public int getNumOfStudents() {
		return numOfStudents;
	}

	public void addStudent() {
		this.numOfStudents++;
	}

}