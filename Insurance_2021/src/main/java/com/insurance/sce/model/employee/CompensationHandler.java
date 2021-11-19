package com.insurance.sce.model.employee;

import com.insurance.sce.model.contract.Accident;

public class CompensationHandler extends Employee {

	public void confirmCompensation(Accident accident, int tmptCompensation) {
		accident.setHandlingStatus(true);
		accident.setCompensation(tmptCompensation);
	}

}