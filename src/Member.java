package model;

import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;

public class Member{
	public String name;
	public Map<LocalDate, Double> payments;

	public Member(){
		this.name = "n/a";
		this.payments = new HashMap<>();
	}

	public Member(String name, Map<LocalDate, Double> payments){
		this.name = name;
		setPayments(payments);
	}
	
	public Member(Member otherMember){
		this.name = otherMember.getName();
		setPayments(otherMember.getPayments());
	}

	public String getName(){
		return this.name;
	}

	public Map<LocalDate, Double> getPayments(){
		Map<LocalDate, Double> result = new HashMap<>();
		for(Map.Entry<LocalDate, Double> entry : this.payments.entryset()){
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setPayments(Map<LocalDate, Double> map){
		this.payments = new HashMap<>();
		for(Map.Entry<LocalDate, Double> entry : map.entryset()){
			this.payments.put(entry.getKey(), entry.getValue());
		}
	}

	public boolean equals(Object obj){
		if(obj == this){return true;}
		if(obj == null || obj.getClass()!=this.getClass()){return false;}

		Member m = (Member) obj;

		return this.getName().equals(m.getname()) && this.getPayments().equals(m.getPayments());
	}

	public String toString(){
		StringBuilder sb = new StringBuilder("Member:\n");
		sb.append("Name: ").append(this.name).append(";");
		sb.append("payments: ").append(this.payments).append(";");
		sb.append("\n");

		return sb.toString();
	}

	public Member clone(){
		return new Member(this)
	}
}