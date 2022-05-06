package cg.park.springlotto.jpaModels;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class userLottoHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;
    private int groupNo;
    private int memberNo;
    private String memberFlag;
    private int round;
    private int firstNo;
    private int secondNo;
    private int thirdNo;
    private int forthNo;
    private int fifthNo;
    private int sixthNo;
    private String createdDate;
    private String createdUser;
    private String updateDate;
    private String updateUser;
}
