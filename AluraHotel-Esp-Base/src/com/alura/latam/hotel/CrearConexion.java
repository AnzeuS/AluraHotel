package com.alura.latam.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrearConexion {

	public Connection estableceConexion() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/alurahoteldb?useTimeZone=true&serverTimeZone=UTC",
				"root", 
				"an061948");
	}
}
