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
@Table(name = "gcproprietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proprietario.findAll", query = "SELECT p FROM Proprietario p")
    , @NamedQuery(name = "Proprietario.findByCpfCnpj", query = "SELECT p FROM Proprietario p WHERE p.cpfCnpj = :cpfCnpj")
    , @NamedQuery(name = "Proprietario.findByNomeRazaoSocial", query = "SELECT p FROM Proprietario p WHERE p.nomeRazaoSocial = :nomeRazaoSocial")
    , @NamedQuery(name = "Proprietario.findByTipoPessoa", query = "SELECT p FROM Proprietario p WHERE p.tipoPessoa = :tipoPessoa")
    , @NamedQuery(name = "Proprietario.findByLogradouro", query = "SELECT p FROM Proprietario p WHERE p.logradouro = :logradouro")
    , @NamedQuery(name = "Proprietario.findByNumero", query = "SELECT p FROM Proprietario p WHERE p.numero = :numero")
    , @NamedQuery(name = "Proprietario.findByComplemento", query = "SELECT p FROM Proprietario p WHERE p.complemento = :complemento")
    , @NamedQuery(name = "Proprietario.findByBairro", query = "SELECT p FROM Proprietario p WHERE p.bairro = :bairro")
    , @NamedQuery(name = "Proprietario.findByMunicipio", query = "SELECT p FROM Proprietario p WHERE p.municipio = :municipio")
    , @NamedQuery(name = "Proprietario.findByUf", query = "SELECT p FROM Proprietario p WHERE p.uf = :uf")
    , @NamedQuery(name = "Proprietario.findByCep", query = "SELECT p FROM Proprietario p WHERE p.cep = :cep")
    , @NamedQuery(name = "Proprietario.findByTelefone", query = "SELECT p FROM Proprietario p WHERE p.telefone = :telefone")
    , @NamedQuery(name = "Proprietario.findByCelular", query = "SELECT p FROM Proprietario p WHERE p.celular = :celular")
    , @NamedQuery(name = "Proprietario.findByUsuarioCadastro", query = "SELECT p FROM Proprietario p WHERE p.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "Proprietario.findByDataCadastro", query = "SELECT p FROM Proprietario p WHERE p.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Proprietario.findByHoraCadastro", query = "SELECT p FROM Proprietario p WHERE p.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Proprietario.findByUsuarioModificacao", query = "SELECT p FROM Proprietario p WHERE p.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "Proprietario.findByDataModificacao", query = "SELECT p FROM Proprietario p WHERE p.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Proprietario.findByHoraModificacao", query = "SELECT p FROM Proprietario p WHERE p.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Proprietario.findBySituacao", query = "SELECT p FROM Proprietario p WHERE p.situacao = :situacao")})
public class Proprietario implements Serializable {

    @OneToMany(mappedBy = "cpfCnpjProprietario")
    private List<Unidade> unidadeList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "cpf_cnpj", nullable = false, length = 14)
    private String cpfCnpj;
    @Size(max = 100)
    @Column(name = "nome_razao_social", length = 100)
    private String nomeRazaoSocial;
    @Column(name = "tipo_pessoa")
    private Integer tipoPessoa;
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
    @Column(name = "municipio", length = 60)
    private String municipio;
    @Size(max = 2)
    @Column(name = "uf", length = 2)
    private String uf;
    @Size(max = 8)
    @Column(name = "cep", length = 8)
    private String cep;
    @Size(max = 20)
    @Column(name = "telefone", length = 20)
    private String telefone;
    @Size(max = 20)
    @Column(name = "celular", length = 20)
    private String celular;
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

    public Proprietario() {
    }

    public Proprietario(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    public Integer getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(Integer tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
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

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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
        hash += (cpfCnpj != null ? cpfCnpj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proprietario)) {
            return false;
        }
        Proprietario other = (Proprietario) object;
        if ((this.cpfCnpj == null && other.cpfCnpj != null) || (this.cpfCnpj != null && !this.cpfCnpj.equals(other.cpfCnpj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Proprietario[ cpfCnpj=" + cpfCnpj + " ]";
    }

    @XmlTransient
    public List<Unidade> getUnidadeList() {
        return unidadeList;
    }

    public void setUnidadeList(List<Unidade> unidadeList) {
        this.unidadeList = unidadeList;
    }
}
