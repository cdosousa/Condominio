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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @Local OICI Serviços e Desenvolvimento Ltda-EPP
 * @Data 24/07/2019
 */
@Entity
@Table(name = "gcvisitante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitante.findAll", query = "SELECT v FROM Visitante v")
    , @NamedQuery(name = "Visitante.findByCdVisitante", query = "SELECT v FROM Visitante v WHERE v.cdVisitante = :cdVisitante")
    , @NamedQuery(name = "Visitante.findByCpf", query = "SELECT v FROM Visitante v WHERE v.cpf = :cpf")
    , @NamedQuery(name = "Visitante.findByRg", query = "SELECT v FROM Visitante v WHERE v.rg = :rg")
    , @NamedQuery(name = "Visitante.findByDataEmissaoRg", query = "SELECT v FROM Visitante v WHERE v.dataEmissaoRg = :dataEmissaoRg")
    , @NamedQuery(name = "Visitante.findByOrgaoEmissorRg", query = "SELECT v FROM Visitante v WHERE v.orgaoEmissorRg = :orgaoEmissorRg")
    , @NamedQuery(name = "Visitante.findByNome", query = "SELECT v FROM Visitante v WHERE v.nome = :nome")
    , @NamedQuery(name = "Visitante.findBySexo", query = "SELECT v FROM Visitante v WHERE v.sexo = :sexo")
    , @NamedQuery(name = "Visitante.findByTelefone", query = "SELECT v FROM Visitante v WHERE v.telefone = :telefone")
    , @NamedQuery(name = "Visitante.findByCelular", query = "SELECT v FROM Visitante v WHERE v.celular = :celular")
    , @NamedQuery(name = "Visitante.findByUsuarioCadastro", query = "SELECT v FROM Visitante v WHERE v.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "Visitante.findByDataCadastro", query = "SELECT v FROM Visitante v WHERE v.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Visitante.findByHoraCadastro", query = "SELECT v FROM Visitante v WHERE v.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Visitante.findByUsuarioModificacao", query = "SELECT v FROM Visitante v WHERE v.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "Visitante.findByDataModificacao", query = "SELECT v FROM Visitante v WHERE v.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Visitante.findByHoraModificacao", query = "SELECT v FROM Visitante v WHERE v.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Visitante.findBySituacao", query = "SELECT v FROM Visitante v WHERE v.situacao = :situacao")})
public class Visitante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_visitante", nullable = false)
    private Integer cdVisitante;
    @Size(max = 11)
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Size(max = 15)
    @Column(name = "rg", length = 15)
    private String rg;
    @Column(name = "data_emissao_rg")
    @Temporal(TemporalType.DATE)
    private Date dataEmissaoRg;
    @Size(max = 20)
    @Column(name = "orgao_emissor_rg", length = 20)
    private String orgaoEmissorRg;
    @Size(max = 100)
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "sexo")
    private Integer sexo;
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

    public Visitante() {
    }

    public Visitante(Integer cdVisitante) {
        this.cdVisitante = cdVisitante;
    }

    public Integer getCdVisitante() {
        return cdVisitante;
    }

    public void setCdVisitante(Integer cdVisitante) {
        this.cdVisitante = cdVisitante;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataEmissaoRg() {
        return dataEmissaoRg;
    }

    public void setDataEmissaoRg(Date dataEmissaoRg) {
        this.dataEmissaoRg = dataEmissaoRg;
    }

    public String getOrgaoEmissorRg() {
        return orgaoEmissorRg;
    }

    public void setOrgaoEmissorRg(String orgaoEmissorRg) {
        this.orgaoEmissorRg = orgaoEmissorRg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
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
        hash += (cdVisitante != null ? cdVisitante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitante)) {
            return false;
        }
        Visitante other = (Visitante) object;
        if ((this.cdVisitante == null && other.cdVisitante != null) || (this.cdVisitante != null && !this.cdVisitante.equals(other.cdVisitante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Visitante[ cdVisitante=" + cdVisitante + " ]";
    }
    
}
