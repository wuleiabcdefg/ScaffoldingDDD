package ddd.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonUtilTest {


    @Test
    void toJson() {
        String json = JsonUtil.toJson(new TestBean("zhangsan",45));
        assertEquals("""
                {"name":"zhangsan","age":45}""", json);
    }
    @Test
    void FromJson() {
        String json = """
                {"name":"zhangsan","age":45}""";
        TestBean testBean = JsonUtil.fromJson(json, TestBean.class);
        assertEquals("zhangsan", testBean.getName());
        assertEquals(45, testBean.getAge());
    }
}

@Setter
@Getter
@NoArgsConstructor
class TestBean{

    private String name;
    private int age;

    public TestBean(String name, int age) {
        this.name = name;
        this.age = age;
    }
}