package org.example.integrahub.dao;

import org.example.integrahub.Config.Conexion;
import org.example.integrahub.modelo.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProveedorDAO {

    // Extrae todos los datos de la tabla Proveedores
    public ArrayList<Proveedor> extraerProveedores() {
        ArrayList<Proveedor> proveedoresBD = new ArrayList<Proveedor>();
        String sql = "SELECT * FROM proveedores";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();

                proveedor.setId_Proveedor(rs.getInt("Id_proveedor"));
                proveedor.setNombre(rs.getString("Nombre"));
                proveedor.setDireccion(rs.getString("Direccion"));
                proveedor.setEspecialidad(rs.getString("Especialidad"));
                proveedor.setTel1(rs.getString("Tel1"));
                proveedor.setTel2(rs.getString("Tel2"));
                proveedor.setTipo_Material(rs.getString("Tipo_material"));
                proveedor.setId_Almacen4(rs.getInt("Id_almacen4"));

                proveedoresBD.add(proveedor);
            }
        } catch (SQLException err) {
            System.err.println("Error al extraer los datos " + err.getMessage());
        }
        return proveedoresBD;
    }
    
    //Borrando el proveedor pidiendo su id
    public boolean borrarProveedor(Proveedor proveedor) {
        boolean eliminado = false;
        String sql = "DELETE FROM `integraHUB`.`proveedor` WHERE Id_proveedor = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, proveedor.getId_Proveedor());
            int filasAfectadas = stm.executeUpdate();

            if (filasAfectadas > 0) {
                eliminado = true;
            }

        } catch (SQLException err) {
            System.out.println("Error al borrar al proveedor " + err.getMessage());
        }

        return eliminado;
    }
    
    //Buscar proveedor por id o Nombre
    public ArrayList<Proveedor> buscarProveedor(Proveedor proveedorex) {
        ArrayList<Proveedor> proveedoresBD = new ArrayList<Proveedor>();
        String sql = "SELECT * FROM proveedor WHERE Id_proveedor = ? OR Nombre LIKE ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, proveedorex.getId_Proveedor());
            stm.setString(2, "%" + proveedorex.getNombre() + "%");

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Proveedor proveedor = new Proveedor();

                    proveedor.setId_Proveedor(rs.getInt("Id_proveedor"));
                    proveedor.setNombre(rs.getString("Nombre"));
                    proveedor.setDireccion(rs.getString("Dirección"));
                    proveedor.setEspecialidad(rs.getString("Especialidad"));
                    proveedor.setTel1(rs.getString("Tel1"));
                    proveedor.setTel2(rs.getString("Tel2"));
                    proveedor.setTipo_Material(rs.getString("Tipo_material"));
                    proveedor.setId_Almacen4(rs.getInt("Id_almacen4"));

                    proveedoresBD.add(proveedor);
                }
            }

        } catch (SQLException err) {
            System.err.println("Error al buscar el proveedor " + err.getMessage());
        }

        return proveedoresBD;
    }
}

