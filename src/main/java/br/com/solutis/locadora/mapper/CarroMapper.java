package br.com.solutis.locadora.mapper;

import br.com.solutis.locadora.model.dto.CarroDto;
import br.com.solutis.locadora.model.dto.CarroMinDto;
import br.com.solutis.locadora.model.entity.CarroEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CarroMapper {

    public static List<CarroDto> convertToCarroDtos(List<CarroEntity> carros) {

        return carros.stream().map(CarroDto::new).toList();
    }

    public static CarroDto convertToCarroDto(CarroEntity carro) {
        return new CarroDto(carro);
    }

    public static List<CarroMinDto> convertToCarroMinDtos(List<CarroEntity> carros) {

        return carros.stream().map(CarroMinDto::new).toList();
    }

    public static CarroMinDto convertToCarroMinDto(CarroEntity carro) {
        return new CarroMinDto(carro);
    }
}
