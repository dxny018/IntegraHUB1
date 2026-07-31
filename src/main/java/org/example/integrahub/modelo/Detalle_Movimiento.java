package org.example.integrahub.modelo;

public class Detalle_Movimiento {

    // asignacion de atributos
    private int id_Detalle = 0;
    private int cod_Movimientos1 = 0;
    private int id_Producto1 = 0;
    private int id_Almacen7;
    private float cantidad = 0;
    
    // constructores (vacio / con atributos )
    public Detalle_Movimiento() {
    }
 
        public Detalle_Movimiento(int id_Detalle, int cod_Movimientos1, int id_Producto1, float cantidad, int Id_Almacen7) {
        setId_Detalle(id_Detalle);
        setCod_Movimientos1(cod_Movimientos1);
        setId_Producto1(id_Producto1);
        setId_Almacen7(Id_Almacen7);
        setCantidad(cantidad);
    }

    // geters (formatos) y setters (condiciones para guardar)

    public int getId_Detalle() {
        return id_Detalle;
    }

    public void setId_Detalle(int id_Detalle) {
        if (id_Detalle > 0) {
            this.id_Detalle = id_Detalle;
        } else {
            System.out.println("El id no debe ser menor a 0");
        }
    }

    public int getCod_Movimientos1() {
        return cod_Movimientos1;
    }

    public void setCod_Movimientos1(int cod_Movimientos1) {
        this.cod_Movimientos1 = cod_Movimientos1;
    }

    public int getId_Producto1() {
        return id_Producto1;
    }

    public void setId_Producto1(int id_Producto1) {
        this.id_Producto1 = id_Producto1;
    }

    public float getCantidad() {
        String precioFormato = String.format("%.2f", this.cantidad);
        return (float) Double.parseDouble(precioFormato);
    }

    public int getId_Almacen7() {
        return id_Almacen7;
    }

    public void setId_Almacen7(int id_Almacen7) {
        this.id_Almacen7 = id_Almacen7;
    }

    public void setCantidad(float cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            System.out.println("La cantidad no puede ser menor a 0");
        }
    }
}