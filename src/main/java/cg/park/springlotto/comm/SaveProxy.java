package cg.park.springlotto.comm;

import cg.park.springlotto.models.MessageDto;
import cg.park.springlotto.utils.LottoHistoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveProxy implements Proxy {

    @Autowired
    LottoHistoryUtil lottoHistoryUtil;

    @Override
    public MessageDto resProxy(MessageDto messageDto) {
        if (messageDto.getCode().startsWith("S")) lottoHistoryUtil.saveMessageHistory(messageDto);
        return messageDto;
    }
}
