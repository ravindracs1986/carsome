package com.carsome.portal.model;

import java.sql.Timestamp;

import javax.persistence.Column;

public class InspectionDto implements java.io.Serializable {

	private static final long serialVersionUID = -4393320270992003990L;

	private Long id;
	private String slotCategory;
	private String slotDate;
	private String slotStartTime;
	private String slotEndTime;
	private String userName;
	private String userEmail;
	private String userPhone;
	
	private String slotTime;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the slotCategory
	 */
	public String getSlotCategory() {
		return slotCategory;
	}
	/**
	 * @param slotCategory the slotCategory to set
	 */
	public void setSlotCategory(String slotCategory) {
		this.slotCategory = slotCategory;
	}
	/**
	 * @return the slotDate
	 */
	public String getSlotDate() {
		return slotDate;
	}
	/**
	 * @param slotDate the slotDate to set
	 */
	public void setSlotDate(String slotDate) {
		this.slotDate = slotDate;
	}
	/**
	 * @return the slotStartTime
	 */
	public String getSlotStartTime() {
		return slotStartTime;
	}
	/**
	 * @param slotStartTime the slotStartTime to set
	 */
	public void setSlotStartTime(String slotStartTime) {
		this.slotStartTime = slotStartTime;
	}
	/**
	 * @return the slotEndTime
	 */
	public String getSlotEndTime() {
		return slotEndTime;
	}
	/**
	 * @param slotEndTime the slotEndTime to set
	 */
	public void setSlotEndTime(String slotEndTime) {
		this.slotEndTime = slotEndTime;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * @return the userPhone
	 */
	public String getUserPhone() {
		return userPhone;
	}
	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	/**
	 * @return the slotTime
	 */
	public String getSlotTime() {
		return slotTime;
	}
	/**
	 * @param slotTime the slotTime to set
	 */
	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}
	
	
	
}
