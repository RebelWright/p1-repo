package com.revature;

import com.revature.utils.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;
import io.javalin.Javalin;

public class Launcher {
    public static void main(String[] args) {
        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("CONNECTION SUCCESSFUL :)");
        }
        catch(SQLException e){
            System.out.println("connection failed :(");
        }


        //Typical Javalin object creation syntax
        Javalin app = Javalin.create(

                //This config lambda lets us specify certain configurations for our Javalin object
                // ->? "For this config object, do the following things"
                //ANYONE USING JAVALIN 5 SHOULD LEAVE THIS OUT
                config -> {
                    config.enableCorsForAllOrigins(); //This lets us process HTTP Requests from anywhere
                }

        ).start(3000);

    }
}
