/**
 * 
 */
package com.mkyong.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 */
@Document(collection = "employees")
public class EmployeeVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String firstName;	
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private String organizationId;	
	
	private Date dateOfJoining;
	
	private String sex;
	
	private Integer age;
	
	private String status;
	
	private Integer performanceScore;
	
	private String description;
	
	public EmployeeVO(String firstName, String lastName, String organizationId, String status ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.organizationId = organizationId;
		this.status = status;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPerformanceScore() {
		return performanceScore;
	}

	public void setPerformanceScore(Integer performanceScore) {
		this.performanceScore = performanceScore;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
