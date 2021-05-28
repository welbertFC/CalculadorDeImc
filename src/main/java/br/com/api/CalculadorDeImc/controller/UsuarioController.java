package br.com.api.CalculadorDeImc.controller;

import br.com.api.CalculadorDeImc.model.Usuario;
import br.com.api.CalculadorDeImc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> inserir (@RequestBody Usuario cliente){
        Usuario novoCliente = usuarioService.inserir(cliente);
        return ResponseEntity.ok().body(novoCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        Usuario cliente = usuarioService.findByid(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> clientes = usuarioService.findAll();
        return ResponseEntity.ok().body(clientes);
    }
}
