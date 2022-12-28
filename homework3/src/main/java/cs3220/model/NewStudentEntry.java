package cs3220.model;

public class NewStudentEntry {
	static int idSeed = 1;
	private int studentId;

	private String name;
	private int birthYear;
	private String parentName;
	private String parentEmail;
	private NewGroupEntry group;
	private String groupName;

	public NewStudentEntry(String name, int birthYear, String parentName, String parentEmail, NewGroupEntry group) {
		this.setStudentId(idSeed++);
		this.name = name;
		this.birthYear = birthYear;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.group = group;
		this.setGroupName(group.getName());
	}

	public NewStudentEntry() {

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

	public NewGroupEntry getGroup() {
		return group;
	}

	public void setGroup(NewGroupEntry group) {
		this.group = group;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int id) {
		this.studentId = id;
	}
}
