package ddd.infra;

import cn.hutool.crypto.SecureUtil;
import org.springframework.stereotype.Component;

@Component
public class SecureInterfaceImpl implements SecureInterface {
    @Override
    public String encrypt(final String data) {
        return SecureUtil.sha256(data);
    }
    
}
