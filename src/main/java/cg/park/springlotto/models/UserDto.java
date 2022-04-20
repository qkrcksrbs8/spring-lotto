package cg.park.springlotto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int seq;
    private String name;
    private String age;
    private String created_date;
    private String update_date;
}
