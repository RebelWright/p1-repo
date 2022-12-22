package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbController;
import com.revature.controllers.Reimb_StatusController;
import com.revature.controllers.UserController;
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

        Javalin app = Javalin.create(


                config -> {
                    config.enableCorsForAllOrigins();
                }

        ).start(3000);


        ReimbController rc = new ReimbController();
        AuthController ac = new AuthController();
        UserController uc = new UserController();
        Reimb_StatusController sc = new Reimb_StatusController();

        app.get("/ers_reimbursements", rc.getAllReimbHandler);
        app.get("/ers_reimbursements/pending", rc.viewPendingReimbHandler);
        app.get("/ers_reimbursements/approved", rc.viewApprovedReimbHandler);
        app.get("/ers_reimbursements/denied", rc.viewDeniedReimbHandler);
        app.get("/ers_reimbursements/user_id", rc.viewUserReimbHandler);


        app.post("/ers_reimbursements", rc.insertReimb);
        app.post("/ers_users", uc.insertEmployee);

        app.patch("/ers_reimbursements/{reimb_id}", sc.changeReimb_StatusHandler);

        app.post("/login", ac.loginHandler);

    }
}
