package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ModelFacade {
    boolean AddMember(int id, String nome,String curso,String ano);
    boolean removeMember(String x);
    Map<Integer, List<Fee>> getInfo();
    String getMemberName(Integer x);
    String getMemberYear(Integer x);
    String getMemberCurse(Integer x);
    //void setFee(int idMember, int idFee);
    Map<LocalDate,Boolean> getMemberFee(Integer x);
    void setMember(int id, String name,String curso,String ano);
    void save();
}
