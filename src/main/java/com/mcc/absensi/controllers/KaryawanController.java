/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.absensi.controllers;

import com.mcc.absensi.entities.Absen;
import com.mcc.absensi.entities.Karyawan;
import com.mcc.absensi.services.AbsenService;
import com.mcc.absensi.services.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author yosef
 */
@Controller
public class KaryawanController {

    @Autowired
    KaryawanService karyawanService;
    
    @Autowired
    AbsenService absenService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("karyawan", new Karyawan());
        return "login";
    }

    @RequestMapping("/check")
    public String checkLogin(@ModelAttribute(name = "karyawan") Karyawan karyawan, Model model) {

        String nik = karyawan.getNik();
        String password = karyawan.getPassword();

        if (karyawanService.checknik(nik)) {
            if (password.equalsIgnoreCase(karyawanService.checkpass(nik))) {
                if (karyawanService.checklevel(nik) == "admin") {
                    model.addAttribute("name", karyawanService.checkname(nik));
                    return "redirect:/adminpage";
                } else {
                    model.addAttribute("name", karyawanService.checkname(nik));
                    return "redirect:/dashboard";
                }

            } else {
                model.addAttribute("loginError", true);
                return "login";
            }
        } else {
            model.addAttribute("loginError", true);
            return "login";
        }
    }
    
    @GetMapping("/adminpage")
    public String karyawan(Model model) {
        model.addAttribute("karyawan", new Karyawan());
        model.addAttribute("karyawans", karyawanService.getAll());
        return "adminpage";
    }
    
     @GetMapping("/dashboard")
    public String absen(Model model) {
        model.addAttribute("absen", new Absen());
        model.addAttribute("absens", absenService.getAll());
        return "dashboard";
    }
}
