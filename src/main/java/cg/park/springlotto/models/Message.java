package cg.park.springlotto.models;

import cg.park.springlotto.utils.Param;
import lombok.Data;

@Data
public class Message {
    private Param param;
    private String code;
    private String message;
}
