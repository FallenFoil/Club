package model;

import java.util.List;
import java.util.Map;

public interface ModelFacade {
    boolean AddMember(int id, String nome);
    boolean removeMember(String x);
    Map<Member,List<Fee>> getInfo();
    void save();
}
