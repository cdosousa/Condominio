/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.dao.AcessoBancoDAO;
import com.condomino.domain.Condominio;
import com.condomino.domain.Condomino;
import com.condomino.domain.CondominoPK;
import com.condomino.domain.Torre;
import com.condomino.domain.Unidade;
import com.parametros.modelo.DataSistema;
import com.parametros.modelo.HoraSistema;
import com.parametros.modelo.enums.GrauParentesco;
import com.parametros.modelo.enums.Sexo;
import com.parametros.modelo.enums.SituacaoCadastral;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data 16/07/2019
 */
@ManagedBean(name = "moradorController")
@SessionScoped
public class MoradorController implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * Objetos injetados na classe
     */
    @EJB
    private AcessoBancoDAO<Condomino, Serializable> dao;
    @EJB
    private CondominioController cc;
    @EJB
    private TorreContoller tc;
    @EJB
    private UnidadeContoller uc;

    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String atual = "Morador.xhtml";
    private final String adicionar = "MoradorAdicionar.xhtml";
    private final String editar = "MoradorEditar.xhtml";

    /**
     * Variáveis de contexto para manipulação da classe
     */
    private Integer activeIndex = 0;

    /**
     * Objetos de intância para edição dos registro
     */
    private Condomino morador;
    private CondominoPK moradorPK;
    private List<Condominio> listCondominio;
    private List<Torre> listTorre;
    private List<Unidade> listUnidade;
    private List<SituacaoCadastral> enumSituacao;
    private List<GrauParentesco> enumGrauParentesco;
    private List<Sexo> enumSexo;
    private DataModel<Condomino> listarMorador;
    private DataSistema dat;
    private HoraSistema hs;

    @PostConstruct
    public void init() {
        dat = new DataSistema();
        hs = new HoraSistema();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
        enumGrauParentesco = Arrays.asList(GrauParentesco.values());
        enumSexo = Arrays.asList(Sexo.values());
    }

    /**
     * @return the morador
     */
    public Condomino getMorador() {
        return morador;
    }

    /**
     * @param morador the morador to set
     */
    public void setMorador(Condomino morador) {
        this.morador = morador;
    }

    /**
     * @return the moradorPK
     */
    public CondominoPK getMoradorPK() {
        return moradorPK;
    }

    /**
     * @param moradorPK the moradorPK to set
     */
    public void setMoradorPK(CondominoPK moradorPK) {
        this.moradorPK = moradorPK;
    }

    /**
     * @return the listarMorador
     */
    public DataModel<Condomino> getListarMorador() {
        List<Condomino> lista = dao.list();
        listarMorador = new ListDataModel<Condomino>(lista);
        return listarMorador;
    }

    /**
     * @param listarMorador the listarUnidade to set
     */
    public void setListarMorador(DataModel<Condomino> listarMorador) {
        this.listarMorador = listarMorador;
    }

    public Integer getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(Integer activeIndex) {
        this.activeIndex = activeIndex;
    }

    public List<Condominio> getListCondominio() {
        //listCondominio = cc.list();
        return listCondominio;
    }

    public List<Torre> getListTorre() {
        if (getMoradorPK().getCdCondominio() != null && !moradorPK.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM Condomino WHERE condominoPK.cdCondominio = '" + getMoradorPK().getCdCondominio()
                    + "'";
            listTorre = tc.consultaHQL(hql);
        }
        return listTorre;
    }

    public List<Unidade> getListUnidade() {
        if (getMoradorPK().getCdCondominio() != null && !moradorPK.getCdCondominio().trim().isEmpty()) {
            if (getMorador().getCdTorre() != null && !morador.getCdTorre().trim().isEmpty()) {
                String hql = "FROM Torre WHERE torrePK.cdCondominio = '" + getMoradorPK().getCdCondominio()
                        + "' AND torrePK.cdTorre = '" + getMorador().getCdTorre()
                        + "'";
                listTorre = tc.consultaHQL(hql);
            }
        }
        return listUnidade;
    }

    /**
     * @return the enumSituacao
     */
    public List<SituacaoCadastral> getEnumSituacao() {
        return enumSituacao;
    }

    /**
     * @return the enumGrauParentesco
     */
    public List<GrauParentesco> getEnumGrauParentesco() {
        return enumGrauParentesco;
    }

    /**
     * @return the enumSexo
     */
    public List<Sexo> getEnumSexo() {
        return enumSexo;
    }
    
    /**
     * Método que limpa os campos do formulário para inclusão de um novo
     * registro
     *
     * @return retorna a página atual que requisitou
     */
    public String adicionaForm(){
        setActiveIndex(2);
        morador = new Condomino();
        moradorPK =  new CondominoPK();
        return adicionar;
    }
    
    /**
     * Criado um novo registro no banco de dados
     *
     * @return retorna a página atual que requisitou
     */
    public String adicionaRegistro(){
        setActiveIndex(0);
        dat = new DataSistema();
        dat.setData("");
        morador.setCondominoPK(moradorPK);
        morador.setDataCadastro(Date.valueOf(dat.getData()));
        morador.setHoraCadastro(Time.valueOf(hs.getHora()));
        dao.create(morador);
        return atual;
    }
    
    
    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e){
        System.out.println("Linha Selecionada: " + ((Condomino) e.getObject()).getCondominoPK().toString());
    }
    
    /**
     * Evento que obter o valor trocado do condominio e buscar o registro correspondente
     */
    public void onCondominioChange(){
        System.out.println("Condominio Selecionado: " + moradorPK.getCdCondominio());
        getListTorre();
    }
    
    /**
     * Evento que obter o valor trocado do Torre e buscar o registro correspondente
     */
    public void onTorreChange(){
        System.out.println("Torre Selecionada: " + morador.getCdTorre());
        getListUnidade();
    }
}