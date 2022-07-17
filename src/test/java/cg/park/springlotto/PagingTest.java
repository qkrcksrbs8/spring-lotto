package cg.park.springlotto;

import cg.park.springlotto.utils.Param;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@SpringBootTest
public class PagingTest {

    @Test
    public void emailTest() {

        String email = "qkrcksrbs8@naver.com";

        StringTokenizer token = new StringTokenizer(email, "@");
        System.out.println("email1 :"+ token.nextToken()); // qkrcksrbs8
        System.out.println("email2 :"+ token.nextToken()); // naver.com
    }


    @Test
    public void paging() {

//        List<Param> list = testList();

        int num = 2;

        if (num == 0) num = 1;
        int currentCount = num;

        int totalCount = 7;
        int blockCount = 5;
        int totalPage = (int) Math.ceil((double)totalCount/blockCount);

        int start = (currentCount-1) * blockCount;
        int end = currentCount * blockCount;


        System.out.println("start: "+start + "/ end: "+end);
        System.out.println(currentCount + "/" + totalPage);

        // 1 / 5
        // 2 / 5
        // 3 / 5
    }

    public int pagingNum(int currentCount, int totalCount, int blockCount) {

        System.out.println("===================");
        System.out.println();
        System.out.println("===================");
        return 0;
    }

    public List<Param> testList() {
        List<Param> list = new ArrayList<>();
        list.add(new Param().set("number", 1));
        list.add(new Param().set("number", 2));
        list.add(new Param().set("number", 3));
        list.add(new Param().set("number", 4));
        list.add(new Param().set("number", 5));
        list.add(new Param().set("number", 6));
        list.add(new Param().set("number", 7));
        return list;
    }
}
