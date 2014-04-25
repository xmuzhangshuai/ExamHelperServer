package com.jsonobjects;

import com.yrw.domains.User;

/**
 * Entity mapped to table USER.
 */
public class JUser {

	private Long id;
	/** Not-null value. */
	private String mail;
	/** Not-null value. */
	private String password;
	private String nickname;
	private String realname;
	private Integer age;
	private String phone;
	private String gender;
	private String user_state;
	private String profession;
	private String area;
	private Integer integral;
	private String avatar;

	public JUser() {
	}

	public JUser(Long id) {
		this.id = id;
	}

	public JUser(Long id, String mail, String password, String nickname, String realname, Integer age, String phone,
			String gender, String user_state, String profession, String area, Integer integral, String avatar) {
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.nickname = nickname;
		this.realname = realname;
		this.age = age;
		this.phone = phone;
		this.gender = gender;
		this.user_state = user_state;
		this.profession = profession;
		this.area = area;
		this.integral = integral;
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", password=" + password + ", nickname=" + nickname
				+ ", realname=" + realname + ", age=" + age + ", phone=" + phone + ", gender=" + gender
				+ ", user_state=" + user_state + ", profession=" + profession + ", area=" + area + ", integral="
				+ integral + ", avatar=" + avatar + "]";
	}

	/**
	 * 将网络传回的User变为本地User
	 * 
	 * @return
	 */
	public User NetToLocal() {

		User localUser = new User(mail, password, nickname, realname, age, phone, gender, avatar, user_state,
				profession, area, integral, null, null, null, null, null, null);
		localUser.setId(id.intValue());
		return localUser;
	}

	/**
	 * 本地User变为网络User
	 * 
	 * @param localAnswerquery
	 * @return
	 */
	public static JUser LocalToNet(User local) {
		return new JUser((long)local.getId(), local.getMail(), local.getPassword(), local.getNickname(), local.getRealname(),
				local.getAge(), local.getPhone(), local.getGender(), local.getUserState(), local.getProfession(),
				local.getArea(), local.getIntegral(), local.getAvatar());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/** Not-null value. */
	public String getMail() {
		return mail;
	}

	/**
	 * Not-null value; ensure this value is available before it is saved to the
	 * database.
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/** Not-null value. */
	public String getPassword() {
		return password;
	}

	/**
	 * Not-null value; ensure this value is available before it is saved to the
	 * database.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
