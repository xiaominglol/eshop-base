//package com.gemini.boot.framework.mybatis.entity;
//
//import com.uepay.corebusiness.risk.base.enums.HttpCodeEnum;
//import lombok.Data;
//
//@Data
//public class ResponseData {
//
//    /**
//     * 相應信息詳情
//     */
//    private Dict msg;
//
//    /**
//     * 返回數據
//     */
//    private Object data;
//
//    public ResponseData(HttpCodeEnum httpCode) {
//        this.msg = httpCode.dict();
//    }
//
//    public ResponseData(Object data) {
//        this.msg = HttpCodeEnum.N200.dict();
//        this.data = data;
//    }
//
//    public ResponseData(HttpCodeEnum httpCode, Object data) {
//        this.msg = httpCode.dict();
//        this.data = data;
//    }
//}
