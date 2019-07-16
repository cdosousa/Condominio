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
public class CondominoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cd_condominio", nullable = false, length = 8)
    private String cdCondominio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cd_condomino", nullable = false, length = 6)
    private String cdCondomino;

    public CondominoPK() {
    }

    public CondominoPK(String cdCondominio, String cdCondomino) {
        this.cdCondominio = cdCondominio;
        this.cdCondomino = cdCondomino;
    }

    public String getCdCondominio() {
        return cdCondominio;
    }

    public void setCdCondominio(String cdCondominio) {
        this.cdCondominio = cdCondominio;
    }

    public String getCdCondomino() {
        return cdCondomino;
    }

    public void setCdCondomino(String cdCondomino) {
        this.cdCondomino = cdCondomino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCondominio != null ? cdCondominio.hashCode() : 0);
        hash += (cdCondomino != null ? cdCondomino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondominoPK)) {
            return false;
        }
        CondominoPK other = (CondominoPK) object;
        if ((this.cdCondominio == null && other.cdCondominio != null) || (this.cdCondominio != null && !this.cdCondominio.equals(other.cdCondominio))) {
            return false;
        }
        if ((this.cdCondomino == null && other.cdCondomino != null) || (this.cdCondomino != null && !this.cdCondomino.equals(other.cdCondomino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.CondominoPK[ cdCondominio=" + cdCondominio + ", cdCondomino=" + cdCondomino + " ]";
    }
    
}
