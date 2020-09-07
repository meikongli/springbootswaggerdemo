package com.example.demo.po;

public class initPo {
    public String id;
    public String namnes;
    public String age;
    public String user;
    public String password;

    @Override
    public String toString() {
        return "initPo{" +
                "id='" + id + '\'' +
                ", namnes='" + namnes + '\'' +
                ", age='" + age + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamnes() {
        return namnes;
    }

    public void setNamnes(String namnes) {
        this.namnes = namnes;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
