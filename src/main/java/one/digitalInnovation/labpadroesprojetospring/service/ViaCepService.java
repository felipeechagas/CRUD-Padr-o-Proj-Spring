package one.digitalInnovation.labpadroesprojetospring.service;

import one.digitalInnovation.labpadroesprojetospring.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Cliente HTTP, criado via <b>OpenFeign</b>, para consumo da API do <b>ViaCep</b>.
 *
 * @author Felipe Chagas
 * @see <a href="https://spring.io/projects/spring-cloud-openfeigh"> Spring Cloud OpenFeigh</a>
 * @see <a href="https://viacep.com.br">ViaCep</a>
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);

}
