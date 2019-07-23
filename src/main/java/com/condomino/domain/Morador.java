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
@Table(name = "gcmorador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Morador.findAll", query = "SELECT m FROM Morador m")
    , @NamedQuery(name = "Morador.findByCdCondominio", query = "SELECT m FROM Morador m WHERE m.moradorPK.cdCondominio = :cdCondominio")
    , @NamedQuery(name = "Morador.findByCdMorador", query = "SELECT m FROM Morador m WHERE m.moradorPK.cdMorador = :cdMorador")
    , @NamedQuery(name = "Morador.findByCpf", query = "SELECT m FROM Morador m WHERE m.cpf = :cpf")
    , @NamedQuery(name = "Morador.findByRg", query = "SELECT m FROM Morador m WHERE m.rg = :rg")
    , @NamedQuery(name = "Morador.findByDataEmissaoRg", query = "SELECT m FROM Morador m WHERE m.dataEmissaoRg = :dataEmissaoRg")
    , @NamedQuery(name = "Morador.findByOrgaoEmissorRg", query = "SELECT m FROM Morador m WHERE m.orgaoEmissorRg = :orgaoEmissorRg")
    , @NamedQuery(name = "Morador.findByNome", query = "SELECT m FROM Morador m WHERE m.nome = :nome")
    , @NamedQuery(name = "Morador.findBySexo", query = "SELECT m FROM Morador m WHERE m.sexo = :sexo")
    , @NamedQuery(name = "Morador.findByTelefone", query = "SELECT m FROM Morador m WHERE m.telefone = :telefone")
    , @NamedQuery(name = "Morador.findByCelular", query = "SELECT m FROM Morador m WHERE m.celular = :celular")
    , @NamedQuery(name = "Morador.findByTipoParentesco", query = "SELECT m FROM Morador m WHERE m.tipoParentesco = :tipoParentesco")
    , @NamedQuery(name = "Morador.findByUsuarioCadastro", query = "SELECT m FROM Morador m WHERE m.usuarioCadastro = :usuarioCadastro")
    , @NamedQuery(name = "Morador.findByDataCadastro", query = "SELECT m FROM Morador m WHERE m.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Morador.findByHoraCadastro", query = "SELECT m FROM Morador m WHERE m.horaCadastro = :horaCadastro")
    , @NamedQuery(name = "Morador.findByUsuarioModificacao", query = "SELECT m FROM Morador m WHERE m.usuarioModificacao = :usuarioModificacao")
    , @NamedQuery(name = "Morador.findByDataModificacao", query = "SELECT m FROM Morador m WHERE m.dataModificacao = :dataModificacao")
    , @NamedQuery(name = "Morador.findByHoraModificacao", query = "SELECT m FROM Morador m WHERE m.horaModificacao = :horaModificacao")
    , @NamedQuery(name = "Morador.findBySituacao", query = "SELECT m FROM Morador m WHERE m.situacao = :situacao")})
public class Morador implements Serializable {

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "morador")
    private List<Veiculo> veiculoList;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MoradorPK moradorPK;
    @Size(min = 1, max = 20)
    @Column(name = "cd_torre", length = 20)
    private String cdTorre;
    @Size(min = 2, max = 4)
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
    @JoinColumns({
        @JoinColumn(name = "cd_condominio", referencedColumnName = "cd_condominio", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_torre", referencedColumnName = "cd_torre", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "cd_unidade", referencedColumnName = "cd_unidade", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Unidade unidade;

    public Morador() {
    }

    public Morador(MoradorPK moradorPK) {
        this.moradorPK = moradorPK;
    }

    public Morador(String cdCondominio, String cdMorador) {
        this.moradorPK = new MoradorPK(cdCondominio, cdMorador);
    }

    public MoradorPK getMoradorPK() {
        return moradorPK;
    }

    public void setMoradorPK(MoradorPK moradorPK) {
        this.moradorPK = moradorPK;
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

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moradorPK != null ? moradorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Morador)) {
            return false;
        }
        Morador other = (Morador) object;
        if ((this.moradorPK == null && other.moradorPK != null) || (this.moradorPK != null && !this.moradorPK.equals(other.moradorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.condomino.domain.Morador[ moradorPK=" + moradorPK + " ]";
    }

    @XmlTransient
    public List<Veiculo> getVeiculoList() {
        return veiculoList;
    }

    public void setVeiculoList(List<Veiculo> veiculoList) {
        this.veiculoList = veiculoList;
    }
    
}
