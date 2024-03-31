package domain;

import java.time.LocalTime;
import java.util.Date;

public class Session {
	private String id;
	private Date date;
	private LocalTime time;
	private String serviceId;
	
	public Session() {
	}
	
	public Session(String id, Date date, LocalTime time, String serviceId) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.serviceId = serviceId;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
}
