package com.jtj.cloud.springcontractexample;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by MrTT (jiang.taojie@foxmail.com)
 * 2019/3/27.
 */
@FeignClient(value = "none-service")
public interface NoneService {

    @GetMapping(value = "/yaml")
    Book getYamlBook(@RequestParam String name, @RequestParam int price);

}
