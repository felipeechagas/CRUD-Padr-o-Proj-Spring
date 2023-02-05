package one.digitalInnovation.labpadroesprojetospring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeCompleto;
    private String cargo;
    private Double salario;

    @ManyToOne
    private Endereco endereco;
}
