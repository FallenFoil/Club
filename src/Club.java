import java.util.List;
import java.util.ArrayList;

public class Club{
	public List<Member> members;

	public Club(){
		this.members = new ArrayList<>();
	}
	
	public Club(List<Member> Members){
		setMembers(Members);
	}

	public Club(Club x){
		setMembers(x.getMembers());
	}

	//Getters!
	public List<Member> getMembers(){
		List<Member> result = new ArrayList<>();
		for(Member m : this.members){
			result.add(m);
		}
		return result;
	}

	//Setters!
	public void setMembers(List<Member> x){
		this.members = new ArrayList<>();
		for(Member m : x){
			this.members.add(m);
		}
	}

	public boolean equals(Object obj){
		if(obj == this){return true;}
		if(obj == null || obj.getClass()!=this.getClass()){return false;}

		Club c = (Club) obj;

		return this.members.equals(c.getMembers());
	}

	public Club clone(){
		return new Club(this);
	}

	public String toString(){
		StringBuilder sb = new StringBuilder("Club:\n");
		sb.append("List of Members:\n").append(this.members);

		return sb.toString();
	}

}