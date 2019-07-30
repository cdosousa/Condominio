/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.domain.Condominio;
import com.condomino.domain.Morador;
import com.condomino.domain.Torre;
import com.condomino.domain.Unidade;
import com.condomino.domain.Visita;
import com.condomino.domain.VisitaPK;
import com.condomino.repositories.CondominioRepository;
import com.condomino.repositories.MoradorRepository;
import com.condomino.repositories.TorreRepository;
import com.condomino.repositories.UnidadeRepository;
import com.condomino.repositories.VisitaRepository;
import com.parametros.modelo.DataSistema;
import com.parametros.modelo.HoraSistema;
import com.parametros.modelo.enums.Sexo;
import com.parametros.modelo.enums.SimNao;
import com.parametros.modelo.enums.SituacaoCadastral;
import com.parametros.modelo.enums.TipoVisita;
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
 * @data 24/07/2019
 */
@ManagedBean(name = "visitaController")
@SessionScoped
public class VisitaController implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Objetos com injeção de dependência da classe
     */
    @Inject
    private VisitaRepository vr;
    @Inject
    private CondominioRepository cr;
    @Inject
    private TorreRepository tr;
    @Inject
    private UnidadeRepository ur;
    @Inject
    private MoradorRepository mr;

    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String listar = "Visita.xhtml";
    private final String adicionar = "VisitaAdicionar.xhtml";
    private final String editar = "VisitaEditar.xhtml";

    /**
     * Variáveis para edição do registro
     */
    private Integer activeIndex = 0;
    private List<Condominio> listCondominio;
    private List<Torre> listTorre;
    private List<Unidade> listUnidade;
    private List<Morador> listMorador;

    /**
     * Objetos de instância para edição dos registros
     */
    private DataSistema dat;
    private HoraSistema hs;
    private Visita visita;
    private VisitaPK visitaPK;
    private Visita visitaSelecinado;
    private VisitaPK visitaPKSelecinado;
    private DataModel<Visita> listarVisita;
    private List<SituacaoCadastral> enumSituacao;
    private List<SimNao> enumSimNao;
    private List<Sexo> enumSexo;
    private List<TipoVisita> enumTipoVista;

    @PostConstruct
    public void init() {
        setVisitaSelecinado(new Visita());
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
     * @param listCondominio the listCondominio to set
     */
    public void setListCondominio(List<Condominio> listCondominio) {
        this.listCondominio = listCondominio;
    }

    /**
     * @return the listTorre
     */
    public List<Torre> getListTorre() {
        if (visitaPK.getCdCondominio() != null && !visitaPK.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM Torre WHERE torrePK.cdCondominio = '" + visitaPK.getCdCondominio()
                    + "'";
            listTorre = tr.consultaHQL(hql);
        }
        return listTorre;
    }

    /**
     * @param listTorre the listTorre to set
     */
    public void setListTorre(List<Torre> listTorre) {
        this.listTorre = listTorre;
    }

    /**
     * Retorna uma lista de unidade
     *
     * @return
     */
    public List<Unidade> getListUnidade() {
        if (visitaPK.getCdCondominio() != null && !visitaPK.getCdCondominio().trim().isEmpty()) {
            System.out.println("Código da torre: " + visita.getCdTorre());
            if (visita.getCdTorre() != null) {
                String hql = "FROM Unidade WHERE unidadePK.cdCondominio = '" + visitaPK.getCdCondominio()
                        + "' AND unidadePK.cdTorre = '" + visita.getCdTorre()
                        + "'";
                listUnidade = ur.consultaHQL(hql);
            }
        }
        return listUnidade;
    }

    /**
     *
     * @param listUnidade
     */
    public void setListUnidade(List<Unidade> listUnidade) {
        this.listUnidade = listUnidade;
    }

    /**
     * @return the listMorador
     */
    public List<Morador> getListMorador() {
        if (visitaPK.getCdCondominio() != null && !visitaPK.getCdCondominio().trim().isEmpty()) {
            if (visita.getCdTorre() != null && !visita.getCdTorre().trim().isEmpty()) {
                if (visita.getCdUnidade() != null && !visita.getCdUnidade().trim().isEmpty()) {
                    String hql = "FROM Morador WHERE moradorPK.cdCondominio = '" + visitaPK.getCdCondominio()
                            + "' AND cdTorre = '" + visita.getCdTorre()
                            + "' AND cdUnidade = '" + visita.getCdUnidade()
                            + "'";
                    listMorador = mr.consultaHQL(hql);
                }
            }
        }
        return listMorador;
    }

    /**
     * @param listMorador the listMorador to set
     */
    public void setListMorador(List<Morador> listMorador) {
        this.listMorador = listMorador;
    }

    /**
     * @return the visitaSelecinado
     */
    public Visita getVisitaSelecinado() {
        return visitaSelecinado;
    }

    /**
     * @param visitaSelecinado the visitaSelecinado to set
     */
    public void setVisitaSelecinado(Visita visitaSelecinado) {
        this.visitaSelecinado = visitaSelecinado;
    }

    /**
     * @return the visita
     */
    public Visita getVisita() {
        return visita;
    }

    /**
     * @param visita the visita to set
     */
    public void setVisita(Visita visita) {
        this.visita = visita;
    }

    /**
     * @return the visitaPK
     */
    public VisitaPK getVisitaPK() {
        return visitaPK;
    }

    /**
     * @param visitaPK the visitaPK to set
     */
    public void setVisitaPK(VisitaPK visitaPK) {
        this.visitaPK = visitaPK;
    }

    /**
     * @return the visitaPKSelecinado
     */
    public VisitaPK getVisitaPKSelecinado() {
        return visitaPKSelecinado;
    }

    /**
     * @param visitaPKSelecinado the visitaPKSelecinado to set
     */
    public void setVisitaPKSelecinado(VisitaPK visitaPKSelecinado) {
        this.visitaPKSelecinado = visitaPKSelecinado;
    }

    /**
     * @return the listarVisita
     */
    public DataModel<Visita> getListarVisita() {
        List<Visita> lista = vr.list();
        listarVisita = new ListDataModel<>(lista);
        return listarVisita;
    }

    /**
     * @param listarVisita the listarVisita to set
     */
    public void setListarVisita(DataModel<Visita> listarVisita) {
        this.listarVisita = listarVisita;
    }

    /**
     * @return the enumSituacao
     */
    public List<SituacaoCadastral> getEnumSituacao() {
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
        return enumSituacao;
    }

    /**
     * @return the enumSimNao
     */
    public List<SimNao> getEnumSimNao() {
        enumSimNao = Arrays.asList(SimNao.values());
        return enumSimNao;
    }

    /**
     * @return the enumSexo
     */
    public List<Sexo> getEnumSexo() {
        enumSexo = Arrays.asList(Sexo.values());
        return enumSexo;
    }

    /**
     * @return the enumTipoVista
     */
    public List<TipoVisita> getEnumTipoVista() {
        enumTipoVista = Arrays.asList(TipoVisita.values());
        return enumTipoVista;
    }

    /**
     * Retorna a situação cadastral do proprietário
     *
     * @param cod
     * @return String contendo a descrição da situação do proprietário
     */
    public String getSituacao(Integer cod) {
        return SituacaoCadastral.toEnum(cod).getDescricao();
    }

    /**
     * Retorna a desrição do valor informado parq Sim ou Não
     *
     * @param cod
     * @return
     */
    public String getSimNao(Integer cod) {
        return SimNao.toEnum(cod).getDescricao();
    }

    /**
     * Retorna a descrição do sexo informado
     *
     * @param cod
     * @return
     */
    public String getSexo(Integer cod) {
        return Sexo.toEnum(cod).getDescricao();
    }

    /**
     * Retorna a descrição do tipo de visita
     *
     * @param cod
     * @return
     */
    public String getTipoVisita(Integer cod) {
        return TipoVisita.toEnum(cod).getDescricao();
    }

    /**
     * Método que limpa os campos do formulário para inclusão de um novo
     * registro
     *
     * @return retorna a página atual que requisitou
     */
    public String adicionarForm() {
        setActiveIndex(2);
        visitaPK = new VisitaPK();
        visita = new Visita();
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
        visita.setVisitaPK(visitaPK);
        visita.setDataCadastro(Date.valueOf(dat.getData()));
        visita.setHoraCadastro(Time.valueOf(hs.getHora()));
        vr.create(visita);
        return listar;
    }

    /**
     * Escluir o registro selecionado
     *
     * @return retonar a página atual que requisitou
     */
    public String excluirRegistro() {
        setActiveIndex(0);
        Visita e = vr.getById(visita.getVisitaPK());
        vr.delete(e);
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
        visita.setVisitaPK(visitaPK);
        visita.setDataModificacao(Date.valueOf(dat.getData()));
        visita.setHoraModificacao(Time.valueOf(hs.getHora()));
        vr.save(visita);
        return listar;
    }

    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Visita) e.getObject()).getVisitaPK().getCdVisita());
        visita = vr.getById(((Visita) e.getObject()).getVisitaPK().getCdVisita());
        setVisitaPK(visita.getVisitaPK());
        System.out.println("Objeto Visita: " + visita.toString());
    }

    /**
     * Evento que obter o valor trocado do condominio e buscar o registro
     * correspondente
     */
    public void onCondominioChange() {
        System.out.println("Condominio Selecionado: " + visitaPK.getCdCondominio());
        getListTorre();
    }

    /**
     * Evento que obter o valor trocado do Torre e buscar o registro
     * correspondente
     */
    public void onTorreChange() {
        System.out.println("Torre Selecionada: " + visita.getCdTorre());
        getListUnidade();
    }

    /**
     * Evento que obter o valor trocado da Unidade e buscar o registro
     * correspondente
     */
    public void onUnidadeChange() {
        System.out.println("Unidade Selecionada: " + visita.getCdUnidade());
        getListMorador();
    }
}
