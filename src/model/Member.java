package model;


import view.Layout;

import java.util.*;
import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;


public class Member implements Serializable{

	//private List observers = new ArrayList<>();
	//private boolean fee ;
	private int ID;
	private	String name;


	public Member(){
		//this.fee = false;
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
	/*
	public void setCotas(){
		this.fee = true;
		this.notifyObservers();
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	public void deleteObserver(Observer o){
		observers.remove(o);
	}

	public void notifyObservers(Object arg){
		for(Observer x : this.observers){
			x.update(this.fee);
		}
	}*/

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