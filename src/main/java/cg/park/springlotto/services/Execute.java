package cg.park.springlotto.services;

import cg.park.springlotto.utils.Param;

public interface Execute {
    public String pre(Param param);
    public Param execute(Param param);
    public void post();
}
