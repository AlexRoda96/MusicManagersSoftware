package com.musicmanagerssoftware.base.enums;

public enum TipoSala {

    TEATRO("Teatro");

    String tipo;

    TipoSala(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
