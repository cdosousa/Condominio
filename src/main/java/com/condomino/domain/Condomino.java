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
@Table(name = "gccondomino")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condomino.findAll", query = "SELECT c FROM Condomino c")
    , @NamedQuery(name = "Condomino.findByCdCondominio", query = "SELECT c FROM Condomino c WHERE c.condominoPK.cdCondominio = :cdCondominio")
    , @NamedQuery(name = "Condomino.findByCdCondomino", query = "SELECT c FROM Condomino c WHERE c.condominoPK.cdCondomino = :cdCondomino")
    , @NamedQuery(name = "Condomino.findByCpf", query = "SELECT c FROM Condomino c WHERE c.cpf = :cpf")
    , @NamedQuery(name = "Condomino.findByRg", query = "SELECT c FROM Condomino c WHERE c.rg = :rg")
    , @NamedQuery(name = "Condomino.findByDataEmissaoRg", query = "SELECT c FROM Condomino c WHERE c.dataEmissaoRg = :dataEmissaoRg")
    , @NamedQuery(name = "Condomino.findByOrgaoEmissorRg", query = "SELECT c FROM Condomino c WHERE c.orgaoEmissorRg = :orgaoEmissorRg")
    , @NamedQuery(name = "Condomino.findByNome", query = "SELECT c FROM Condomino c WHERE c.nome = :nome")
    , @NamedQuery(name = "Condomino.findBySexo", query = "SELECT c FROM Condomino c WHERE c.sexo = :sexo")
    , @NamedQuery(name = "Condomino.findByTelefone", query = "SELECT c FROM Condomino c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Condomino.findByCelular", query = "SELECT c FROM Condomino c WHERE c.celular = :celular")
    , @NamedQuery(name = "Condomino.findByTipoParentesco", query = "SELECT c FROM Condomino c WHERE c.tipoParentesco = :tipoParentesco")
    , @NamedQuery(name = "Condomino.findByUsuarioCadastro", query = "SELECT c FROM Condomino c WHERE c.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "Condomino.findByDataCadastro", query = "SELECT c FROM Condomino c WHERE c.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Condomino.findByHoraCadastro", query = "SELECT c FROM Condomino c WHERE c.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Condomino.findByUsuarioModificacao", query = "SELECT c FROM Condomino c WHERE c.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "Condomino.findByDataModificacao", query = "SELECT c FROM Condomino c WHERE c.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Condomino.findByHoraModificacao", query = "SELECT c FROM Condomino c WHERE c.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Condomino.findBySituacao", query = "SELECT c FROM Condomino c WHERE c.situacao = :situacao")})
public class Condomino implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CondominoPK condominoPK;
    @Size(max = 20)
    @Column(name = "cd_torre", length = 20)
    private String cdTorre;
    @Size(max = 4)
    @Column(name = "cd_unidade", length = 4)
    private String cdUnidade;
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
    @Column(name = "tipo_parentesco")
    private Integer tipoParentesco;
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
        , @JoinColumn(name = "cd_torre", referencedColumnName = "cd_torre", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Torre torre;
    @JoinColumns({
        @JoinColumn(name = "cd_condominio", referencedColumnName = "cd_condominio", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_torre", referencedColumnName = "cd_torre", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_unidade", referencedColumnName = "cd_unidade", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Unidade unidade;

    public Condomino() {
    }

    public Condomino(CondominoPK condominoPK) {
        this.condominoPK = condominoPK;
    }

    public Condomino(String cdCondominio, String cdCondomino) {
        this.condominoPK = new CondominoPK(cdCondominio, cdCondomino);
    }

    public CondominoPK getCondominoPK() {
        return condominoPK;
    }

    public void setCondominoPK(CondominoPK condominoPK) {
        this.condominoPK = condominoPK;
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

    public Integer getTipoParentesco() {
        return tipoParentesco;
    }

    public void setTipoParentesco(Integer tipoParentesco) {
        this.tipoParentesco = tipoParentesco;
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

    public Torre getTorre() {
        return torre;
    }

    public void setTorre(Torre torre) {
        this.torre = torre;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (condominoPK != null ? condominoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condomino)) {
            return false;
        }
        Condomino other = (Condomino) object;
        if ((this.condominoPK == null && other.condominoPK != null) || (this.condominoPK != null && !this.condominoPK.equals(other.condominoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Condomino[ condominoPK=" + condominoPK + " ]";
    }
    
}
