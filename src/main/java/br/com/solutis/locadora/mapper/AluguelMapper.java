package br.com.solutis.locadora.mapper;

import br.com.solutis.locadora.model.dto.AluguelDto;
import br.com.solutis.locadora.model.entity.AluguelEntity;

import java.util.List;

public class AluguelMapper {
    public static List<AluguelDto> convertEntitiesToDto(List<AluguelEntity> entities) {
        return entities.stream().map(AluguelDto::new).toList();
    }
}
