package org.example.integrahub.dao;

import org.example.integrahub.Config.Conexion;
import org.example.integrahub.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    // 1. INSERTAR / GUARDAR UN NUEVO CLIENTE
    public boolean insertarCliente(Cliente cliente) {
        boolean insertado = false;
        // Nombres de columnas en minúsculas como están en MySQL
        String sql = "INSERT INTO cliente (nombre, direccion, tel1, tel2, id_almacen3) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setString(1, cliente.getNombre());
            stm.setString(2, cliente.getDireccion());
            stm.setString(3, cliente.getTel1());
            stm.setString(4, cliente.getTel2());
            stm.setInt(5, cliente.getId_Almacen3());

            int filasAfectadas = stm.executeUpdate();
            if (filasAfectadas > 0) {
                insertado = true;
            }

        } catch (SQLException err) {
            System.err.println("Error al insertar cliente: " + err.getMessage());
        }

        return insertado;
    }

    // 2. EXTRAER TODOS LOS CLIENTES
    public ArrayList<Cliente> extraerCliente() {
        ArrayList<Cliente> clientesBD = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_Cliente(rs.getInt("Id_cliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setTel1(rs.getString("Tel1"));
                cliente.setTel2(rs.getString("Tel2"));
                cliente.setId_Almacen3(rs.getInt("Id_almacen3"));

                clientesBD.add(cliente);
            }

        } catch (SQLException err) {
            System.err.println("Error al extraer los datos: " + err.getMessage());
        }

        return clientesBD;
    }

    // 3. BORRAR CLIENTE POR ID
    public boolean borrarCliente(Cliente cliente) {
        boolean eliminado = false;
        String sql = "DELETE FROM cliente WHERE Id_cliente = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, cliente.getId_Cliente());
            int filasAfectadas = stm.executeUpdate();

            if (filasAfectadas > 0) {
                eliminado = true;
            }

        } catch (SQLException err) {
            System.err.println("Error al borrar al cliente: " + err.getMessage());
        }

        return eliminado;
    }

    // 4. BUSCAR CLIENTES POR ID
    public ArrayList<Cliente> buscarCliente(Cliente clienteex) {
        ArrayList<Cliente> clientesBD = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE Id_cliente = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, clienteex.getId_Cliente());

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId_Cliente(rs.getInt("Id_cliente"));
                    cliente.setNombre(rs.getString("Nombre"));
                    cliente.setDireccion(rs.getString("Direccion"));
                    cliente.setTel1(rs.getString("Tel1"));
                    cliente.setTel2(rs.getString("Tel2"));
                    cliente.setId_Almacen3(rs.getInt("Id_almacen3"));

                    clientesBD.add(cliente);
                }
            }

        } catch (SQLException err) {
            System.err.println("Error al buscar al cliente: " + err.getMessage());
        }

        return clientesBD;
    }

    // METODO DE PRUEBA RAPIDA
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();

        // Le pasamos 1 en lugar de 0 para que no brinque la validacion del modelo
        Cliente nuevo = new Cliente(1, "Carlos Lopez", "Av. Universidad 123", "4271234567", "", 1);

        if (dao.insertarCliente(nuevo)) {
            System.out.println("¡Exito! El cliente se inserto correctamente en MySQL.");
        } else {
            System.out.println("No se pudo insertar el cliente.");
        }
    }
}