package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbController;
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

        //EmployeeController ec = new EmployeeController();
        ReimbController rc = new ReimbController();
        AuthController ac = new AuthController();

        /* app.get() is the Javalin method that takes in GET requests.
        In this case, it's calling to the getAllEmployeesHandler in the EmployeeController
        SO, when we send a request to localhost:3000/employees, the getEmployeesHandler will execute */
        app.get("/ers_reimbursements", rc.getAllReimbHandler);
        app.get("/ers_reimbursements", rc.viewPendingReimbHandler);
        app.get("/ers_reimbursements", rc.viewApprovedReimbHandler);
        app.get("/ers_reimbursements", rc.viewDeniedReimbHandler);
        app.get("/ers_reimbursements", rc.viewUserReimbHandler);

        //app.post() is the Javalin method that takes in POST requests
        //why are we allowed to have two handlers that both take requests ending in /employees
        app.post("/ers_reimbursements", rc.insertReimb);

        //app.patch() is the Javalin method that takes in PATCH requests
        //{title}?? This is a PATH PARAMETER. The value that the user inputs after /roles/ will be stored.
        app.patch("/roles/{title}", rc.updateSalaryHandler);

        //this is the endpoint handler for login
        app.post("/login", ac.loginHandler);

    }
}
