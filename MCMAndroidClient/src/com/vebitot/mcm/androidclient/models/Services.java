package com.vebitot.mcm.androidclient.models;

import java.io.Serializable;
import java.util.Map;
/**
 * Model class describing a service
 * @author vebitot
 */
public class Services implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String mServiceName;
	private String mServiceDescription;
	private String mServiceOwner;
	/**
	 * Should be an array of tags instead
	 */
	private String mSpecilization;
	private String mServiceType;
	private OperatingHours mOperatingHours;
	private int mRating;
	
	public String getmServiceName() {
		return mServiceName;
	}

	public void setmServiceName(String mServiceName) {
		this.mServiceName = mServiceName;
	}

	public String getmServiceDescription() {
		return mServiceDescription;
	}

	public void setmServiceDescription(String mServiceDescription) {
		this.mServiceDescription = mServiceDescription;
	}

	public String getmServiceOwner() {
		return mServiceOwner;
	}

	public void setmServiceOwner(String mServiceOwner) {
		this.mServiceOwner = mServiceOwner;
	}

	public String getmSpecilization() {
		return mSpecilization;
	}

	public void setmSpecilization(String mSpecilization) {
		this.mSpecilization = mSpecilization;
	}

	public OperatingHours getmOperatingHours() {
		return mOperatingHours;
	}

	public void setmOperatingHours(OperatingHours mOperatingHours) {
		this.mOperatingHours = mOperatingHours;
	}

	public int getmRating() {
		return mRating;
	}

	public void setmRating(int mRating) {
		this.mRating = mRating;
	}

	/**
	 * @return the mServiceType
	 */
	public String getmServiceType() {
		return mServiceType;
	}

	/**
	 * @param mServiceType the mServiceType to set
	 */
	public void setmServiceType(String mServiceType) {
		this.mServiceType = mServiceType;
	}

	public class OperatingHours {
		private Map<Day,String> mOpeartingSchedule;

		/**
		 * Format of the schedule : [DAY,"FROM-TO"]
		 * Eg: [MONDAY,"9.30-18.00"]
		 * @return Map
		 */
		public Map<Day, String> getOpeartingSchedule() {
			return mOpeartingSchedule;
		}
		
		/**
		 * Format of the schedule : [DAY,"FROM-TO"]
		 * Eg: [MONDAY,"9.30-18.00"]
		 */
		public void setOpeartingSchedule(Map<Day, String> opeartingSchedule) {
			this.mOpeartingSchedule = opeartingSchedule;
		}
	}
	
	public static enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	}
}
