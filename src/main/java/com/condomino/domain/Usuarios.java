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
@Table(name = "pgsusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT p FROM Usuarios p")
    , @NamedQuery(name = "Usuarios.findByLogin", query = "SELECT p FROM Usuarios p WHERE p.login = :login")
    , @NamedQuery(name = "Usuarios.findByCCusto", query = "SELECT p FROM Usuarios p WHERE p.cCusto = :cCusto")
    , @NamedQuery(name = "Usuarios.findByCdDepartamento", query = "SELECT p FROM Usuarios p WHERE p.cdDepartamento = :cdDepartamento")
    , @NamedQuery(name = "Usuarios.findByCdGerencia", query = "SELECT p FROM Usuarios p WHERE p.cdGerencia = :cdGerencia")
    , @NamedQuery(name = "Usuarios.findByCelular", query = "SELECT p FROM Usuarios p WHERE p.celular = :celular")
    , @NamedQuery(name = "Usuarios.findByCpf", query = "SELECT p FROM Usuarios p WHERE p.cpf = :cpf")
    , @NamedQuery(name = "Usuarios.findByDataCadastro", query = "SELECT p FROM Usuarios p WHERE p.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Usuarios.findByDataModificacao", query = "SELECT p FROM Usuarios p WHERE p.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Usuarios.findByNomoUsuario", query = "SELECT p FROM Usuarios p WHERE p.nomoUsuario = :nomoUsuario")
    , @NamedQuery(name = "Usuarios.findByRamal", query = "SELECT p FROM Usuarios p WHERE p.ramal = :ramal")
    , @NamedQuery(name = "Usuarios.findBySenha", query = "SELECT p FROM Usuarios p WHERE p.senha = :senha")
    , @NamedQuery(name = "Usuarios.findBySituacao", query = "SELECT p FROM Usuarios p WHERE p.situacao = :situacao")
    , @NamedQuery(name = "Usuarios.findByTelefone", query = "SELECT p FROM Usuarios p WHERE p.telefone = :telefone")
    , @NamedQuery(name = "Usuarios.findByUsuarioCadastro", query = "SELECT p FROM Usuarios p WHERE p.usuarioCadastro = :usuarioCadastro")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "login", nullable = false, length = 10)
    private String login;
    @Size(max = 5)
    @Column(name = "c_custo", length = 5)
    private String cCusto;
    @Size(max = 45)
    @Column(name = "cd_departamento", length = 45)
    private String cdDepartamento;
    @Size(max = 45)
    @Column(name = "cd_gerencia", length = 45)
    private String cdGerencia;
    @Size(max = 12)
    @Column(name = "celular", length = 12)
    private String celular;
    @Size(max = 11)
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column(name = "data_modificacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataModificacao;
    @Size(max = 45)
    @Column(name = "nomo_usuario", length = 45)
    private String nomoUsuario;
    @Size(max = 4)
    @Column(name = "ramal", length = 4)
    private String ramal;
    @Size(max = 45)
    @Column(name = "senha", length = 45)
    private String senha;
    @Column(name = "situacao")
    private Integer situacao;
    @Size(max = 12)
    @Column(name = "telefone", length = 12)
    private String telefone;
    @Size(max = 10)
    @Column(name = "usuario_cadastro", length = 10)
    private String usuarioCadastro;

    public Usuarios() {
    }

    public Usuarios(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCCusto() {
        return cCusto;
    }

    public void setCCusto(String cCusto) {
        this.cCusto = cCusto;
    }

    public String getCdDepartamento() {
        return cdDepartamento;
    }

    public void setCdDepartamento(String cdDepartamento) {
        this.cdDepartamento = cdDepartamento;
    }

    public String getCdGerencia() {
        return cdGerencia;
    }

    public void setCdGerencia(String cdGerencia) {
        this.cdGerencia = cdGerencia;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getNomoUsuario() {
        return nomoUsuario;
    }

    public void setNomoUsuario(String nomoUsuario) {
        this.nomoUsuario = nomoUsuario;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Pgsusuario[ login=" + login + " ]";
    }
    
}
