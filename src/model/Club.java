package model;


import data.DataFacade;

import java.io.Serializable;
import java.util.*;

public class Club implements ModelFacade, Serializable  {

	//Variaveis e metodos de Classe
	private static DataFacade dataManager;
	private static String file = "test.dss";


	//Para manter a mesma versão da instancia no ficheiro
	private static final long serialVersionUID = 1L;

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

	private Map<Member,List<Fee>> info;


	public Club() {
		this.info = new  LinkedHashMap<>();
	}

	public Club(Map<Member,List<Fee>> x){
		setInfo(x);
	}

	public Club(DataFacade df){
		Club.dataManager = df;
		new Club();
	}

	public void save(){
		if(Club.dataManager != null){
			Club.dataManager.saveData(this, Club.file);
		}
	}


	//Getters!

	public Map<Member,List<Fee>> getInfo(){

		Map<Member,List<Fee>> result = new  LinkedHashMap<>();

		for(Map.Entry<Member ,List<Fee>> entry : this.info.entrySet()){

			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}


	//Setters!
	public void setInfo(Map<Member,List<Fee>> x){
		this.info = new LinkedHashMap<>();
		for(Map.Entry<Member,List<Fee>> entry : x.entrySet()){
			this.info.put(entry.getKey(), entry.getValue());
		}
	}


	public boolean equals(Object obj){

		if(obj == this){return true;}
		if(obj == null || obj.getClass()!=this.getClass()) return false;

		Club c = (Club) obj;

		boolean r;

		return this.info.equals(c.getInfo());

	}


	public Club clone(){
		return Club.getInstance();
	}

	public String toString(){
		StringBuilder sb = new StringBuilder("Club:\n");
		sb.append("List of Members:\n").append(this.info);

		return sb.toString();
	}

	public boolean AddMember(int id, String nome) {
		for(Member m : this.info.keySet()){
			if(m.getID() == id) return false;
		}
		this.info.put(new Member(nome, id), new ArrayList<>());
		return true;
	}

	public boolean removeMember(String x){
		for(Member a : this.info.keySet()){
			if(a.getID() ==  Integer.parseInt(x)){
				this.info.remove(a);
				return true;
			}
		}
		return false;
	}
}