package com.mangopuree.support.base;

public interface BaseConstant {

    // fetch 호출 결과 코드 키
    String KEY_RESULT_CODE = "code";
    // fetch 호출 결과 메세지 키
    String KEY_RESULT_MESSAGE = "message";
    // fetch 호출 성공 코드
    String CODE_SUCCESS = "00";
    // fetch 호출 실패 코드
    String CODE_FAIL = "99";
    // fetch 호출 성공 메세지
    String RESULT_SUCCESS = "success";
    // fetch 호출 실패 메세지
    String RESULT_FAIL = "fail";
    // fetch 호출 Data
    String RESULT_DATA = "data";
    // fetch 호출 유효성검사 에러
    String FIELD_ERRORS = "fieldErrors";

    // fetch 호출 오류 명
    String EXCEPTION_NAME = "exception_name";
    // fetch 호출 오류 메세지
    String EXCEPTION_MESSAGE = "exception_message";
    // Toast grid 메세지
    String GRID_RESULT_KEY = "result";

    // 하둡 동영상 다운로드 경로
    String HADOOP_MOVIE_PATH = "/data/movie/";

    // 하둡 동영상 확장자
    String EXTENSION_MP4 = "mp4";
}
