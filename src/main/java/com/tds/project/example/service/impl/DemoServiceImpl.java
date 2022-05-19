package com.tds.project.example.service.impl;

import com.tds.project.example.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public void demo() {
        System.out.println("测试");
    }
}
