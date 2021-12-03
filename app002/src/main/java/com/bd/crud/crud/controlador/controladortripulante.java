/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bd.crud.crud.controlador;

import com.bd.crud.crud.modelo.modelotripulante;
import com.bd.crud.crud.repositorio.repositoriotripulante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cjsal
 */

@RestController
@RequestMapping("api/tripulante")

public class controladortripulante {
    @Autowired
    public repositoriotripulante Repository;
    
    @GetMapping("/consulta")
    
    public List<modelotripulante>consulta(){
        return Repository.findAll();
    }    
}
