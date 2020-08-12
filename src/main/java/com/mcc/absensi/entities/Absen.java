/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.absensi.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yosef
 */
@Entity
@Table(name = "absen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Absen.findAll", query = "SELECT a FROM Absen a")
    , @NamedQuery(name = "Absen.findByNik", query = "SELECT a FROM Absen a WHERE a.nik = :nik")
    , @NamedQuery(name = "Absen.findByMasuk", query = "SELECT a FROM Absen a WHERE a.masuk = :masuk")
    , @NamedQuery(name = "Absen.findByKeluar", query = "SELECT a FROM Absen a WHERE a.keluar = :keluar")
    , @NamedQuery(name = "Absen.findByTanggal", query = "SELECT a FROM Absen a WHERE a.tanggal = :tanggal")
    , @NamedQuery(name = "Absen.findByStatus", query = "SELECT a FROM Absen a WHERE a.status = :status")})
public class Absen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nik")
    private String nik;
    @Basic(optional = false)
    @Column(name = "masuk")
    @Temporal(TemporalType.TIME)
    private Date masuk;
    @Basic(optional = false)
    @Column(name = "keluar")
    @Temporal(TemporalType.TIME)
    private Date keluar;
    @Basic(optional = false)
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "nik", referencedColumnName = "nik", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Karyawan karyawan;

    public Absen() {
    }

    public Absen(String nik) {
        this.nik = nik;
    }

    public Absen(String nik, Date masuk, Date keluar, Date tanggal, String status) {
        this.nik = nik;
        this.masuk = masuk;
        this.keluar = keluar;
        this.tanggal = tanggal;
        this.status = status;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public Date getMasuk() {
        return masuk;
    }

    public void setMasuk(Date masuk) {
        this.masuk = masuk;
    }

    public Date getKeluar() {
        return keluar;
    }

    public void setKeluar(Date keluar) {
        this.keluar = keluar;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
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
        if (!(object instanceof Absen)) {
            return false;
        }
        Absen other = (Absen) object;
        if ((this.nik == null && other.nik != null) || (this.nik != null && !this.nik.equals(other.nik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcc.absensi.entities.Absen[ nik=" + nik + " ]";
    }
    
}
