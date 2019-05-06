package com.superface.example.controller;

import com.superface.example.bean.BlogProperties;
import com.superface.example.bean.ConfigBean;
import com.superface.example.bean.TestConfigBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页Controller
 */
@RestController
public class IndexController {

    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private TestConfigBean testConfigBean;

    @RequestMapping("/index001")
    String index() {
        return testConfigBean.getName() + "，" + testConfigBean.getAge();
    }
}