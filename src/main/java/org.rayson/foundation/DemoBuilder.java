package org.rayson.foundation;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-31
 *  Time: 下午7:07
 *  Description:
 **/
public class DemoBuilder {
    private Demo demo = new Demo();

    public DemoBuilder withId(String id) {
        this.demo.setId(id);
        return this;
    }

    public DemoBuilder withName(String name) {
        this.demo.setName(name);
        return this;
    }

    public DemoBuilder withAge(int age) {
        this.demo.setAge(age);
        return this;
    }

    public Demo build(){
        return this.demo;
    }
}
