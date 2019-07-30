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
 * @author cristiano
 */
@Entity
@Table(name = "gmvisita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visita.findAll", query = "SELECT v FROM Visita v")
    , @NamedQuery(name = "Visita.findByCdCondominio", query = "SELECT v FROM Visita v WHERE v.visitaPK.cdCondominio = :cdCondominio")
    , @NamedQuery(name = "Visita.findByCdVisita", query = "SELECT v FROM Visita v WHERE v.visitaPK.cdVisita = :cdVisita")
    , @NamedQuery(name = "Visita.findByCdTorre", query = "SELECT v FROM Visita v WHERE v.cdTorre = :cdTorre")
    , @NamedQuery(name = "Visita.findByCdUnidade", query = "SELECT v FROM Visita v WHERE v.cdUnidade = :cdUnidade")
    , @NamedQuery(name = "Visita.findByTipoVisita", query = "SELECT v FROM Visita v WHERE v.tipoVisita = :tipoVisita")
    , @NamedQuery(name = "Visita.findByDataEntrada", query = "SELECT v FROM Visita v WHERE v.dataEntrada = :dataEntrada")
    , @NamedQuery(name = "Visita.findByHoraEntrada", query = "SELECT v FROM Visita v WHERE v.horaEntrada = :horaEntrada")
    , @NamedQuery(name = "Visita.findByDataSaida", query = "SELECT v FROM Visita v WHERE v.dataSaida = :dataSaida")
    , @NamedQuery(name = "Visita.findByHoraSaida", query = "SELECT v FROM Visita v WHERE v.horaSaida = :horaSaida")
    , @NamedQuery(name = "Visita.findByCdMorador", query = "SELECT v FROM Visita v WHERE v.cdMorador = :cdMorador")
    , @NamedQuery(name = "Visita.findByUsuarioCadastro", query = "SELECT v FROM Visita v WHERE v.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "Visita.findByDataCadastro", query = "SELECT v FROM Visita v WHERE v.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Visita.findByHoraCadastro", query = "SELECT v FROM Visita v WHERE v.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Visita.findByUsuarioModificacao", query = "SELECT v FROM Visita v WHERE v.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "Visita.findByDataModificacao", query = "SELECT v FROM Visita v WHERE v.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Visita.findByHoraModificacao", query = "SELECT v FROM Visita v WHERE v.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Visita.findBySituacao", query = "SELECT v FROM Visita v WHERE v.situacao = :situacao")})
public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VisitaPK visitaPK;
    @Size(min = 1, max = 20)
    @Column(name = "cd_torre", length = 20)
    private String cdTorre;
    @Size(min = 2, max = 4)
    @Column(name = "cd_unidade", length = 4)
    private String cdUnidade;
    @Column(name = "tipo_visita")
    private Integer tipoVisita;
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Column(name = "hora_entrada")
    @Temporal(TemporalType.TIME)
    private Date horaEntrada;
    @Column(name = "data_saida")
    @Temporal(TemporalType.DATE)
    private Date dataSaida;
    @Column(name = "hora_saida")
    @Temporal(TemporalType.TIME)
    private Date horaSaida;
    @Size(min = 1,max = 6)
    @Column(name = "cd_morador", length = 6)
    private String cdMorador;
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
        , @JoinColumn(name = "cd_torre", referencedColumnName = "cd_torre", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_unidade", referencedColumnName = "cd_unidade", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Unidade unidade;

    @JoinColumns({
        @JoinColumn(name = "cd_condominio", referencedColumnName = "cd_condominio", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_morador", referencedColumnName = "cd_morador", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Morador morador;

    public Visita() {
    }

    public Visita(VisitaPK visitaPK) {
        this.visitaPK = visitaPK;
    }

    public Visita(String cdCondominio, int cdVisita) {
        this.visitaPK = new VisitaPK(cdCondominio, cdVisita);
    }

    public VisitaPK getVisitaPK() {
        return visitaPK;
    }

    public void setVisitaPK(VisitaPK visitaPK) {
        this.visitaPK = visitaPK;
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

    public Integer getTipoVisita() {
        return tipoVisita;
    }

    public void setTipoVisita(Integer tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getCdMorador() {
        return cdMorador;
    }

    public void setCdMorador(String cdMorador) {
        this.cdMorador = cdMorador;
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

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the morador
     */
    public Morador getMorador() {
        return morador;
    }

    /**
     * @param morador the morador to set
     */
    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitaPK != null ? visitaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.visitaPK == null && other.visitaPK != null) || (this.visitaPK != null && !this.visitaPK.equals(other.visitaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Visita[ visitaPK=" + visitaPK + " ]";
    }

}