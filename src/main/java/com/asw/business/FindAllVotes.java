package com.asw.business;

import com.asw.model.exception.BusinessException;
import com.asw.persistence.VotoFinder;

public class FindAllVotes implements Command {

	@Override
	public Object execute() throws BusinessException {
		return VotoFinder.findAll();
	}

}
