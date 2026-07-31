package org.example.integrahub.modelo;

public class Cliente {
    
    // asignacion de atruibuto
    private int id_Cliente = 0;
    private String nombre = "";
    private String direccion = "";
    private String tel1 = "";
    private String tel2 = "";
    private int id_Almacen3 = 0;

    // constructores (vacio / con atributos )
    public Cliente() {
    }

    public Cliente(int id_Cliente,String nombre, String direccion, String tel1, String tel2, int id_Almacen3) {
        setId_Cliente(id_Cliente);
        setDireccion(direccion);
        setTel1(tel1);
        setTel2(tel2);
        setId_Almacen3(id_Almacen3);
        setNombre(nombre);
    }

    // geters (formatos) y setters (condiciones para guardar)

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        if (id_Cliente > 0) {
            this.id_Cliente = id_Cliente;
        } else {
            System.out.println("El id del cliente es un requisito y debe ser mayor a 0");
        }
    }

    public String getNombre() {
            String nombreFormato = "";
            if (this.nombre != null) {
                nombreFormato = this.nombre.toLowerCase();
            }
            return nombreFormato;
        }

        public void setNombre(String nombre) {
            if (nombre == null || nombre.isBlank()) {
                System.out.println("El nombre es un requisito");
            } else {
                this.nombre = nombre;
            }
        }

    public String getDireccion() {
        String direccionFormato = "";
        if (this.direccion != null) {
            direccionFormato = this.direccion.toLowerCase();
        }
        return direccionFormato;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isBlank()) {
            System.out.println("La direccion es un requisito");
        } else {
            this.direccion = direccion;
        }
    }

    public String getTel1() {
        String tel1Formato = "";
        if (this.tel1 != null) {
            tel1Formato = this.tel1.toLowerCase();
        }
        return tel1Formato;
    }

    public void setTel1(String tel1) {
        if (tel1 == null || tel1.isBlank()) {
            System.out.println("El teléfono 1 es un requisito");
        } else {
            this.tel1 = tel1;
        }
    }

    public String getTel2() {
        String tel2Formato = "";
        if (this.tel2 != null) {
            tel2Formato = this.tel2.toLowerCase();
        }
        return tel2Formato;
    }

    public void setTel2(String tel2) {
        // Permite nulos o cadenas vacías sin lanzar mensaje de error
        this.tel2 = tel2;
    }

    public int getId_Almacen3() {
        return id_Almacen3;
    }

    public void setId_Almacen3(int id_Almacen3) {
        this.id_Almacen3 = id_Almacen3;
    }
}