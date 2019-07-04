/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.domain;

import com.parametros.modelo.enums.SituacaoCadastral;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristiano
 */
@Entity
@Table(name = "pgsmenus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menus.findAll", query = "SELECT p FROM Menus p")
    , @NamedQuery(name = "Menus.findByCdMenu", query = "SELECT p FROM Menus p WHERE p.cdMenu = :cdMenu")
    , @NamedQuery(name = "Menus.findByDataCadastro", query = "SELECT p FROM Menus p WHERE p.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Menus.findByDataModificacao", query = "SELECT p FROM Menus p WHERE p.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Menus.findByHoraCadastro", query = "SELECT p FROM Menus p WHERE p.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Menus.findByHoraModificacao", query = "SELECT p FROM Menus p WHERE p.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Menus.findByNomeMenu", query = "SELECT p FROM Menus p WHERE p.nomeMenu = :nomeMenu")
    , @NamedQuery(name = "Menus.findBySituacao", query = "SELECT p FROM Menus p WHERE p.situacao = :situacao")
    , @NamedQuery(name = "Menus.findByUsarioCadastro", query = "SELECT p FROM Menus p WHERE p.usarioCadastro = :usarioCadastro")
    , @NamedQuery(name = "Menus.findByUsarioModificacao", query = "SELECT p FROM Menus p WHERE p.usarioModificacao = :usarioModificacao")})
public class Menus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cd_menu", nullable = false, length = 6)
    private String cdMenu;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column(name = "data_modificacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataModificacao;
    @Column(name = "hora_cadastro")
    @Temporal(TemporalType.TIME)
    private Date horaCadastro;
    @Column(name = "hora_modificacao")
    @Temporal(TemporalType.TIME)
    private Date horaModificacao;
    @Size(max = 50)
    @Column(name = "nome_menu", length = 50)
    private String nomeMenu;
    @Column(name = "situacao")
    private Integer situacao;
    @Size(max = 10)
    @Column(name = "usario_cadastro", length = 10)
    private String usarioCadastro;
    @Size(max = 10)
    @Column(name = "usario_modificacao", length = 10)
    private String usarioModificacao;

    public Menus() {
    }

    public Menus(String cdMenu) {
        this.cdMenu = cdMenu;
    }

    public String getCdMenu() {
        return cdMenu;
    }

    public void setCdMenu(String cdMenu) {
        this.cdMenu = cdMenu;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Date getHoraCadastro() {
        return horaCadastro;
    }

    public void setHoraCadastro(Date horaCadastro) {
        this.horaCadastro = horaCadastro;
    }

    public Date getHoraModificacao() {
        return horaModificacao;
    }

    public void setHoraModificacao(Date horaModificacao) {
        this.horaModificacao = horaModificacao;
    }

    public String getNomeMenu() {
        return nomeMenu;
    }

    public void setNomeMenu(String nomeMenu) {
        this.nomeMenu = nomeMenu;
    }

    public SituacaoCadastral getSituacao() {
        return SituacaoCadastral.toEnum(situacao);
    }

    public void setSituacao(SituacaoCadastral situacao) {
        this.situacao = situacao.getCod();
    }

    public String getUsarioCadastro() {
        return usarioCadastro;
    }

    public void setUsarioCadastro(String usarioCadastro) {
        this.usarioCadastro = usarioCadastro;
    }

    public String getUsarioModificacao() {
        return usarioModificacao;
    }

    public void setUsarioModificacao(String usarioModificacao) {
        this.usarioModificacao = usarioModificacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdMenu != null ? cdMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menus)) {
            return false;
        }
        Menus other = (Menus) object;
        if ((this.cdMenu == null && other.cdMenu != null) || (this.cdMenu != null && !this.cdMenu.equals(other.cdMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Pgsmenus[ cdMenu=" + cdMenu + " ]";
    }
    
}
