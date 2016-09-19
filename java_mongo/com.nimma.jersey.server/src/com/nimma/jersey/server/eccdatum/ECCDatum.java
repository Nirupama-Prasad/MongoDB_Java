package com.nimma.jersey.server.eccdatum;


import java.math.BigInteger;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public class ECCDatum {
	
	private String message; //Name of item
	private BigInteger hash;
	private BigInteger signature;
	private BigInteger signx;
	private BigInteger public_key_x;
	private BigInteger public_key_y;

	
	//Dummy c-tor 
	public ECCDatum(){
		
	}
	
	@JsonCreator
	public ECCDatum (@JsonProperty("message") String message, @JsonProperty("hash") BigInteger hash,
					@JsonProperty("signx") BigInteger signx, @JsonProperty("signature") BigInteger signature,
					@JsonProperty("public_key_x") BigInteger public_key_x, 
					@JsonProperty("public_key_y") BigInteger public_key_y){ 
		this.message = message;
		this.hash = hash;
		this.signature = signature;
		this.signx = signx;
		this.public_key_x = public_key_x;
		this.public_key_y = public_key_y;

	}
	
	public void setmessage(String message){
		this.message = message;
	}
	
	public String getmessage() {
		return message;
	}
	
	public void sethash(BigInteger hash){
		this.hash = hash;
	}
	
	public BigInteger gethash() {
		return hash;
	}
	
	public BigInteger getsignature(){
		return signature;
	}
	
	public void setsignature(BigInteger signature){
		this.signature = signature;
	}
	
	public BigInteger getsignx(){
		return signx;
	}
	
	public void setsignx(BigInteger signx){
		this.signx = signx;
	}
	
	public BigInteger get_public_key_x(){
		return public_key_x;
	}
	
	public void set_public_key_x(BigInteger public_key_x){
		this.public_key_x = public_key_x;
	}
	
	public BigInteger get_public_key_y(){
		return public_key_y;
	}
	
	public void set_public_key_y(BigInteger public_key_y){
		this.public_key_y = public_key_y;
	}
	
	@Override
	public String toString(){
		return "{" 
				+"\"message\": \"" + message + "\""
				+ "," + "\"hash\": \"" + hash + "\""
				+ "," + "\"signature\": \"" +  signature + "\""
				+ "," + "\"signx\": \"" + signx + "\"" 
				+ "," + "\"public_key_x\": \"" + public_key_x + "\"" 
				+ "," + "\"public_key_y\": \"" + public_key_y + "\"" 
				+ "}";
	}

}
