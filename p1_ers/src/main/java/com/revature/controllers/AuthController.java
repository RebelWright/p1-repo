package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.dao.AuthDAO;
import com.revature.models.ERS_Users;
import com.revature.models.LoginDTO;
import io.javalin.http.Handler;

import javax.servlet.http.HttpSession;

public class AuthController {
    AuthDAO aDAO = new AuthDAO();
    //create an empty HTTPSession will be filled on successful login
    public static HttpSession ses;
    //to prevent functionalities from running before login have them check to see if the session is null

    //for the service layer
    //login will be a post request since the user is expected to send some data in the http request
    public Handler loginHandler = (ctx) -> {
        //ctx.body to grab the http request data
        String body = ctx.body();
        Gson gson = new Gson();
        LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
        //take this data and make an object based off the logindto class
        ERS_Users loggedInEmployee = aDAO.login(lDTO.getErs_username(), lDTO.getErs_password());
        if(loggedInEmployee != null) {
            ses = ctx.req.getSession();
            String userJson = gson.toJson(loggedInEmployee);
            ctx.result(userJson);
            ctx.status(202);
        }
        else {
            ctx.status(401);
        }
    };
}
