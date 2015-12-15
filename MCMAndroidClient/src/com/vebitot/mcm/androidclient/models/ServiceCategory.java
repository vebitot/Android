package com.vebitot.mcm.androidclient.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A Model describing the types of services available
 * @author vebitot
 */
public class ServiceCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	private String mServiceType;
	private String mServiceTypeLogo;
	private String mDescription;
	private ArrayList<String> tags;
	
	public String getmServiceType() {
		return mServiceType;
	}
	public void setmServiceType(String mServiceType) {
		this.mServiceType = mServiceType;
	}
	public String getmDescription() {
		return mDescription;
	}
	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	public String getmServiceTypeLogo() {
		return mServiceTypeLogo;
	}
	public void setmServiceTypeLogo(String mServiceTypeLogo) {
		this.mServiceTypeLogo = mServiceTypeLogo;
	}
	
	public void addTags(String tag){
		this.tags.add(tag);
	}
	/**
	 * This will be made dynamic 
	 * @author vebitot
	 */
	public static enum ServiceCategories{
		
	}
}
