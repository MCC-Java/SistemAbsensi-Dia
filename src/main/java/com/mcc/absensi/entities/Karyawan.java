/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.absensi.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yosef
 */
@Entity
@Table(name = "karyawan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karyawan.findAll", query = "SELECT k FROM Karyawan k")
    , @NamedQuery(name = "Karyawan.findByNik", query = "SELECT k FROM Karyawan k WHERE k.nik = :nik")
    , @NamedQuery(name = "Karyawan.findByNama", query = "SELECT k FROM Karyawan k WHERE k.nama = :nama")
    , @NamedQuery(name = "Karyawan.findByAlamat", query = "SELECT k FROM Karyawan k WHERE k.alamat = :alamat")
    , @NamedQuery(name = "Karyawan.findByTelp", query = "SELECT k FROM Karyawan k WHERE k.telp = :telp")
    , @NamedQuery(name = "Karyawan.findByEmail", query = "SELECT k FROM Karyawan k WHERE k.email = :email")
    , @NamedQuery(name = "Karyawan.findByPassword", query = "SELECT k FROM Karyawan k WHERE k.password = :password")
    , @NamedQuery(name = "Karyawan.findByLevel", query = "SELECT k FROM Karyawan k WHERE k.level = :level")})
public class Karyawan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nik")
    private String nik;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @Column(name = "telp")
    private int telp;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "level")
    private String level;
    @JoinColumn(name = "divisi", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Divisi divisi;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "karyawan", fetch = FetchType.LAZY)
    private Absen absen;

    public Karyawan() {
    }

    public Karyawan(String nik) {
        this.nik = nik;
    }

    public Karyawan(String nik, String nama, String alamat, int telp, String email, String password, String level) {
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
        this.email = email;
        this.password = password;
        this.level = level;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getTelp() {
        return telp;
    }

    public void setTelp(int telp) {
        this.telp = telp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Divisi getDivisi() {
        return divisi;
    }

    public void setDivisi(Divisi divisi) {
        this.divisi = divisi;
    }

    public Absen getAbsen() {
        return absen;
    }

    public void setAbsen(Absen absen) {
        this.absen = absen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nik != null ? nik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.nik == null && other.nik != null) || (this.nik != null && !this.nik.equals(other.nik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcc.absensi.entities.Karyawan[ nik=" + nik + " ]";
    }
    
}
