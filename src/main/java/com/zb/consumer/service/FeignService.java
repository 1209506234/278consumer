package com.zb.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "SERVICE-PROVIDER",fallback = FeignHystricService.class)
public interface FeignService {

    @RequestMapping(value = "/list")
    public List<Map> list(@RequestParam String name);

    @RequestMapping("/delete/{did}")
    public String delete(@PathVariable("did")String id);

    @RequestMapping("/getAllRoles")
    public List<Map> getAllRoles();

    @RequestMapping("/save")
    public String save(@RequestParam Map map);

}
