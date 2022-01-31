package com.compass.avaliacao3.controller.dto;

import com.compass.avaliacao3.model.State;
import org.springframework.data.domain.Page;

public class StateDto {

    private Long id;
    private String nome;
    private String regiao;
    private Long populacao;
    private String capital;
    private Float area;


    public StateDto(State state) {
        this.id = state.getId();
        this.nome = state.getName();
        this.regiao = state.getRegion();
        this.populacao = state.getPopulation();
        this.capital = state.getCapital();
        this.area = state.getArea();
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public String getCapital() {
        return capital;
    }

    public Float getArea() {
        return area;
    }

    public static Page<StateDto> convert(Page<State> states) {
        return states.map(StateDto::new);
    }
}
