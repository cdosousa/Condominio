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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
 * @author Cristiano de Oliveira Sousa
 * @Local OICI Serviços e Desenvolvimento Ltda-EPP
 * @Data 19/07/2019
 */
@Entity
@Table(name = "gcveiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v")
    , @NamedQuery(name = "Veiculo.findByPlaca", query = "SELECT v FROM Veiculo v WHERE v.placa = :placa")
    , @NamedQuery(name = "Veiculo.findByMarca", query = "SELECT v FROM Veiculo v WHERE v.marca = :marca")
    , @NamedQuery(name = "Veiculo.findByModelo", query = "SELECT v FROM Veiculo v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Veiculo.findByUsuarioCadastro", query = "SELECT v FROM Veiculo v WHERE v.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "Veiculo.findByDataCadastro", query = "SELECT v FROM Veiculo v WHERE v.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Veiculo.findByHoraCadastro", query = "SELECT v FROM Veiculo v WHERE v.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Veiculo.findByUsuarioModificacao", query = "SELECT v FROM Veiculo v WHERE v.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "Veiculo.findByDataModificacao", query = "SELECT v FROM Veiculo v WHERE v.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Veiculo.findByHoraModificacao", query = "SELECT v FROM Veiculo v WHERE v.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Veiculo.findBySituacao", query = "SELECT v FROM Veiculo v WHERE v.situacao = :situacao")})
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(min = 1, max = 8)
    @Column(name = "cd_condominio", nullable = false, length = 8)
    private String cdCondominio;
    @Size(min = 1, max = 20)
    @Column(name = "cd_torre", length = 20)
    private String cdTorre;
    @Size(min = 2, max = 4)
    @Column(name = "cd_unidade", length = 4)
    private String cdUnidade;
    @Size(min = 1, max = 6)
    @Column(name = "cd_morador", nullable = false, length = 6)
    private String cdMorador;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "placa", nullable = false, length = 7)
    private String placa;
    @Size(max = 20)
    @Column(name = "marca", length = 20)
    private String marca;
    @Size(max = 20)
    @Column(name = "modelo", length = 20)
    private String modelo;
    @Size(max = 20)
    @Column(name = "cor", length = 20)
    private String cor;
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
    @JoinColumns({
        @JoinColumn(name = "cd_condominio", referencedColumnName = "cd_condominio", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_morador", referencedColumnName = "cd_morador", nullable = false, insertable = false, updatable = false)})
    @ManyToOne
    private Morador morador;
    
    @JoinColumns({
        @JoinColumn(name = "cd_condominio", referencedColumnName = "cd_condominio", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_torre", referencedColumnName = "cd_torre", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_unidade", referencedColumnName = "cd_unidade", nullable = false, insertable = false, updatable = false)})
    @ManyToOne
    private Unidade unidade;

    public Veiculo() {
    }

    public Veiculo(String placa) {
        this.placa = placa;
    }

    /**
     * @return the cdCondominio
     */
    public String getCdCondominio() {
        return cdCondominio;
    }

    /**
     * @param cdCondominio the cdCondominio to set
     */
    public void setCdCondominio(String cdCondominio) {
        this.cdCondominio = cdCondominio;
    }

    /**
     * @return the cdTorre
     */
    public String getCdTorre() {
        return cdTorre;
    }

    /**
     * @param cdTorre the cdTorre to set
     */
    public void setCdTorre(String cdTorre) {
        this.cdTorre = cdTorre;
    }

    /**
     * @return the cdUnidade
     */
    public String getCdUnidade() {
        return cdUnidade;
    }

    /**
     * @param cdUnidade the cdUnidade to set
     */
    public void setCdUnidade(String cdUnidade) {
        this.cdUnidade = cdUnidade;
    }

    /**
     * @return the cdMorador
     */
    public String getCdMorador() {
        return cdMorador;
    }

    /**
     * @param cdMorador the cdMorador to set
     */
    public void setCdMorador(String cdMorador) {
        this.cdMorador = cdMorador;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
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

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    /**
     * @return the unidade
     */
    public Unidade getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Veiculo[ placa=" + placa + " ]";
    }

}
