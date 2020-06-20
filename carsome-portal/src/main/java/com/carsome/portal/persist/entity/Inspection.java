package com.carsome.portal.persist.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.carsome.portal.core.AbstractEntity;

/**
 * 
 * CREATE TABLE carsome.Inspection (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `slot_category` varchar(45) DEFAULT NULL,
  `slot_date` Date DEFAULT NULL,
  `slot_startTime` timestamp NULL DEFAULT NULL,
  `slot_endTime` timestamp NULL DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  `user_phone` varchar(45) DEFAULT NULL,
  `crt_ts` timestamp NULL DEFAULT NULL,
  `update_ts` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
 * 
 * 
 * 
 * 
 * 
 * @author rvkum
 *
 */
@Entity
@Table(name = "Inspection")
public class Inspection extends AbstractEntity implements java.io.Serializable {

	private static final long serialVersionUID = -4393320270992003990L;
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "slot_category")
	private String slotCategory;

	@Column(name = "slot_date")
	private Date slotDate;

	@Column(name = "slot_startTime")
	private Timestamp slotStartTime;

	@Column(name = "slot_endTime")
	private Timestamp slotEndTime;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_phone")
	private String userPhone;
	 
	@Column(name = "crt_ts")
	private Timestamp crtTs;
	
	@Column(name = "update_ts")
	private Timestamp updateTs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	@Override
	public Timestamp getCrtTs() {

		return this.crtTs;
	}

	@Override
	public void setCrtTs(Timestamp crtTs) {
		this.crtTs = crtTs;

	}

	public Timestamp getUpdateTs() {
		return updateTs;
	}

	public void setUpdateTs(Timestamp updateTs) {
		this.updateTs = updateTs;
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
	public Date getSlotDate() {
		return slotDate;
	}

	/**
	 * @param slotDate the slotDate to set
	 */
	public void setSlotDate(Date slotDate) {
		this.slotDate = slotDate;
	}

	/**
	 * @return the slotStartTime
	 */
	public Timestamp getSlotStartTime() {
		return slotStartTime;
	}

	/**
	 * @param slotStartTime the slotStartTime to set
	 */
	public void setSlotStartTime(Timestamp slotStartTime) {
		this.slotStartTime = slotStartTime;
	}

	/**
	 * @return the slotEndTime
	 */
	public Timestamp getSlotEndTime() {
		return slotEndTime;
	}

	/**
	 * @param slotEndTime the slotEndTime to set
	 */
	public void setSlotEndTime(Timestamp slotEndTime) {
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
	
	

}
