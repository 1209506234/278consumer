package com.zb.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String port){
        return restTemplate.getForObject("http://SERVICE-PROVIDER/hi?name="+port,String.class);
    }

    public List listService(){
        return restTemplate.getForObject("http://SERVICE-PROVIDER/list", List.class);
    }

}
