package br.com.fiap.gerenciamentotrafego.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tbl_estrada")
public class Estrada {

//    id_estrada NUMBER PRIMARY KEY,
//    vel_max NUMBER,
//    hora DATE,
//    nome_estrada VARCHAR2(50)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Estrada")
    private Long idEstrada;

    @Column(name = "vel_max",  nullable = false)
    private Integer velocidadeMax;

    @Column(name = "hora", nullable = false)
    private Date hora;

    @Column(name = "nome_estrada", length = 50, nullable = false)
    private String nomeEstrada;

}
