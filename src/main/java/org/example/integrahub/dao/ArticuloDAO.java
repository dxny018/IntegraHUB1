package org.example.integrahub.dao;


import org.example.integrahub.Config.Conexion;
import org.example.integrahub.modelo.Articulo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticuloDAO {

      // Extrae todos los datos de la tabla Articulos
        public ArrayList<Articulo> extraerArticulo() {
            ArrayList<Articulo> articulosBD = new ArrayList<Articulo>();
            String sql = "SELECT * FROM articulo";
            try (Connection conexion = Conexion.conectar();
                 PreparedStatement stm = conexion.prepareStatement(sql);
                 ResultSet rs = stm.executeQuery()) {

                while (rs.next()) {
                    Articulo articulo = new Articulo();

                    articulo.setId_Producto(rs.getInt("Id_producto"));
                    articulo.setTipoProducto(rs.getString("Tipo_producto"));
                    articulo.setNombre(rs.getString("Nombre"));
                    articulo.setCantidad(rs.getInt("Cantidad"));
             articulo.setModelo(rs.getString("Modelo"));


    articulo.setModelo(rs.getString("Modelo"));                    articulo.setColor(rs.getString("Color"));
                    articulo.setProducto_De(rs.getString("Producto_de_"));
                   articulo.setId_Proveedor1(rs.getInt("Id_proveedor1"));
                    articulo.setId_Almacen5(rs.getInt("Id_almacen5"));

                    articulosBD.add(articulo);
                }
            } catch (SQLException err) {
                System.err.println("Error al extraer los datos " + err.getMessage());
            }
            return articulosBD;
        }

       // Borrar
              public boolean borrarArticulo (Articulo articulo){
                  boolean eliminado = false;
                  String sql = "DELETE FROM `integraHUB`.`articulo` WHERE Id_producto = ?";
                  try (Connection conexion = Conexion.conectar();
                       PreparedStatement stm = conexion.prepareStatement(sql)) {

                      stm.setInt(1, articulo.getId_Producto());
                      int filasAfectadas = stm.executeUpdate();

                      if (filasAfectadas > 0) {
                          eliminado = true;
                      }

                  } catch (SQLException err) {
                      System.out.println("Error al borrar el articulo " + err.getMessage());
                  }

                  return eliminado;
              }
       // Buscar articulo
          public ArrayList<Articulo> buscarArticulo(Articulo articuloex) {
              ArrayList<Articulo> articuloBD = new ArrayList<Articulo>();
              String sql = "SELECT * FROM articulo WHERE Id_producto = ?";

              try (Connection conexion = Conexion.conectar();
                   PreparedStatement stm = conexion.prepareStatement(sql)) {

                  stm.setInt(1, articuloex.getId_Producto());

                  try (ResultSet rs = stm.executeQuery()) {
                      while (rs.next()) {
                          Articulo articulo = new Articulo();

                          articulo.setId_Producto(rs.getInt("Id_cliente"));
                          articulo.setTipoProducto(rs.getString("Tipo_producto"));
                          articulo.setNombre(rs.getString("Nombre"));
                          articulo.setCantidad(rs.getInt("Cantidad"));
                          articulo.setModelo(rs.getString("Modelo"));
                          articulo.setColor(rs.getString("Color"));
                          articulo.setProducto_De(rs.getString("Producto_de_"));
                          articulo.setId_Proveedor1(rs.getInt("Id_proveedor1"));
                          articulo.setId_Almacen5(rs.getInt("Id_almacen5"));

                          articuloBD.add(articulo);
                      }
                  }

              } catch (SQLException err) {
                  System.err.println("Error al buscar el articulo: " + err.getMessage());
              }

              return articuloBD;
          }
}
