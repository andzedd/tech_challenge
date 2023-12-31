package br.com.fiap.postech.soat.techchallenger1.application.Impl;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.application.ClienteService;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CpfNaoEncontradoException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cliente;
import br.com.fiap.postech.soat.techchallenger1.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public void criarUsuario(ClienteDto cliente) throws CadastroClienteException {
        try {
            clienteRepository.cadastrarCliente(new Cliente(cliente));
        } catch (DataIntegrityViolationException e) {
            throw new CadastroClienteException("Cliente ja Cadastrado");
        }
    }

    @Override
    public ClienteDto findByCpf(String cpf) throws CpfNaoEncontradoException {
       Optional<Cliente> cliente =  clienteRepository.findByCpf(cpf);
       if (!cliente.isPresent())
           throw new CpfNaoEncontradoException("Cpf Não encontrado");
         return new ClienteDto(cliente.get());
    }
}
