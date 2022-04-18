package cg.park.springlotto.models;

import lombok.*;

import java.util.List;

@Data
public class UserLottoHistoryVo {
    private int memberNo;
    private String memberFlag;
    private int round;
    private List<LottoNumberVo> lottoNumbers;
    private String createdDate;
    private String createdUser;
    private String updateDate;
    private String updateUser;
}
