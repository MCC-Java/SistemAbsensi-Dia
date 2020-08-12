/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.absensi.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yosef
 */
@Entity
@Table(name = "divisi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divisi.findAll", query = "SELECT d FROM Divisi d")
    , @NamedQuery(name = "Divisi.findById", query = "SELECT d FROM Divisi d WHERE d.id = :id")
    , @NamedQuery(name = "Divisi.findByNama", query = "SELECT d FROM Divisi d WHERE d.nama = :nama")})
public class Divisi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisi", fetch = FetchType.LAZY)
    private List<Karyawan> karyawanList;

    public Divisi() {
    }

    public Divisi(String id) {
        this.id = id;
    }

    public Divisi(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @XmlTransient
    public List<Karyawan> getKaryawanList() {
        return karyawanList;
    }

    public void setKaryawanList(List<Karyawan> karyawanList) {
        this.karyawanList = karyawanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisi)) {
            return false;
        }
        Divisi other = (Divisi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcc.absensi.entities.Divisi[ id=" + id + " ]";
    }
    
}
