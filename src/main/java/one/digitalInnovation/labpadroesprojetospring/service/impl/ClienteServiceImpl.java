package one.digitalInnovation.labpadroesprojetospring.service.impl;

import one.digitalInnovation.labpadroesprojetospring.model.Cliente;
import one.digitalInnovation.labpadroesprojetospring.model.Endereco;
import one.digitalInnovation.labpadroesprojetospring.repository.ClienteRepository;
import one.digitalInnovation.labpadroesprojetospring.repository.EnderecoRepository;
import one.digitalInnovation.labpadroesprojetospring.service.ClienteService;
import one.digitalInnovation.labpadroesprojetospring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    //Singleton: Injetar os componentes do Spring com @Autowired.
    //Strategy: Implementar os métodos definidos na interface.
    //Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        //Buscar Todos os Clientes
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {

        //Buscar cliente por id
        Optional<Cliente> clienteId = clienteRepository.findById(id);
        return clienteId.get();
    }

    @Override
    public void inserir(Cliente cliente) {

        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

        //Buscar Cliente por id, caso exista:
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        //Verificar se o endereço do cliente já existe (pelo cep).
        //Caso exista, integrar com o ViaCep e persistir o retorno.
        //Alterar Cliente, vinculando o endereço (novo ou existente).
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        //Deletar cliente por id.
        clienteRepository.deleteById(id);

    }

    private void salvarClienteComCep(Cliente cliente) {
        //Verificar se o endereço do cliente já existe (pelo cep).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {

            //Caso exista, integrar com o ViaCep e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        //Inserir cliente, vinculando o endereço (novo ou existente).
        clienteRepository.save(cliente);
    }
}
