package market.model;

import java.util.Date;



public class BeanUser {

	public static BeanUser currentLoginUser=null;
	
	private String usertype;
	private int user_id;
	private String user_name;
	private String user_sex;
	private String user_password;
	private String user_phone;
	private String user_email;
	private String user_city;
	private Date user_registration;
	private String user_member;
	private Date user_deadline;
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_city() {
		return user_city;
	}
	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}
	public Date getUser_registration() {
		return user_registration;
	}
	public void setUser_registration(Date user_registration) {
		this.user_registration = user_registration;
	}
	public String getUser_member() {
		return user_member;
	}
	public void setUser_member(String user_member) {
		this.user_member = user_member;
	}
	public Date getUser_deadline() {
		return user_deadline;
	}
	public void setUser_deadline(Date user_deadline) {
		this.user_deadline = user_deadline;
	}
	
}
