/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.dao.AcessoBancoDAO;
import com.condomino.domain.Proprietario;
import com.parametros.modelo.DataSistema;
import com.parametros.modelo.HoraSistema;
import com.parametros.modelo.enums.SituacaoCadastral;
import com.parametros.modelo.enums.TipoPessoa;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data 03/07/2019
 */
@ManagedBean(name = "proprietarioController")
@SessionScoped
public class ProprietarioContoller extends AcessoBancoDAO<Proprietario, Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String anterior = "MenuPrincipal.xhtml";
    private final String atual = "Proprietario.xhtml";
    private final String adicionar = "ProprietarioAdicionar.xhtml";
    private final String editar = "ProprietarioEditar.xhtml";

    /**
     * Variáveis para edição do registro
     */
    private String usuarioConectado;
    private String nomeProprietario;
    private Integer tipoPessoaProprietario;
    private String enderecoProprietario;
    private String numeroEndProprietario;
    private String complementoProprietario;
    private String bairroProprietario;
    private String cidadeProprietario;
    private String ufProprietario;
    private String cepProprietario;
    private String telefoneProprietario;
    private String celularProprietario;
    private Integer situacaProprietario;
    private Integer activeIndex = 0;
    private String msg;

    /**
     * Objetos de instância para edição dos registros
     */
    private DataSistema dat;
    private HoraSistema hs;
    private Proprietario proprietarioSelecinado;
    private Proprietario proprietario;
    private DataModel<Proprietario> listarProprietario;
    private List<SituacaoCadastral> enumSituacao;
    private List<TipoPessoa> enumTipoPessoa;

    @PostConstruct
    public void init() {
        dat = new DataSistema();
        hs = new HoraSistema();
        setProprietarioSelecinado(new Proprietario());
        setProprietario(new Proprietario());
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
        enumTipoPessoa = Arrays.asList(TipoPessoa.values());
    }

    /**
     * @return the usuarioConectado
     */
    public String getUsuarioConectado() {
        return usuarioConectado;
    }

    /**
     * @param usuarioConectado the usuarioConectado to set
     */
    public void setUsuarioConectado(String usuarioConectado) {
        this.usuarioConectado = usuarioConectado;
    }

    /**
     * @return the nomeProprietario
     */
    public String getNomeProprietario() {
        return nomeProprietario;
    }

    /**
     * @param nomeProprietario the nomeProprietario to set
     */
    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    /**
     * @return the tipoPessoaProprietario
     */
    public Integer getTipoPessoaProprietario() {
        return tipoPessoaProprietario;
    }

    /**
     * @param tipoPessoaProprietario the tipoPessoaProprietario to set
     */
    public void setTipoPessoaProprietario(Integer tipoPessoaProprietario) {
        this.tipoPessoaProprietario = tipoPessoaProprietario;
    }

    /**
     * @return the enderecoProprietario
     */
    public String getEnderecoProprietario() {
        return enderecoProprietario;
    }

    /**
     * @param enderecoProprietario the enderecoProprietario to set
     */
    public void setEnderecoProprietario(String enderecoProprietario) {
        this.enderecoProprietario = enderecoProprietario;
    }

    /**
     * @return the numeroEndProprietario
     */
    public String getNumeroEndProprietario() {
        return numeroEndProprietario;
    }

    /**
     * @param numeroEndProprietario the numeroEndProprietario to set
     */
    public void setNumeroEndProprietario(String numeroEndProprietario) {
        this.numeroEndProprietario = numeroEndProprietario;
    }

    /**
     * @return the complementoProprietario
     */
    public String getComplementoProprietario() {
        return complementoProprietario;
    }

    /**
     * @param complementoProprietario the complementoProprietario to set
     */
    public void setComplementoProprietario(String complementoProprietario) {
        this.complementoProprietario = complementoProprietario;
    }

    /**
     * @return the bairroProprietario
     */
    public String getBairroProprietario() {
        return bairroProprietario;
    }

    /**
     * @param bairroProprietario the bairroProprietario to set
     */
    public void setBairroProprietario(String bairroProprietario) {
        this.bairroProprietario = bairroProprietario;
    }

    /**
     * @return the cidadeProprietario
     */
    public String getCidadeProprietario() {
        return cidadeProprietario;
    }

    /**
     * @param cidadeProprietario the cidadeProprietario to set
     */
    public void setCidadeProprietario(String cidadeProprietario) {
        this.cidadeProprietario = cidadeProprietario;
    }

    /**
     * @return the ufProprietario
     */
    public String getUfProprietario() {
        return ufProprietario;
    }

    /**
     * @param ufProprietario the ufProprietario to set
     */
    public void setUfProprietario(String ufProprietario) {
        this.ufProprietario = ufProprietario;
    }

    /**
     * @return the cepProprietario
     */
    public String getCepProprietario() {
        return cepProprietario;
    }

    /**
     * @param cepProprietario the cepProprietario to set
     */
    public void setCepProprietario(String cepProprietario) {
        this.cepProprietario = cepProprietario;
    }

    /**
     * @return the telefoneProprietario
     */
    public String getTelefoneProprietario() {
        return telefoneProprietario;
    }

    /**
     * @param telefoneProprietario the telefoneProprietario to set
     */
    public void setTelefoneProprietario(String telefoneProprietario) {
        this.telefoneProprietario = telefoneProprietario;
    }

    /**
     * @return the celularProprietario
     */
    public String getCelularProprietario() {
        return celularProprietario;
    }

    /**
     * @param celularProprietario the celularProprietario to set
     */
    public void setCelularProprietario(String celularProprietario) {
        this.celularProprietario = celularProprietario;
    }

    /**
     * @return the situacaProprietario
     */
    public Integer getSituacaProprietario() {
        return situacaProprietario;
    }

    /**
     * @param situacaProprietario the situacaProprietario to set
     */
    public void setSituacaProprietario(Integer situacaProprietario) {
        this.situacaProprietario = situacaProprietario;
    }

    /**
     * @return the activeIndex
     */
    public Integer getActiveIndex() {
        return activeIndex;
    }

    /**
     * @param activeIndex the activeIndex to set
     */
    public void setActiveIndex(Integer activeIndex) {
        this.activeIndex = activeIndex;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the proprietarioSelecinado
     */
    public Proprietario getProprietarioSelecinado() {
        return proprietarioSelecinado;
    }

    /**
     * @param proprietarioSelecinado the proprietarioSelecinado to set
     */
    public void setProprietarioSelecinado(Proprietario proprietarioSelecinado) {
        this.proprietarioSelecinado = proprietarioSelecinado;
    }

    /**
     * @return the proprietario
     */
    public Proprietario getProprietario() {
        return proprietario;
    }

    /**
     * @param proprietario the proprietario to set
     */
    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    /**
     * @return the listarProprietario
     */
    public DataModel<Proprietario> getListarProprietario() {
        List<Proprietario> lista = list();
        listarProprietario = new ListDataModel<Proprietario>(lista);
        return listarProprietario;
    }

    /**
     * @param listarProprietario the listarProprietario to set
     */
    public void setListarProprietario(DataModel<Proprietario> listarProprietario) {
        this.listarProprietario = listarProprietario;
    }

    /**
     * @return the enumSituacao
     */
    public List<SituacaoCadastral> getEnumSituacao() {
        return enumSituacao;
    }

    /**
     * @return the enumTipoPessoa
     */
    public List<TipoPessoa> getEnumTipoPessoa() {
        return enumTipoPessoa;
    }

    /**
     * Método que limpa os campos do formulário para inclusão de um novo
     * registro
     *
     * @return retorna a página atual que requisitou
     */
    public String adicionarForm() {
        setActiveIndex(2);
        proprietario = new Proprietario();
        return adicionar;
    }

    /**
     * Criado um novo registro no banco de dados
     *
     * @return retorna a página atual que requisitou
     */
    public String adicionaRegistro() {
        setActiveIndex(0);
        dat.setData("");
        proprietario.setUsuarioCadastro(getUsuarioConectado());
        proprietario.setDataCadastro(Date.valueOf(dat.getData()));
        proprietario.setHoraCadastro(Time.valueOf(hs.getHora()));
        create(proprietario);
        setMsg("Registro criado com sucesso!");
        return atual;
    }

    /**
     * Escluir o registro selecionado
     *
     * @return retonar a página atual que requisitou
     */
    public String excluirRegistro() {
        setActiveIndex(0);
        Proprietario e = getById(proprietario.getCpfCnpj());
        delete(e);
        setMsg("Registro escluído com sucesso!");
        return atual;
    }

    /**
     * Seta o índice do TableView para guia de edição
     *
     * @return retorna a página atual que requisitou
     */
    public String editarRegistro() {
        setActiveIndex(1);
        return editar;
    }

    /**
     * Salva o registro modificado no banco de dados
     *
     * @return retorna a página atual que requisitou
     */
    public String salvarRegistro() {
        setActiveIndex(0);
        dat.setData("");
        proprietario.setNomeRazaoSocial(getNomeProprietario());
        proprietario.setTipoPessoa(tipoPessoaProprietario);
        proprietario.setLogradouro(enderecoProprietario);
        proprietario.setNumero(numeroEndProprietario);
        proprietario.setComplemento(complementoProprietario);
        proprietario.setBairro(bairroProprietario);
        proprietario.setMunicipio(cidadeProprietario);
        proprietario.setUf(ufProprietario);
        proprietario.setCep(cepProprietario);
        proprietario.setTelefone(telefoneProprietario);
        proprietario.setCelular(celularProprietario);
        proprietario.setSituacao(getSituacaProprietario());
        proprietario.setDataModificacao(Date.valueOf(dat.getData()));
        proprietario.setHoraModificacao(Time.valueOf(hs.getHora()));
        save(proprietario);
        return atual;
    }

    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Proprietario) e.getObject()).getCpfCnpj().toString());
        proprietario = getById(((Proprietario) e.getObject()).getCpfCnpj());
        setNomeProprietario(proprietario.getNomeRazaoSocial());
        setTipoPessoaProprietario(proprietario.getTipoPessoa());
        setEnderecoProprietario(proprietario.getLogradouro());
        setNumeroEndProprietario(proprietario.getNumero());
        setBairroProprietario(proprietario.getBairro());
        setCidadeProprietario(proprietario.getMunicipio());
        setUfProprietario(proprietario.getUf());
        setCepProprietario(proprietario.getCep());
        setTelefoneProprietario(proprietario.getTelefone());
        setCelularProprietario(proprietario.getCelular());
        setSituacaProprietario(proprietario.getSituacao());
        System.out.println("Objeto Proprietario: " + proprietario.toString());
    }
}
