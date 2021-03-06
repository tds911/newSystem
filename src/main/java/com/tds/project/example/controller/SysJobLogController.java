package com.tds.project.example.controller;

import com.tds.common.utils.page.TableDateInfo;
import com.tds.common.web.controller.BaseController;
import com.tds.common.web.domain.server.AjaxResult;
import com.tds.modules.domain.SysJobLog;
import com.tds.modules.service.ISysJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor/jobLog")
public class SysJobLogController extends BaseController {
    @Autowired
    private ISysJobLogService jobLogService;

    @GetMapping("/list")
    public TableDateInfo list(SysJobLog sysJobLog){
        startPage();
        List<SysJobLog>list=jobLogService.selectJobLogList(sysJobLog);
        return getDataTable(list);
    }


    @GetMapping("/export")
    public AjaxResult export(SysJobLog sysJobLog){
        List<SysJobLog> list=jobLogService.selectJobLogList(sysJobLog);
//        ExcelUtil<SysJobLog> util=new ExcelUtil<SysJobLog>(SysJobLog.class);
//        return util.exportExcel(list,"调度日志");
        return null;
    }

    @GetMapping("/{jobLogIds}")
    public AjaxResult getInfo(@PathVariable Long jobLogId){
        return AjaxResult.success(jobLogService.selectJobLogById(jobLogId));
    }

    @DeleteMapping("/{jobLogIds}")
    public AjaxResult remove(@PathVariable Long[] jobLogIds){
        return toAjax(jobLogService.deleteJobLogByIds(jobLogIds));
    }

    @DeleteMapping("/clean")
    public AjaxResult clean(){
        jobLogService.cleanJobLog();
        return AjaxResult.success();
    }
}
