/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bd.crud.crud.repositorio;

import com.bd.crud.crud.modelo.modelotripulante;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cjsal
 */
@Repository
public interface repositoriotripulante extends MongoRepository<modelotripulante, String> {

    public List<modelotripulante> findAll();

}
