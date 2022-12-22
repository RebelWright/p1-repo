package com.revature.dao;

public interface ERS_Reimb_StatusDAO_Interface {
    //boolean approveReimb_Status(int reimb_status, int reimb_id);
    //boolean denyReimb_Status(int reimb_status, int reimb_id);
    boolean changeReimb_Status(int reimb_status_fk, int reimb_id );

}
