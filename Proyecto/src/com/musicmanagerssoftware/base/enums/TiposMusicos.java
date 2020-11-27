package com.musicmanagerssoftware.base.enums;

public enum TiposMusicos {

    NULL("Desconocido"),
    VOCALISTA("Vocalista");

    private String tipo;

    private TiposMusicos(String tipo){
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
