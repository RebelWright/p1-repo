package com.revature.models;

public class ERS_User_Roles {
    private int user_role_id;
    private String user_role;

    public ERS_User_Roles() {
    }

    public ERS_User_Roles(int user_role_id, String user_role) {
        this.user_role_id = user_role_id;
        this.user_role = user_role;
    }

    public ERS_User_Roles(String user_role) {
        this.user_role = user_role;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return "ERS_User_Roles{" +
                "user_role_id=" + user_role_id +
                ", user_role='" + user_role + '\'' +
                '}';
    }
}

