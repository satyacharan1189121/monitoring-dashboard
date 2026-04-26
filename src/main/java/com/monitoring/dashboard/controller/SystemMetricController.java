package com.monitoring.dashboard.controller;

import com.monitoring.dashboard.entity.SystemMetric;
import com.monitoring.dashboard.service.SystemMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metrics")
public class SystemMetricController {

    @Autowired
    private SystemMetricService service;

    @PostMapping("/add")
    public SystemMetric addMetric(@RequestBody SystemMetric metric) {
        return service.saveMetric(metric);
    }

    @GetMapping("/all")
    public List<SystemMetric> getAllMetrics() {
        return service.getAllMetrics();
    }
    @GetMapping("/sample")
    public String addSampleData() {

        SystemMetric metric1 = new SystemMetric();
        metric1.setVmName("VM-Server-1");
        metric1.setCpuUsage(78.5);
        metric1.setRamUsage(65.2);
        metric1.setDiskUsage(81.0);
        metric1.setPriorityStatus("HIGH");
        service.saveMetric(metric1);

        SystemMetric metric2 = new SystemMetric();
        metric2.setVmName("Docker-Container-2");
        metric2.setCpuUsage(45.0);
        metric2.setRamUsage(52.1);
        metric2.setDiskUsage(38.5);
        metric2.setPriorityStatus("MEDIUM");
        service.saveMetric(metric2);

        SystemMetric metric3 = new SystemMetric();
        metric3.setVmName("Kubernetes-Pod-3");
        metric3.setCpuUsage(22.4);
        metric3.setRamUsage(30.5);
        metric3.setDiskUsage(25.8);
        metric3.setPriorityStatus("LOW");
        service.saveMetric(metric3);

        return "Sample Data Inserted Successfully";
    }
}