package com.github.dadiyang.bestpractice.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回结果
 *
 * @author dadiyang
 * @since 2019-06-02
 */
@Data
@NoArgsConstructor
@ApiModel(description = "返回结果")
public class ResultBean<T> {
    @ApiModelProperty(value = "处理结果code，0 表示成功，非零表示失败", notes = "正数表示已知错误，负数表示未知异常")
    private int code;
    @ApiModelProperty("错误信息，一般只在处理失败时才有")
    private String msg;
    @ApiModelProperty("结果数据")
    private T data;

    public static <T> ResultBean<T> success(T data) {
        return new ResultBean<>(data);
    }

    public static <T> ResultBean<T> fail(String msg) {
        return new ResultBean<>(1, msg);
    }

    public static <T> ResultBean<T> unknownError(String msg) {
        return new ResultBean<>(-1, msg);
    }

    public ResultBean(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBean(T data) {
        this.data = data;
    }
}
