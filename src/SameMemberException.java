public class SameMemberException extends Exception{

    public SameMemberException(){
        super();
    }

    public SameMemberException(String x){
        super(x);
    }

    public SameMemberException(SameMemberException x){
        super(x);
    }
}
