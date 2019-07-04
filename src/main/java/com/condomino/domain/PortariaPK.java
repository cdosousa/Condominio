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
public class PortariaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cd_condominio", nullable = false, length = 8)
    private String cdCondominio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cd_portaria", nullable = false, length = 4)
    private String cdPortaria;

    public PortariaPK() {
    }

    public PortariaPK(String cdCondominio, String cdPortaria) {
        this.cdCondominio = cdCondominio;
        this.cdPortaria = cdPortaria;
    }

    public String getCdCondominio() {
        return cdCondominio;
    }

    public void setCdCondominio(String cdCondominio) {
        this.cdCondominio = cdCondominio;
    }

    public String getCdPortaria() {
        return cdPortaria;
    }

    public void setCdPortaria(String cdPortaria) {
        this.cdPortaria = cdPortaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCondominio != null ? cdCondominio.hashCode() : 0);
        hash += (cdPortaria != null ? cdPortaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PortariaPK)) {
            return false;
        }
        PortariaPK other = (PortariaPK) object;
        if ((this.cdCondominio == null && other.cdCondominio != null) || (this.cdCondominio != null && !this.cdCondominio.equals(other.cdCondominio))) {
            return false;
        }
        if ((this.cdPortaria == null && other.cdPortaria != null) || (this.cdPortaria != null && !this.cdPortaria.equals(other.cdPortaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.PortariaPK[ cdCondominio=" + cdCondominio + ", cdPortaria=" + cdPortaria + " ]";
    }
    
}
