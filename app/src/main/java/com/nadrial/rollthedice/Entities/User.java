package com.nadrial.rollthedice.Entities;

public class User {



    static int imgUser;
    static String name,id,email;
    public String getName() {
        return name;
    }

    public static void setName(String newName) {
        name = newName;
    }
    public static void setId(String newId) {
        id = newId;
    }

    public static void setEmail(String newEmail) {
        email = newEmail;
    }
    public static String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getImgUser() {
        return imgUser;
    }

    public static void setImgUser(int newImgUser) {
        imgUser = newImgUser;
    }









}
