package cg.park.springlotto.comm;

import cg.park.springlotto.models.MessageDto;

public interface Proxy {
    MessageDto resProxy(MessageDto messageDto);
}
