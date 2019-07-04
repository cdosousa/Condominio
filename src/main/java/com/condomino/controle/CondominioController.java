/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.dao.AcessoBancoDAO;
import com.condomino.domain.Condominio;
import com.parametros.modelo.DataSistema;
import com.parametros.modelo.HoraSistema;
import com.parametros.modelo.SessaoUsuario;
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
 * @author Cristiano de Oliveira Sousa
 * @Local..: OICI Serviços e Desenvolvimento Ltda - EPP
 * @Data...: 12/06/2019
 */
@ManagedBean(name = "condominioController")
@SessionScoped
public class CondominioController extends AcessoBancoDAO<Condominio, Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final String inserir = "Condominio";
    private final String listar = "MenuPrincipal";
    private Integer activIndex;

    private DataSistema dat;
    private HoraSistema hs;
    private Condominio condominio;
    private DataModel<Condominio> listarCondominio;
    private List<SituacaoCadastral> enumSituacao;
    private static SessaoUsuario su;
    private String msg;
    private String columnTemplate = "codigo nome logradouro numero complemento bairro municipio uf";

    @PostConstruct
    public void init() {
        dat = new DataSistema();
        hs = new HoraSistema();
        condominio = new Condominio();
        activIndex = 0;
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public DataModel<Condominio> getListarCondominio() {
        List<Condominio> lista = list();
        listarCondominio = new ListDataModel<Condominio>(lista);
        return listarCondominio;
    }

    public void setListarCondominio(DataModel<Condominio> listarCondominio) {
        this.listarCondominio = listarCondominio;
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
    
    public void setUsuarioCadastro(String usuarioCadastro){
        condominio.setUsuarioCadastro(usuarioCadastro);
    }

    /**
     * @return the activIndex
     */
    public Integer getActivIndex() {
        return activIndex;
    }

    /**
     * @param activIndex the activIndex to set
     */
    public void setActivIndex(Integer activIndex) {
        this.activIndex = activIndex;
    }

    /**
     * @return the columnTemplate
     */
    public String getColumnTemplate() {
        return columnTemplate;
    }

    /**
     * @param columnTemplate the columnTemplate to set
     */
    public void setColumnTemplate(String columnTemplate) {
        this.columnTemplate = columnTemplate;
    }

    public String adicionaForm() {
        condominio = new Condominio();
        return inserir;
    }

    public String excluirRegistro() {
        Condominio c = (Condominio) (listarCondominio.getRowData());
        delete(c);
        setMsg("Registro Excluído com sucesso!");
        return listar;
    }

    public String adicionaRegistro() {
        System.out.println("Vamos salvar o registro!");
        FacesContext fc = FacesContext.getCurrentInstance();
        System.out.println("Login: " + fc.getAttributes().get("txtLogin"));
        System.out.println("Situação: " + fc.getAttributes().get("txtSituacao"));
        System.out.println("Situação: " + enumSituacao.lastIndexOf(fc));
        dat.setData("");
        //condominio.setUsuarioCadastro(su.getUsuarioConectado());
        condominio.setDataCadastro(Date.valueOf(dat.getData()));
        condominio.setHoraCadastro(Time.valueOf(hs.getHora()));
        create(condominio);
        setActivIndex(0);
        setMsg("Registro salvo com sucesso!");
        return "MenuPrincipal";
    }
    
    public String editarRegistro(){
        setActivIndex(1);
        return "Condominio.xhtml";
    }
}