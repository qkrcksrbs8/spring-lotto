package cg.park.springlotto;

import cg.park.springlotto.daos.MessageDao;
import cg.park.springlotto.daos.UserDao;
import cg.park.springlotto.models.MessageDto;
import cg.park.springlotto.models.UserDto;
import cg.park.springlotto.services.impl.LottoServiceImpl;
import cg.park.springlotto.utils.Param;
import cg.park.springlotto.utils.PcgUtil;
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
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Connection connection;
        if (1 == 1) {
            connection = null;
        }
        else {
            connection = null;
        }
        System.out.println(connection);

    }

    @Autowired
    UserDao userDao;

    @Test
    public void allUser() throws Exception {
        System.out.println("allUser");

        try {
            List<UserDto> users = userDao.allUser();
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
            MessageDto message = messageDao.selectMessage("S0001");
            System.out.println(message.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    LottoServiceImpl lottoServiceimpl;


    // 단일 로또 테스트
    @Test
    public void TestNum() {
        MessageDto result = lottoServiceimpl.execute(new Param().set("count", 1));
        System.out.println(result);
    }

    // count가 0일 때
    @Test
    public void errorCaseTestNum0() {
        MessageDto result = lottoServiceimpl.execute(new Param().set("count", 0));
        System.out.println(result);
    }

    // count가 음수일 때
    @Test
    public void errorCaseTestMinor() {
        MessageDto result = lottoServiceimpl.execute(new Param().set("count", -1));
        System.out.println(result);
    }

    // 다중 로또 테스트
    @Test
    public void MultiTestNum() {
        MessageDto result = lottoServiceimpl.execute(new Param().set("count", 5));
        System.out.println(result);
    }

    // 다중 로또 테스트 5개 초과일 때
    @Test
    public void MultiTestNumOver() {
        MessageDto result = lottoServiceimpl.execute(new Param().set("count", 10));
        System.out.println(result);
    }

    // -----------------------------
    // Enum 테스트
    @Autowired
    PcgUtil pcgUtil;

    @Test
    public void EnumTest() {
        System.out.println("EnumTest 시작");
        String str = pcgUtil.toEnum("F0001");
        System.out.println(str);
        System.out.println("EnumTest 종료");
    }
}
