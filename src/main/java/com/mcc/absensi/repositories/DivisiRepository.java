/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.absensi.repositories;

import com.mcc.absensi.entities.Divisi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yosef
 */
@Repository
public interface DivisiRepository extends JpaRepository<Divisi, String> {
    
}
