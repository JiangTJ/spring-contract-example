package com.jtj.cloud.springcontractexample;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableFeignClients
@SpringCloudApplication
public class SpringContractExampleApplication {

    @Resource
    private NoneService noneService;

    public static void main(String[] args) {
        SpringApplication.run(SpringContractExampleApplication.class, args);
    }

    @GetMapping("groovy")
    public Book getGroovyBook(String name){
        return new Book(name,1000);
    }

    @GetMapping("yaml")
    public Book getYamlBook(String name,int price){
        return new Book(name,price);
    }

    @GetMapping("fromNone")
    public Book fromNone(){
        return noneService.getYamlBook("从入库到精通",666);
    }

}
