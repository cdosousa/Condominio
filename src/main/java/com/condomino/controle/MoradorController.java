/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.domain.Condominio;
import com.condomino.domain.Morador;
import com.condomino.domain.MoradorPK;
import com.condomino.domain.Torre;
import com.condomino.domain.Unidade;
import com.condomino.repositories.CondominioRepository;
import com.condomino.repositories.MoradorRepository;
import com.condomino.repositories.TorreRepository;
import com.condomino.repositories.UnidadeRepository;
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
 * @data 19/07/2019
 */
@ManagedBean(name = "moradorController")
@SessionScoped
public class MoradorController implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * Objetos injetados na classe
     */
    @Inject
    private MoradorRepository mr;
    @Inject
    private CondominioRepository cr;
    @Inject
    private TorreRepository tr;
    @Inject
    private UnidadeRepository ur;

    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String listar = "Morador.xhtml";
    private final String adicionar = "MoradorAdicionar.xhtml";
    private final String editar = "MoradorEditar.xhtml";

    /**
     * Variáveis de contexto para manipulação da classe
     */
    private Integer activeIndex = 0;

    /**
     * Objetos de intância para edição dos registro
     */
    private DataSistema dat;
    private HoraSistema hs;
    private Morador morador;
    private MoradorPK moradorPK;
    private Morador moradorSelecionado;
    private MoradorPK moradorSelecionadoPK;
    private DataModel<Morador> listarMorador;
    private List<Condominio> listCondominio;
    private List<Torre> listTorre;
    private List<Unidade> listUnidade;
    private List<SituacaoCadastral> enumSituacao;
    private List<GrauParentesco> enumGrauParentesco;
    private List<Sexo> enumSexo;

    @PostConstruct
    public void init() {
        moradorSelecionado = new Morador();
        moradorSelecionadoPK = new MoradorPK();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
        enumGrauParentesco = Arrays.asList(GrauParentesco.values());
        enumSexo = Arrays.asList(Sexo.values());
    }

    /**
     * @return the morador
     */
    public Morador getMorador() {
        return morador;
    }

    /**
     * @param morador the morador to set
     */
    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    /**
     * @return the moradorPK
     */
    public MoradorPK getMoradorPK() {
        return moradorPK;
    }

    /**
     * @param moradorPK the moradorPK to set
     */
    public void setMoradorPK(MoradorPK moradorPK) {
        this.moradorPK = moradorPK;
    }

    /**
     * @return the moradorSelecionado
     */
    public Morador getMoradorSelecionado() {
        return moradorSelecionado;
    }

    /**
     * @param moradorSelecionado the moradoSelecionado to set
     */
    public void setMoradorSelecionado(Morador moradorSelecionado) {
        this.moradorSelecionado = moradorSelecionado;
    }

    /**
     * @return the moradorSelecionadoPK
     */
    public MoradorPK getMoradorSelecionadoPK() {
        return moradorSelecionadoPK;
    }

    /**
     * @param moradorSelecionadoPK the moradorSelecionadoPK to set
     */
    public void setMoradorSelecionadoPK(MoradorPK moradorSelecionadoPK) {
        this.moradorSelecionadoPK = moradorSelecionadoPK;
    }

    /**
     * @return the listarMorador
     */
    public DataModel<Morador> getListarMorador() {
        List<Morador> lista = mr.list();
        listarMorador = new ListDataModel<>(lista);
        return listarMorador;
    }

    /**
     * @param listarMorador the listarUnidade to set
     */
    public void setListarMorador(DataModel<Morador> listarMorador) {
        this.listarMorador = listarMorador;
    }

    public Integer getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(Integer activeIndex) {
        this.activeIndex = activeIndex;
    }

    public List<Condominio> getListCondominio() {
        listCondominio = cr.list();
        return listCondominio;
    }

    public List<Torre> getListTorre() {
        if (moradorPK.getCdCondominio() != null && !moradorPK.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM Torre WHERE torrePK.cdCondominio = '" + getMoradorPK().getCdCondominio()
                    + "'";
            listTorre = tr.consultaHQL(hql);
        }
        return listTorre;
    }

    public List<Unidade> getListUnidade() {
        if (moradorPK.getCdCondominio() != null && !moradorPK.getCdCondominio().trim().isEmpty()) {
            if (morador.getCdTorre() != null && !morador.getCdTorre().trim().isEmpty()) {
                String hql = "FROM Unidade WHERE unidadePK.cdCondominio = '" + moradorPK.getCdCondominio()
                        + "' AND unidadePK.cdTorre = '" + morador.getCdTorre()
                        + "'";
                listUnidade = ur.consultaHQL(hql);
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
    public String adicionaForm() {
        setActiveIndex(2);
        morador = new Morador();
        moradorPK = new MoradorPK();
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
        morador.setMoradorPK(moradorPK);
        morador.setDataCadastro(Date.valueOf(dat.getData()));
        morador.setHoraCadastro(Time.valueOf(hs.getHora()));
        mr.create(morador);
        return listar;
    }

    /**
     * Escluir o registro selecionado
     *
     * @return retonar a página atual que requisitou
     */
    public String excluirRegistro(){
        setActiveIndex(0);
        Morador m = mr.getById(moradorPK);
        mr.delete(m);
        return listar;
    }
    
    /**
     * Seta o índice do TableView para guia de edição
     *
     * @return retorna a página atual que requisitou
     */
    public String editarRegistro(){
        setActiveIndex(1);
        return editar;
    }
    
    /**
     * Salva o registro modificado no banco de dados
     *
     * @return retorna a página atual que requisitou
     */
    public String salvarRegistro(){
        setActiveIndex(0);
        dat = new DataSistema();
        hs = new HoraSistema();
        dat.setData("");
        morador.setDataModificacao(Date.valueOf(dat.getData()));
        morador.setHoraModificacao(Time.valueOf(hs.getHora()));
        mr.save(morador);
        return listar;
    }
    
    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Morador) e.getObject()).getMoradorPK().toString());
        setMorador(mr.getById(((Morador) e.getObject()).getMoradorPK()));
        setMoradorPK(getMorador().getMoradorPK());
        System.out.println("Objeto Morador: " + morador.toString());
    }
    
    /**
     * Evento que obter o valor trocado do condominio e buscar o registro
     * correspondente
     */
    public void onCondominioChange() {
        System.out.println("Condominio Selecionado: " + moradorPK.getCdCondominio());
        getListTorre();
    }

    /**
     * Evento que obter o valor trocado do Torre e buscar o registro
     * correspondente
     */
    public void onTorreChange() {
        System.out.println("Torre Selecionada: " + morador.getCdTorre());
        getListUnidade();
    }
}