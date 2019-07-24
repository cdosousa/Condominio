/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.domain.Visitante;
import com.condomino.repositories.VisitanteRepository;
import com.parametros.modelo.DataSistema;
import com.parametros.modelo.HoraSistema;
import com.parametros.modelo.enums.Sexo;
import com.parametros.modelo.enums.SimNao;
import com.parametros.modelo.enums.SituacaoCadastral;
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
 * @data 24/07/2019
 */
@ManagedBean(name = "visitanteController")
@SessionScoped
public class VisitanteController implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Objetos com injeção de dependência da classe
     */
    @Inject
    VisitanteRepository vr;

    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String listar = "Visitante.xhtml";
    private final String adicionar = "VisitanteAdicionar.xhtml";
    private final String editar = "VisitanteEditar.xhtml";

    /**
     * Variáveis para edição do registro
     */
    private Integer activeIndex = 0;

    /**
     * Objetos de instância para edição dos registros
     */
    private DataSistema dat;
    private HoraSistema hs;
    private Visitante visitante;
    private Visitante visitanteSelecinado;
    private DataModel<Visitante> listarVisitante;
    private List<SituacaoCadastral> enumSituacao;
    private List<SimNao> enumSimNao;
    private List<Sexo> enumSexo;

    @PostConstruct
    public void init() {
        setVisitanteSelecinado(new Visitante());
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
     * @return the visitanteSelecinado
     */
    public Visitante getVisitanteSelecinado() {
        return visitanteSelecinado;
    }

    /**
     * @param visitanteSelecinado the visitanteSelecinado to set
     */
    public void setVisitanteSelecinado(Visitante visitanteSelecinado) {
        this.visitanteSelecinado = visitanteSelecinado;
    }

    /**
     * @return the visitante
     */
    public Visitante getVisitante() {
        return visitante;
    }

    /**
     * @param visitante the visitante to set
     */
    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

    /**
     * @return the listarVisitante
     */
    public DataModel<Visitante> getListarVisitante() {
        List<Visitante> lista = vr.list();
        listarVisitante = new ListDataModel<>(lista);
        return listarVisitante;
    }

    /**
     * @param listarVisitante the listarVisitante to set
     */
    public void setListarVisitante(DataModel<Visitante> listarVisitante) {
        this.listarVisitante = listarVisitante;
    }

    /**
     * @return the enumSituacao
     */
    public List<SituacaoCadastral> getEnumSituacao() {
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
        return enumSituacao;
    }

    /**
     * @return the enumSimNao
     */
    public List<SimNao> getEnumSimNao() {
        enumSimNao = Arrays.asList(SimNao.values());
        return enumSimNao;
    }

    /**
     * @return the enumSexo
     */
    public List<Sexo> getEnumSexo() {
        enumSexo = Arrays.asList(Sexo.values());
        return enumSexo;
    }

    /**
     * Retorna a situação cadastral do proprietário
     *
     * @param cod
     * @return String contendo a descrição da situação do proprietário
     */
    public String getSituacao(Integer cod) {
        return SituacaoCadastral.toEnum(cod).getDescricao();
    }

    /**
     * Retorna a desrição do valor informado parq Sim ou Não
     *
     * @param cod
     * @return
     */
    public String getSimNao(Integer cod) {
        return SimNao.toEnum(cod).getDescricao();
    }
    
    /**
     * Retorna a descrição do sexo informado
     * @param cod
     * @return 
     */
    public String getSexo(Integer cod){
        return Sexo.toEnum(cod).getDescricao();
    }

    /**
     * Método que limpa os campos do formulário para inclusão de um novo
     * registro
     *
     * @return retorna a página atual que requisitou
     */
    public String adicionarForm() {
        setActiveIndex(2);
        visitante = new Visitante();
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
        visitante.setDataCadastro(Date.valueOf(dat.getData()));
        visitante.setHoraCadastro(Time.valueOf(hs.getHora()));
        vr.create(visitante);
        return listar;
    }

    /**
     * Escluir o registro selecionado
     *
     * @return retonar a página atual que requisitou
     */
    public String excluirRegistro() {
        setActiveIndex(0);
        Visitante e = vr.getById(visitante.getCdVisitante());
        vr.delete(e);
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
        visitante.setDataModificacao(Date.valueOf(dat.getData()));
        visitante.setHoraModificacao(Time.valueOf(hs.getHora()));
        vr.save(visitante);
        return listar;
    }

    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Visitante) e.getObject()).getCdVisitante().toString());
        visitante = vr.getById(((Visitante) e.getObject()).getCdVisitante());
        System.out.println("Objeto Visitante: " + visitante.toString());
    }
}
