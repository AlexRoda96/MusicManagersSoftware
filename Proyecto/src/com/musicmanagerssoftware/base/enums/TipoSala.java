package com.musicmanagerssoftware.base.enums;

public enum TipoSala {

    TEATRO("Teatro"),
    SALACONCIERTOS("Sala de conciertos"),
    AUDITORIO("Auditorio"),
    ESTADIO("Estadio"),
    PABELLON("Pabellon"),
    CARPA("Carpa");

    String tipo;

    TipoSala(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
