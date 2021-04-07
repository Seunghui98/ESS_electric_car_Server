package ess;

public class GwangjuEss {
	private int id;
	private String name;
	private String address;
	private String gu;
	private String dong;
	private double latitude;
	private double longitude;
	private double now;
	
	public GwangjuEss(int id, String name, String address, String gu, String dong, double latitude, double longitude, double now) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.gu = gu;
		this.dong = dong;
		this.latitude = latitude;
		this.longitude = longitude;
		this.now = now;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getNow() {
		return now;
	}
	public void setNow(double now) {
		this.now = now;
	}
	
	
}
