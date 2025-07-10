package com.mycompany.main.modelo;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String telefono;
    private String correo;

    public Cliente(int idCliente, String nombre, String telefono, String correo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
}
