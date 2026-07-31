package org.example.integrahub.dao;

import org.example.integrahub.Config.Conexion;
import org.example.integrahub.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    // Extrae todos los datos de la tabla Usuarios
    public ArrayList<Usuario> extraerUsuarios() {
        ArrayList<Usuario> usuariosBD = new ArrayList<Usuario>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setId_User(rs.getInt("Id_User"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setId_Almacen2(rs.getInt("Id_almacen2"));
                usuario.setId_Empleado1(rs.getInt("Id_empleado1"));

                usuariosBD.add(usuario);
            }
        } catch (SQLException err) {
            System.err.println("Error al extraer los datos " + err.getMessage());
        }
        return usuariosBD;
    }

    // Borrar al usuario pidiendo el id
    public boolean borrarUsuario(Usuario usuario) {
        boolean eliminado = false;
        String sql = "DELETE FROM `integraHUB`.`usuarios` WHERE Id_User = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, usuario.getId_User());
            int filasAfectadas = stm.executeUpdate();

            if (filasAfectadas > 0) {
                eliminado = true;
            }

        } catch (SQLException err) {
            System.out.println("Error al borrar al usuario " + err.getMessage());
        }

        return eliminado;
    }

    // Buscar usuario por nombre o id
    public ArrayList<Usuario> buscarUsuario(Usuario usuarioex) {
        ArrayList<Usuario> usuariosBD = new ArrayList<Usuario>();
        String sql = "SELECT * FROM usuarios WHERE Id_User = ? OR usuario LIKE ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, usuarioex.getId_User());
            stm.setString(2, "%" + usuarioex.getUsuario() + "%");

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Usuario usuario = new Usuario();

                    usuario.setId_User(rs.getInt("Id_User"));
                    usuario.setUsuario(rs.getString("usuario"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setId_Almacen2(rs.getInt("Id_almacen2"));
                    usuario.setId_Empleado1(rs.getInt("Id_empleado1"));

                    usuariosBD.add(usuario);
                }
            }

        } catch (SQLException err) {
            System.err.println("Error al buscar el usuario " + err.getMessage());
        }

        return usuariosBD;
    }
}
