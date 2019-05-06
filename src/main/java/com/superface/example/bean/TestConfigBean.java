
package com.superface.example.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @LastEditors: Please set LastEditors
 * @Date: 2019-04-11 11:35:58
 * @LastEditTime: 2019-04-11 13:37:03
 */
@Configuration
@ConfigurationProperties(prefix = "test")
@PropertySource(TestConfigBean.SOURCE)
public class TestConfigBean {

    /**
     * property 文件地址
     */
    static final String SOURCE = "classpath:test.properties";

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}