package com.revature.dao;

import com.revature.models.ERS_Reimbursements;

import java.util.ArrayList;

public interface ERS_ReimbursementsDAO_Interface {
    ArrayList<ERS_Reimbursements> getAllReimbursements();
    ERS_Reimbursements insertReimbursement(ERS_Reimbursements reimb);

}
