package cs3220.model;

public class NewReservationEntry {

	static int idSeed = 1;
	private String name;
	private String weekDay;
	private String time;
	private int id;
	

	public NewReservationEntry(String name, String weekDay, String time) {
		
		id = idSeed++;
		this.time = time;
		this.weekDay = weekDay;
		this.name = name;

	}

	public NewReservationEntry() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}