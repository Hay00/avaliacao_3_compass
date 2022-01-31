package com.compass.avaliacao3.controller.form;

import com.compass.avaliacao3.config.validation.Region;
import com.compass.avaliacao3.model.State;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StateForm {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    @Region
    private String regiao;

    @NotNull
    @Min(0)
    private Long populacao;

    @NotNull
    @NotEmpty
    private String capital;

    @NotNull
    private Float area;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public State convert() {
        return new State(nome, regiao, populacao, capital, area);
    }
}
