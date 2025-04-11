package com.mangopuree.support.schedule.nvrjob;

import com.mangopuree.nvrcamera.service.NvrCameraService;
import com.mangopuree.nvrschedule.service.NvrScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NvrScheduleJob {

    private final NvrScheduleService nvrScheduleService;

    public void movieDownload() {

    }
}
