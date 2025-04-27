package mylab.user.di.annot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    ApplicationContext context;
    UserService userService;

    @BeforeEach
    void container() {
        context = new GenericXmlApplicationContext("classpath:mylab-user-di.xml");
        userService = context.getBean(UserService.class);
    }

    @Test
    void testUserService() {
        // UserService 주입 확인
        System.out.println("userService = " + userService);
        assertNotNull(userService);

        // UserRepository 주입 확인
        System.out.println("userRepository = " + userService.getUserRepository());
        assertNotNull(userService.getUserRepository());

        // DB 타입 확인
        System.out.println("DB Type = " + userService.getUserRepository().getDbType());
        assertEquals("MySQL", userService.getUserRepository().getDbType());

        // SecurityService 주입 확인
        System.out.println("securityService = " + userService.getSecurityService());
        assertNotNull(userService.getSecurityService());

        // registerUser 메서드 테스트
        boolean result = userService.registerUser("user1", "홍길동", "1234");
        System.out.println("registerUser result = " + result);
        assertTrue(result);
    }
}
