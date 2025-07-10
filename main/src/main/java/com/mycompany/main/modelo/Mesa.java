package com.mycompany.main.modelo;

public class Mesa {
    private String idMesa;
    private boolean disponible;

    public Mesa(String idMesa) {
        this.idMesa = idMesa;
        this.disponible = true;
    }

    public String getIdMesa() { return idMesa; }
    public boolean isDisponible() { return disponible; }

    public void ocupar() { disponible = false; }
    public void liberar() { disponible = true; }
}

