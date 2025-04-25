package com.mangopuree.support.schedule;

import com.mangopuree.support.schedule.nvrjob.NvrCameraJob;
import com.mangopuree.support.schedule.nvrjob.NvrScheduleJob;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NvrScheduler {

    private final NvrCameraJob nvrCameraJob;
    private final NvrScheduleJob nvrScheduleJob;

    // 카메라 조회 스케쥴
    // @Scheduled(cron = "0/30 * * * * ?")
    public void searchCameras() {
        nvrCameraJob.searchCameras();
    }

    // 영상 다운로드 스케쥴
    // @Scheduled(cron = "0 * * * * ?")
    public void movieDownload() {
        nvrScheduleJob.movieDownload();
    }
}
