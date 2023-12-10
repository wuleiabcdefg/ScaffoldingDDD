package ddd.utils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonUtilTest {


    @Test
    void toJson() {
        var mapp = new HashMap<String, String>();
        mapp.put("acsac", "");
        String json = null;
        try {
            json = JsonUtil.toJson(new VIAN());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals("null", json);
    }
}

class VIAN{

}