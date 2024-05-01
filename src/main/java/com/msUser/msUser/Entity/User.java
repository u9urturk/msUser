package com.msUser.msUser.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "register_type")
	private int registerType;

	@Column(name = "is_valid")
	private boolean isValid;

	@Column(name = "verification_code")
	private String verificationCode;

	public User(Long id, String firstName, String lastName, int registerType, boolean isValid,
			String verificationCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.registerType = registerType;
		this.isValid = isValid;
		this.verificationCode = verificationCode;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRegisterType() {
		return registerType;
	}

	public void setRegisterType(int registerType) {
		this.registerType = registerType;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

}
