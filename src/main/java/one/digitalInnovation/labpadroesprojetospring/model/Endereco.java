package one.digitalInnovation.labpadroesprojetospring.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * OS atributos foram gerados automaticamente pelo site jsonschema2pojo.org
 * Para isso usamos o JSON de retorno da Api do ViaCep
 *
 * @see <a href="https://www.jsonschema2pojo.org">jsonschema2pojo.org</a>
 * @see <a href="https://www.viacep.com.br">ViaCep</a>
 */

@Setter
@Getter
@Entity
@RequiredArgsConstructor
public class Endereco {

    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
