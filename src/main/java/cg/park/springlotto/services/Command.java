package cg.park.springlotto.services;

import cg.park.springlotto.utils.Param;

public abstract class Command {
    public final Param execute(Param param) {
        String preResult = pre(param);
        if (!preResult.startsWith("S")) return new Param().set("resCd", preResult);
        Param postResult = post(param);
        return postResult;
    };
    public abstract String pre(Param param);
    public abstract Param post(Param param);
}
