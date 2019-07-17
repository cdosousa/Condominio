/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.domain.Condominio;
import com.condomino.domain.Praca;
import com.condomino.domain.PracaPK;
import com.condomino.repositories.CondominioRepository;
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
 * @Criação 27/06/2019
 * @Local OICI Serviços e Desenvolvimento Ltda-EPP
 */
@ManagedBean(name = "pracaController")
@SessionScoped
public class PracaController implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Objetos com injeção de dependência
     */
    @Inject
    private CondominioRepository cr;
    @Inject
    private PracaRepository pr;

    /**
     * Variáveis de instância do controller
     */
    private final String menu = "MenuPrincipal.xhtml";
    private final String listar = "Praca.xhtml";
    private final String adicionar = "PracaAdicionar.xhtml";
    private final String editar = "PracaEditar.xhtml";
    //private String usuarioConectado;
    //private String nomePraca = "";
    //private Integer situacao = 1;
    private Integer activeIndex = 0;
    private List<Condominio> listCondominio;

    private DataSistema dat;
    private HoraSistema hs;
    private Praca pracaSelecionada;
    private Praca praca;
    private PracaPK pracaPKSelecionada;
    private PracaPK pracaPK;
    private DataModel<Praca> listarPraca;
    private List<SituacaoCadastral> enumSituacao;
    private String msg;

    @PostConstruct
    public void init() {
        dat = new DataSistema();
        hs = new HoraSistema();
        praca = new Praca();
        pracaPK = new PracaPK();
        pracaSelecionada = new Praca();
        pracaPKSelecionada = new PracaPK();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
    }

    public Praca getPracaSelecionada() {
        return pracaSelecionada;
    }

    public void setPracaSelecionada(Praca pracaSelecionada) {
        this.pracaSelecionada = pracaSelecionada;
    }

    public Praca getPraca() {
        return praca;
    }

    public void setPraca(Praca praca) {
        this.praca = praca;
    }

    public PracaPK getPracaPKSelecionada() {
        return pracaPKSelecionada;
    }

    public void setPracaSelecionadaPK(PracaPK pracaPK) {
        this.pracaPKSelecionada = pracaPK;
    }

    /**
     * @return the pracaPK
     */
    public PracaPK getPracaPK() {
        return pracaPK;
    }

    /**
     * @param pracaPK the pracaPK to set
     */
    public void setPracaPK(PracaPK pracaPK) {
        this.pracaPK = pracaPK;
    }

    public DataModel<Praca> getListarPraca() {
        List<Praca> lista = pr.list();
        listarPraca = new ListDataModel<Praca>(lista);
        return listarPraca;
    }

    public void setListarPraca(DataModel<Praca> listarPraca) {
        this.listarPraca = listarPraca;
    }

    public List<SituacaoCadastral> getEnumSituacao() {
        return enumSituacao;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getActiveIndex() {
        return activeIndex;
    }

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

    public String adicionaForm() {
        setActiveIndex(2);
        praca = new Praca();
        pracaPK = new PracaPK();
        return adicionar;
    }

    public String adicionaRegistro() {
        setActiveIndex(0);
        dat.setData("");
        praca.setPracaPK(pracaPK);
        praca.setDataCadastro(Date.valueOf(dat.getData()));
        praca.setHoraCadastro(Time.valueOf(hs.getHora()));
        pr.create(praca);
        setMsg("Registro salvo com sucesso!");
        return listar;
    }

    public String excluirRegistro() {
        setActiveIndex(0);
        Praca p = pr.getById(pracaPK);
        pr.delete(p);
        setMsg("Registro excluído com sucesso!");
        return listar;
    }

    public String editarRegistro() {
        setActiveIndex(1);
        return editar;
    }

    public String salvarRegistro() {
        setActiveIndex(0);
        dat.setData("");
        praca.setDataModificacao(Date.valueOf(dat.getData()));
        praca.setHoraModificacao(Time.valueOf(hs.getHora()));
        pr.save(praca);
        return listar;
    }

    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Praca) e.getObject()).getPracaPK().toString());
        praca = pr.getById(((Praca) e.getObject()).getPracaPK());
        setPracaPK(praca.getPracaPK());
        System.out.println("Objeto Praca: " + praca.toString());
    }
}
