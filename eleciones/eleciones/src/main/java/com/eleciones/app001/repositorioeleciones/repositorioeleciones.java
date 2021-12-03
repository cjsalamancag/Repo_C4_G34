/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eleciones.app001.repositorioeleciones;

import com.eleciones.app001.modeloeleciones.modeloplanilla;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SENA
 */
@Repository
public interface repositorioeleciones extends MongoRepository<modeloplanilla, String>{
    
    
    
}
