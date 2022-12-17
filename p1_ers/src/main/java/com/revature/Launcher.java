package com.revature;

import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {
    public static void main(String[] args) {
        try(Connection conn= ConnectionUtil.getConnection()){
            System.out.println("Connection successful");
        }
        catch(SQLException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        Javalin app = Javalin.create(
                config -> {
                    config.enableCorsForAllOrigins(); //let's us get and send HTTP responses from anywhere
                }
        ).start(3000);

    }
}
