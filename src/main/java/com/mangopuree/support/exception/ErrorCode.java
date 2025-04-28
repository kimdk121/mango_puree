package com.mangopuree.support.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    MENU_NOT_FOUND ("ERR_SYS_001", "errorCode.menu.notFound")
    , PARENT_MENU_NOT_FOUND ("ERR_SYS_002", "errorCode.parentMenu.notFound")
    , ESTIMATE_NOT_FOUND ("ERR_SYS_003", "errorCode.estimate.notFound")
    , NVRSCHEDULE_NOT_FOUND ("ERR_SYS_004", "errorCode.nvrschedule.notFound")

    , API_TIMEOUT ("ERR_API_001", "errorCode.api.timeout")
    , API_FAIL ("ERR_API_002", "errorCode.api.fail")

    , HDFS_WRITE_FAIL ("ERR_HDFS_001", "errorCode.hdfs.writeFail")
    , HDFS_READ_FAIL ("ERR_HDFS_002", "errorCode.hdfs.readFail")
    , HDFS_FILE_NOT_FOUND ("ERR_HDFS_003", "errorCode.hdfs.fileNotFound")

    , NVR_MOVIE_NOT_EXIST ("ERR_NVR_001", "errorCode.nvr.movieNotExist")

    , EXCELTOPDF_CONVERT_FAIL ("ERR_EXCEL_001", "errorCode.excelToPdf.convertFail");

    private final String code;
    private final String messageKey;

    ErrorCode(String code, String messageKey) {
        this.code = code;
        this.messageKey = messageKey;
    }

}
