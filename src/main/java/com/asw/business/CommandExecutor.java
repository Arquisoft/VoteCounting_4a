package com.asw.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.asw.model.exception.BusinessException;
import com.asw.persistence.util.Jpa;

/**
 * Clase que provee el m�todo para ejecutar comandos con una conexi�n abierta a
 * la base de datos
 * 
 * @author V�ctor Casta�o Guti�rrez
 * 
 */
public class CommandExecutor {

	/**
	 * M�todo que ejecuta un comando pasado por par�metro. Crea un entityManager
	 * usando la factor�a y abre una transacci�n. Una vez abierta ejecuta el
	 * comando pasado por par�metro. En caso de ocurrir alg�n error durante la
	 * ejecuci�n se deshacen los cambios
	 */
	public Object execute(Command command) throws BusinessException {
		// Creo el entityManager usando la factoria
		EntityManager em = Jpa.createEntityManager();

		// Tengo que abrir una transaccion
		EntityTransaction trx = em.getTransaction();
		// La abro
		try {
			trx.begin();
		} catch (PersistenceException pex) {
			throw new BusinessException("Ha ocurrido un error con la base "
					+ "de datos.");
		}

		Object res = null;
		try {
			res = command.execute();

			// Guardo cambios
			trx.commit();
		} catch (RuntimeException rex) {
			if (trx.isActive()) {
				trx.rollback();
			}
			throw rex;
		} catch (BusinessException bex) {
			if (trx.isActive()) {
				trx.rollback();
			}
			throw bex;
		} finally {
			// Cierro
			if (em.isOpen()) {
				em.close();
			}
		}
		return res;
	}

}
