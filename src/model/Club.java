package model;

//// Imports que não deveriam de estar aqui////
import data.ClubDataManager;
///////////////////////////////////////////////

import data.DataFacade;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Club implements ModelFacade, Serializable {

	//Variaveis e metodos de Classe
	private static DataFacade dataManager = new ClubDataManager();
	private static String file = "test.dss";
	private static Club ourInstance = new Club();

	public static Club getInstance() {
		return ourInstance;
	}
	public static void setInstance() {
		Object o = dataManager.fetchData(Club.file);
		if(o.getClass() == Club.ourInstance.getClass())
			Club.ourInstance = (Club) o;
	}


	//Variaveis e metodos de instancia

	public Map<Member,List<Fee>> info;

	public Club(){
		this.info = new HashMap<>();
	}

	public Club(Map<Member,List<Fee>> x){
		setInfo(x);
	}

	public Club(Club x){
		try {
			this.info = x.getInfo();
		}catch (Exception e){
			this.info = new HashMap<>();
		}
	}


	//Getters!

	public Map<Member,List<Fee>> getInfo(){

		Map<Member,List<Fee>> result = new HashMap<>();

		for(Map.Entry<Member ,List<Fee>> entry : this.info.entrySet()){

			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}


	//Setters!
	public void setInfo(Map<Member,List<Fee>> x){
		this.info = new HashMap<>();
		for(Map.Entry<Member,List<Fee>> entry : x.entrySet()){
			this.info.put(entry.getKey(), entry.getValue());
		}
	}


	public boolean equals(Object obj){

		if(obj == this){return true;}
		if(obj == null || obj.getClass()!=this.getClass()){return false;}

		Club c = (Club) obj;

		boolean r;

		return this.info.equals(c.getInfo());

	}


	public Club clone(){
		return new Club(this);
	}

	public String toString(){
		StringBuilder sb = new StringBuilder("Club:\n");
		sb.append("List of Members:\n").append(this.info);

		return sb.toString();
	}

	public boolean AddMember(Member x) {
		if (!this.info.containsKey(x)) {
			this.info.put(x,new ArrayList<>());
			return true;
		}
		return false;
	}

	public void removeMember(String x){
		if(this.info.containsKey(x)){
			this.info.remove(x);
		}
	}
}