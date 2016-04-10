package com.asw.business;

import com.asw.model.exception.BusinessException;


/**
 * Clase que implementa el patr�n Command
 * 
 */
public interface Command {

	/**
	 * M�todo de ejecuci�n del comando
	 * 
	 * @return
	 * @throws BusinessException
	 *             en caso de ocurrir alg�n problema
	 */
	Object execute() throws BusinessException;

}
