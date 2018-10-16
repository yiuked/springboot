package com.example.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer girlId;
    @Min(value = 17,message = "非法不符，不得进入！")
    @Max(value = 50, message = "年轻人的空间，老年人慎入！")
    private Integer age;
    private String username;

    public Girl() {
    }

    public Integer getGirlId() {
        return girlId;
    }

    public void setGirlId(Integer girlId) {
        this.girlId = girlId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "girlId=" + girlId +
                ", age=" + age +
                ", username='" + username + '\'' +
                '}';
    }
}
