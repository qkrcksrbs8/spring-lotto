package cg.park.springlotto.services;

import cg.park.springlotto.utils.Param;

public interface Execute {
    String pre(Param param);
    Param execute(Param param);
    void post();
}
