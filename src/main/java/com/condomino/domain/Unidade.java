/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.domain;

import java.io.Serializable;
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
@Table(name = "gcunidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidade.findAll", query = "SELECT u FROM Unidade u")
    , @NamedQuery(name = "Unidade.findByCdCondominio", query = "SELECT u FROM Unidade u WHERE u.unidadePK.cdCondominio = :cdCondominio")
    , @NamedQuery(name = "Unidade.findByCdPraca", query = "SELECT u FROM Unidade u WHERE u.cdPraca = :cdPraca")
    , @NamedQuery(name = "Unidade.findByCdTorre", query = "SELECT u FROM Unidade u WHERE u.unidadePK.cdTorre = :cdTorre")
    , @NamedQuery(name = "Unidade.findByCdUnidade", query = "SELECT u FROM Unidade u WHERE u.unidadePK.cdUnidade = :cdUnidade")
    , @NamedQuery(name = "Unidade.findByAndar", query = "SELECT u FROM Unidade u WHERE u.andar = :andar")
    , @NamedQuery(name = "Unidade.findByUsuarioCadastro", query = "SELECT u FROM Unidade u WHERE u.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "Unidade.findByDataCadastro", query = "SELECT u FROM Unidade u WHERE u.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Unidade.findByHoraCadastro", query = "SELECT u FROM Unidade u WHERE u.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Unidade.findByUsuarioModificacao", query = "SELECT u FROM Unidade u WHERE u.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "Unidade.findByDataModificacao", query = "SELECT u FROM Unidade u WHERE u.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Unidade.findByHoraModificacao", query = "SELECT u FROM Unidade u WHERE u.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Unidade.findBySituacao", query = "SELECT u FROM Unidade u WHERE u.situacao = :situacao")})
public class Unidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UnidadePK unidadePK;
    @Size(max = 4)
    @Column(name = "cd_praca", length = 4)
    private String cdPraca;
    @Size(max = 2)
    @Column(name = "andar", length = 2)
    private String andar;
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

    @JoinColumn(name = "cpf_cnpj_proprietario", referencedColumnName = "cpf_cnpj")
    @ManyToOne
    private Proprietario cpfCnpjProprietario;

    @JoinColumns({
        @JoinColumn(name = "cd_condominio", referencedColumnName = "cd_condominio", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_torre", referencedColumnName = "cd_torre", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Torre torre;

    @JoinColumn(name = "cd_condominio", referencedColumnName = "cd_condominio", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Condominio condominio;

    @JoinColumns({
        @JoinColumn(name = "cd_condominio", referencedColumnName = "cd_condominio", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_praca", referencedColumnName = "cd_praca", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Praca praca;

    public Unidade() {
    }

    public Unidade(UnidadePK unidadePK) {
        this.unidadePK = unidadePK;
    }

    public Unidade(String cdCondominio, String cdTorre, String cdUnidade) {
        this.unidadePK = new UnidadePK(cdCondominio, cdTorre, cdUnidade);
    }

    public UnidadePK getUnidadePK() {
        return unidadePK;
    }

    public void setUnidadePK(UnidadePK unidadePK) {
        this.unidadePK = unidadePK;
    }

    public String getCdPraca() {
        return cdPraca;
    }

    public void setCdPraca(String cdPraca) {
        this.cdPraca = cdPraca;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
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

    public Proprietario getCpfCnpjProprietario() {
        return cpfCnpjProprietario;
    }

    public void setCpfCnpjProprietario(Proprietario cpfCnpjProprietario) {
        this.cpfCnpjProprietario = cpfCnpjProprietario;
    }

    public Torre getTorre() {
        return torre;
    }

    public void setTorre(Torre torre) {
        this.torre = torre;
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

    /**
     * @return the praca
     */
    public Praca getPraca() {
        return praca;
    }

    /**
     * @param praca the praca to set
     */
    public void setPraca(Praca praca) {
        this.praca = praca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidadePK != null ? unidadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        if ((this.unidadePK == null && other.unidadePK != null) || (this.unidadePK != null && !this.unidadePK.equals(other.unidadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Unidade[ unidadePK=" + unidadePK + " ]";
    }
}
