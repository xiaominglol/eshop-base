package com.gemini.cloud.framework.web.exception;

/**
 * cloud-web-throwable 异常
 *
 * @author 小明不读书
 *
 */
public class CloudCoreException extends Throwable {
	private static final long serialVersionUID = 1L;

	public CloudCoreException(Throwable e) {
		super(e);
	}

	public CloudCoreException(String msg) {
		super(msg);
	}

	public CloudCoreException(String msg, Throwable e) {
		super(msg, e);
	}
}
