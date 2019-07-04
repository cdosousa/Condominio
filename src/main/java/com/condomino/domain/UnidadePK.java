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
public class UnidadePK implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cd_torre", nullable = false, length = 20)
    private String cdTorre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cd_unidade", nullable = false, length = 4)
    private String cdUnidade;

    public UnidadePK() {
    }

    public UnidadePK(String cdCondominio, String cdPraca, String cdTorre, String cdUnidade) {
        this.cdCondominio = cdCondominio;
        this.cdPraca = cdPraca;
        this.cdTorre = cdTorre;
        this.cdUnidade = cdUnidade;
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

    public String getCdTorre() {
        return cdTorre;
    }

    public void setCdTorre(String cdTorre) {
        this.cdTorre = cdTorre;
    }

    public String getCdUnidade() {
        return cdUnidade;
    }

    public void setCdUnidade(String cdUnidade) {
        this.cdUnidade = cdUnidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCondominio != null ? cdCondominio.hashCode() : 0);
        hash += (cdPraca != null ? cdPraca.hashCode() : 0);
        hash += (cdTorre != null ? cdTorre.hashCode() : 0);
        hash += (cdUnidade != null ? cdUnidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadePK)) {
            return false;
        }
        UnidadePK other = (UnidadePK) object;
        if ((this.cdCondominio == null && other.cdCondominio != null) || (this.cdCondominio != null && !this.cdCondominio.equals(other.cdCondominio))) {
            return false;
        }
        if ((this.cdPraca == null && other.cdPraca != null) || (this.cdPraca != null && !this.cdPraca.equals(other.cdPraca))) {
            return false;
        }
        if ((this.cdTorre == null && other.cdTorre != null) || (this.cdTorre != null && !this.cdTorre.equals(other.cdTorre))) {
            return false;
        }
        if ((this.cdUnidade == null && other.cdUnidade != null) || (this.cdUnidade != null && !this.cdUnidade.equals(other.cdUnidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.UnidadePK[ cdCondominio=" + cdCondominio + ", cdPraca=" + cdPraca + ", cdTorre=" + cdTorre + ", cdUnidade=" + cdUnidade + " ]";
    }
    
}
