package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.dao.ERS_ReimbursementsDAO;
import com.revature.dao.ERS_User_RolesDAO;
import com.revature.dao.ERS_UsersDAO;
import com.revature.models.ERS_Reimbursements;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class ReimbController {
    ERS_ReimbursementsDAO reimbDAO = new ERS_ReimbursementsDAO();
    public Handler getAllReimbHandler = (ctx) -> {

        /*What's ctx?? The context object! This object contains methods that we can use to
         process HTTP Requests and send HTTP Responses.
         Here, we are giving it a variable called "ctx" so that we can access its methods */

        //if the Session is not null, we know the user is logged in.
        //Thus, we can allow them to view employees
        if(AuthController.ses != null) {

            //We need an ArrayList of Employees, courtesy of our EmployeeDAO
            ArrayList<ERS_Reimbursements> reimbList = reimbDAO.getAllReimbursements();

            //PROBLEM: we can't send plain Java in an HTTP Response. We need JSON! This is where GSON comes in

            //instantiate a GSON object so that we can make Java <-> JSON conversions
            Gson gson = new Gson();

            //use the GSON .toJson() method to turn our Java into a JSON String (JSON is always in String format
            String JSONReimb = gson.toJson(reimbList);

            //we use ctx.result() to send back an HTTP Response
            //in this case, the user requests all employee data, so that's what we're sending.
            ctx.result(JSONReimb);

            //we can set status code with ctx.status()
            ctx.status(202); //202 stands for accepted. 200 is default which is also fine

        } else { //if the user is NOT logged in:
            ctx.result("YOU MUST LOG IN TO DO THIS");
            ctx.status(401); //401 "unauthorized"
        }

    };
    public Handler viewPendingReimbHandler = (ctx) -> {

        /*What's ctx?? The context object! This object contains methods that we can use to
         process HTTP Requests and send HTTP Responses.
         Here, we are giving it a variable called "ctx" so that we can access its methods */

            //if the Session is not null, we know the user is logged in.
            //Thus, we can allow them to view employees
            if(AuthController.ses != null) {

                //We need an ArrayList of Employees, courtesy of our EmployeeDAO
                ArrayList<ERS_Reimbursements> reimbList = reimbDAO.viewPendingReimbursements();

                //PROBLEM: we can't send plain Java in an HTTP Response. We need JSON! This is where GSON comes in

                //instantiate a GSON object so that we can make Java <-> JSON conversions
                Gson gson = new Gson();

                //use the GSON .toJson() method to turn our Java into a JSON String (JSON is always in String format
                String JSONReimb = gson.toJson(reimbList);

                //we use ctx.result() to send back an HTTP Response
                //in this case, the user requests all employee data, so that's what we're sending.
                ctx.result(JSONReimb);

                //we can set status code with ctx.status()
                ctx.status(202); //202 stands for accepted. 200 is default which is also fine

            } else { //if the user is NOT logged in:
                ctx.result("YOU MUST LOG IN TO DO THIS");
                ctx.status(401); //401 "unauthorized"
            }

        };
    public Handler viewApprovedReimbHandler = (ctx) -> {

        /*What's ctx?? The context object! This object contains methods that we can use to
         process HTTP Requests and send HTTP Responses.
         Here, we are giving it a variable called "ctx" so that we can access its methods */

            //if the Session is not null, we know the user is logged in.
            //Thus, we can allow them to view employees
            if(AuthController.ses != null) {

                //We need an ArrayList of Employees, courtesy of our EmployeeDAO
                ArrayList<ERS_Reimbursements> reimbList = reimbDAO.viewApprovedReimbursements();

                //PROBLEM: we can't send plain Java in an HTTP Response. We need JSON! This is where GSON comes in

                //instantiate a GSON object so that we can make Java <-> JSON conversions
                Gson gson = new Gson();

                //use the GSON .toJson() method to turn our Java into a JSON String (JSON is always in String format
                String JSONReimb = gson.toJson(reimbList);

                //we use ctx.result() to send back an HTTP Response
                //in this case, the user requests all employee data, so that's what we're sending.
                ctx.result(JSONReimb);

                //we can set status code with ctx.status()
                ctx.status(202); //202 stands for accepted. 200 is default which is also fine

            } else { //if the user is NOT logged in:
                ctx.result("YOU MUST LOG IN TO DO THIS");
                ctx.status(401); //401 "unauthorized"
            }

        };
    public Handler viewDeniedReimbHandler = (ctx) -> {

        /*What's ctx?? The context object! This object contains methods that we can use to
         process HTTP Requests and send HTTP Responses.
         Here, we are giving it a variable called "ctx" so that we can access its methods */

            //if the Session is not null, we know the user is logged in.
            //Thus, we can allow them to view employees
            if(AuthController.ses != null) {

                //We need an ArrayList of Employees, courtesy of our EmployeeDAO
                ArrayList<ERS_Reimbursements> reimbList = reimbDAO.viewDeniedReimbursements();

                //PROBLEM: we can't send plain Java in an HTTP Response. We need JSON! This is where GSON comes in

                //instantiate a GSON object so that we can make Java <-> JSON conversions
                Gson gson = new Gson();

                //use the GSON .toJson() method to turn our Java into a JSON String (JSON is always in String format
                String JSONReimb = gson.toJson(reimbList);

                //we use ctx.result() to send back an HTTP Response
                //in this case, the user requests all employee data, so that's what we're sending.
                ctx.result(JSONReimb);

                //we can set status code with ctx.status()
                ctx.status(202); //202 stands for accepted. 200 is default which is also fine

            } else { //if the user is NOT logged in:
                ctx.result("YOU MUST LOG IN TO DO THIS");
                ctx.status(401); //401 "unauthorized"
            }

        };
    public Handler viewUserReimbHandler = (ctx) -> {

        /*What's ctx?? The context object! This object contains methods that we can use to
         process HTTP Requests and send HTTP Responses.
         Here, we are giving it a variable called "ctx" so that we can access its methods */

            //if the Session is not null, we know the user is logged in.
            //Thus, we can allow them to view employees
            if(AuthController.ses != null) {
                int user_id = (int) AuthController.ses.getAttribute("user_id");
                //We need an ArrayList of Employees, courtesy of our EmployeeDAO
                ArrayList<ERS_Reimbursements> reimbList = reimbDAO.viewUserReimbursements(user_id);

                //PROBLEM: we can't send plain Java in an HTTP Response. We need JSON! This is where GSON comes in

                //instantiate a GSON object so that we can make Java <-> JSON conversions
                Gson gson = new Gson();

                //use the GSON .toJson() method to turn our Java into a JSON String (JSON is always in String format
                String JSONReimb = gson.toJson(reimbList);

                //we use ctx.result() to send back an HTTP Response
                //in this case, the user requests all employee data, so that's what we're sending.
                ctx.result(JSONReimb);

                //we can set status code with ctx.status()
                ctx.status(202); //202 stands for accepted. 200 is default which is also fine

            } else { //if the user is NOT logged in:
                ctx.result("YOU MUST LOG IN TO DO THIS");
                ctx.status(401); //401 "unauthorized"
            }

        };
    public Handler insertReimb = (ctx) -> {

        //With POST requests, we have JSON data coming in, which we can access with ctx.body();
        //body??? it refers to the BODY (aka the DATA) sent with the HTTP Request (in this case, employee)
        if(AuthController.ses != null) {
        String body = ctx.body(); //we now have a Java String holding a JSON String

        //Instantiate a new GSON object to JSON <-> Java conversions
        Gson gson = new Gson();

        //turn the incoming JSON data (stored in the body String) into an Employee object
        ERS_Reimbursements newReimb = gson.fromJson(body, ERS_Reimbursements.class);

        /*we're calling the insert employees method from the EmployeeDAO
           if it's successful, we'll send the new employee back in the response with a 201 status code
           if it fails, we'll send an error message and a 406 status code
         */

            if(reimbDAO.insertReimbursement(newReimb) != null){ //if insert was succesful (which we set to return an Employee)
                ctx.status(201); //201 "created"
                ctx.result(body); //send back the employee
            } else {
                ctx.status(406); //406 "not acceptable"
                ctx.result("Insert employee failed!");
            }
        } else { //if the user is NOT logged in:
            ctx.result("YOU MUST LOG IN TO DO THIS");
            ctx.status(401); //401 "unauthorized"
        }
    };
}
