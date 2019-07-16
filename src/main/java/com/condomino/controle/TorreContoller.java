/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.dao.AcessoBancoDAO;
import com.condomino.domain.Condominio;
import com.condomino.domain.Torre;
import com.condomino.domain.TorrePK;
import com.condomino.domain.Praca;
import com.condomino.domain.PracaPK;
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
 * @data 03/07/2019
 */
@ManagedBean(name = "torreController")
@SessionScoped
public class TorreContoller extends AcessoBancoDAO<Torre, Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String anterior = "MenuPrincipal.xhtml";
    private final String atual = "Torre.xhtml";
    private final String adicionar = "TorreAdicionar.xhtml";
    private final String editar = "TorreEditar.xhtml";

    /**
     * Variáveis para edição do registro
     */
    private String usuarioConectado;
    private String nomeTorre;
    private String cdPraca;
    private Integer situacaTorre;
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
    private Torre torreSelecinado;
    private TorrePK torreSelecinadoPK;
    private Torre torre;
    private TorrePK torrePK;
    private DataModel<Torre> listarTorre;
    private List<SituacaoCadastral> enumSituacao;

    @PostConstruct
    public void init() {
        dat = new DataSistema();
        hs = new HoraSistema();
        setTorreSelecinado(new Torre());
        setTorreSelecinadoPK(new TorrePK());
        setTorre(new Torre());
        setTorrePK(new TorrePK());
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
     * @return the nomeTorre
     */
    public String getNomeTorre() {
        return nomeTorre;
    }

    /**
     * @param nomeTorre the nomeTorre to set
     */
    public void setNomeTorre(String nomeTorre) {
        this.nomeTorre = nomeTorre;
    }

    /**
     * @return the cdPraca
     */
    public String getCdPraca() {
        return cdPraca;
    }

    /**
     * @param cdPraca the cdPraca to set
     */
    public void setCdPraca(String cdPraca) {
        this.cdPraca = cdPraca;
    }

    /**
     * @return the situacaTorre
     */
    public Integer getSituacaTorre() {
        return situacaTorre;
    }

    /**
     * @param situacaTorre the situacaTorre to set
     */
    public void setSituacaTorre(Integer situacaTorre) {
        this.situacaTorre = situacaTorre;
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
        //listCondominio = cc.list();
        return listCondominio;
    }

    /**
     * @return the listPraca
     */
    public List<Praca> getListPraca() {
        if (torrePK.getCdCondominio() != null && !torrePK.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM Praca WHERE pracaPK.cdCondominio = '" + torrePK.getCdCondominio()
                    + "'";
            listPraca = pc.consultaHQL(hql);
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
     * @return the torreSelecinado
     */
    public Torre getTorreSelecinado() {
        return torreSelecinado;
    }

    /**
     * @param torreSelecinado the torreSelecinado to set
     */
    public void setTorreSelecinado(Torre torreSelecinado) {
        this.torreSelecinado = torreSelecinado;
    }

    /**
     * @return the torreSelecinadoPK
     */
    public TorrePK getTorreSelecinadoPK() {
        return torreSelecinadoPK;
    }

    /**
     * @param torreSelecinadoPK the torreSelecinadoPK to set
     */
    public void setTorreSelecinadoPK(TorrePK torreSelecinadoPK) {
        this.torreSelecinadoPK = torreSelecinadoPK;
    }

    /**
     * @return the torre
     */
    public Torre getTorre() {
        return torre;
    }

    /**
     * @param torre the torre to set
     */
    public void setTorre(Torre torre) {
        this.torre = torre;
    }

    /**
     * @return the torrePK
     */
    public TorrePK getTorrePK() {
        return torrePK;
    }

    /**
     * @param torrePK the torrePK to set
     */
    public void setTorrePK(TorrePK torrePK) {
        this.torrePK = torrePK;
    }

    /**
     * @return the listarTorre
     */
    public DataModel<Torre> getListarTorre() {
        List<Torre> lista = list();
        listarTorre = new ListDataModel<Torre>(lista);
        return listarTorre;
    }

    /**
     * @param listarTorre the listarTorre to set
     */
    public void setListarTorre(DataModel<Torre> listarTorre) {
        this.listarTorre = listarTorre;
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
        torre = new Torre();
        torrePK = new TorrePK();
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
        PracaPK pracaPK = new PracaPK(torrePK.getCdCondominio(), cdPraca);
        torre.setTorrePK(torrePK);
        torre.setPraca(pc.getById(pracaPK));
        torre.setCdPraca(pracaPK.getCdPraca());
        torre.setUsuarioCadastro(getUsuarioConectado());
        torre.setDataCadastro(Date.valueOf(dat.getData()));
        torre.setHoraCadastro(Time.valueOf(hs.getHora()));
        create(torre);
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
        Torre e = getById(torrePK);
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
        System.out.println("com.condomino.controle.TorreContoller.editarRegistro()");
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
        PracaPK pracaPK = new PracaPK(torrePK.getCdCondominio(), cdPraca);
        torre.setNome(getNomeTorre());
        torre.setPraca(pc.getById(pracaPK));
        torre.setCdPraca(pracaPK.getCdPraca());
        torre.setSituacao(getSituacaTorre());
        torre.setDataModificacao(Date.valueOf(dat.getData()));
        torre.setHoraModificacao(Time.valueOf(hs.getHora()));
        save(torre);
        return atual;
    }

    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Torre) e.getObject()).getTorrePK().toString());
        torre = getById(((Torre) e.getObject()).getTorrePK());
        torrePK.setCdCondominio(torre.getTorrePK().getCdCondominio());
        torrePK.setCdTorre(torre.getTorrePK().getCdTorre());
        setNomeTorre(torre.getNome());
        setCdPraca(torre.getPraca().getPracaPK().getCdPraca());
        setSituacaTorre(torre.getSituacao());
        System.out.println("Objeto Torre: " + torre.toString());
    }

    /**
     * Evento que obter o valor trocado do condominio e buscar a praca de acordo
     * com o registro
     */
    public void onCondominoChange() {
        System.out.println("Condominio trocado: " + torrePK.getCdCondominio());
        getListPraca();
    }
}