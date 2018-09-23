package model;

import java.util.List;
import java.util.Map;

public interface ModelFacade {

    boolean AddMember(Member x);
    boolean removeMember(String x);
    Map<Member,List<Fee>> getInfo();
}
