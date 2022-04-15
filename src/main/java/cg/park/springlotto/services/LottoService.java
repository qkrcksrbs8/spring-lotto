package cg.park.springlotto.services;

import cg.park.springlotto.utils.Param;

// 어뎁터 클래스
public abstract class LottoService extends Command{
    public abstract Param LottoServicePre(Param param);
    public abstract Param LottoServicePost(Param param);
    public Param pre(Param param) {
        return LottoServicePre(param);
    }
    public Param post(Param param) {
        return LottoServicePost(param);
    }
}
