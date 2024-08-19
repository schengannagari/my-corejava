package com.core.basic;

public class Manager {
    public static void main(String[] args) {
        Prop prop = new Prop();
        System.out.println(prop.name());
    }
}



class Prop {
    private String name;

    public String name() {
        System.out.println(this.name);
        return this.name;
    }

    public String getName() {
        return "Dummy name";
    }

    public void setName(String name) {
        this.name = name;
    }
}
