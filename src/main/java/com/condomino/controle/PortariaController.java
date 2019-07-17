/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.domain.Condominio;
import com.condomino.domain.Portaria;
import com.condomino.domain.PortariaPK;
import com.condomino.repositories.CondominioRepository;
import com.condomino.repositories.PortariaRepository;
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
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @Criação 03/07/2019
 * @Local OICI Serviços e Desenvolvimento Ltda-EPP
 */
@ManagedBean(name = "portariaController")
@SessionScoped
public class PortariaController implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Ojetos com injeção de dependência da classe
     */
    @Inject
    private CondominioRepository cr;
    @Inject
    private PortariaRepository pr;

    /**
     * Variáveis de Intância da classe
     */
    private final String listar = "Portaria.xhtml";
    private final String adicionar = "PortariaAdicionar.xhtml";
    private final String editar = "PortariaEditar.xhtml";
    private Integer activeIndex = 0;

    /**
     * Objetos de instância da classe
     */
    private DataSistema dat;
    private HoraSistema hs;
    private Portaria portaria;
    private PortariaPK portariaPK;
    private Portaria portariaSelecionada;
    private PortariaPK portariaPKSelecionada;
    private DataModel<Portaria> listarPortaria;
    private List<Condominio> listCondominio;
    private List<SituacaoCadastral> enumSituacao;
    private List<PortariaTipo> enumTipo;

    @PostConstruct
    public void init() {
        portariaSelecionada = new Portaria();
        portariaPKSelecionada = new PortariaPK();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
        enumTipo = Arrays.asList(PortariaTipo.values());
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
        List<Portaria> lista = pr.list();
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
    
    public String getTipoPortaria(Integer cod){
        return PortariaTipo.toEnum(cod).getDescricao();
    }

    public String adicionaForm() {
        setActiveIndex(2);
        portaria = new Portaria();
        portariaPK = new PortariaPK();
        return adicionar;
    }

    public String adicionaRegistro() {
        setActiveIndex(0);
        dat = new DataSistema();
        hs = new HoraSistema();
        dat.setData("");
        portaria.setPortariaPK(portariaPK);
        portaria.setDataCadastro(Date.valueOf(dat.getData()));
        portaria.setHoraCadastro(Time.valueOf(hs.getHora()));
        pr.create(portaria);
        return listar;
    }

    public String excluirRegistro() {
        setActiveIndex(0);
        Portaria p = pr.getById(portariaPK);
        pr.delete(p);
        return listar;
    }

    public String editarRegistro() {
        setActiveIndex(1);
        return editar;
    }

    public String salvarRegistro() {
        setActiveIndex(0);
        dat = new DataSistema();
        hs = new HoraSistema();
        dat.setData("");
        portaria.setDataModificacao(Date.valueOf(dat.getData()));
        portaria.setHoraModificacao(Time.valueOf(hs.getHora()));
        pr.save(portaria);
        return listar;
    }

    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Portaria) e.getObject()).getPortariaPK().toString());
        portaria = pr.getById(((Portaria) e.getObject()).getPortariaPK());
        setPortariaPK(portaria.getPortariaPK());
        System.out.println("Objeto Portaria: " + portaria.toString());
    }
}