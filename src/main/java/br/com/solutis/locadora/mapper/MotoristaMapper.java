package br.com.solutis.locadora.mapper;

import br.com.solutis.locadora.model.dto.CarroDto;
import br.com.solutis.locadora.model.dto.CarroMinDto;
import br.com.solutis.locadora.model.dto.MotoristaDto;
import br.com.solutis.locadora.model.entity.CarroEntity;
import br.com.solutis.locadora.model.entity.MotoristaEntity;

import java.util.List;

public class MotoristaMapper {

    public static List<MotoristaDto> convertToMotoristaDtos(List<MotoristaEntity> motoristas) {

        return motoristas.stream().map(MotoristaDto::new).toList();
    }

    public static MotoristaDto convertToMotoristaDto(MotoristaEntity motorista) {
        return new MotoristaDto(motorista);
    }
}
