/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.domain.Condominio;
import com.condomino.domain.Torre;
import com.condomino.domain.TorrePK;
import com.condomino.domain.Praca;
import com.condomino.repositories.CondominioRepository;
import com.condomino.repositories.PracaRepository;
import com.condomino.repositories.TorreRepository;
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
public class TorreContoller implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Objetos com injeção de dependência na classe
     */
    @Inject
    private TorreRepository tr;
    @Inject
    private CondominioRepository cr;
    @Inject
    private PracaRepository pr;
    
    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String listar = "Torre.xhtml";
    private final String adicionar = "TorreAdicionar.xhtml";
    private final String editar = "TorreEditar.xhtml";

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
    private Torre torre;
    private TorrePK torrePK;
    private Torre torreSelecinado;
    private TorrePK torreSelecinadoPK;
    private DataModel<Torre> listarTorre;
    private List<SituacaoCadastral> enumSituacao;

    @PostConstruct
    public void init() {
        setTorreSelecinado(new Torre());
        setTorreSelecinadoPK(new TorrePK());
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
        if (torrePK.getCdCondominio() != null && !torrePK.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM Praca WHERE pracaPK.cdCondominio = '" + torrePK.getCdCondominio()
                    + "'";
            listPraca = pr.consultaHQL(hql);
            System.out.println("Buscando Praca");
        }
        return listPraca;
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
        List<Torre> lista = tr.list();
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
        dat = new DataSistema();
        hs = new HoraSistema();
        dat.setData("");
        torre.setTorrePK(torrePK);
        torre.setDataCadastro(Date.valueOf(dat.getData()));
        torre.setHoraCadastro(Time.valueOf(hs.getHora()));
        tr.create(torre);
        return listar;
    }

    /**
     * Escluir o registro selecionado
     *
     * @return retonar a página atual que requisitou
     */
    public String excluirRegistro() {
        setActiveIndex(0);
        Torre e = tr.getById(torrePK);
        tr.delete(e);
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
        torre.setDataModificacao(Date.valueOf(dat.getData()));
        torre.setHoraModificacao(Time.valueOf(hs.getHora()));
        tr.save(torre);
        return listar;
    }

    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Torre) e.getObject()).getTorrePK().toString());
        torre = tr.getById(((Torre) e.getObject()).getTorrePK());
        setTorrePK(torre.getTorrePK());
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