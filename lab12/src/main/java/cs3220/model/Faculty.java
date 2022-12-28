package cs3220.model;

public class Faculty {

	private String name;

	private boolean isChair;

	public Faculty() {
		isChair = false;
	}

	public Faculty(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChair() {
		return isChair;
	}

	public void setChair(boolean isChair) {
		this.isChair = isChair;
	}

}
