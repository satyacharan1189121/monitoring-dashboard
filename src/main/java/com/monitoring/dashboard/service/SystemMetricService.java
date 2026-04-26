package com.monitoring.dashboard.service;

import com.monitoring.dashboard.entity.SystemMetric;
import com.monitoring.dashboard.repository.SystemMetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemMetricService {

    @Autowired
    private SystemMetricRepository repository;

    public SystemMetric saveMetric(SystemMetric metric) {
        return repository.save(metric);
    }

    public List<SystemMetric> getAllMetrics() {
        return repository.findAll();
    }
}