package cs3220.model;

public class NewCommentEntry {

	private String parkName;
	private String personName;
	private String review;

	public NewCommentEntry() {

	}

	public NewCommentEntry(String parkName, String name, String review) {

		this.parkName = parkName;
		this.personName = name;
		this.review = review;

	}

	public String getName() {
		return personName;
	}

	public void setName(String name) {
		this.personName = name;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

}