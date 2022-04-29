package cg.park.springlotto.services;

import cg.park.springlotto.models.MessageDto;
import cg.park.springlotto.utils.MessageUtil;
import cg.park.springlotto.utils.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

public abstract class CommandService {

    @Autowired
    MessageUtil messageUtil;

    public final MessageDto execute(Param param) {
        Param preResult = preService(param);
        if (!((String) preResult.get("code")).startsWith("S")) return messageUtil.resMessage(preResult);
        Param postResult = postService(param);
        return messageUtil.resMessage(postResult);
    };
    public abstract Param preService(Param param);
    public abstract Param postService(Param param);
}
