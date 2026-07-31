package org.example.integrahub.modelo;

public class Proveedor {

    // asignacion de atributos
    private int id_Proveedor = 0;
    private String nombre = "";
    private String direccion = "";
    private String especialidad = "";
    private String tel1 = "";
    private String tel2 = "";
    private String tipo_Material = "";
    private int id_Almacen4 = 0;

    // constructores (vacio / con atributos )
    public Proveedor() {
    }

    public Proveedor(int id_Proveedor, String nombre, String direccion, String especialidad, String tel1, String tel2, String tipo_Material, int id_Almacen4) {
        setId_Proveedor(id_Proveedor);
        setNombre(nombre);
        setDireccion(direccion);
        setEspecialidad(especialidad);
        setTel1(tel1);
        setTel2(tel2);
        setTipo_Material(tipo_Material);
        setId_Almacen4(id_Almacen4);
    }

    // geters (formatos) y setters (condiciones para guardar)

    public int getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(int id_Proveedor) {
        if (id_Proveedor > 0) {
            this.id_Proveedor = id_Proveedor;
        } else {
            System.out.println("El id no debe ser menor a 0");
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
            System.out.println("El nombre del proveedor es un requisito");
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
            System.out.println("La dirección del proveedor es un requisito");
        } else {
            this.direccion = direccion;
        }
    }

    public String getEspecialidad() {
        String especialidadFormato = "";
        if (this.especialidad != null) {
            especialidadFormato = this.especialidad.toLowerCase();
        }
        return especialidadFormato;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.isBlank()) {
            System.out.println("La especialidad del proveedor es un requisito");
        } else {
            this.especialidad = especialidad;
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
        if (tel2 == null || tel2.isBlank()) {
            System.out.println("El teléfono 2 es un requisito");
        } else {
            this.tel2 = tel2;
        }
    }

    public String getTipo_Material() {
        String tipo_MaterialFormato = "";
        if (this.tipo_Material != null) {
            tipo_MaterialFormato = this.tipo_Material.toLowerCase();
        }
        return tipo_MaterialFormato;
    }

    public void setTipo_Material(String tipo_Material) {
        if (tipo_Material == null || tipo_Material.isBlank()) {
            System.out.println("El tipo de material es un requisito");
        } else {
            this.tipo_Material = tipo_Material;
        }
    }

    public int getId_Almacen4() {
        return id_Almacen4;
    }

    public void setId_Almacen4(int id_Almacen4) {
        if (id_Almacen4 > 0) {
            this.id_Almacen4 = id_Almacen4;
        } else {
            System.out.println("El id no debe ser menor a 0");
        }
    }
}
