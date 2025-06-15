package com.main.data.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author mobai
 */
@Data
@AllArgsConstructor
public class RedisVo {

    @ApiModelProperty(value = "Redis键")
    private String key;

    @ApiModelProperty(value = "Redis值")
    private String value;

    @ApiModelProperty(value = "保存秒数")
    private Long expireTime;
}
