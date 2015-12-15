package com.vebitot.mcm.androidclient.models;

import java.io.Serializable;
/**
 * Generic model class for storing contacts
 * @author vebitot
 */
public class Contacts implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mMobile;
	private String mOfficeDeskPhone;
	private String mEmail;
	private String address;
	
	public String getmMobile() {
		return mMobile;
	}

	public void setmMobile(String mMobile) {
		this.mMobile = mMobile;
	}

	public String getmOfficeDeskPhone() {
		return mOfficeDeskPhone;
	}

	public void setmOfficeDeskPhone(String mOfficeDeskPhone) {
		this.mOfficeDeskPhone = mOfficeDeskPhone;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public class Address{
		private String mAddessLine1;
		private String mAddressLine2;
		private String mCity;
		private String mState;
		private int mPinCode;
		private String mCountry;
		private float lat;
		private float lon;
		public String getmAddessLine1() {
			return mAddessLine1;
		}
		public void setmAddessLine1(String mAddessLine1) {
			this.mAddessLine1 = mAddessLine1;
		}
		public String getmAddressLine2() {
			return mAddressLine2;
		}
		public void setmAddressLine2(String mAddressLine2) {
			this.mAddressLine2 = mAddressLine2;
		}
		public String getmCity() {
			return mCity;
		}
		public void setmCity(String mCity) {
			this.mCity = mCity;
		}
		public String getmState() {
			return mState;
		}
		public void setmState(String mState) {
			this.mState = mState;
		}
		public int getmPinCode() {
			return mPinCode;
		}
		public void setmPinCode(int mPinCode) {
			this.mPinCode = mPinCode;
		}
		public String getmCountry() {
			return mCountry;
		}
		public void setmCountry(String mCountry) {
			this.mCountry = mCountry;
		}
		public float getLat() {
			return lat;
		}
		public void setLat(float lat) {
			this.lat = lat;
		}
		public float getLon() {
			return lon;
		}
		public void setLon(float lon) {
			this.lon = lon;
		}
	}
}
