/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.absensi.services;

import com.mcc.absensi.entities.Karyawan;
import com.mcc.absensi.repositories.KaryawanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yosef
 */
@Service
public class KaryawanService {
    @Autowired
    KaryawanRepository karyawanRepository;
    
    public List<Karyawan> getAll(){
        return karyawanRepository.findAll();
    }
    
    public String checkpass(String nik){
       return karyawanRepository.findById(nik).get().getPassword();
    }
    
    public boolean checknik(String nik){
        return karyawanRepository.existsById(nik);
    }
    
    public String checkname(String nik){
        return karyawanRepository.findById(nik).get().getNama();
    }
    
    public Karyawan getbynik(String nik){
        return karyawanRepository.findById(nik).get();
    }
    
    public String checklevel (String nik){
        return karyawanRepository.findById(nik).get().getLevel();
    }
}
