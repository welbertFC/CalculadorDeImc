package br.com.api.CalculadorDeImc.service;

import br.com.api.CalculadorDeImc.model.Usuario;
import br.com.api.CalculadorDeImc.repository.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario inserir(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario findByid(Integer id){
        Optional<Usuario> cliente = usuarioRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException(id, "Usuario não encontrado"));
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

}
