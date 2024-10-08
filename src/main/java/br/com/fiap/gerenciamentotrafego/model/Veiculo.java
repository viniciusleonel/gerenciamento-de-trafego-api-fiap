package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.dto.VeiculoCadastroDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.stream.Collectors;

@Document(collection = "veiculos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Veiculo {

    @Id
    private String id;

    @Setter
    @Field
    private String acidenteId;

    @Field
    private String placa;

    @Field
    private String modelo;

    @Field
    private Integer ano;

    @Field
    private String cor;


    public Veiculo(VeiculoCadastroDTO dados) {
        this.id = dados.id();
        this.placa = dados.placa();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
        this.cor = dados.cor();
    }

}

