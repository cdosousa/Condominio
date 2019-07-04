/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.dao.AcessoBancoDAO;
import com.condomino.domain.Condominio;
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
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @Criação 27/06/2019
 * @Local OICI Serviços e Desenvolvimento Ltda-EPP
 */
@ManagedBean(name = "pracaController")
@SessionScoped
public class PracaController extends AcessoBancoDAO<Praca, Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final String menu = "MenuPrincipal.xhtml";
    private final String atual = "Praca.xhtml";
    private String usuarioConectado;
    private String nomeCondominio = "";
    private Integer situacao = 1;
    private Integer activeIndex = 0;
    private List<Condominio> listCondominio;
    private CondominioController cc;
    
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
    public void init(){
        dat =  new DataSistema();
        hs = new HoraSistema();
        pracaSelecionada = new Praca();
        pracaPKSelecionada = new PracaPK();
        pracaPK = new PracaPK();
        praca = new Praca();
        cc = new CondominioController();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
        listCondominio = cc.list();
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
        List<Praca> lista = list();
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
     * @return the nomeCondominio
     */
    public String getNomeCondominio() {
        return nomeCondominio;
    }

    /**
     * @param nomeCondominio the nomeCondominio to set
     */
    public void setNomeCondominio(String nomeCondominio) {
        this.nomeCondominio = nomeCondominio;
    }

    /**
     * @return the situacao
     */
    public Integer getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the listCondominio
     */
    public List<Condominio> getListCondominio() {
        return listCondominio;
    }
    
    public String adicionaForm(){
        praca = new Praca();
        pracaPK = new PracaPK();
        return atual;
    }
    
    public String adicionaRegistro(){
        setActiveIndex(0);
        dat.setData("");
        praca.setPracaPK(pracaPK);
        praca.setUsuarioCadastro(getUsuarioConectado());
        praca.setDataCadastro(Date.valueOf(dat.getData()));
        praca.setHoraCadastro(Time.valueOf(hs.getHora()));
        create(praca);
        setMsg("Registro salvo com sucesso!");
        adicionaForm();
        return atual;
    }
    
    public String excluirRegistro(){
        setActiveIndex(0);
        Praca p = getById(pracaPK);
        delete(p);
        setMsg("Registro excluído com sucesso!");
        return atual;
    }
    
    public String editarRegistro(){
        setActiveIndex(1);
        return "pracaEditar.xhtml";
    }
    
    public String salvarRegistro(){
        setActiveIndex(0);
        dat.setData("");
        praca.setNome(getNomeCondominio());
        praca.setSituacao(getSituacao());
        praca.setDataModificacao(Date.valueOf(dat.getData()));
        praca.setHoraModificacao(Time.valueOf(hs.getHora()));
        save(praca);
        adicionaForm();
        return atual;
    }
    
    public void onRowSelect(SelectEvent e){
        System.out.println("Linha Selecionada: " + ((Praca) e.getObject()).getPracaPK().toString());
        praca = getById(((Praca) e.getObject()).getPracaPK());
        pracaPK.setCdCondominio(praca.getPracaPK().getCdCondominio());
        pracaPK.setCdPraca(praca.getPracaPK().getCdPraca());
        setNomeCondominio(praca.getNome());
        setSituacao(praca.getSituacao());
        System.out.println("Objeto Praca: " + praca.toString());
    }
}
