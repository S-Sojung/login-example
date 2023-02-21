package shop.mtcoding.loginexample.util;

import org.junit.jupiter.api.Test;

public class EncryptionUtilsTest {

    @Test
    public void EncryptionUtils_test() throws Exception {
        String a1 = EncryptionUtils.encrypt("1234");
        String a2 = EncryptionUtils.encrypt("1234");
        String a3 = EncryptionUtils.encrypt("1234");
        System.out.println("테스트 : " + a1);
        System.out.println("테스트 : " + a2);
        System.out.println("테스트 : " + a3);
    }
}
