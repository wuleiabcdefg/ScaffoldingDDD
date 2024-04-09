package ddd.infra;

public interface SecureInterface {

    /**
     * 加密
     *
     * @param data 明文
     * @return 加密后的字符串
     */
    String encrypt(String data);
}
