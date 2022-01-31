package com.compass.avaliacao3.config.validation;

public class PropertyErrorDto {
    private String parametro;
    private String erro;

    public PropertyErrorDto(String parametro, String erro){
        this.parametro = parametro;
        this.erro = erro;
    }

    public String getParametro() {
        return parametro;
    }

    public String getErro() {
        return erro;
    }
}
