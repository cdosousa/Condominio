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
 * @author Cristiano de Oliveira Sousa
 * @Local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data 27/06/2019
 */
@Embeddable
public class EquipamentoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cd_condominio", nullable = false, length = 10)
    private String cdCondominio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cd_praca", nullable = false, length = 4)
    private String cdPraca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cd_equipamento", nullable = false, length = 4)
    private String cdEquipamento;

    public EquipamentoPK() {
    }

    public EquipamentoPK(String cdCondominio, String cdPraca, String cdEquipamento) {
        this.cdCondominio = cdCondominio;
        this.cdPraca = cdPraca;
        this.cdEquipamento = cdEquipamento;
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

    public String getCdEquipamento() {
        return cdEquipamento;
    }

    public void setCdEquipamento(String cdEquipamento) {
        this.cdEquipamento = cdEquipamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCondominio != null ? cdCondominio.hashCode() : 0);
        hash += (cdPraca != null ? cdPraca.hashCode() : 0);
        hash += (cdEquipamento != null ? cdEquipamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipamentoPK)) {
            return false;
        }
        EquipamentoPK other = (EquipamentoPK) object;
        if ((this.cdCondominio == null && other.cdCondominio != null) || (this.cdCondominio != null && !this.cdCondominio.equals(other.cdCondominio))) {
            return false;
        }
        if ((this.cdPraca == null && other.cdPraca != null) || (this.cdPraca != null && !this.cdPraca.equals(other.cdPraca))) {
            return false;
        }
        if ((this.cdEquipamento == null && other.cdEquipamento != null) || (this.cdEquipamento != null && !this.cdEquipamento.equals(other.cdEquipamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.GcequipamentoPK[ cdCondominio=" + cdCondominio + ", cdPraca=" + cdPraca + ", cdEquipamento=" + cdEquipamento + " ]";
    }
    
}
