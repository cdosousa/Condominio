/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristiano
 */
@Entity
@Table(name = "gcportaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Portaria.findAll", query = "SELECT p FROM Portaria p")
    , @NamedQuery(name = "Portaria.findByCdCondominio", query = "SELECT p FROM Portaria p WHERE p.portariaPK.cdCondominio = :cdCondominio")
    , @NamedQuery(name = "Portaria.findByCdPortaria", query = "SELECT p FROM Portaria p WHERE p.portariaPK.cdPortaria = :cdPortaria")
    , @NamedQuery(name = "Portaria.findByNome", query = "SELECT p FROM Portaria p WHERE p.nome = :nome")
    , @NamedQuery(name = "Portaria.findByTipo", query = "SELECT p FROM Portaria p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Portaria.findByUsuarioCadastro", query = "SELECT p FROM Portaria p WHERE p.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "Portaria.findByDataCadastro", query = "SELECT p FROM Portaria p WHERE p.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Portaria.findByHoraCadastro", query = "SELECT p FROM Portaria p WHERE p.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Portaria.findByUsuarioModificacao", query = "SELECT p FROM Portaria p WHERE p.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "Portaria.findByDataModificacao", query = "SELECT p FROM Portaria p WHERE p.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Portaria.findByHoraModificacao", query = "SELECT p FROM Portaria p WHERE p.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Portaria.findBySituacao", query = "SELECT p FROM Portaria p WHERE p.situacao = :situacao")})
public class Portaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PortariaPK portariaPK;
    @Size(max = 60)
    @Column(name = "nome", length = 60)
    private String nome;
    @Column(name = "tipo")
    private Integer tipo;
    @Size(max = 10)
    @Column(name = "usuario_cadastro", length = 10)
    private String usuarioCadastro;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "hora_cadastro")
    @Temporal(TemporalType.TIME)
    private Date horaCadastro;
    @Size(max = 10)
    @Column(name = "usuario_modificacao", length = 10)
    private String usuarioModificacao;
    @Column(name = "data_modificacao")
    @Temporal(TemporalType.DATE)
    private Date dataModificacao;
    @Column(name = "hora_modificacao")
    @Temporal(TemporalType.TIME)
    private Date horaModificacao;
    @Column(name = "situacao")
    private Integer situacao;

    public Portaria() {
    }

    public Portaria(PortariaPK portariaPK) {
        this.portariaPK = portariaPK;
    }

    public Portaria(String cdCondominio, String cdPortaria) {
        this.portariaPK = new PortariaPK(cdCondominio, cdPortaria);
    }

    public PortariaPK getPortariaPK() {
        return portariaPK;
    }

    public void setPortariaPK(PortariaPK portariaPK) {
        this.portariaPK = portariaPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getHoraCadastro() {
        return horaCadastro;
    }

    public void setHoraCadastro(Date horaCadastro) {
        this.horaCadastro = horaCadastro;
    }

    public String getUsuarioModificacao() {
        return usuarioModificacao;
    }

    public void setUsuarioModificacao(String usuarioModificacao) {
        this.usuarioModificacao = usuarioModificacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Date getHoraModificacao() {
        return horaModificacao;
    }

    public void setHoraModificacao(Date horaModificacao) {
        this.horaModificacao = horaModificacao;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (portariaPK != null ? portariaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portaria)) {
            return false;
        }
        Portaria other = (Portaria) object;
        if ((this.portariaPK == null && other.portariaPK != null) || (this.portariaPK != null && !this.portariaPK.equals(other.portariaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Portaria[ portariaPK=" + portariaPK + " ]";
    }
    
}
