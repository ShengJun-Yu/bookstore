package com.jun.conrtoller.until;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author : Bojack
 * @date : Created in 18:58 2022.11.04
 */
@Data
public class R {
    private boolean flag;
    private Object data;
    private String msg;

    public R() {
    }

    public R(boolean flag) {
        this.flag = flag;
    }

    public R(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public R(String msg) {
        this.flag = false;
        this.msg = msg;
    }
}
