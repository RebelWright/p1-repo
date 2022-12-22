package com.revature.controllers;


import com.revature.dao.AuthDAO;
import com.revature.dao.ERS_Reimb_StatusDAO;

import com.revature.dao.ERS_ReimbursementsDAO;
import com.revature.dao.ERS_User_RolesDAO;
import io.javalin.http.Handler;

import javax.servlet.http.HttpSession;

public class Reimb_StatusController {
    public static HttpSession ses;
    AuthDAO aDAO = new AuthDAO();
    ERS_Reimb_StatusDAO statusDAO = new ERS_Reimb_StatusDAO();
    ERS_ReimbursementsDAO reimbDAO = new ERS_ReimbursementsDAO();
    ERS_User_RolesDAO rolesDAO = new ERS_User_RolesDAO();
    public Handler changeReimb_StatusHandler = (ctx) -> {

        if (AuthController.ses != null) {

            //if (AuthController.ses.getAttribute("user_role_id_fk")) {

            int reimb_id = Integer.parseInt(ctx.pathParam("reimb_id"));
            int reimb_status_fk = Integer.parseInt(ctx.body());
            int statusId = reimbDAO.getReimbById(reimb_id).getReimb_status_fk();

            if (statusId != 1) {
                ctx.status(406);
                ctx.result("Cannot alter status after update");
            } else {
                if (statusDAO.changeReimb_Status(reimb_status_fk, reimb_id)) {
                    ctx.status(202); //202 "accepted"
                } else {
                    ctx.status(406); //406 "not acceptable"
                }
            }
        //}
        } else {
            ctx.status(406);
            ctx.result("Please login in");
        }
    };
}
