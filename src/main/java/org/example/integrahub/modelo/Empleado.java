package org.example.integrahub.modelo;

public class Empleado {

    // asignacion de atributos
    private int id_Empleado = 0;
    private String nombre = "";
    private String tel1 = "";
    private String tel2 = null; // Puede ser nulo
    private String puesto = "";
    private String area = "";
    private String direccion = "";
    private String rfc = "";
    private String curp = "";
    private int id_Almacen1 = 0;

    // constructores (vacio / con atributos )
    public Empleado() {
    }

    public Empleado(int id_Empleado, String nombre, String tel1, String tel2, String puesto, String area, String direccion, String rfc, String curp, int id_Almacen1) {
        setId_Empleado(id_Empleado);
        setNombre(nombre);
        setTel1(tel1);
        setTel2(tel2);
        setPuesto(puesto);
        setArea(area);
        setDireccion(direccion);
        setRfc(rfc);
        setCurp(curp);
        setId_Almacen1(id_Almacen1);
    }

    // geters (formatos) y setters (condiciones para guardar)

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        if (id_Empleado > 0) {
            this.id_Empleado = id_Empleado;
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
            System.out.println("El nombre del empleado es un requisito");
        } else {
            this.nombre = nombre;
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

    public String getPuesto() {
        String puestoFormato = "";
        if (this.puesto != null) {
            puestoFormato = this.puesto.toLowerCase();
        }
        return puestoFormato;
    }

    public void setPuesto(String puesto) {
        if (puesto == null || puesto.isBlank()) {
            System.out.println("El puesto del empleado es un requisito");
        } else {
            this.puesto = puesto;
        }
    }

    public String getArea() {
        String areaFormato = "";
        if (this.area != null) {
            areaFormato = this.area.toLowerCase();
        }
        return areaFormato;
    }

    public void setArea(String area) {
        if (area == null || area.isBlank()) {
            System.out.println("El área del empleado es un requisito");
        } else {
            this.area = area;
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
            System.out.println("La dirección del empleado es un requisito");
        } else {
            this.direccion = direccion;
        }
    }

    public String getRfc() {
        String rfcFormato = "";
        if (this.rfc != null) {
            rfcFormato = this.rfc.toLowerCase();
        }
        return rfcFormato;
    }

    public void setRfc(String rfc) {
        if (rfc == null || rfc.isBlank()) {
            System.out.println("El RFC del empleado es un requisito");
        } else {
            this.rfc = rfc;
        }
    }

    public String getCurp() {
        String curpFormato = "";
        if (this.curp != null) {
            curpFormato = this.curp.toLowerCase();
        }
        return curpFormato;
    }

    public void setCurp(String curp) {
        if (curp == null || curp.isBlank()) {
            System.out.println("La CURP del empleado es un requisito");
        } else {
            this.curp = curp;
        }
    }

    public int getId_Almacen1() {
        return id_Almacen1;
    }

    public void setId_Almacen1(int id_Almacen1) {
        if (id_Almacen1 > 0) {
            this.id_Almacen1 = id_Almacen1;
        } else {
            System.out.println("El id no debe ser menor a 0");
        }
    }
}