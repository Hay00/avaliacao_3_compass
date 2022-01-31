package com.compass.avaliacao3.controller.form;

import com.compass.avaliacao3.config.validation.Region;
import com.compass.avaliacao3.model.State;
import com.compass.avaliacao3.repository.StateRepository;

import javax.validation.constraints.Min;
import java.util.Optional;

public class UpdateStateForm {

    private String nome;

    @Region
    private String regiao;

    @Min(0)
    private Long populacao;

    private String capital;

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

    public State update(Long id, StateRepository repository) {
        State state = repository.getById(id);
        Optional.ofNullable(this.nome).ifPresent(state::setName);
        Optional.ofNullable(this.regiao).ifPresent(state::setRegion);
        Optional.ofNullable(this.populacao).ifPresent(state::setPopulation);
        Optional.ofNullable(this.capital).ifPresent(state::setCapital);
        Optional.ofNullable(this.area).ifPresent(state::setArea);
        return state;
    }
}
