package com.superface.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ben
 * @date 2019.4.11
 * @see nothing
 */
@Entity
@Table(name="student")
public class Student{
    @Id
    private String sno;

    @Column(name="sname")
    private String name;

    @Column(name = "ssex")
    private String sex;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}