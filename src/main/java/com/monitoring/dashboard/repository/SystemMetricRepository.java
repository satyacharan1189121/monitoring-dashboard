package com.monitoring.dashboard.repository;

import com.monitoring.dashboard.entity.SystemMetric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemMetricRepository extends JpaRepository<SystemMetric, Long> {
}