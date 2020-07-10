package com.safez.project.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="user对象",description="用户对象user")
public class TestEntity {
    @ApiModelProperty(value="用户id",name="id",example="1")
    protected Integer id ;
    @ApiModelProperty(value="魔术Id",name="magicId",example="1")
    protected String magicId ;
    @ApiModelProperty(value="首名",name="username",example="测试")
    protected String firstName ;
    @ApiModelProperty(value="尾名",name="username",example="测试")
    protected String lastName ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMagicId() {
        return magicId;
    }

    public void setMagicId(String magicId) {
        this.magicId = magicId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
