/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cristiano
 */
@Embeddable
public class MoradorPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cd_condominio", nullable = false, length = 8)
    private String cdCondominio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cd_morador", nullable = false, length = 6)
    private String cdMorador;

    public MoradorPK() {
    }

    public MoradorPK(String cdCondominio, String cdMorador) {
        this.cdCondominio = cdCondominio;
        this.cdMorador = cdMorador;
    }

    public String getCdCondominio() {
        return cdCondominio;
    }

    public void setCdCondominio(String cdCondominio) {
        this.cdCondominio = cdCondominio;
    }

    public String getCdMorador() {
        return cdMorador;
    }

    public void setCdMorador(String cdMorador) {
        this.cdMorador = cdMorador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCondominio != null ? cdCondominio.hashCode() : 0);
        hash += (cdMorador != null ? cdMorador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoradorPK)) {
            return false;
        }
        MoradorPK other = (MoradorPK) object;
        if ((this.cdCondominio == null && other.cdCondominio != null) || (this.cdCondominio != null && !this.cdCondominio.equals(other.cdCondominio))) {
            return false;
        }
        if ((this.cdMorador == null && other.cdMorador != null) || (this.cdMorador != null && !this.cdMorador.equals(other.cdMorador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.MoradorPK[ cdCondominio=" + cdCondominio + ", cdMorador=" + cdMorador + " ]";
    }
    
}
