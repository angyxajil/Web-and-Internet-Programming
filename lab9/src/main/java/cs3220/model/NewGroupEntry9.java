package cs3220.model;

public class NewGroupEntry9 {

	static int idSeed=1;
	private int id;
	private int numOfStudents=0;
	
	private String name;
	
	public NewGroupEntry9(String name) {
		this.id=idSeed++;
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
	
	// method to increase the amount of students when new student added
	public void addStudent() {
		this.numOfStudents++;
	}
}