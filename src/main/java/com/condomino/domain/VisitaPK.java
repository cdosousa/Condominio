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
public class VisitaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cd_condominio", nullable = false, length = 8)
    private String cdCondominio;
    @Basic(optional = false)
    @Column(name = "cd_visita", nullable = false)
    private int cdVisita;

    public VisitaPK() {
    }

    public VisitaPK(String cdCondominio, int cdVisita) {
        this.cdCondominio = cdCondominio;
        this.cdVisita = cdVisita;
    }

    public String getCdCondominio() {
        return cdCondominio;
    }

    public void setCdCondominio(String cdCondominio) {
        this.cdCondominio = cdCondominio;
    }

    public int getCdVisita() {
        return cdVisita;
    }

    public void setCdVisita(int cdVisita) {
        this.cdVisita = cdVisita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCondominio != null ? cdCondominio.hashCode() : 0);
        hash += (int) cdVisita;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitaPK)) {
            return false;
        }
        VisitaPK other = (VisitaPK) object;
        if ((this.cdCondominio == null && other.cdCondominio != null) || (this.cdCondominio != null && !this.cdCondominio.equals(other.cdCondominio))) {
            return false;
        }
        if (this.cdVisita != other.cdVisita) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.VisitaPK[ cdCondominio=" + cdCondominio + ", cdVisita=" + cdVisita + " ]";
    }
    
}
