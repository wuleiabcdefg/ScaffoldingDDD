package ddd.infra;

import org.junit.jupiter.api.Test;

class SecureInterfaceImplTest {

    @Test
    void encrypt() {
        System.out.println(new SecureInterfaceImpl().encrypt("123456"));
        System.out.println(new SecureInterfaceImpl().encrypt("test"));

    }
}