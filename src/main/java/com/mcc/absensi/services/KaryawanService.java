/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.absensi.services;

import com.mcc.absensi.repositories.KaryawanRepository;
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
}
