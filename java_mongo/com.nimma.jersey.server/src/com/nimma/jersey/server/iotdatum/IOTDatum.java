package com.nimma.jersey.server.iotdatum;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class IOTDatum {
	private int id; //Department ID
	private String phone_number; //Name of item
	private int device_id;
	
	
	//Dummy c-tor 
	public IOTDatum(){
		
	}
	
	@JsonCreator
	public IOTDatum (@JsonProperty("id") int id, @JsonProperty("phone_number") String s,
						@JsonProperty("device_id") int dev_id){ 
		this.id = id;
		this.phone_number = s;
		this.device_id = dev_id;
	}
	
	public void setid(int id){
		this.id = id;
	}
	
	public int getid() {
		return id;
	}
	
	public void setdeviceid(int dev_id){
		this.device_id = dev_id;
	}
	
	public int getdeviceid() {
		return device_id;
	}
	
	public String getphonenumber(){
		return phone_number;
	}
	
	public void setphonenumber(String s){
		this.phone_number = s;
	}
	
	@Override
	public String toString(){
		return "{" 
				+"\"id\": " + id 
				+ "," + "\"phone_number\": \"" + phone_number + "\""
				+ "," + "\"device_id\": \"" +  device_id + "\""
				+ "}";
	}

}
