package model;


import view.Layout;

import java.io.Serializable;
import java.time.LocalDate;


public class Member implements Serializable{

	private int ID;
	private	String name;
	private String curso;
	private String ano;

	public Member(){
		//this.fee = false;
		this.name = "n/a";
		this.ID = 0;
	}

	public Member(String name,int id,String curso,String ano){
		this.name = name;
		this.ID = id;
		this.curso = curso;
		this.ano = ano;
	}

	public Member(Member x){
		this.name = x.getName();
		this.ID = x.getID();
	}
	public void setID(int ID) {
		this.ID = ID;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
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