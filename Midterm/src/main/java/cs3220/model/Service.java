package cs3220.model;

import java.time.LocalTime;
import java.util.List;

public class Service {
	static int idSeed = 1;
	private int id;

	private LocalTime time;
	private String name;
	private String type;
	private String status; 
	private String des;

	public Service() {
		id = idSeed++;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		
	}

	public LocalTime gettime() {
        return time;
    }
    
    public void settime() {
        this.time = LocalTime.now();    
    }

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
}