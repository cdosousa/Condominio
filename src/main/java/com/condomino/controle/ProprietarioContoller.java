/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.domain.Proprietario;
import com.condomino.repositories.ProprietarioRepository;
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
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data 03/07/2019
 */
@ManagedBean(name = "proprietarioController")
@SessionScoped
public class ProprietarioContoller implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Objetos com injeção de dependência na classe
     */
    @Inject
    private ProprietarioRepository pr;
    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String listar = "Proprietario.xhtml";
    private final String adicionar = "ProprietarioAdicionar.xhtml";
    private final String editar = "ProprietarioEditar.xhtml";

    /**
     * Variáveis para edição do registro
     */
    private Integer activeIndex = 0;
    
    /**
     * Objetos de instância para edição dos registros
     */
    private DataSistema dat;
    private HoraSistema hs;
    private Proprietario proprietario;
    private Proprietario proprietarioSelecinado;
    private DataModel<Proprietario> listarProprietario;
    private List<SituacaoCadastral> enumSituacao;
    private List<TipoPessoa> enumTipoPessoa;

    @PostConstruct
    public void init() {
        setProprietarioSelecinado(new Proprietario());
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
        enumTipoPessoa = Arrays.asList(TipoPessoa.values());
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
        List<Proprietario> lista = pr.list();
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
     * Retorna o tipo de pessoa jurídica do cadastro
     * @param cod
     * @return String contendo a descrição do tipo de pessoa jurídica
     */
    public String getTipoPessoa(Integer cod){
        return TipoPessoa.toEnum(cod).getDescricao();
    }
    
    /**
     * Retorna a situação cadastral do proprietário
     * @param cod
     * @return String contendo a descrição da situação do proprietário
     */
    public String getSituacao(Integer cod){
        return SituacaoCadastral.toEnum(cod).getDescricao();
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
        dat = new DataSistema();
        hs = new HoraSistema();
        dat.setData("");
        proprietario.setDataCadastro(Date.valueOf(dat.getData()));
        proprietario.setHoraCadastro(Time.valueOf(hs.getHora()));
        pr.create(proprietario);
        return listar;
    }

    /**
     * Escluir o registro selecionado
     *
     * @return retonar a página atual que requisitou
     */
    public String excluirRegistro() {
        setActiveIndex(0);
        Proprietario e = pr.getById(proprietario.getCpfCnpj());
        pr.delete(e);
        return listar;
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
        dat = new DataSistema();
        hs = new HoraSistema();
        dat.setData("");
        proprietario.setDataModificacao(Date.valueOf(dat.getData()));
        proprietario.setHoraModificacao(Time.valueOf(hs.getHora()));
        pr.save(proprietario);
        return listar;
    }

    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Proprietario) e.getObject()).getCpfCnpj().toString());
        proprietario = pr.getById(((Proprietario) e.getObject()).getCpfCnpj());
        System.out.println("Objeto Proprietario: " + proprietario.toString());
    }
}