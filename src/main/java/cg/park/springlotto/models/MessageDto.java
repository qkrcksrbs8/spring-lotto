package cg.park.springlotto.models;

import cg.park.springlotto.utils.Param;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class MessageDto {

    public MessageDto() {}

    public MessageDto(Param data, String code) {
        this.data = data;
        this.code = code;
    }

    public MessageDto(Param data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    @NotNull
    private Param data;

    @NotNull
    private String code;
    private String message;
}
