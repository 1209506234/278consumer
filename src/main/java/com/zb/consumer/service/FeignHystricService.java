package com.zb.consumer.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FeignHystricService implements FeignService {
    @Override
    public List<Map> list(String name) {
        System.out.println("Hystric is working...");
        return null;
    }

    @Override
    public String delete(String id) {
        return null;
    }

    @Override
    public List<Map> getAllRoles() {
        System.out.println("Hystric is working...");
        return null;
    }

    @Override
    public String save(Map map) {
        return null;
    }
}
