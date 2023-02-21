package shop.mtcoding.loginexample.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.EncryptionLevel;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mtcoding.loginexample.util.EncryptionUtils;

//Filter - Dispatcher Servlet - Contoller - Service - Repository - MyBatis - DB
//SOLID 중 S (SRP) : 단일책임의 원칙
@MybatisTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll_test() throws Exception {
        // given
        ObjectMapper om = new ObjectMapper();

        // when
        List<User> userList = userRepository.findAll();
        // System.out.println("테스트 : size : " + userList.size());
        // String responseBody = om.writeValueAsString(userList);
        // System.out.println("테스트 : " + responseBody);

        // then
        assertThat(userList.get(0).getUsername()).isEqualTo("ssar");
        assertThat(userList.get(0).getEmail()).isEqualTo("ssar@nate.com");
        assertThat(userList.get(1).getUsername()).isEqualTo("love");
    }

    @Test
    public void findByUsernameAndPassword() throws Exception {
        // given
        String username = "ssar";
        String password = "1234";
        ObjectMapper om = new ObjectMapper();

        // when
        password = EncryptionUtils.encrypt(password);
        User userPS = userRepository.findByUsernameAndPassword(username, password);
        String responseBody = om.writeValueAsString(userPS);
        System.out.println("테스트 : " + responseBody);

        // then
        assertThat(userPS.getUsername()).isEqualTo("ssar");
    }
}
