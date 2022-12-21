package com.revature.controllers;


import com.google.gson.Gson;
import com.revature.dao.AuthDAO;
import com.revature.dao.ERS_Reimb_StatusDAO;
import com.revature.models.ERS_Users;
import com.revature.models.LoginDTO;
import io.javalin.http.Handler;

import javax.servlet.http.HttpSession;

public class Reimb_StatusController {
    public static HttpSession ses;
    AuthDAO aDAO = new AuthDAO();
    ERS_Reimb_StatusDAO statusDAO = new ERS_Reimb_StatusDAO();
    public Handler changeReimb_StatusHandler = (ctx) -> {

        /*For this request, the user will include the title of Role to be changed in the path parameters
         The new salary number will be in the HTTP Request body*/

        /*To access a path parameter, we can use ctx.pathParam()
        the value that the user includes will be stored in the "title" key
        in this case, our Launcher endpoint handler calls it "title", so we need to call "title" here */


        int reimb_id = Integer.parseInt(ctx.pathParam("reimb_id"));
        //int to hold the new Role salary that the user will input in the HTTP Request body
        int reimb_status_fk = Integer.parseInt(ctx.body());
        //int resolver_id_fk = (int) ses.getAttribute("user_id");
        //int resolver_id_fk = Integer.parseInt(ctx.body());
        //we need to parseInt() here since ctx.body() returns String
        //in Postman, no need to make a JSON object, we can just input the new salary int

        //if updateRoleSalary returns true...
        if(statusDAO.changeReimb_Status( reimb_status_fk,reimb_id)){
            ctx.status(202); //202 "accepted"
        } else {
            ctx.status(406); //406 "not acceptable"
        }

    };

    //This Handler will get the HTTP PATCH request to update a Role's salary
    //public Handler approveReimb_StatusHandler = (ctx) -> {

        /*For this request, the user will include the title of Role to be changed in the path parameters
         The new salary number will be in the HTTP Request body*/

        /*To access a path parameter, we can use ctx.pathParam()
        the value that the user includes will be stored in the "title" key
        in this case, our Launcher endpoint handler calls it "title", so we need to call "title" here */
        //String body = ctx.body();
        //Gson gson = new Gson();
        //LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
        //take this data and make an object based off the logindto class
        //ERS_Users loggedInEmployee = aDAO.login(lDTO.getErs_username(), lDTO.getErs_password());
        //if(loggedInEmployee != null) {
            //ses = ctx.req.getSession();
            //int reimb_id = Integer.parseInt(ctx.pathParam("reimb_id"));
            //int reimb_id = Integer.parseInt(ctx.pathParam("reimb_id"));

            //int to hold the new Role salary that the user will input in the HTTP Request body
            //int reimb_status_id = Integer.parseInt(ctx.body());
            //int resolver_id_fk = (int) ses.getAttribute("user_id");
            //int resolver_id_fk = Integer.parseInt(ctx.body());
            //we need to parseInt() here since ctx.body() returns String
            //in Postman, no need to make a JSON object, we can just input the new salary int

            //if updateRoleSalary returns true...
            //if (statusDAO.approveReimb_Status(resolver_id_fk, reimb_id)) {
                //ctx.status(202); //202 "accepted"
            //} else {
                //ctx.status(406); //406 "not acceptable"
            //}
        //}

    //};

}
