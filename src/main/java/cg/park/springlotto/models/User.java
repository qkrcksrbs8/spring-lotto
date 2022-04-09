package cg.park.springlotto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String age;
    private String email;
    private String etc;
}
