//package com.gemini.cloud.framework.mybatis.enums;
//
//import com.uepay.framework.exception.ErrorInfo;
//
//public enum WebResponseEnum  implements ErrorInfo {
//
//    /**
//     * 新增成功
//     */
//    INSERT_SUCCESS(200, "新增成功"),
//
//    /**
//     * 新增失敗
//     */
//    INSERT_FAILURE(500, "新增失敗"),
//
//    /**
//     * 更新成功
//     */
//    UPDATE_SUCCESS(200, "更新成功"),
//
//    /**
//     * 更新失敗
//     */
//    UPDATE_FAILURE(500, "更新失敗"),
//
//    /**
//     * 刪除成功
//     */
//    DELETE_SUCCESS(200, "刪除成功"),
//
//    /**
//     * 刪除失敗
//     */
//    DELETE_FAILURE(500, "刪除失敗"),
//
//    /**
//     * 查詢成功
//     */
//    SEARCH_SUCCESS(200, "查詢成功"),
//
//    /**
//     * 查詢失敗
//     */
//    SEARCH_FAILURE(500, "查詢失敗");
//
//    private int code;
//    private String msg;
//
//    private WebResponseEnum(int code, String msg) {
//        this.code = code;
//        this.msg = msg;
//    }
//
//    @Override
//    public int getCode() {
//        return this.code;
//    }
//
//    @Override
//    public String getMsg() {
//        return this.msg;
//    }
//}
