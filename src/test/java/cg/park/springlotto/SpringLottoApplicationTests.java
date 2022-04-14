package cg.park.springlotto;

import cg.park.springlotto.comm.constant.MessageEnum;
import cg.park.springlotto.daos.LottoDao;
import cg.park.springlotto.daos.MessageDao;
import cg.park.springlotto.daos.UserDao;
import cg.park.springlotto.models.Message;
import cg.park.springlotto.models.User;
import cg.park.springlotto.services.impl.LottoServiceImpl;
import cg.park.springlotto.services.impl.TestNumberServiceImpl;
import cg.park.springlotto.utils.Lotto;
import cg.park.springlotto.utils.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@SpringBootTest
class SpringLottoApplicationTests {

    @Test
    void daotest() {

    }

    //--------------------------------------------------
    //테스트 출력
    @Test
    void contextLoads() {
        System.out.println("contextLoads 테스트 출력입니다.");
    }

    //---------------------------------------------------
    // MySQL Connector 의 클래스. DB 연결 드라이버 정의
    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    // DB 경로
    private static final String URL = "jdbc:mariadb://localhost:3307/pcgdb";
    private static final String USER = "pcg";
    private static final String PASSWORD = "1234";

    @Test
    public void testConnection() throws Exception {
        System.out.println("testConnection");
        // DBMS에게 DB 연결 드라이버의 위치를 알려주기 위한 메소드
        Class.forName(DRIVER);
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Autowired
    UserDao userDao;

    @Test
    public void allUser() throws Exception {
        System.out.println("allUser");

        try {
            List<User> users = userDao.allUser();
            System.out.println(users.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    MessageDao messageDao;
    @Test
    public void megTest() {
        System.out.println("Message");
        try {
            Message message = messageDao.selectMessage("S0001");
            System.out.println(message.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //----------------------------------------
    //로또번호 출력 테스트
    @Autowired
    LottoServiceImpl lottoServiceimpl;

    @Test
    public void lotto() {
        int count = 1 ;

        Param param = new Param().set("count", count);
        String preCode = lottoServiceimpl.pre(param);
        if (!preCode.startsWith("S")) ;
        Param excute = lottoServiceimpl.execute(param);
        System.out.println(excute);
    }


    @Autowired
    TestNumberServiceImpl testNumberService;

    @Test
    public void TestNum() {
        Message result = testNumberService.execute(new Param().set("count", 1));
        System.out.println(result);
    }
}
