package com.alura.latam.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alura.latam.hotel.CreaConexion;

public class ReservaGuardar {
	   
	public  void diferenciaDias(Date fechaEntrada, Date fechaSalida, Double valor, String formaPago) throws SQLException {

		Connection con = new CreaConexion().estableceConexion();

	 	PreparedStatement reservaMax = con.prepareStatement("SELECT MAX(RESERVAID) FROM TBLRESERVAS");
	 	
	 	ResultSet resultado = reservaMax.executeQuery();
	 	
	 	
	 
	 	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); // Formato
	 	
	 	java.util.Date fechaSeleccionada = fechaEntrada;
	    String fechaEntra = formatoFecha.format(fechaSeleccionada); // Formatear la fecha a una cadena
	    
	    java.util.Date fechaSeleccionada1 = fechaSalida;
	    String fechaSalid = formatoFecha.format(fechaSeleccionada1); // Formatear la fecha a una cadena
	 	

	    PreparedStatement statement = con.prepareStatement("INSERT INTO TBLRESERVAS (FECHAENTRADA, FECHASALIDA, VALOR, FORMAAPAGO) "
	            + "VALUES (?, ?, ?, ?)");
	    
	    // Establecer los valores de los parámetros
	    statement.setString(1, fechaEntra); // fechaEntrada es un objeto Date
	    statement.setString(2, fechaSalid);   //  fechaSalida es un objeto Date
	    statement.setDouble(3, valor); //  valor es un valor double
	    statement.setString(4, formaPago);   //  formaPago es un String
	    
	    // Ejecutar la consulta
	    statement.executeUpdate();
	    
	    statement.close();
	    con.close();
	
	}
}