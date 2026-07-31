package org.example.integrahub.dao;

import org.example.integrahub.Config.Conexion;
import org.example.integrahub.modelo.Almacen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlmacenDAO {

    // 1. EXTRAER / LISTAR TODOS LOS ALMACENES
    public List<Almacen> extraerAlmacenes() {
        List<Almacen> almacenesBD = new ArrayList<>();
        String sql = "SELECT id_almacen, Zona, Piso, Direccion FROM almacen";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Almacen almacen = new Almacen();
                almacen.setId_Almacen(rs.getInt("id_almacen"));
                almacen.setZona(rs.getString("Zona"));
                almacen.setPiso(rs.getInt("Piso"));
                almacen.setDireccion(rs.getString("Direccion"));

                almacenesBD.add(almacen);
            }
        } catch (SQLException err) {
            System.err.println("Error al extraer los almacenes: " + err.getMessage());
        }
        return almacenesBD;
    }

    // 2. INSERTAR UN NUEVO ALMACÉN
    public boolean insertarAlmacen(Almacen almacen) {
        boolean insertado = false;
        String sql = "INSERT INTO almacen (Zona, Piso, Direccion) VALUES (?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setString(1, almacen.getZona());
            stm.setInt(2, almacen.getPiso());
            stm.setString(3, almacen.getDireccion());

            int filasAfectadas = stm.executeUpdate();
            if (filasAfectadas > 0) {
                insertado = true;
            }

        } catch (SQLException err) {
            System.err.println("Error al insertar el almacén: " + err.getMessage());
        }

        return insertado;
    }

    // 3. ACTUALIZAR UN ALMACÉN EXISTENTE
    public boolean actualizarAlmacen(Almacen almacen) {
        boolean actualizado = false;
        String sql = "UPDATE almacen SET Zona = ?, Piso = ?, Direccion = ? WHERE id_almacen = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setString(1, almacen.getZona());
            stm.setInt(2, almacen.getPiso());
            stm.setString(3, almacen.getDireccion());
            stm.setInt(4, almacen.getId_Almacen());

            int filasAfectadas = stm.executeUpdate();
            if (filasAfectadas > 0) {
                actualizado = true;
            }

        } catch (SQLException err) {
            System.err.println("Error al actualizar el almacén: " + err.getMessage());
        }

        return actualizado;
    }

    // 4. BORRAR ALMACÉN (Recibiendo ID)
    public boolean borrarAlmacen(int idAlmacen) {
        boolean eliminado = false;
        String sql = "DELETE FROM almacen WHERE id_almacen = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, idAlmacen);
            int filasAfectadas = stm.executeUpdate();

            if (filasAfectadas > 0) {
                eliminado = true;
            }

        } catch (SQLException err) {
            System.err.println("Error al borrar el almacén: " + err.getMessage());
        }

        return eliminado;
    }

    // Sobrecarga de borrar (recibiendo el Objeto Almacen)
    public boolean borrarAlmacen(Almacen almacen) {
        return borrarAlmacen(almacen.getId_Almacen());
    }

    // 5. BUSCAR ALMACÉN POR ID (Retorna un solo objeto)
    public Almacen buscarPorId(int idAlmacen) {
        Almacen almacen = null;
        String sql = "SELECT id_almacen, Zona, Piso, Direccion FROM almacen WHERE id_almacen = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, idAlmacen);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    almacen = new Almacen();
                    almacen.setId_Almacen(rs.getInt("id_almacen"));
                    almacen.setZona(rs.getString("Zona"));
                    almacen.setPiso(rs.getInt("Piso"));
                    almacen.setDireccion(rs.getString("Direccion"));
                }
            }

        } catch (SQLException err) {
            System.err.println("Error al buscar el almacén por ID: " + err.getMessage());
        }

        return almacen;
    }

    // 6. BUSCAR ALMACENES POR CRITERIO (ej. por coincidencia de Zona)
    public List<Almacen> buscarPorZona(String zona) {
        List<Almacen> almacenesBD = new ArrayList<>();
        String sql = "SELECT id_almacen, Zona, Piso, Direccion FROM almacen WHERE Zona LIKE ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setString(1, "%" + zona + "%");

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Almacen almacen = new Almacen();
                    almacen.setId_Almacen(rs.getInt("id_almacen"));
                    almacen.setZona(rs.getString("Zona"));
                    almacen.setPiso(rs.getInt("Piso"));
                    almacen.setDireccion(rs.getString("Direccion"));

                    almacenesBD.add(almacen);
                }
            }

        } catch (SQLException err) {
            System.err.println("Error al buscar almacenes por zona: " + err.getMessage());
        }

        return almacenesBD;
    }
}