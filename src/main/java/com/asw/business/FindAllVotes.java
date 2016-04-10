package com.asw.business;

import com.asw.model.exception.BusinessException;
import com.asw.persistence.VotoFinder;

public class FindAllVotes implements Command {

	public Object execute() throws BusinessException {
		return VotoFinder.findAll();
	}


}
