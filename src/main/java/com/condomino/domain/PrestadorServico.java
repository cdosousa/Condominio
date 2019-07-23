/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.domain;

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
@Table(name = "gcprestadorservico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrestadorServico.findAll", query = "SELECT p FROM PrestadorServico p")
    , @NamedQuery(name = "PrestadorServico.findByCpfCnpj", query = "SELECT p FROM PrestadorServico p WHERE p.cpfCnpj = :cpfCnpj")
    , @NamedQuery(name = "PrestadorServico.findByNome", query = "SELECT p FROM PrestadorServico p WHERE p.nome = :nome")
    , @NamedQuery(name = "PrestadorServico.findByTipoPessoa", query = "SELECT p FROM PrestadorServico p WHERE p.tipoPessoa = :tipoPessoa")
    , @NamedQuery(name = "PrestadorServico.findByLogradouro", query = "SELECT p FROM PrestadorServico p WHERE p.logradouro = :logradouro")
    , @NamedQuery(name = "PrestadorServico.findByNumero", query = "SELECT p FROM PrestadorServico p WHERE p.numero = :numero")
    , @NamedQuery(name = "PrestadorServico.findByComplemento", query = "SELECT p FROM PrestadorServico p WHERE p.complemento = :complemento")
    , @NamedQuery(name = "PrestadorServico.findByBairro", query = "SELECT p FROM PrestadorServico p WHERE p.bairro = :bairro")
    , @NamedQuery(name = "PrestadorServico.findByMunicipio", query = "SELECT p FROM PrestadorServico p WHERE p.municipio = :municipio")
    , @NamedQuery(name = "PrestadorServico.findByUf", query = "SELECT p FROM PrestadorServico p WHERE p.uf = :uf")
    , @NamedQuery(name = "PrestadorServico.findByCep", query = "SELECT p FROM PrestadorServico p WHERE p.cep = :cep")
    , @NamedQuery(name = "PrestadorServico.findByContato", query = "SELECT p FROM PrestadorServico p WHERE p.contato = :contato")
    , @NamedQuery(name = "PrestadorServico.findByTelefone", query = "SELECT p FROM PrestadorServico p WHERE p.telefone = :telefone")
    , @NamedQuery(name = "PrestadorServico.findByFax", query = "SELECT p FROM PrestadorServico p WHERE p.fax = :fax")
    , @NamedQuery(name = "PrestadorServico.findByUsuarioCadastro", query = "SELECT p FROM PrestadorServico p WHERE p.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "PrestadorServico.findByDataCadastro", query = "SELECT p FROM PrestadorServico p WHERE p.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "PrestadorServico.findByHoraCadastro", query = "SELECT p FROM PrestadorServico p WHERE p.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "PrestadorServico.findByUsuarioModificacao", query = "SELECT p FROM PrestadorServico p WHERE p.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "PrestadorServico.findByDataModificacao", query = "SELECT p FROM PrestadorServico p WHERE p.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "PrestadorServico.findByHoraModificacao", query = "SELECT p FROM PrestadorServico p WHERE p.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "PrestadorServico.findBySituacao", query = "SELECT p FROM PrestadorServico p WHERE p.situacao = :situacao")})
public class PrestadorServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "cpf_cnpj", nullable = false, length = 14)
    private String cpfCnpj;
    @Size(max = 100)
    @Column(name = "nome", length = 100)
    private String nome;
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
    @Size(max = 50)
    @Column(name = "contato", length = 50)
    private String contato;
    @Size(max = 20)
    @Column(name = "telefone", length = 20)
    private String telefone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Formato de telefone/fax inválido, deve ser xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "fax", length = 20)
    private String fax;
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

    public PrestadorServico() {
    }

    public PrestadorServico(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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
        if (!(object instanceof PrestadorServico)) {
            return false;
        }
        PrestadorServico other = (PrestadorServico) object;
        if ((this.cpfCnpj == null && other.cpfCnpj != null) || (this.cpfCnpj != null && !this.cpfCnpj.equals(other.cpfCnpj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.PrestadorServico[ cpfCnpj=" + cpfCnpj + " ]";
    }
    
}
