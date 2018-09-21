package model;

import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;

public class Member{

	private int ID;
	private	String name;

	public Member(){
		this.name = "n/a";
		this.ID = 0;
	}

	public Member(String name,int id){
		this.name = name;
		this.ID = id;
	}
	
	public Member(Member x){
		this.name = x.getName();
		this.ID = x.getID();
	}

	public String getName(){
		return this.name;
	}

	public int getID(){
		return this.ID;
	}

	public void setName(String name){
		this.name = name;
	}


	public boolean equals(Object obj){
		if(obj == this){return true;}
		if(obj == null || obj.getClass()!=this.getClass()){return false;}

		Member m = (Member) obj;

		return this.getName().equals(m.getName()) && this.getID() == (m.getID());
	}

	public String toString(){
		StringBuilder sb = new StringBuilder("Member:\n");
		sb.append("Name: ").append(this.name).append(";");
		sb.append("\n");

		return sb.toString();
	}

	public Member clone(){
		return new Member(this);
	}
}