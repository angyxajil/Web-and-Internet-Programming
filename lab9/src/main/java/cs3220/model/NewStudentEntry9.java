package cs3220.model;

public class NewStudentEntry9 {
	static int idSeed = 1;

	private String name;
	private int birthYear;
	private String parentName;
	private String parentEmail;
	private NewGroupEntry9 group;
	private int studentId;
	private String groupName;

	// constructor
	public NewStudentEntry9(String name, int birthYear, String parentName, String parentEmail, NewGroupEntry9 group) {
		this.setStudentId(idSeed++);
		this.name = name;
		this.birthYear = birthYear;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.group = group;
		this.setGroupName(group.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public NewGroupEntry9 getGroup() {
		return group;
	}

	public void setGroup(NewGroupEntry9 group) {
		this.group = group;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
