package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.dto.AcidenteCadastroDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Document(collection = "acidentes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Acidente {

    @Id
    private String id;

    @Setter
    @Field
    private List<Veiculo> veiculos;

    @Field
    private Rua rua;

    @Field
    private LocalDateTime dataHora;

    @Field
    private String gravidade;

    @Field
    private List<Ferido> feridos;

    public Acidente(AcidenteCadastroDTO dados) {
        this.veiculos = dados.veiculos().stream().map(Veiculo::new).collect(Collectors.toList());
        this.rua = new Rua(dados.rua());
        this.dataHora = dados.dataHora();
        this.gravidade = dados.gravidade();
        this.feridos = dados.feridos().stream().map(Ferido::new).collect(Collectors.toList());
    }

    public void atualizarInformacoes(AcidenteCadastroDTO dados) {
        if (dados.veiculos() != null) {
            this.veiculos = dados.veiculos().stream().map(Veiculo::new).collect(Collectors.toList());
        }
        if (dados.rua() != null) {
            this.rua = new Rua(dados.rua());
        }
        if (dados.dataHora() != null) {
            this.dataHora = dados.dataHora();
        }
        if (dados.gravidade() != null) {
            this.gravidade = dados.gravidade();
        }
        if (dados.feridos() != null) {
            this.feridos = dados.feridos().stream().map(Ferido::new).collect(Collectors.toList());
        }

    }
}
