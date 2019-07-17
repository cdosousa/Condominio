/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "gctorre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Torre.findAll", query = "SELECT t FROM Torre t")
    , @NamedQuery(name = "Torre.findByCdCondominio", query = "SELECT t FROM Torre t WHERE t.torrePK.cdCondominio = :cdCondominio")
    , @NamedQuery(name = "Torre.findByCdTorre", query = "SELECT t FROM Torre t WHERE t.torrePK.cdTorre = :cdTorre")
    , @NamedQuery(name = "Torre.findByNome", query = "SELECT t FROM Torre t WHERE t.nome = :nome")
    , @NamedQuery(name = "Torre.findByUsuarioCadastro", query = "SELECT t FROM Torre t WHERE t.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "Torre.findByDataCadastro", query = "SELECT t FROM Torre t WHERE t.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Torre.findByHoraCadastro", query = "SELECT t FROM Torre t WHERE t.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Torre.findByUsuarioModificacao", query = "SELECT t FROM Torre t WHERE t.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "Torre.findByDataModificacao", query = "SELECT t FROM Torre t WHERE t.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Torre.findByHoraModificacao", query = "SELECT t FROM Torre t WHERE t.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Torre.findBySituacao", query = "SELECT t FROM Torre t WHERE t.situacao = :situacao")})
public class Torre implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "torre")
    private List<Unidade> unidadeList;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TorrePK torrePK;
    @Size(max = 4)
    @Column(name = "cd_praca", length = 60)
    private String cdPraca;
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
    @JoinColumns({
        @JoinColumn(name = "cd_condominio", referencedColumnName = "cd_condominio", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_praca", referencedColumnName = "cd_praca", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Praca praca;

    public Torre() {
    }

    public Torre(TorrePK torrePK) {
        this.torrePK = torrePK;
    }

    public Torre(String cdCondominio, String cdTorre) {
        this.torrePK = new TorrePK(cdCondominio, cdTorre);
    }

    public TorrePK getTorrePK() {
        return torrePK;
    }

    public void setTorrePK(TorrePK torrePK) {
        this.torrePK = torrePK;
    }

    public String getCdPraca() {
        return cdPraca;
    }

    public void setCdPraca(String cdPraca) {
        this.cdPraca = cdPraca;
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

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public Praca getPraca() {
        return praca;
    }

    public void setPraca(Praca praca) {
        this.praca = praca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (torrePK != null ? torrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Torre)) {
            return false;
        }
        Torre other = (Torre) object;
        if ((this.torrePK == null && other.torrePK != null) || (this.torrePK != null && !this.torrePK.equals(other.torrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Torre[ torrePK=" + torrePK + " ]";
    }

    @XmlTransient
    public List<Unidade> getUnidadeList() {
        return unidadeList;
    }

    public void setUnidadeList(List<Unidade> unidadeList) {
        this.unidadeList = unidadeList;
    }
}
