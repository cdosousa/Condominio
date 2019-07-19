/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.dao.AcessoBancoDAO;
import com.condomino.domain.Condominio;
import com.condomino.domain.Unidade;
import com.condomino.domain.UnidadePK;
import com.condomino.domain.Praca;
import com.condomino.domain.PracaPK;
import com.condomino.domain.Proprietario;
import com.condomino.domain.Torre;
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
public class UnidadeContoller extends AcessoBancoDAO<Unidade, Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String anterior = "MenuPrincipal.xhtml";
    private final String atual = "Unidade.xhtml";
    private final String adicionar = "UnidadeAdicionar.xhtml";
    private final String editar = "UnidadeEditar.xhtml";

    /**
     * Variáveis para edição do registro
     */
    private String usuarioConectado;
    private String cdPraca;
    private Praca praca;
    private String andarUnidade;
    private String cpfCnpjProprietario;
    private Proprietario proprietarioUnidade;
    private Integer situacaUnidade;
    private Integer activeIndex = 0;
    private List<Condominio> listCondominio;
    private List<Praca> listPraca;
    private List<Torre> listTorre;
    private List<Proprietario> listProprietario;
    private CondominioController cc;
    private PracaController pc;
    private TorreContoller tc;
    private ProprietarioContoller prc;
    private String msg;

    /**
     * Objetos de instância para edição dos registros
     */
    private DataSistema dat;
    private HoraSistema hs;
    private Unidade unidadeSelecinado;
    private UnidadePK unidadeSelecinadoPK;
    private Unidade unidade;
    private UnidadePK unidadePK;
    private DataModel<Unidade> listarUnidade;
    private List<SituacaoCadastral> enumSituacao;

    @PostConstruct
    public void init() {
        dat = new DataSistema();
        hs = new HoraSistema();
        setUnidadeSelecinado(new Unidade());
        setUnidadeSelecinadoPK(new UnidadePK());
        setUnidade(new Unidade());
        setUnidadePK(new UnidadePK());
        cc = new CondominioController();
        pc = new PracaController();
        tc = new TorreContoller();
        prc = new ProprietarioContoller();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
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
     * @return the cdPraca
     */
    public String getCdPraca() {
        return cdPraca;
    }

    /**
     * @param cdPraca the cdPraca to set
     */
    public void setCdPraca(String cdPraca) {
        this.cdPraca = cdPraca;
    }

    /**
     * @return the praca
     */
    public Praca getPraca() {
        return praca;
    }

    /**
     * @param praca the praca to set
     */
    public void setPraca(Praca praca) {
        this.praca = praca;
    }

    /**
     * @return the andarUnidade
     */
    public String getAndarUnidade() {
        return andarUnidade;
    }

    /**
     * @param andarUnidade the andarUnidade to set
     */
    public void setAndarUnidade(String andarUnidade) {
        this.andarUnidade = andarUnidade;
    }

    /**
     * @return the cpfCnpjProprietario
     */
    public String getCpfCnpjProprietario() {
        return cpfCnpjProprietario;
    }

    /**
     * @param cpfCnpjProprietario the cpfCnpjProprietario to set
     */
    public void setCpfCnpjProprietario(String cpfCnpjProprietario) {
        this.cpfCnpjProprietario = cpfCnpjProprietario;
    }

    /**
     * @return the proprietarioUnidade
     */
    public Proprietario getProprietarioUnidade() {
        return proprietarioUnidade;
    }

    /**
     * @param proprietarioUnidade the proprietarioUnidade to set
     */
    public void setProprietarioUnidade(Proprietario proprietarioUnidade) {
        this.proprietarioUnidade = proprietarioUnidade;
    }

    /**
     * @return the situacaUnidade
     */
    public Integer getSituacaUnidade() {
        return situacaUnidade;
    }

    /**
     * @param situacaUnidade the situacaUnidade to set
     */
    public void setSituacaUnidade(Integer situacaUnidade) {
        this.situacaUnidade = situacaUnidade;
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
        //listCondominio = cc.list();
        return listCondominio;
    }

    /**
     * @return the listPraca
     */
    public List<Praca> getListPraca() {
        if (unidadePK.getCdCondominio() != null && !unidadePK.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM Praca WHERE pracaPK.cdCondominio = '" + unidadePK.getCdCondominio()
                    + "'";
            //listPraca = pc.consultaHQL(hql);
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
                //listTorre = tc.consultaHQL(hql);
        }
        return listTorre;
    }

    /**
     * @return the listProprietario
     */
    public List<Proprietario> getListProprietario() {
        //listProprietario = prc.list();
        return listProprietario;
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
        List<Unidade> lista = list();
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
        dat.setData("");
        PracaPK pracaPK = new PracaPK(unidadePK.getCdCondominio(), getCdPraca());
        //unidade.setCdPraca(pc.getById(pracaPK).getPracaPK().getCdPraca());
        unidade.setUnidadePK(unidadePK);
        //unidade.setCpfCnpjProprietario(prc.getById(cpfCnpjProprietario));
        unidade.setUsuarioCadastro(getUsuarioConectado());
        unidade.setDataCadastro(Date.valueOf(dat.getData()));
        unidade.setHoraCadastro(Time.valueOf(hs.getHora()));
        create(unidade);
        setMsg("Registro criado com sucesso!");
        return atual;
    }

    /**
     * Escluir o registro selecionado
     *
     * @return retonar a página atual que requisitou
     */
    public String excluirRegistro() {
        setActiveIndex(0);
        Unidade e = getById(unidadePK);
        delete(e);
        setMsg("Registro escluído com sucesso!");
        return atual;
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
        dat.setData("");
        PracaPK pracaPK = new PracaPK(unidadePK.getCdCondominio(), getCdPraca());
        //unidade.setCdPraca(pc.getById(pracaPK).getPracaPK().getCdPraca());
        unidade.setAndar(andarUnidade);
        //unidade.setCpfCnpjProprietario(prc.getById(cpfCnpjProprietario));
        unidade.setSituacao(situacaUnidade);
        unidade.setDataModificacao(Date.valueOf(dat.getData()));
        unidade.setHoraModificacao(Time.valueOf(hs.getHora()));
        save(unidade);
        return atual;
    }

    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Unidade) e.getObject()).getUnidadePK().toString());
        unidade = getById(((Unidade) e.getObject()).getUnidadePK());
        unidadePK.setCdCondominio(unidade.getUnidadePK().getCdCondominio());
        unidadePK.setCdUnidade(unidade.getUnidadePK().getCdUnidade());
        setCdPraca(unidade.getCdPraca());
        setAndarUnidade(unidade.getAndar());
        setProprietarioUnidade(unidade.getCpfCnpjProprietario());
        setSituacaUnidade(unidade.getSituacao());
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
     * Evento que obter o valor trocado da praca e buscar a praca de acordo
     * com o registro
     */
    public void onPracaChange() {
        System.out.println("Condominio trocado: " + unidadePK.getCdCondominio());
        getListTorre();
    }
}