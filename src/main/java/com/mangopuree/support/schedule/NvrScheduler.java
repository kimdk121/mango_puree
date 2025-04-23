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

    // @Scheduled(cron = "*/30 * * * * ?")
    public void searchCameras() {
        nvrCameraJob.searchCameras();
    }

    @Scheduled(cron = "10 49 * * * ?")
    public void movieDownload() {
        nvrScheduleJob.movieDownload();
    }
}
