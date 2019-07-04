/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.dao.AcessoBancoDAO;
import com.condomino.domain.Usuarios;
import com.parametros.modelo.DataSistema;
import com.parametros.modelo.HoraSistema;
import com.parametros.modelo.SessaoUsuario;
import com.parametros.modelo.enums.SituacaoCadastral;
import java.io.Serializable;
import java.sql.Date;
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
@ManagedBean(name = "usuariosController")
@SessionScoped
public class UsuariosController extends AcessoBancoDAO<Usuarios, Serializable> implements Serializable{

    private Usuarios usuarios;
    private DataModel<Usuarios> listarUsuarios;
    private List<SituacaoCadastral> enumSituacao;
    private static SessaoUsuario su;
    private String msg;

    @PostConstruct
    public void init() {
        usuarios = new Usuarios();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
    }

    /**
     * @return the usuarios
     */
    public Usuarios getUsuarios() {
        return usuarios;
    }

    /**
     * @return the listarUsuarios
     */
    public DataModel<Usuarios> getListarUsuarios() {
        List<Usuarios> lista = list();
        listarUsuarios = new ListDataModel<Usuarios>(lista);
        return listarUsuarios;
    }

    /**
     * @param listarMenus the listarMenus to set
     */
    public void setListarMenus(DataModel<Usuarios> listarMenus) {
        this.listarUsuarios = listarMenus;
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

    public String adicionaForm() {
        usuarios = new Usuarios();
        return "inserirMenu";
    }

    public String excluirUsuarios() {
        Usuarios u = (Usuarios) (listarUsuarios.getRowData());
        delete(u);
        setMsg("Excluído com sucesso");
        return "";
    }

    public String adicionarUsuario() {
        FacesContext fc = FacesContext.getCurrentInstance();
        DataSistema dat = new DataSistema();
        HoraSistema hs = new HoraSistema();
        dat.setData("");
        usuarios.setDataCadastro(Date.valueOf(dat.getData()));
        usuarios.setSituacao(Integer.valueOf(fc.getAttributes().get("lblSituacao").toString().substring(0, 1)));
        create(usuarios);
        setMsg("Salvo com sucesso!");
        return "";
    }

    public String validaUsuario() {
        String login = usuarios.getLogin();
        String senha = convertToMd5(usuarios.getSenha());
        System.out.println("Usuario: " + login);
        usuarios = getById(login);
        if (usuarios != null) {
            if (!usuarios.getSenha().equals(senha)) {
                setMsg("Usuário ou senha inválido!");
                return "login";
            }else{
                su = new SessaoUsuario();
                su.setUsuarioConectado(login);
                su.setSenha(senha);
                su.setSessaoUsuario(String.format("%s%s", senha,login));
                System.out.println("Redirecionando para o Menu Principal");
                return "MenuPrincipal";
            }
        } else {
            return "login";
        }
    }

    /**
     * @return the enumSituacao
     */
    public List<SituacaoCadastral> getEnumSituacao() {
        return enumSituacao;
    }
}
