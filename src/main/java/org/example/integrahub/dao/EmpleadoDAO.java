package org.example.integrahub.dao;

import org.example.integrahub.Config.Conexion;
import org.example.integrahub.modelo.Cliente;
import org.example.integrahub.modelo.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAO {

    // Extrae todos los datos de la tabla Empleados
    public ArrayList<Empleado> extraerEmpleados() {
        ArrayList<Empleado> empleadosBD = new ArrayList<Empleado>();
        String sql = "SELECT * FROM empleados";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado();

                empleado.setId_Empleado(rs.getInt("Id_empleado"));
                empleado.setNombre(rs.getString("Nombre"));
                empleado.setTel1(rs.getString("Tel1"));
                empleado.setTel2(rs.getString("Tel2")); // Puede recibir nulo directamente
                empleado.setPuesto(rs.getString("Puesto"));
                empleado.setArea(rs.getString("Area"));
                empleado.setDireccion(rs.getString("Dirección"));
                empleado.setRfc(rs.getString("Rfc"));
                empleado.setCurp(rs.getString("Curp"));
                empleado.setId_Almacen1(rs.getInt("Id_almacen1"));

                empleadosBD.add(empleado);
            }
        } catch (SQLException err) {
            System.err.println("Error al extraer los datos " + err.getMessage());
        }

        return empleadosBD;
    }

    //Borrar el empleado pidiendo su id
    public boolean borrarEmpleado(Empleado empleado) {
        boolean eliminado = false;
        String sql = "DELETE FROM `integraHUB`.`empleados` WHERE Id_empleado = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, empleado.getId_Empleado());
            int filasAfectadas = stm.executeUpdate();

            if (filasAfectadas > 0) {
                eliminado = true;
            }

        } catch (SQLException err) {
            System.out.println("Error al borrar al empleado " + err.getMessage());
        }

        return eliminado;
    }

    // Buscar empleados
    public ArrayList<Empleado> buscarEmpleado(Empleado empleadoex) {
        ArrayList<Empleado> empleadosBD = new ArrayList<Empleado>();
        String sql = "SELECT * FROM empleados WHERE Id_empleado = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, empleadoex.getId_Empleado());

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Empleado empleado = new Empleado();

                    empleado.setId_Empleado(rs.getInt("Id_empleado"));
                    empleado.setNombre(rs.getString("Nombre"));
                    empleado.setTel1(rs.getString("Tel1"));
                    empleado.setTel2(rs.getString("Tel2")); // Puede recibir nulo directamente
                    empleado.setPuesto(rs.getString("Puesto"));
                    empleado.setArea(rs.getString("Area"));
                    empleado.setDireccion(rs.getString("Dirección"));
                    empleado.setRfc(rs.getString("Rfc"));
                    empleado.setCurp(rs.getString("Curp"));
                    empleado.setId_Almacen1(rs.getInt("Id_almacen1"));

                    empleadosBD.add(empleado);
                }
            }

        } catch (SQLException err) {
            System.err.println("Error al buscar al cliente: " + err.getMessage());
        }

        return empleadosBD;
    }
}