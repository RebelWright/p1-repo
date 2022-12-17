package com.revature.models;

public class ERS_Users {
    private int user_id;
    private String ers_username;
    private String ers_password;
    private String ers_first_name;
    private String ers_last_name;
    private int user_role_id_fk;

    public ERS_Users() {
    }

    public ERS_Users(int user_id, String ers_username, String ers_password, String ers_first_name, String ers_last_name, int user_role_id_fk) {
        this.user_id = user_id;
        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.ers_first_name = ers_first_name;
        this.ers_last_name = ers_last_name;
        this.user_role_id_fk = user_role_id_fk;
    }

    public ERS_Users(String ers_username, String ers_password, String ers_first_name, String ers_last_name, int user_role_id_fk) {
        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.ers_first_name = ers_first_name;
        this.ers_last_name = ers_last_name;
        this.user_role_id_fk = user_role_id_fk;
    }

    public ERS_Users(int user_id, String ers_username, String ers_password, String ers_first_name, String ers_last_name) {
        this.user_id = user_id;
        this.ers_username = ers_username;
        this.ers_password = ers_password;
        this.ers_first_name = ers_first_name;
        this.ers_last_name = ers_last_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getErs_username() {
        return ers_username;
    }

    public void setErs_username(String ers_username) {
        this.ers_username = ers_username;
    }

    public String getErs_password() {
        return ers_password;
    }

    public void setErs_password(String ers_password) {
        this.ers_password = ers_password;
    }

    public String getErs_first_name() {
        return ers_first_name;
    }

    public void setErs_first_name(String ers_first_name) {
        this.ers_first_name = ers_first_name;
    }

    public String getErs_last_name() {
        return ers_last_name;
    }

    public void setErs_last_name(String ers_last_name) {
        this.ers_last_name = ers_last_name;
    }

    public int getUser_role_id_fk() {
        return user_role_id_fk;
    }

    public void setUser_role_id_fk(int user_role_id_fk) {
        this.user_role_id_fk = user_role_id_fk;
    }

    @Override
    public String toString() {
        return "ERS_Users{" +
                "user_id=" + user_id +
                ", ers_username='" + ers_username + '\'' +
                ", ers_password='" + ers_password + '\'' +
                ", ers_first_name='" + ers_first_name + '\'' +
                ", ers_last_name='" + ers_last_name + '\'' +
                ", user_role_id_fk=" + user_role_id_fk +
                '}';
    }
}
