package org.example.integrahub.dao;

import org.example.integrahub.Config.Conexion;
import org.example.integrahub.modelo.Empleado;
import org.example.integrahub.modelo.Movimiento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovimientoDAO {

    //Extrae todos los datos de la tabla Movimientos
    public ArrayList<Movimiento> extraerMovimientos() {
        ArrayList<Movimiento> movimientosBD = new ArrayList<Movimiento>();
        String sql = "SELECT * FROM movimientos";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Movimiento movimiento = new Movimiento();

                movimiento.setCod_Movimiento(rs.getInt("Cod_Movimientos"));
                movimiento.setId_Almacen6(rs.getInt("Id_almacen6"));
                movimiento.setMovimiento_de_(rs.getString("Movimiento_de_"));

                // Manejo de id_Cliente1 (puede ser nulo en la BD)
                int idCliente = rs.getInt("Id_cliente1");
                movimiento.setId_Cliente1(rs.wasNull() ? null : idCliente);

                // Manejo de id_Proveedor2 (puede ser nulo en la BD)
                int idProveedor = rs.getInt("Id_proveedor2");
                movimiento.setId_Proveedor2(rs.wasNull() ? null : idProveedor);

                movimiento.setId_Empleado3(rs.getInt("Id_empleado3"));
                movimiento.setDescripcion(rs.getString("descripcion"));

                Date fechRegistro = rs.getDate("Fech_Registro");
                if (fechRegistro != null) {
                    movimiento.setFech_Registro(fechRegistro.toLocalDate());
                }

                Date fechOrden = rs.getDate("Fech_Orden");
                if (fechOrden != null) {
                    movimiento.setFech_Orden(fechOrden.toLocalDate());
                }

                Date fechConcluido = rs.getDate("Fech_Concluido");
                movimiento.setFech_Concluido(fechConcluido != null ? fechConcluido.toLocalDate() : null);

                movimiento.setCalificacion(rs.getInt("Calificacion"));
                movimiento.setDesc_Calificacion(rs.getString("desc_Calificacion"));

                movimientosBD.add(movimiento);
            }
        } catch (SQLException err) {
            System.err.println("Error al extraer los datos " + err.getMessage());
        }

        return movimientosBD;
    }

    // Borrar Movimiento pidiendo su codigo
    public boolean borrarMovimiento(Movimiento movimiento) {
        boolean eliminado = false;
        String sql = "DELETE FROM `integraHUB`.`movimientos` WHERE Cod_Movimientos = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, movimiento.getCod_Movimiento());
            int filasAfectadas = stm.executeUpdate();

            if (filasAfectadas > 0) {
                eliminado = true;
            }

        } catch (SQLException err) {
            System.out.println("Error al borrar el movimiento " + err.getMessage());
        }

        return eliminado;
    }

    // Buscar movimientos
    public ArrayList<Movimiento> buscarMovimiento(Movimiento movimientoex) {
        ArrayList<Movimiento> movimientosBD = new ArrayList<Movimiento>();
        String sql = "SELECT * FROM movimientos WHERE Cod_movimientos = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, movimientoex.getCod_Movimiento());

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Movimiento movimiento = new Movimiento();

                    movimiento.setCod_Movimiento(rs.getInt("Cod_Movimientos"));
                    movimiento.setId_Almacen6(rs.getInt("Id_almacen6"));
                    movimiento.setMovimiento_de_(rs.getString("Movimiento_de_"));

                    // Manejo de id_Cliente1 (puede ser nulo en la BD)
                    int idCliente = rs.getInt("Id_cliente1");
                    movimiento.setId_Cliente1(rs.wasNull() ? null : idCliente);

                    // Manejo de id_Proveedor2 (puede ser nulo en la BD)
                    int idProveedor = rs.getInt("Id_proveedor2");
                    movimiento.setId_Proveedor2(rs.wasNull() ? null : idProveedor);

                    movimiento.setId_Empleado3(rs.getInt("Id_empleado3"));
                    movimiento.setDescripcion(rs.getString("descripcion"));

                    Date fechRegistro = rs.getDate("Fech_Registro");
                    if (fechRegistro != null) {
                        movimiento.setFech_Registro(fechRegistro.toLocalDate());
                    }

                    Date fechOrden = rs.getDate("Fech_Orden");
                    if (fechOrden != null) {
                        movimiento.setFech_Orden(fechOrden.toLocalDate());
                    }

                    Date fechConcluido = rs.getDate("Fech_Concluido");
                    movimiento.setFech_Concluido(fechConcluido != null ? fechConcluido.toLocalDate() : null);

                    movimiento.setCalificacion(rs.getInt("Calificacion"));
                    movimiento.setDesc_Calificacion(rs.getString("desc_Calificacion"));

                    movimientosBD.add(movimiento);
                }
            }

        } catch (SQLException err) {
            System.err.println("Error al buscar al cliente: " + err.getMessage());
        }

        return movimientosBD;
    }
}