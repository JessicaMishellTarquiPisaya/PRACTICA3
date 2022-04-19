package com.emergentes.modelo;

public class Categorias {
    private int id;
    private String categoria;
    
    public Categorias()
    {
        id=0;
        categoria = "";
    }
    public Categorias(int id, String categoria){
        this.id = id;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}

    