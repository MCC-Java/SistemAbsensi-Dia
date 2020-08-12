/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.absensi.controllers;

import com.mcc.absensi.services.DivisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author yosef
 */
@Controller
public class DivisiController {
    @Autowired
    DivisiService divisiService;
}
