package cg.park.springlotto.models;

import cg.park.springlotto.utils.Param;
import lombok.Data;

@Data
public class MessageVo {
    private Param data;
    private String code;
    private String message;
}
