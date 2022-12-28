package cs3220.model;

public class StudentEntry {
	static int idSeed = 1;
	private int studentId;

	private String name;
	private int birthYear;
	private String parentName;
	private String parentEmail;
	private GroupEntry group;
	private String groupName;

	public StudentEntry(String name, int birthYear, String parentName, String parentEmail, GroupEntry group) {
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

	public GroupEntry getGroup() {
		return group;
	}

	public void setGroup(GroupEntry group) {
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
