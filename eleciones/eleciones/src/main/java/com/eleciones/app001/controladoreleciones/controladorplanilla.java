/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eleciones.app001.controladoreleciones;

import com.eleciones.app001.modeloeleciones.modeloplanilla;
import com.eleciones.app001.repositorioeleciones.repositorioeleciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SENA
 */
@RestController
@RequestMapping("/api/planilla")
public class controladorplanilla {
    @Autowired
    private repositorioeleciones Repository;
    @Autowired private MongoTemplate c;
    
    @GetMapping("/consulta")
    public List<modeloplanilla> consulta(){
        return Repository.findAll();
    }
    
    @PostMapping("/registro")
    public modeloplanilla registro(@RequestBody @Validated modeloplanilla V){
     return Repository.insert(V);
    }
    
    @PutMapping("/editar/{id}")
    public modeloplanilla editar(@PathVariable(value="id") String id, @RequestBody @Validated modeloplanilla V){
    
        return Repository.save(V);
    }
    
    @GetMapping("/consultaind/{id}")
    public Optional<modeloplanilla> consultaind(@PathVariable (value="id") String id){
    return Repository.findById(id);
    }
    
    @GetMapping("/reportexdocumento/{comuna}")
    public List<modeloplanilla> reportexdocumento(@PathVariable(value="comuna") String comuna){
    Query q =new Query();
    q.addCriteria(Criteria.where("comuna").is(comuna));
    return c.find(q,modeloplanilla.class);
    }
    
    @GetMapping("/reportexdocumentotros/{comuna}/{puesto}")
    public List<modeloplanilla> reportexdocumentotros(@PathVariable(value="comuna") String comuna, @PathVariable(value="puesto") String puesto){
    Query q =new Query();
    q.addCriteria(Criteria.where("comuna").is(comuna).and("puesto").is(puesto));
    return c.find(q,modeloplanilla.class);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable (value="id") String id){
    Repository.deleteById(id);
    
    
    }
}
