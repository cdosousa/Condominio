/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.domain.Condominio;
import com.condomino.repositories.CondominioRepository;
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
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @Local..: OICI Serviços e Desenvolvimento Ltda - EPP
 * @Data...: 12/06/2019
 */
@ManagedBean(name = "condominioController")
@SessionScoped
public class CondominioController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CondominioRepository cr;
    private final String menu = "MenuPrincipal";
    private final String listar = "Condominio.xhtml";
    private final String adicionar = "CondominioAdicionar.xhtml";
    private final String editar = "CondominioEditar.xhtml";
    private Integer activIndex = 0;

    private DataSistema dat;
    private HoraSistema hs;
    private Condominio condominio;
    private DataModel<Condominio> listarCondominio;
    private List<SituacaoCadastral> enumSituacao;
    
    @PostConstruct
    public void init() {
        condominio = new Condominio();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public DataModel<Condominio> getListarCondominio() {
        List<Condominio> lista = cr.list();
        listarCondominio = new ListDataModel<Condominio>(lista);
        return listarCondominio;
    }

    public void setListarCondominio(DataModel<Condominio> listarCondominio) {
        this.listarCondominio = listarCondominio;
    }

    public List<SituacaoCadastral> getEnumSituacao() {
        return enumSituacao;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
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

    public String adicionaForm() {
        setActivIndex(2);
        condominio = new Condominio();
        return adicionar;
    }

    public String adicionaRegistro() {
        setActivIndex(0);
        dat.setData("");
        condominio.setDataCadastro(Date.valueOf(dat.getData()));
        condominio.setHoraCadastro(Time.valueOf(hs.getHora()));
        cr.create(condominio);
        return listar;
    }
    
    public String excluirRegistro() {
        setActivIndex(0);
        Condominio c = cr.getById(condominio.getCdCondominio());
        cr.delete(c);
        return listar;
    }

    public String editarRegistro(){
        setActivIndex(1);
        return editar;
    }
    
    public String salvarRegistro(){
        dat = new DataSistema();
        hs =  new HoraSistema();
        setActivIndex(0);
        dat.setData("");
        condominio.setDataModificacao(Date.valueOf(dat.getData()));
        condominio.setHoraModificacao(Time.valueOf(hs.getHora()));
        cr.save(condominio);
        return listar;
    }

    public void onRowSelect(SelectEvent e){
        System.out.println("Linha Selecionada: " + ((Condominio) e.getObject()).getCdCondominio().toString());
    }
}