package com.alura.latam.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.alura.latam.hotel.CreaConexion;

public class Guadar {

	public void ejecutarGuardar(String nombre, String apellido, String fechaSeleccionada, String nacionalidad, String telefono, String reserva) throws SQLException {
	    Connection con = new CreaConexion().estableceConexion();

	    PreparedStatement statement = con.prepareStatement("INSERT INTO TBLHUESPEDES (NOMBRE, APELLIDO, FECHANACIMIENTO, NACIONALIDAD, TELEFONO, RESERVAID) "
	            + "VALUES (?, ?, ?, ?, ?, ?)");

	    statement.setString(1, nombre);
	    statement.setString(2, apellido);
	    statement.setString(3, fechaSeleccionada); // No es necesario convertir a java.sql.Date si fechaSeleccionada ya es de ese tipo
	    statement.setString(4, nacionalidad);
	    statement.setString(5, telefono);
	    statement.setString(6, reserva);

	    statement.executeUpdate(); // Usar executeUpdate para insertar datos en la tabla

	    con.close();
	}
}