package org.example.integrahub.modelo;

public class Usuario {

    // asignacion de atributos
    private int id_User = 0 ;
    private String usuario = "";
    private String contrasena = "";
    private int id_Almacen2 = 0;
    private int id_Empleado1 = 0;

    // constructores (vacio / con atributos )
    public Usuario() {
    }

    public Usuario(int id_User, String usuario, String contrasena, int id_Almacen2, int id_Empleado1) {
        setId_User(id_User);
        setUsuario(usuario);
        setContrasena(contrasena);
        setId_Almacen2(id_Almacen2);
        setId_Empleado1(id_Empleado1);
    }

    // geters (formatos) y setters (condiciones para guardar)


    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        if (id_User >0 ) {
            this.id_User = id_User;
        }else {
            System.out.println("El id no debe ser menor a 0");
        }
    }

    public String getUsuario() {
        String usuarioFormato = "";
        if(this.usuario!=null){
            usuarioFormato = this.usuario.toLowerCase();
        }
        return usuarioFormato;
    }

    public void setUsuario(String usuario) {
        if (usuario == null || usuario.isBlank()) {
            System.out.println("El nombre del usuario es un requisito");
        } else {
            this.usuario = usuario;
        }
    }

    public String getContrasena() {
        String contrasenaFormato = "";
        if(this.contrasena!=null){
            contrasenaFormato = this.usuario.toLowerCase();
        }
        return contrasenaFormato;
    }

    public void setContrasena(String contrasena) {
        if (contrasena == null || contrasena.isBlank()) {
            System.out.println("La contraseña del usuario es un requisito");
        } else {
            this.contrasena = contrasena;
        }
    }

    public int getId_Almacen2() {
        return id_Almacen2;
    }

    public void setId_Almacen2(int id_Almacen2) {
        if (id_Almacen2 > 0) {
            this.id_Almacen2 = id_Almacen2;
        }else {
            System.out.println("El id no debe ser menor a 0");
        }
    }

    public int getId_Empleado1() {
        return id_Empleado1;
    }

    public void setId_Empleado1(int id_Empleado1) {
        if (id_Empleado1 > 0) {
            this.id_Empleado1 = id_Empleado1;
        }else {
            System.out.println("El id no debe ser menor a 0");
        }
    }
}
