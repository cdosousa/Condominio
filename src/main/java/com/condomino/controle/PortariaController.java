/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.dao.AcessoBancoDAO;
import com.condomino.domain.Condominio;
import com.condomino.domain.Portaria;
import com.condomino.domain.PortariaPK;
import com.parametros.modelo.DataSistema;
import com.parametros.modelo.HoraSistema;
import com.parametros.modelo.enums.PortariaTipo;
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
 * @Criação 03/07/2019
 * @Local OICI Serviços e Desenvolvimento Ltda-EPP
 */
@ManagedBean(name = "portariaController")
@SessionScoped
public class PortariaController extends AcessoBancoDAO<Portaria, Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final String menu = "MenuPrincipal.xhtml";
    private final String atual = "Portaria.xhtml";
    private String usuarioConectado;
    private String nomePortaria = "";
    private Integer situacaoPortaria = 1;
    private Integer tipoPortaria = 1;
    private Integer activeIndex = 0;
    private List<Condominio> listCondominio;
    private CondominioController cc;
    
    private DataSistema dat;
    private HoraSistema hs;
    private Portaria portariaSelecionada;
    private Portaria portaria;
    private PortariaPK portariaPKSelecionada;
    private PortariaPK portariaPK;
    private DataModel<Portaria> listarPortaria;
    private List<SituacaoCadastral> enumSituacao;
    private List<PortariaTipo> enumTipo;
    private String msg;
    
    @PostConstruct
    public void init(){
        dat =  new DataSistema();
        hs = new HoraSistema();
        portariaSelecionada = new Portaria();
        portariaPKSelecionada = new PortariaPK();
        portariaPK = new PortariaPK();
        portaria = new Portaria();
        cc = new CondominioController();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
        enumTipo = Arrays.asList(PortariaTipo.values());
        listCondominio = cc.list();
    }

    public Portaria getPortariaSelecionada() {
        return portariaSelecionada;
    }

    public void setPortariaSelecionada(Portaria portariaSelecionada) {
        this.portariaSelecionada = portariaSelecionada;
    }

    public Portaria getPortaria() {
        return portaria;
    }

    public void setPortaria(Portaria portaria) {
        this.portaria = portaria;
    }

    public PortariaPK getPortariaPKSelecionada() {
        return portariaPKSelecionada;
    }

    public void setPortariaSelecionadaPK(PortariaPK portariaPK) {
        this.portariaPKSelecionada = portariaPK;
    }

    /**
     * @return the portariaPK
     */
    public PortariaPK getPortariaPK() {
        return portariaPK;
    }

    /**
     * @param portariaPK the portariaPK to set
     */
    public void setPortariaPK(PortariaPK portariaPK) {
        this.portariaPK = portariaPK;
    }
    
    
    public DataModel<Portaria> getListarPortaria() {
        List<Portaria> lista = list();
        listarPortaria = new ListDataModel<Portaria>(lista);
        return listarPortaria;
    }

    public void setListarPortaria(DataModel<Portaria> listarPortaria) {
        this.listarPortaria = listarPortaria;
    }

    public List<SituacaoCadastral> getEnumSituacao() {
        return enumSituacao;
    }

    public List<PortariaTipo> getEnumTipo() {
        return enumTipo;
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
     * @return the nomePortaria
     */
    public String getNomePortaria() {
        return nomePortaria;
    }

    /**
     * @param nomePortaria the nomePortaria to set
     */
    public void setNomePortaria(String nomePortaria) {
        this.nomePortaria = nomePortaria;
    }

    /**
     * @return the situacaoPortaria
     */
    public Integer getSituacaoPortaria() {
        return situacaoPortaria;
    }

    /**
     * @param situacaoPortaria the situacaoPortaria to set
     */
    public void setSituacaoPortaria(Integer situacaoPortaria) {
        this.situacaoPortaria = situacaoPortaria;
    }

    /**
     * @return the tipoPortaria
     */
    public Integer getTipoPortaria() {
        return tipoPortaria;
    }

    /**
     * @param tipoPortaria the tipoPortaria to set
     */
    public void setTipoPortaria(Integer tipoPortaria) {
        this.tipoPortaria = tipoPortaria;
    }

    /**
     * @return the listCondominio
     */
    public List<Condominio> getListCondominio() {
        return listCondominio;
    }
    
    public void adicionaForm(){
        portaria = new Portaria();
        portariaPK = new PortariaPK();
    }
    
    public String adicionaRegistro(){
        setActiveIndex(0);
        dat.setData("");
        portaria.setPortariaPK(portariaPK);
        portaria.setUsuarioCadastro(getUsuarioConectado());
        portaria.setDataCadastro(Date.valueOf(dat.getData()));
        portaria.setHoraCadastro(Time.valueOf(hs.getHora()));
        create(portaria);
        setMsg("Registro salvo com sucesso!");
        adicionaForm();
        return atual;
    }
    
    public String excluirRegistro(){
        setActiveIndex(0);
        Portaria p = getById(portariaPK);
        delete(p);
        setMsg("Registro excluído com sucesso!");
        adicionaForm();
        return atual;
    }
    
    public String editarRegistro(){
        setActiveIndex(1);
        return "Portaria.xhtml";
    }
    
    public String salvarRegistro(){
        setActiveIndex(0);
        dat.setData("");
        portaria.setNome(getNomePortaria());
        portaria.setSituacao(getSituacaoPortaria());
        portaria.setTipo(getTipoPortaria());
        portaria.setDataModificacao(Date.valueOf(dat.getData()));
        portaria.setHoraModificacao(Time.valueOf(hs.getHora()));
        save(portaria);
        adicionaForm();
        return atual;
    }
    
    public void onRowSelect(SelectEvent e){
        System.out.println("Linha Selecionada: " + ((Portaria) e.getObject()).getPortariaPK().toString());
        portaria = getById(((Portaria) e.getObject()).getPortariaPK());
        portariaPK.setCdCondominio(portaria.getPortariaPK().getCdCondominio());
        portariaPK.setCdPortaria(portaria.getPortariaPK().getCdPortaria());
        setNomePortaria(portaria.getNome());
        setSituacaoPortaria(portaria.getSituacao());
        System.out.println("Objeto Portaria: " + portaria.toString());
    }
}