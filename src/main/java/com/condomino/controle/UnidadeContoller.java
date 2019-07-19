/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.domain.Condominio;
import com.condomino.domain.Unidade;
import com.condomino.domain.UnidadePK;
import com.condomino.domain.Praca;
import com.condomino.domain.Proprietario;
import com.condomino.domain.Torre;
import com.condomino.repositories.CondominioRepository;
import com.condomino.repositories.PracaRepository;
import com.condomino.repositories.ProprietarioRepository;
import com.condomino.repositories.TorreRepository;
import com.condomino.repositories.UnidadeRepository;
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
 * @local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data 03/07/2019
 */
@ManagedBean(name = "unidadeController")
@SessionScoped
public class UnidadeContoller implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Objetos com injeção de dependência da classe
     */
    @Inject
    UnidadeRepository ur;
    @Inject
    private CondominioRepository cr;
    @Inject
    private PracaRepository pr;
    @Inject
    private TorreRepository tr;
    @Inject
    private ProprietarioRepository prr;

    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String listar = "Unidade.xhtml";
    private final String adicionar = "UnidadeAdicionar.xhtml";
    private final String editar = "UnidadeEditar.xhtml";

    /**
     * Variáveis para edição do registro
     */
    private Integer activeIndex = 0;
    private List<Condominio> listCondominio;
    private List<Praca> listPraca;
    private List<Torre> listTorre;
    private List<Proprietario> listProprietario;

    /**
     * Objetos de instância para edição dos registros
     */
    private DataSistema dat;
    private HoraSistema hs;
    private Unidade unidade;
    private UnidadePK unidadePK;
    private Unidade unidadeSelecinado;
    private UnidadePK unidadeSelecinadoPK;
    private DataModel<Unidade> listarUnidade;
    private List<SituacaoCadastral> enumSituacao;

    @PostConstruct
    public void init() {
        setUnidadeSelecinado(new Unidade());
        setUnidadeSelecinadoPK(new UnidadePK());
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
    }

    /**
     * @return the activeIndex
     */
    public Integer getActiveIndex() {
        return activeIndex;
    }

    /**
     * @param activeIndex the activeIndex to set
     */
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

    /**
     * @return the listPraca
     */
    public List<Praca> getListPraca() {
        if (unidadePK.getCdCondominio() != null && !unidadePK.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM Praca WHERE pracaPK.cdCondominio = '" + unidadePK.getCdCondominio()
                    + "'";
            listPraca = pr.consultaHQL(hql);
        }
        return listPraca;
    }

    /**
     * @return the listTorre
     */
    public List<Torre> getListTorre() {
        if (unidadePK.getCdCondominio() != null && !unidadePK.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM  Torre WHERE torrePK.cdCondominio = '" + unidadePK.getCdCondominio()
                    + "'";
            listTorre = tr.consultaHQL(hql);
        }
        return listTorre;
    }

    /**
     * @return the listProprietario
     */
    public List<Proprietario> getListProprietario() {
        listProprietario = prr.list();
        return listProprietario;
    }

    /**
     * @return the unidadeSelecinado
     */
    public Unidade getUnidadeSelecinado() {
        return unidadeSelecinado;
    }

    /**
     * @param unidadeSelecinado the unidadeSelecinado to set
     */
    public void setUnidadeSelecinado(Unidade unidadeSelecinado) {
        this.unidadeSelecinado = unidadeSelecinado;
    }

    /**
     * @return the unidadeSelecinadoPK
     */
    public UnidadePK getUnidadeSelecinadoPK() {
        return unidadeSelecinadoPK;
    }

    /**
     * @param unidadeSelecinadoPK the unidadeSelecinadoPK to set
     */
    public void setUnidadeSelecinadoPK(UnidadePK unidadeSelecinadoPK) {
        this.unidadeSelecinadoPK = unidadeSelecinadoPK;
    }

    /**
     * @return the unidade
     */
    public Unidade getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the unidadePK
     */
    public UnidadePK getUnidadePK() {
        return unidadePK;
    }

    /**
     * @param unidadePK the unidadePK to set
     */
    public void setUnidadePK(UnidadePK unidadePK) {
        this.unidadePK = unidadePK;
    }

    /**
     * @return the listarUnidade
     */
    public DataModel<Unidade> getListarUnidade() {
        List<Unidade> lista = ur.list();
        listarUnidade = new ListDataModel<Unidade>(lista);
        return listarUnidade;
    }

    /**
     * @param listarUnidade the listarUnidade to set
     */
    public void setListarUnidade(DataModel<Unidade> listarUnidade) {
        this.listarUnidade = listarUnidade;
    }

    /**
     * @return the enumSituacao
     */
    public List<SituacaoCadastral> getEnumSituacao() {
        return enumSituacao;
    }

    /**
     * Método que limpa os campos do formulário para inclusão de um novo
     * registro
     *
     * @return retorna a página atual que requisitou
     */
    public String adicionarForm() {
        setActiveIndex(2);
        unidade = new Unidade();
        unidadePK = new UnidadePK();
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
        unidade.setUnidadePK(unidadePK);
        unidade.setDataCadastro(Date.valueOf(dat.getData()));
        unidade.setHoraCadastro(Time.valueOf(hs.getHora()));
        ur.create(unidade);
        return listar;
    }

    /**
     * Escluir o registro selecionado
     *
     * @return retonar a página atual que requisitou
     */
    public String excluirRegistro() {
        setActiveIndex(0);
        Unidade e = ur.getById(unidadePK);
        ur.delete(e);
        return listar;
    }

    /**
     * Seta o índice do TableView para guia de edição
     *
     * @return retorna a página atual que requisitou
     */
    public String editarRegistro() {
        setActiveIndex(1);
        return editar;
    }

    /**
     * Salva o registro modificado no banco de dados
     *
     * @return retorna a página atual que requisitou
     */
    public String salvarRegistro() {
        setActiveIndex(0);
        dat = new DataSistema();
        hs = new HoraSistema();
        dat.setData("");
        unidade.setDataModificacao(Date.valueOf(dat.getData()));
        unidade.setHoraModificacao(Time.valueOf(hs.getHora()));
        ur.save(unidade);
        return listar;
    }

    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Unidade) e.getObject()).getUnidadePK().toString());
        unidade = ur.getById(((Unidade) e.getObject()).getUnidadePK());
        unidadePK.setCdCondominio(unidade.getUnidadePK().getCdCondominio());
        unidadePK.setCdUnidade(unidade.getUnidadePK().getCdUnidade());
        System.out.println("Objeto Unidade: " + unidade.toString());
    }

    /**
     * Evento que obter o valor trocado do condominio e buscar a praca de acordo
     * com o registro
     */
    public void onCondominoChange() {
        System.out.println("Condominio trocado: " + unidadePK.getCdCondominio());
        getListPraca();
    }

    /**
     * Evento que obter o valor trocado da praca e buscar a praca de acordo com
     * o registro
     */
    public void onPracaChange() {
        System.out.println("Condominio trocado: " + unidadePK.getCdCondominio());
        getListTorre();
    }
}