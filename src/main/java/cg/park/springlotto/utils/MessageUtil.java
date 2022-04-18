package cg.park.springlotto.utils;

import cg.park.springlotto.daos.MessageDao;
import cg.park.springlotto.models.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

    @Autowired
    MessageDao messageDao;

    public MessageVo resMessage(Param param) {
        String code = (String) param.getOrDefault("code", "E1000");
        MessageVo message = messageDao.selectMessage(code);
        param.remove("code");
        message.setData(param);
        return message;
    }

}
