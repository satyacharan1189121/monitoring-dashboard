package com.monitoring.dashboard.controller;

import com.monitoring.dashboard.service.SystemMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private SystemMetricService service;

    @GetMapping("/")
    public String showDashboard(Model model) {
        model.addAttribute("metrics", service.getAllMetrics());
        return "dashboard";
    }
}