package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.dao.ERS_ReimbursementsDAO;
import com.revature.dao.ERS_UsersDAO;
import com.revature.models.ERS_Reimbursements;
import com.revature.models.ERS_Users;
import io.javalin.http.Handler;

public class UserController {
    ERS_UsersDAO usersDAO = new ERS_UsersDAO();
    public Handler insertEmployee = (ctx) -> {

        //With POST requests, we have JSON data coming in, which we can access with ctx.body();
        //body??? it refers to the BODY (aka the DATA) sent with the HTTP Request (in this case, employee)
        String body = ctx.body(); //we now have a Java String holding a JSON String

        //Instantiate a new GSON object to JSON <-> Java conversions
        Gson gson = new Gson();

        //turn the incoming JSON data (stored in the body String) into an Employee object
        ERS_Users newUser = gson.fromJson(body, ERS_Users.class);

        /*we're calling the insert employees method from the EmployeeDAO
           if it's successful, we'll send the new employee back in the response with a 201 status code
           if it fails, we'll send an error message and a 406 status code
         */

        if(usersDAO.insertEmployee(newUser) != null){ //if insert was succesful (which we set to return an Employee)
            ctx.status(201); //201 "created"
            ctx.result(body); //send back the employee
        } else {
            ctx.status(406); //406 "not acceptable"
            ctx.result("Insert employee failed!");
        }

    };
}
