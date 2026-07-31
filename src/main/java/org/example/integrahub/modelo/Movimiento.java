package org.example.integrahub.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Movimiento {

    // asignacion de atributos
    private int cod_Movimiento = 0;
    private int id_Almacen6 = 0;
    private String movimiento_de_ = "";
    private Integer id_Cliente1 = null; 
    private Integer id_Proveedor2 = null; 
    private int id_Empleado3 = 0;
    private String descripcion = "";
    private LocalDate fech_Registro;
    private LocalDate fech_Orden;
    private LocalDate fech_Concluido; 
    private int calificacion = 0;
    private String desc_Calificacion = "";

    // constructores (vacio / con atributos )
    public Movimiento() {
    }

    public Movimiento(int cod_Movimiento, int id_Almacen6, String movimiento_de_, Integer id_Cliente1, Integer id_Proveedor2, int id_Empleado3, String descripcion, LocalDate fech_Registro, LocalDate fech_Orden, LocalDate fech_Concluido, int calificacion, String desc_Calificacion) {
        setCod_Movimiento(cod_Movimiento);
        setId_Almacen6(id_Almacen6);
        setMovimiento_de_(movimiento_de_);
        setId_Cliente1(id_Cliente1);
        setId_Proveedor2(id_Proveedor2);
        setId_Empleado3(id_Empleado3);
        setDescripcion(descripcion);
        setFech_Registro(fech_Registro);
        setFech_Orden(fech_Orden);
        setFech_Concluido(fech_Concluido);
        setCalificacion(calificacion);
        setDesc_Calificacion(desc_Calificacion);
    }

    // geters (formatos) y setters (condiciones para guardar)

    public int getCod_Movimiento() {
        return cod_Movimiento;
    }

    public void setCod_Movimiento(int cod_Movimiento) {
        if (cod_Movimiento > 0) {
            this.cod_Movimiento = cod_Movimiento;
        } else {
            System.out.println("El código de movimiento no debe ser menor a 0");
        }
    }

    public int getId_Almacen6() {
        return id_Almacen6;
    }

    public void setId_Almacen6(int id_Almacen6) {
        if (id_Almacen6 > 0) {
            this.id_Almacen6 = id_Almacen6;
        } else {
            System.out.println("El id no debe ser menor a 0");
        }
    }

    public String getMovimiento_de_() {
        String movimientoFormato = "";
        if (this.movimiento_de_ != null) {
            movimientoFormato = this.movimiento_de_.toLowerCase();
        }
        return movimientoFormato;
    }

    public void setMovimiento_de_(String movimiento_de_) {
        if (movimiento_de_ == null || movimiento_de_.isBlank()) {
            System.out.println("El movimiento es un requisito");
        } else {
            this.movimiento_de_ = movimiento_de_;
        }
    }

    public Integer getId_Cliente1() {
        return id_Cliente1;
    }

    public void setId_Cliente1(Integer id_Cliente1) {
        // Permite nulos o valores mayores a 0
        if (id_Cliente1 == null || id_Cliente1 > 0) {
            this.id_Cliente1 = id_Cliente1;
        } else {
            System.out.println("El id cliente no debe ser menor a 0");
        }
    }

    public Integer getId_Proveedor2() {
        return id_Proveedor2;
    }

    public void setId_Proveedor2(Integer id_Proveedor2) {
        // Permite nulos o valores mayores a 0
        if (id_Proveedor2 == null || id_Proveedor2 > 0) {
            this.id_Proveedor2 = id_Proveedor2;
        } else {
            System.out.println("El id proveedor no debe ser menor a 0");
        }
    }

    public int getId_Empleado3() {
        return id_Empleado3;
    }

    public void setId_Empleado3(int id_Empleado3) {
        if (id_Empleado3 > 0) {
            this.id_Empleado3 = id_Empleado3;
        } else {
            System.out.println("El id no debe ser menor a 0");
        }
    }

    public String getDescripcion() {
        String descripcionFormato = "";
        if (this.descripcion != null) {
            descripcionFormato = this.descripcion.toLowerCase();
        }
        return descripcionFormato;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            System.out.println("La descripción es un requisito");
        } else {
            this.descripcion = descripcion;
        }
    }

    public String getFech_Registro() {
        if (this.fech_Registro != null) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
            return this.fech_Registro.format(formato);
        }
        return "Fecha no asignada";
    }

    public void setFech_Registro(LocalDate fech_Registro) {
        if (fech_Registro == null) {
            System.out.println("La fecha de registro es un requisito");
        } else {
            this.fech_Registro = fech_Registro;
        }
    }

    public String getFech_Orden() {
        if (this.fech_Orden != null) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
            return this.fech_Orden.format(formato);
        }
        return "Fecha no asignada";
    }

    public void setFech_Orden(LocalDate fech_Orden) {
        if (fech_Orden == null) {
            System.out.println("La fecha de orden es un requisito");
        } else {
            this.fech_Orden = fech_Orden;
        }
    }

    public String getFech_Concluido() {
        if (this.fech_Concluido != null) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
            return this.fech_Concluido.format(formato);
        }
        return "Fecha no asignada";
    }

    public void setFech_Concluido(LocalDate fech_Concluido) {
        // Permite asignar valor nulo sin mostrar mensaje de error
        this.fech_Concluido = fech_Concluido;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        if (calificacion > 0) {
            this.calificacion = calificacion;
        } else {
            System.out.println("La calificación no debe ser menor a 0");
        }
    }

    public String getDesc_Calificacion() {
        String descCalificacionFormato = "";
        if (this.desc_Calificacion != null) {
            descCalificacionFormato = this.desc_Calificacion.toLowerCase();
        }
        return descCalificacionFormato;
    }

    public void setDesc_Calificacion(String desc_Calificacion) {
        if (desc_Calificacion == null || desc_Calificacion.isBlank()) {
            System.out.println("La descripción de calificación es un requisito");
        } else {
            this.desc_Calificacion = desc_Calificacion;
        }
    }
}