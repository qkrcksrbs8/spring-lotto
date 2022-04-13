package cg.park.springlotto.services;

import cg.park.springlotto.models.Message;
import cg.park.springlotto.utils.MessageUtil;
import cg.park.springlotto.utils.Param;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Command {

    @Autowired
    MessageUtil messageUtil;

    public final Message execute(Param param) {
        Param preResult = pre(param);
        if (!((String) preResult.get("code")).startsWith("S")) return messageUtil.resMessage(preResult);
        Param postResult = post(param);
        return messageUtil.resMessage(postResult);
    };
    public abstract Param pre(Param param);
    public abstract Param post(Param param);
}
