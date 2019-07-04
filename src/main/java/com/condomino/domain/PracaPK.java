/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.domain;

import java.io.Serializable;
import javax.inject.Named;
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
@Named
public class PracaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cd_condominio", nullable = false, length = 8)
    private String cdCondominio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cd_praca", nullable = false, length = 4)
    private String cdPraca;

    public PracaPK() {
    }

    public PracaPK(String cdCondominio, String cdPraca) {
        this.cdCondominio = cdCondominio;
        this.cdPraca = cdPraca;
    }

    public String getCdCondominio() {
        return cdCondominio;
    }

    public void setCdCondominio(String cdCondominio) {
        this.cdCondominio = cdCondominio;
    }

    public String getCdPraca() {
        return cdPraca;
    }

    public void setCdPraca(String cdPraca) {
        this.cdPraca = cdPraca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCondominio != null ? cdCondominio.hashCode() : 0);
        hash += (cdPraca != null ? cdPraca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PracaPK)) {
            return false;
        }
        PracaPK other = (PracaPK) object;
        if ((this.cdCondominio == null && other.cdCondominio != null) || (this.cdCondominio != null && !this.cdCondominio.equals(other.cdCondominio))) {
            return false;
        }
        if ((this.cdPraca == null && other.cdPraca != null) || (this.cdPraca != null && !this.cdPraca.equals(other.cdPraca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.PracaPK[ cdCondominio=" + cdCondominio + ", cdPraca=" + cdPraca + " ]";
    }
    
}
