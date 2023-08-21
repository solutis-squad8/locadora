package br.com.solutis.locadora.model.dto;

import br.com.solutis.locadora.model.entity.ApoliceSeguroEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ApoliceSeguroDto {
    private BigDecimal valorFranquia;

    private Boolean protecaoTerceiro;

    private Boolean protecaoCausasNaturais;

    private Boolean protecaoRoubo;

    public ApoliceSeguroDto(ApoliceSeguroEntity entity){
        valorFranquia = entity.getValorFranquia();
        protecaoRoubo = entity.getProtecaoRoubo();
        protecaoTerceiro = entity.getProtecaoTerceiro();
        protecaoCausasNaturais = entity.getProtecaoCausasNaturais();
    }
}
