/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristiano
 */
@Entity
@Table(name = "gccondominio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condominio.findAll", query = "SELECT c FROM Condominio c")
    , @NamedQuery(name = "Condominio.findByCdCondominio", query = "SELECT c FROM Condominio c WHERE c.cdCondominio = :cdCondominio")
    , @NamedQuery(name = "Condominio.findByNome", query = "SELECT c FROM Condominio c WHERE c.nomeCondominio = :nomeCondominio")
    , @NamedQuery(name = "Condominio.findByLogradouro", query = "SELECT c FROM Condominio c WHERE c.logradouro = :logradouro")
    , @NamedQuery(name = "Condominio.findByNumero", query = "SELECT c FROM Condominio c WHERE c.numero = :numero")
    , @NamedQuery(name = "Condominio.findByComplemento", query = "SELECT c FROM Condominio c WHERE c.complemento = :complemento")
    , @NamedQuery(name = "Condominio.findByBairro", query = "SELECT c FROM Condominio c WHERE c.bairro = :bairro")
    , @NamedQuery(name = "Condominio.findByCidade", query = "SELECT c FROM Condominio c WHERE c.cidade = :cidade")
    , @NamedQuery(name = "Condominio.findByUf", query = "SELECT c FROM Condominio c WHERE c.uf = :uf")
    , @NamedQuery(name = "Condominio.findByUsuarioCadastro", query = "SELECT c FROM Condominio c WHERE c.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "Condominio.findByDataCadastro", query = "SELECT c FROM Condominio c WHERE c.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Condominio.findByHoraCadastro", query = "SELECT c FROM Condominio c WHERE c.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Condominio.findByUsuarioModificacao", query = "SELECT c FROM Condominio c WHERE c.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "Condominio.findByDataModificacao", query = "SELECT c FROM Condominio c WHERE c.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Condominio.findByHoraModificacao", query = "SELECT c FROM Condominio c WHERE c.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Condominio.findBySituacao", query = "SELECT c FROM Condominio c WHERE c.situacao = :situacao")})
public class Condominio implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condominio")
    private List<Unidade> unidadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condominio")
    private List<Torre> torreList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condominio")
    private List<Praca> pracaList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cd_condominio", nullable = false, length = 8)
    private String cdCondominio;
    @Size(max = 100)
    @Column(name = "nome", length = 100)
    private String nomeCondominio;
    @Size(max = 60)
    @Column(name = "logradouro", length = 60)
    private String logradouro;
    @Size(max = 10)
    @Column(name = "numero", length = 10)
    private String numero;
    @Size(max = 60)
    @Column(name = "complemento", length = 60)
    private String complemento;
    @Size(max = 60)
    @Column(name = "bairro", length = 60)
    private String bairro;
    @Size(max = 60)
    @Column(name = "cidade", length = 60)
    private String cidade;
    @Size(max = 2)
    @Column(name = "uf", length = 2)
    private String uf;
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

    public Condominio() {
    }

    public Condominio(Condominio cond) {
        this.cdCondominio = cond.getCdCondominio();
        this.nomeCondominio = cond.getNomeCondominio();
        this.logradouro = cond.getLogradouro();
        this.numero = cond.getNumero();
        this.complemento = cond.getComplemento();
        this.bairro = cond.getBairro();
        this.cidade = cond.getCidade();
        this.uf = cond.getUf();
        this.usuarioCadastro = cond.getUsuarioCadastro();
        this.dataCadastro = cond.getDataCadastro();
        this.horaCadastro = cond.getHoraCadastro();
        this.usuarioModificacao = cond.getUsuarioModificacao();
        this.dataModificacao = cond.getDataModificacao();
        this.horaModificacao = cond.getHoraModificacao();
        this.situacao = cond.getSituacao();
    }

    public Condominio(String cdCondominio) {
        this.cdCondominio = cdCondominio;
    }

    public String getCdCondominio() {
        return cdCondominio;
    }

    public void setCdCondominio(String cdCondominio) {
        this.cdCondominio = cdCondominio;
    }

    public String getNomeCondominio() {
        return nomeCondominio;
    }

    public void setNomeCondominio(String nomeCondominio) {
        this.nomeCondominio = nomeCondominio;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
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
        hash += (cdCondominio != null ? cdCondominio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condominio)) {
            return false;
        }
        Condominio other = (Condominio) object;
        if ((this.cdCondominio == null && other.cdCondominio != null) || (this.cdCondominio != null && !this.cdCondominio.equals(other.cdCondominio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Condominio[ cdCondominio=" + cdCondominio + " ]";
    }

    @XmlTransient
    public List<Torre> getTorreList() {
        return torreList;
    }

    public void setTorreList(List<Torre> torreList) {
        this.torreList = torreList;
    }

    @XmlTransient
    public List<Praca> getPracaList() {
        return pracaList;
    }

    public void setPracaList(List<Praca> pracaList) {
        this.pracaList = pracaList;
    }

    @XmlTransient
    public List<Unidade> getUnidadeList() {
        return unidadeList;
    }

    public void setUnidadeList(List<Unidade> unidadeList) {
        this.unidadeList = unidadeList;
    }
}
