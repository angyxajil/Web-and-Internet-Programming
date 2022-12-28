package cs3220.model;

public class NewAttractionsEntry {

	private String name;
	private String phone;
	private String review;

	public NewAttractionsEntry() {

	}

	public NewAttractionsEntry(String name, String phone) {

		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}