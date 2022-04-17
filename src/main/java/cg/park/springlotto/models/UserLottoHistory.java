package cg.park.springlotto.models;

import lombok.*;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLottoHistory {
    private int groupNo = 1;
    private int memberNo = 0;
    private String memberFlag = "0";
    private int firstNo = 0;
    private int secondNo = 0;
    private int thirdNo = 0;
    private int forthNo = 0;
    private int fifthNo = 0;
    private int round = 0;
    private String createdDate = "";
    private String createdUser = "";
    private String updateDate = "";
    private String updateUser = "";
}
