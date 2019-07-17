/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.dao.AcessoBancoDAO;
import com.condomino.domain.Condominio;
import com.condomino.domain.Equipamento;
import com.condomino.domain.EquipamentoPK;
import com.condomino.domain.Praca;
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
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data 28/06/2019
 */
@ManagedBean(name = "equipamentoController")
@SessionScoped
public class EquipamentoContoller extends AcessoBancoDAO<Equipamento, Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String anterior = "MenuPrincipal.xhtml";
    private final String atual = "Equipamento.xhtml";
    private final String editar = "EquipamentoEditar.xhtml";

    /**
     * Variáveis para edição do registro
     */
    private String usuarioConectado;
    private String nomeEquipamento;
    private Integer situacaEquipamento;
    private Integer activeIndex = 0;
    private List<Condominio> listCondominio;
    private List<Praca> listPraca;
    private CondominioController cc;
    private PracaController pc;
    private String msg;

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
        setEquipamento(new Equipamento());
        setEquipamentoPK(new EquipamentoPK());
        cc = new CondominioController();
        pc = new PracaController();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
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
     * @return the nomeEquipamento
     */
    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    /**
     * @param nomeEquipamento the nomeEquipamento to set
     */
    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    /**
     * @return the situacaEquipamento
     */
    public Integer getSituacaEquipamento() {
        return situacaEquipamento;
    }

    /**
     * @param situacaEquipamento the situacaEquipamento to set
     */
    public void setSituacaEquipamento(Integer situacaEquipamento) {
        this.situacaEquipamento = situacaEquipamento;
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
        //listCondominio = cc..list();
        return listCondominio;
    }

    /**
     * @return the listPraca
     */
    public List<Praca> getListPraca() {
        if (equipamentoPK.getCdCondominio() != null && !equipamentoPK.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM Praca WHERE pracaPK.cdCondominio = '" + equipamentoPK.getCdCondominio()
                    + "'";
            //listPraca = pc.consultaHQL(hql);
        }
        return listPraca;
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
        List<Equipamento> lista = list();
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
        equipamento = new Equipamento();
        equipamentoPK = new EquipamentoPK();
        return atual;
    }

    /**
     * Criado um novo registro no banco de dados
     *
     * @return retorna a página atual que requisitou
     */
    public String adicionaRegistro() {
        setActiveIndex(0);
        dat.setData("");
        equipamento.setEquipamentoPK(equipamentoPK);
        equipamento.setUsuarioCadastro(getUsuarioConectado());
        equipamento.setDataCadastro(Date.valueOf(dat.getData()));
        equipamento.setHoraCadastro(Time.valueOf(hs.getHora()));
        create(equipamento);
        setMsg("Registro criado com sucesso!");
        adicionarForm();
        return atual;
    }

    /**
     * Escluir o registro selecionado
     *
     * @return retonar a página atual que requisitou
     */
    public String excluirRegistro() {
        setActiveIndex(0);
        Equipamento e = getById(equipamentoPK);
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
        System.out.println("com.condomino.controle.EquipamentoContoller.editarRegistro()");
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
        equipamento.setNome(getNomeEquipamento());
        equipamento.setSituacao(getSituacaEquipamento());
        equipamento.setDataModificacao(Date.valueOf(dat.getData()));
        equipamento.setHoraModificacao(Time.valueOf(hs.getHora()));
        save(equipamento);
        adicionarForm();
        return atual;
    }

    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Equipamento) e.getObject()).getEquipamentoPK().toString());
        equipamento = getById(((Equipamento) e.getObject()).getEquipamentoPK());
        equipamentoPK.setCdCondominio(equipamento.getEquipamentoPK().getCdCondominio());
        equipamentoPK.setCdPraca(equipamento.getEquipamentoPK().getCdPraca());
        equipamentoPK.setCdEquipamento(equipamento.getEquipamentoPK().getCdEquipamento());
        setNomeEquipamento(equipamento.getNome());
        setSituacaEquipamento(equipamento.getSituacao());
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
