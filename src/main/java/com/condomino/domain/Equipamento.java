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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
 * @Data 27/06/2019
 */
@Entity
@Table(name = "gcequipamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipamento.findAll", query = "SELECT g FROM Equipamento g")
    , @NamedQuery(name = "Equipamento.findByCdCondominio", query = "SELECT g FROM Equipamento g WHERE g.equipamentoPK.cdCondominio = :cdCondominio")
    , @NamedQuery(name = "Equipamento.findByCdPraca", query = "SELECT g FROM Equipamento g WHERE g.equipamentoPK.cdPraca = :cdPraca")
    , @NamedQuery(name = "Equipamento.findByCdEquipamento", query = "SELECT g FROM Equipamento g WHERE g.equipamentoPK.cdEquipamento = :cdEquipamento")
    , @NamedQuery(name = "Equipamento.findByNome", query = "SELECT g FROM Equipamento g WHERE g.nome = :nome")
    , @NamedQuery(name = "Equipamento.findByUsuarioCadastro", query = "SELECT g FROM Equipamento g WHERE g.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "Equipamento.findByDataCadastro", query = "SELECT g FROM Equipamento g WHERE g.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Equipamento.findByHoraCadastro", query = "SELECT g FROM Equipamento g WHERE g.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Equipamento.findByUsuarioModificacao", query = "SELECT g FROM Equipamento g WHERE g.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "Equipamento.findByDataModificacao", query = "SELECT g FROM Equipamento g WHERE g.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Equipamento.findByHoraModificacao", query = "SELECT g FROM Equipamento g WHERE g.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Equipamento.findBySituacao", query = "SELECT g FROM Equipamento g WHERE g.situacao = :situacao")})
public class Equipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipamentoPK equipamentoPK;
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
    @JoinColumns({
        @JoinColumn(name = "cd_condominio", referencedColumnName = "cd_condominio", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_praca", referencedColumnName = "cd_praca", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Praca praca;

    public Equipamento() {
    }

    public Equipamento(EquipamentoPK equipamentoPK) {
        this.equipamentoPK = equipamentoPK;
    }

    public Equipamento(String cdCondominio, String cdPraca, String cdEquipamento) {
        this.equipamentoPK = new EquipamentoPK(cdCondominio, cdPraca, cdEquipamento);
    }

    public EquipamentoPK getEquipamentoPK() {
        return equipamentoPK;
    }

    public void setEquipamentoPK(EquipamentoPK equipamentoPK) {
        this.equipamentoPK = equipamentoPK;
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

    public Praca getPraca() {
        return praca;
    }

    public void setPraca(Praca praca) {
        this.praca = praca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipamentoPK != null ? equipamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipamento)) {
            return false;
        }
        Equipamento other = (Equipamento) object;
        if ((this.equipamentoPK == null && other.equipamentoPK != null) || (this.equipamentoPK != null && !this.equipamentoPK.equals(other.equipamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Equipamento[ equipamentoPK=" + equipamentoPK + " ]";
    }
    
}
