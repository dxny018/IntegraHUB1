package org.example.integrahub.dao;
import org.example.integrahub.Config.Conexion;
import org.example.integrahub.modelo.Detalle_Movimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Detalle_MovimientoDAO {
     // Extrae todos los datos de la tabla Detalle_Movimiento
                public ArrayList<Detalle_Movimiento> extraerDetalle_Movimiento() {
                    ArrayList<Detalle_Movimiento> Detalle_MovimientosBD = new ArrayList<Detalle_Movimiento>();
                    String sql = "SELECT * FROM detalle_movimiento";
                    try (Connection conexion = Conexion.conectar();
                         PreparedStatement stm = conexion.prepareStatement(sql);
                         ResultSet rs = stm.executeQuery()) {
    
                        while (rs.next()) {
                            Detalle_Movimiento detalle_Movimiento = new Detalle_Movimiento();
    
                        detalle_Movimiento.setId_Detalle(rs.getInt("Id_detalle"));
                            detalle_Movimiento.setCod_Movimientos1(rs.getInt("Cod_Movimientos1"));                            detalle_Movimiento.setId_Producto1(rs.getInt("id_producto1"));
                            detalle_Movimiento.setId_Almacen7(rs.getInt("id_almacen7"));
                            detalle_Movimiento.setCantidad(rs.getInt("Cantidad"));

                          Detalle_MovimientosBD.add(detalle_Movimiento);
                        }
                    } catch (SQLException err) {
                        System.err.println("Error al extraer los datos " + err.getMessage());
                    }
                    return  Detalle_MovimientosBD;
                }

    // Borrar
    public boolean borrarDetalle_Movimiento(Detalle_Movimiento detalle_Movimiento) {
        boolean eliminado = false;
        String sql = "DELETE FROM `integraHUB`.`detalle_Movimiento` WHERE Id_detalle = ?";
    try (Connection conexion = Conexion.conectar();
         PreparedStatement stm = conexion.prepareStatement(sql)) {
        
        stm.setInt(1, detalle_Movimiento.getId_Detalle());
        int filasAfectadas = stm.executeUpdate();

        if (filasAfectadas > 0) {
            eliminado = true;
        }

    } catch (SQLException err) {
        System.out.println("Error al borrar el detalle de movimiento " + err.getMessage());
    }

    return eliminado;
}

 // Buscar detalles de movimiento
    public ArrayList<Detalle_Movimiento> buscarDetalle_Movimiento(Detalle_Movimiento detalle_Movimientoex) {
        ArrayList<Detalle_Movimiento> Detalle_MovimientosBD = new ArrayList<Detalle_Movimiento>();
        String sql = "SELECT * FROM detalle_movimiento WHERE Id_detalle = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, detalle_Movimientoex.getId_Detalle());

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Detalle_Movimiento detalle_Movimiento = new Detalle_Movimiento();

                    detalle_Movimiento.setId_Detalle(rs.getInt("Id_detalle"));
                    detalle_Movimiento.setCod_Movimientos1(rs.getInt("Cod_Movimientos1"));
                    detalle_Movimiento.setId_Producto1(rs.getInt("id_producto1"));
                    detalle_Movimiento.setId_Almacen7(rs.getInt("id_almacen7"));
                    detalle_Movimiento.setCantidad(rs.getInt("Cantidad"));

                    Detalle_MovimientosBD.add(detalle_Movimiento);
                }
            }

        } catch (SQLException err) {
            System.err.println("Error al buscar los detalles del movimiento: " + err.getMessage());
        }

        return Detalle_MovimientosBD;
    }
}
