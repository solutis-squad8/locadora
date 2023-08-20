package br.com.solutis.locadora.mapper;

import br.com.solutis.locadora.model.dto.CarroDto;
import br.com.solutis.locadora.model.entity.ApoliceSeguroEntity;
import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.model.form.ApoliceInsertForm;

public class ApoliceSeguroMapper {

    public static ApoliceSeguroEntity convertToCarroEntity(ApoliceInsertForm apolice) {
        return new ApoliceSeguroEntity(apolice);
    }
}
