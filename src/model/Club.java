package model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Club{

	public List<String> members;
	public Map<String,Map<LocalDate,Double>> payments;

	public Club(){
		this.members = new ArrayList<>();
		this.payments = new HashMap<>();
	}
	
	public Club(List<String> x , Map<String,Map<LocalDate,Double>> y){
		setMembers(x);
		setPayments(y);
	}

	public Club(Club x){
		try {
			this.members = x.getMembers();
			this.payments = x.getPayments();
		}catch (Exception e){
			this.members = new ArrayList<>();
		}
	}


	//Getters!
	public List<String> getMembers() throws EmptyListException{

		List<String> result = new ArrayList<>();

		if(this.members.size() == 0) throw new EmptyListException("Nenhum membro associado ao Cesium.");
		for (String m : this.members) {
				result.add(m);
			}

		return result;
	}

	public Map<String,Map<LocalDate,Double>> getPayments(){

		Map<String,Map<LocalDate,Double>> result = new HashMap<>();

		for(Map.Entry<String ,Map<LocalDate, Double>> entry : this.payments.entrySet()){

			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}


	//Setters!
	public void setMembers(List<String> x){
		this.members = new ArrayList<>();
		for(String m : x){
			this.members.add(m);
		}
	}

	public void setPayments(Map<String,Map<LocalDate,Double>> x){
		this.payments = new HashMap<>();
		for(Map.Entry<String,Map<LocalDate, Double>> entry : x.entrySet()){
			this.payments.put(entry.getKey(), entry.getValue());
		}
	}


	public boolean equals(Object obj){

		if(obj == this){return true;}
		if(obj == null || obj.getClass()!=this.getClass()){return false;}

		Club c = (Club) obj;

		boolean r;

		try{
			r = this.members.equals(c.getMembers());
		}catch (Exception e){
			r = false;
		}
		return r;
	}


	public Club clone(){
		return new Club(this);
	}

	public String toString(){
		StringBuilder sb = new StringBuilder("Club:\n");
		sb.append("List of Members:\n").append(this.members);

		return sb.toString();
	}

	public boolean AddMember(String x) {
		if (!this.members.contains(x)) {
			this.members.add(x);
			return true;
		}
		return false;
	}

	public void RemoveMember(String x){
		if(this.members.contains(x)){
			this.members.remove(x);
		}
		if(this.payments.containsKey(x)){
			this.payments.remove(x);
		}
	}
}