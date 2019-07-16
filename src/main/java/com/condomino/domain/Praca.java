/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristiano
 */
@Entity
@Table(name = "gcpraca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Praca.findAll", query = "SELECT p FROM Praca p")
    , @NamedQuery(name = "Praca.findByCdCondominio", query = "SELECT p FROM Praca p WHERE p.pracaPK.cdCondominio = :cdCondominio")
    , @NamedQuery(name = "Praca.findByCdPraca", query = "SELECT p FROM Praca p WHERE p.pracaPK.cdPraca = :cdPraca")
    , @NamedQuery(name = "Praca.findByNome", query = "SELECT p FROM Praca p WHERE p.nome = :nome")
    , @NamedQuery(name = "Praca.findByUsuarioCadastro", query = "SELECT p FROM Praca p WHERE p.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "Praca.findByDataCadastro", query = "SELECT p FROM Praca p WHERE p.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Praca.findByHoraCadastro", query = "SELECT p FROM Praca p WHERE p.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Praca.findByUsuarioModificacao", query = "SELECT p FROM Praca p WHERE p.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "Praca.findByDataModificacao", query = "SELECT p FROM Praca p WHERE p.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Praca.findByHoraModificacao", query = "SELECT p FROM Praca p WHERE p.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Praca.findBySituacao", query = "SELECT p FROM Praca p WHERE p.situacao = :situacao")})
@Named
public class Praca implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "praca")
    private List<Unidade> unidadeList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "praca")
    private List<Torre> torreList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "praca")
    private List<Equipamento> equipamentoList;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PracaPK pracaPK;
    @Size(max = 60)
    @Column(name = "nome", length = 60)
    private String nome;
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
    
    @JoinColumn(name = "cd_condominio", referencedColumnName = "cd_condominio", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Condominio condominio;

    public Praca() {
    }

    public Praca(PracaPK pracaPK) {
        this.pracaPK = pracaPK;
    }

    public Praca(String cdCondominio, String cdPraca) {
        this.pracaPK = new PracaPK(cdCondominio, cdPraca);
    }

    public PracaPK getPracaPK() {
        return pracaPK;
    }

    public void setPracaPK(PracaPK pracaPK) {
        this.pracaPK = pracaPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    /**
     * @return the condominio
     */
    public Condominio getCondominio() {
        return condominio;
    }

    /**
     * @param condominio the condominio to set
     */
    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pracaPK != null ? pracaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Praca)) {
            return false;
        }
        Praca other = (Praca) object;
        if ((this.pracaPK == null && other.pracaPK != null) || (this.pracaPK != null && !this.pracaPK.equals(other.pracaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Praca[ pracaPK=" + pracaPK + " ]";
    }

    @XmlTransient
    public List<Equipamento> getEquipamentoList() {
        return equipamentoList;
    }

    public void setEquipamentoList(List<Equipamento> equipamentoList) {
        this.equipamentoList = equipamentoList;
    }

    @XmlTransient
    public List<Torre> getTorreList() {
        return torreList;
    }

    public void setTorreList(List<Torre> torreList) {
        this.torreList = torreList;
    }

    @XmlTransient
    public List<Unidade> getUnidadeList() {
        return unidadeList;
    }

    public void setUnidadeList(List<Unidade> unidadeList) {
        this.unidadeList = unidadeList;
    }
}
