package com.gemini.boot.framework.core.exception;

/**
 * cloud-web-throwable 异常
 *
 * @author 小明不读书
 */
public class CoreException extends Throwable {
    private static final long serialVersionUID = 1L;

    public CoreException(Throwable e) {
        super(e);
    }

    public CoreException(String msg) {
        super(msg);
    }

    public CoreException(String msg, Throwable e) {
        super(msg, e);
    }
}
