package com.example.demo.Coll;

public class users {

    private String id;
    private String names;
    private String age;
    private String user;
    private String password;

    @Override
    public String toString() {
        return "users{" +
                "id='" + id + '\'' +
                ", names='" + names + '\'' +
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

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
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
