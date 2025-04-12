package com.mitocode;

import com.mitocode.inter.IConexion;
import com.mitocode.inter.impl.ConexionMySQL;
import com.mitocode.inter.impl.ConexionOracle;
import com.mitocode.inter.impl.ConexionPostgreSQL;
import com.mitocode.inter.impl.ConexionSQLServer;
import com.mitocode.inter.impl.ConexionVacia;

public class ConexionFabrica {

	/*
	We have this interface that declares the way of behavior of each database. Then we have this
	Factory, which has the role of creating instances of the interface IConexion.

	The client, with that interface, will be able to connect to each database
	 */




	public IConexion getConexion(String motor) {
		if (motor == null) {
			return new ConexionVacia();
		}
		if (motor.equalsIgnoreCase("MYSQL")) {
			return new ConexionMySQL();
		} else if (motor.equalsIgnoreCase("ORACLE")) {
			return new ConexionOracle();
		} else if (motor.equalsIgnoreCase("POSTGRE")) {
			return new ConexionPostgreSQL();
		} else if (motor.equalsIgnoreCase("SQL")) {
			return new ConexionSQLServer();
		}

		return new ConexionVacia();
	}
}
