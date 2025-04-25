package com.mangopuree.support.base;

public interface BaseConstant {

    // fetch 호출 성공 코드
    String CODE_SUCCESS = "00";

    // fetch 호출 실패 코드
    String CODE_FAIL = "99";

    // fetch 호출 성공 메세지
    String RESULT_SUCCESS = "success";

    // fetch 호출 실패 메세지
    String RESULT_FAIL = "fail";

    // 하둡 동영상 다운로드 경로
    String HADOOP_MOVIE_PATH = "/data/movie/";

    // 하둡 동영상 확장자
    String EXTENSION_MP4 = "mp4";
}
