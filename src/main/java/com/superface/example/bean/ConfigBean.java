package com.superface.example.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ConfigBean
 */
@ConfigurationProperties(prefix = "superface.blog")
@Configuration
public class ConfigBean {
    private String name;
	private String title;
    private String wholeTitle;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the wholeTitle
     */
    public String getWholeTitle() {
        return wholeTitle;
    }

    /**
     * @param wholeTitle the wholeTitle to set
     */
    public void setWholeTitle(String wholeTitle) {
        this.wholeTitle = wholeTitle;
    }
    
    
    
}