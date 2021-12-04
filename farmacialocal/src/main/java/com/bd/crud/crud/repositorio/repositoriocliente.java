/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bd.crud.crud.repositorio;

import com.bd.crud.crud.modelo.modelocliente;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cjsal
 */
@Repository
public interface repositoriocliente extends MongoRepository<modelocliente, String> {


}
