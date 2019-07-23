/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.domain.Condominio;
import com.condomino.domain.Morador;
import com.condomino.domain.Veiculo;
import com.condomino.domain.Praca;
import com.condomino.domain.Torre;
import com.condomino.domain.Unidade;
import com.condomino.repositories.CondominioRepository;
import com.condomino.repositories.MoradorRepository;
import com.condomino.repositories.TorreRepository;
import com.condomino.repositories.UnidadeRepository;
import com.condomino.repositories.VeiculoRepository;
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
 * @data 23/07/2019
 */
@ManagedBean(name = "veiculoController")
@SessionScoped
public class VeiculoContoller implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Objetos com injeção de dependência da classe
     */
    @Inject
    VeiculoRepository vr;
    @Inject
    private CondominioRepository cr;
    @Inject
    private UnidadeRepository ur;
    @Inject
    private TorreRepository tr;
    @Inject
    private MoradorRepository mr;

    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String listar = "Veiculo.xhtml";
    private final String adicionar = "VeiculoAdicionar.xhtml";
    private final String editar = "VeiculoEditar.xhtml";

    /**
     * Variáveis para edição do registro
     */
    private Integer activeIndex = 0;
    private List<Condominio> listCondominio;
    private List<Unidade> listUnidade;
    private List<Torre> listTorre;
    private List<Morador> listMorador;

    /**
     * Objetos de instância para edição dos registros
     */
    private DataSistema dat;
    private HoraSistema hs;
    private Veiculo veiculo;
    private Veiculo veiculoSelecinado;
    private DataModel<Veiculo> listarVeiculo;
    private List<SituacaoCadastral> enumSituacao;

    @PostConstruct
    public void init() {
        setVeiculoSelecinado(new Veiculo());
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
     * @return the listUnidade
     */
    public List<Unidade> getListUnidade() {
        if (veiculo.getCdCondominio() != null && !veiculo.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM Unidade WHERE unidadePK.cdCondominio = '" + veiculo.getCdCondominio()
                    + "'";
            listUnidade = ur.consultaHQL(hql);
        }
        return listUnidade;
    }

    /**
     * @return the listTorre
     */
    public List<Torre> getListTorre() {
        if (veiculo.getCdCondominio() != null && !veiculo.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM  Torre WHERE torrePK.cdCondominio = '" + veiculo.getCdCondominio()
                    + "'";
            listTorre = tr.consultaHQL(hql);
        }
        return listTorre;
    }

    /**
     * @return the listMorador
     */
    public List<Morador> getListMorador() {
        if (veiculo.getCdCondominio() != null && !veiculo.getCdCondominio().trim().isEmpty()) {
            if (veiculo.getCdUnidade() != null && !veiculo.getCdUnidade().trim().isEmpty()) {
                String hql = "FROM Morador WHERE moradorPK.cdCondominio = '" + veiculo.getCdCondominio()
                        + "'";
                listMorador = mr.consultaHQL(hql);
            }
        }
        return listMorador;
    }

    /**
     * @return the veiculoSelecinado
     */
    public Veiculo getVeiculoSelecinado() {
        return veiculoSelecinado;
    }

    /**
     * @param veiculoSelecinado the veiculoSelecinado to set
     */
    public void setVeiculoSelecinado(Veiculo veiculoSelecinado) {
        this.veiculoSelecinado = veiculoSelecinado;
    }

    /**
     * @return the veiculo
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * @return the listarVeiculo
     */
    public DataModel<Veiculo> getListarVeiculo() {
        List<Veiculo> lista = vr.list();
        listarVeiculo = new ListDataModel<>(lista);
        return listarVeiculo;
    }

    /**
     * @param listarVeiculo the listarVeiculo to set
     */
    public void setListarVeiculo(DataModel<Veiculo> listarVeiculo) {
        this.listarVeiculo = listarVeiculo;
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
        veiculo = new Veiculo();
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
        veiculo.setDataCadastro(Date.valueOf(dat.getData()));
        veiculo.setHoraCadastro(Time.valueOf(hs.getHora()));
        vr.create(veiculo);
        return listar;
    }

    /**
     * Escluir o registro selecionado
     *
     * @return retonar a página atual que requisitou
     */
    public String excluirRegistro() {
        setActiveIndex(0);
        Veiculo e = vr.getById(veiculo.getPlaca());
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
        veiculo.setDataModificacao(Date.valueOf(dat.getData()));
        veiculo.setHoraModificacao(Time.valueOf(hs.getHora()));
        vr.save(veiculo);
        return listar;
    }

    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Veiculo) e.getObject()).getPlaca().toString());
        veiculo = vr.getById(((Veiculo) e.getObject()).getPlaca().toString());
        System.out.println("Objeto Veiculo: " + veiculo.toString());
    }

    /**
     * Evento que obter o valor trocado do condominio e buscar a praca de acordo
     * com o registro
     */
    public void onCondominoChange() {
        System.out.println("Condominio trocado: " + veiculo.getCdCondominio());
        getListTorre();
    }

    /**
     * Evento que obter o valor trocado da torre e buscar a unidade de acordo
     * com o registro
     */
    public void onTorreChange() {
        System.out.println("Condominio trocado: " + veiculo.getCdCondominio());
        getListUnidade();
    }
}
