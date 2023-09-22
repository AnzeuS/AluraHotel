package com.alura.latam.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alura.latam.hotel.CreaConexion;

public class ObtenerPosicion {
	
	public static int datosPosicion() throws SQLException {
		
		Connection con = new CreaConexion().estableceConexion();

	 	PreparedStatement reservaMax = con.prepareStatement("SELECT MAX(RESERVAID) FROM TBLRESERVAS");
	 	
	 	ResultSet resultado = reservaMax.executeQuery();
	 	
	 	int maxReservaID = 0;
	 	
	 	if (resultado.next()) {
	 	    maxReservaID = resultado.getInt(1); 
	 	}
	 	
	 	resultado.close();
	 	reservaMax.close();
	 	System.out.println("Este es el resultado de la query:" + maxReservaID);
	 	
	 	return maxReservaID;
	 	
	}
}
