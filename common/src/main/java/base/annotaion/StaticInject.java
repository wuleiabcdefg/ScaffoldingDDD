package base.annotaion;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 静态注入
 * 用于在领域层中，实体使用
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface StaticInject {

}
