package com.gemini.boot.framework.mybatis.service;


import com.gemini.boot.framework.mybatis.exception.UidServiceException;

public interface UidService {

    long getUID() throws UidServiceException;

    String parseUID(long uid);

}
