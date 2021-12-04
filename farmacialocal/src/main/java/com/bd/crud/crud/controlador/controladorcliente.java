/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bd.crud.crud.controlador;

import com.bd.crud.crud.modelo.modelocliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bd.crud.crud.repositorio.repositoriocliente;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author cjsal
 */

@RestController
@RequestMapping("api/cliente")

public class controladorcliente {
    @Autowired
    private repositoriocliente Repository;
    @Autowired private MongoTemplate c;
    
    @GetMapping("/consulta")
    
    public List<modelocliente>consulta(){
        return Repository.findAll();
    }  
    
    @PostMapping("/registro")
    public modelocliente registro (@RequestBody @Validated modelocliente V){
        return Repository.insert(V);
    }
    
    
    @PutMapping("/editar/(id)")
    public modelocliente editar(@PathVariable(value="id")String id, @RequestBody @Validated modelocliente V){
       return Repository.save(V);
    }
           
    @GetMapping("/consultaind/{id}")
    public Optional<modelocliente> consultaind(@PathVariable (value="id") String id){
    return Repository.findById(id);
    }
    
    @GetMapping("/reportexdocumento/{Ciudad}")
    public List<modelocliente> reportexdocumento(@PathVariable(value="Ciudad") String Ciudad){
    Query q =new Query();
    q.addCriteria(Criteria.where("Ciudad").is(Ciudad));
    return c.find(q,modelocliente.class);
    }
    
    @GetMapping("/reportexdocumentotros/{Ciudad}/{Nombre}")
    public List<modelocliente> reportexdocumentotros(@PathVariable(value="Ciudad") String ciudad, @PathVariable(value="Nombre") String nombre){
    Query q =new Query();
    q.addCriteria(Criteria.where("Ciudad").is(ciudad).and("Nombre").is(nombre));
    return c.find(q,modelocliente.class);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable (value="id") String id){
    Repository.deleteById(id);
    }   
    
}
