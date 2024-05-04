package ddd.auth;

import cn.hutool.db.Page;
import lombok.Data;

import java.time.LocalDate;

@Data
public class QueryParams {


    private LocalDate queryDate;
    private Page page;
}
