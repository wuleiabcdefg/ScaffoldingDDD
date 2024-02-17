package base.model;

import cn.hutool.core.util.IdUtil;

/**
 * 标识符
 */
public abstract class Identifier {

    /**
     * 生成唯一ID
     *
     * @return id
     */
    protected long generateId() {
        return IdUtil.getSnowflakeNextId();
    }

    public static void main(String[] args) {
        System.out.println(IdUtil.getSnowflakeNextId());
    }
    //1739304492485050368
    //1739304525741699072
    //1739304556767064064
    //1739304585678299136
}
