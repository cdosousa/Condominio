/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.domain.Condominio;
import com.condomino.domain.Equipamento;
import com.condomino.domain.EquipamentoPK;
import com.condomino.domain.Praca;
import com.condomino.repositories.CondominioRepository;
import com.condomino.repositories.EquipamentoRepository;
import com.condomino.repositories.PracaRepository;
import com.parametros.modelo.DataSistema;
import com.parametros.modelo.HoraSistema;
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
 * @data 28/06/2019
 */
@ManagedBean(name = "equipamentoController")
@SessionScoped
public class EquipamentoContoller implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Objetos com injeção de dependência
     */
    @Inject
    private CondominioRepository cr;
    @Inject
    private PracaRepository pr;
    @Inject
    private EquipamentoRepository er;
    
    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String listar = "Equipamento.xhtml";
    private final String adicionar = "EquipamentoAdicionar.xhtml";
    private final String editar = "EquipamentoEditar.xhtml";

    /**
     * Variáveis para edição do registro
     */
    private Integer activeIndex = 0;
    private List<Condominio> listCondominio;
    private List<Praca> listPraca;
    
    /**
     * Objetos de instância para edição dos registros
     */
    private DataSistema dat;
    private HoraSistema hs;
    private Equipamento equipamentoSelecinado;
    private EquipamentoPK equipamentoSelecinadoPK;
    private Equipamento equipamento;
    private EquipamentoPK equipamentoPK;
    private DataModel<Equipamento> listarEquipamento;
    private List<SituacaoCadastral> enumSituacao;

    @PostConstruct
    public void init() {
        dat = new DataSistema();
        hs = new HoraSistema();
        setEquipamentoSelecinado(new Equipamento());
        setEquipamentoSelecinadoPK(new EquipamentoPK());
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
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
     * @return the listCondominio
     */
    public List<Condominio> getListCondominio() {
        listCondominio = cr.list();
        return listCondominio;
    }

    /**
     * @return the listPraca
     */
    public List<Praca> getListPraca() {
        if (equipamentoPK.getCdCondominio() != null && !equipamentoPK.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM Praca WHERE pracaPK.cdCondominio = '" + equipamentoPK.getCdCondominio()
                    + "'";
            listPraca = pr.consultaHQL(hql);
        }
        return listPraca;
    }

    /**
     * @return the equipamentoSelecinado
     */
    public Equipamento getEquipamentoSelecinado() {
        return equipamentoSelecinado;
    }

    /**
     * @param equipamentoSelecinado the equipamentoSelecinado to set
     */
    public void setEquipamentoSelecinado(Equipamento equipamentoSelecinado) {
        this.equipamentoSelecinado = equipamentoSelecinado;
    }

    /**
     * @return the equipamentoSelecinadoPK
     */
    public EquipamentoPK getEquipamentoSelecinadoPK() {
        return equipamentoSelecinadoPK;
    }

    /**
     * @param equipamentoSelecinadoPK the equipamentoSelecinadoPK to set
     */
    public void setEquipamentoSelecinadoPK(EquipamentoPK equipamentoSelecinadoPK) {
        this.equipamentoSelecinadoPK = equipamentoSelecinadoPK;
    }

    /**
     * @return the equipamento
     */
    public Equipamento getEquipamento() {
        return equipamento;
    }

    /**
     * @param equipamento the equipamento to set
     */
    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    /**
     * @return the equipamentoPK
     */
    public EquipamentoPK getEquipamentoPK() {
        return equipamentoPK;
    }

    /**
     * @param equipamentoPK the equipamentoPK to set
     */
    public void setEquipamentoPK(EquipamentoPK equipamentoPK) {
        this.equipamentoPK = equipamentoPK;
    }

    /**
     * @return the listarEquipamento
     */
    public DataModel<Equipamento> getListarEquipamento() {
        List<Equipamento> lista = er.list();
        listarEquipamento = new ListDataModel<Equipamento>(lista);
        return listarEquipamento;
    }

    /**
     * @param listarEquipamento the listarEquipamento to set
     */
    public void setListarEquipamento(DataModel<Equipamento> listarEquipamento) {
        this.listarEquipamento = listarEquipamento;
    }

    /**
     * @return the enumSituacao
     */
    public List<SituacaoCadastral> getEnumSituacao() {
        return enumSituacao;
    }

    /**
     * Método que limpa os campos do formulário para inclusão de um novo
     * registro
     *
     * @return retorna a página atual que requisitou
     */
    public String adicionarForm() {
        setActiveIndex(2);
        equipamento = new Equipamento();
        equipamentoPK = new EquipamentoPK();
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
        dat.setData("");
        equipamento.setEquipamentoPK(equipamentoPK);
        equipamento.setDataCadastro(Date.valueOf(dat.getData()));
        equipamento.setHoraCadastro(Time.valueOf(hs.getHora()));
        er.create(equipamento);
        return listar;
    }

    /**
     * Escluir o registro selecionado
     *
     * @return retonar a página atual que requisitou
     */
    public String excluirRegistro() {
        setActiveIndex(0);
        Equipamento e = er.getById(equipamentoPK);
        er.delete(e);
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
        dat.setData("");
        equipamento.setDataModificacao(Date.valueOf(dat.getData()));
        equipamento.setHoraModificacao(Time.valueOf(hs.getHora()));
        er.save(equipamento);
        return listar;
    }

    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Equipamento) e.getObject()).getEquipamentoPK().toString());
        equipamento = er.getById(((Equipamento) e.getObject()).getEquipamentoPK());
        setEquipamentoPK(equipamento.getEquipamentoPK());
        System.out.println("Objeto Equipamento: " + equipamento.toString());
    }

    /**
     * Evento que obter o valor trocado do condominio e buscar a praca de acordo
     * com o registro
     */
    public void onCondominoChange() {
        System.out.println("Condominio trocado: " + equipamentoPK.getCdCondominio());
        getListPraca();
    }
}