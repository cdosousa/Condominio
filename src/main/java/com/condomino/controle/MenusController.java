/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.dao.AcessoBancoDAO;
import com.condomino.domain.Menus;
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
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Cristiano de Oliveira Sousa criado em 20/05/2019
 */
@ManagedBean(name = "menusController")
@SessionScoped
public class MenusController extends AcessoBancoDAO<Menus, Serializable> {

    private Menus menus;
    private DataModel<Menus> listarMenus;
    private List<SituacaoCadastral> enumSituacao;
    private String msg;

    @PostConstruct
    public void init(){
        menus = new Menus();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
    }
    
    /**
     * @return the menus
     */
    public Menus getMenus() {
        return menus;
    }

    /**
     * @return the listarMenus
     */
    public DataModel<Menus> getListarMenus() {
        List<Menus> lista = list();
        listarMenus = new ListDataModel<Menus>(lista);
        return listarMenus;
    }

    /**
     * @param listarMenus the listarMenus to set
     */
    public void setListarMenus(DataModel<Menus> listarMenus) {
        this.listarMenus = listarMenus;
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
    
    public String adicionaForm(){
        menus = new Menus();
        return "inserirMenu";
    }
    
    public String excluirMenu(){
        Menus m = (Menus) (listarMenus.getRowData());
        delete(m);
        setMsg("Excluído com sucesso");
        return "listarMenu.xhtml";
    }
    
    public String adicionarMenu(){
        FacesContext fc = FacesContext.getCurrentInstance();
        DataSistema dat = new DataSistema();
        HoraSistema hs = new HoraSistema();
        dat.setData("");
        menus.setDataCadastro(Date.valueOf(dat.getData()));
        menus.setHoraCadastro(Time.valueOf(hs.getHora()));
        menus.setSituacao((SituacaoCadastral)fc.getAttributes().get("situacao"));
        create(menus);
        setMsg("Salvo com sucesso!");
        return "listarMenu";
    }

    /**
     * @return the enumSituacao
     */
    public List<SituacaoCadastral> getEnumSituacao() {
        return enumSituacao;
    }
}