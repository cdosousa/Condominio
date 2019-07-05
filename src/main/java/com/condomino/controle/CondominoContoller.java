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
import com.condomino.domain.Praca;
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data 04/07/2019
 */
@ManagedBean(name = "moradorController")
@SessionScoped
public class CondominoContoller extends AcessoBancoDAO<Condomino, Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Variáveis estáticas para fluxo de navegação da página
     */
    private final String anterior = "MenuPrincipal.xhtml";
    private final String atual = "Condomino.xhtml";
    private final String adicionar = "CondominoAdicionar.xhtml";
    private final String editar = "CondominoEditar.xhtml";

    /**
     * Variáveis para edição do registro
     */
    private String usuarioConectado;
    private String cpfCondomino;
    private String rgCondomino;
    private String dataEmissaoRgCondomino;
    private String orgaoEmissorRgCondomino;
    private String nomeCondomino;
    private Integer sexoCondomino;
    private String telefoneCondomino;
    private String celularCondomino;
    private Integer tipoParentescoCondomino;
    private Integer situacaCondomino;
    private Integer activeIndex = 0;
    private List<Condominio> listCondominio;
    private List<Praca> listPraca;
    private List<Torre> listTorre;
    private List<Unidade> listUnidade;
    private CondominioController cc;
    private PracaController pc;
    private TorreContoller tc;
    private UnidadeContoller uc;
    private String msg;

    /**
     * Objetos de instância para edição dos registros
     */
    private DataSistema dat;
    private HoraSistema hs;
    private Condomino condominoSelecinado;
    private CondominoPK condominoSelecinadoPK;
    private Condomino condomino;
    private CondominoPK condominoPK;
    private DataModel<Condomino> listarCondomino;
    private List<SituacaoCadastral> enumSituacao;
    private List<Sexo> enumSexo;
    private List<GrauParentesco> enumGrauParentesco;

    @PostConstruct
    public void init() {
        dat = new DataSistema();
        hs = new HoraSistema();
        setCondominoSelecinado(new Condomino());
        setCondominoSelecinadoPK(new CondominoPK());
        setCondomino(new Condomino());
        setCondominoPK(new CondominoPK());
        cc = new CondominioController();
        pc = new PracaController();
        tc = new TorreContoller();
        uc = new UnidadeContoller();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
        enumSexo = Arrays.asList(Sexo.values());
        enumGrauParentesco = Arrays.asList(GrauParentesco.values());
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
     * @return the cpfCnpjCondomino
     */
    public String getCpfProprietario() {
        return cpfCondomino;
    }

    /**
     * @param cpfProprietario the cpfCnpjCondomino to set
     */
    public void setCpfProprietario(String cpfProprietario) {
        this.cpfCondomino = cpfProprietario;
    }

    /**
     * @return the rgCondomino
     */
    public String getRgCondomino() {
        return rgCondomino;
    }

    /**
     * @param rgCondomino the rgCondomino to set
     */
    public void setRgCondomino(String rgCondomino) {
        this.rgCondomino = rgCondomino;
    }

    /**
     * @return the dataEmissaoRgCondomino
     */
    public String getDataEmissaoRgCondomino() {
        return dataEmissaoRgCondomino;
    }

    /**
     * @param dataEmissaoRgCondomino the dataEmissaoRgCondomino to set
     */
    public void setDataEmissaoRgCondomino(String dataEmissaoRgCondomino) {
        this.dataEmissaoRgCondomino = dataEmissaoRgCondomino;
    }

    /**
     * @return the orgaoEmissorRgCondomino
     */
    public String getOrgaoEmissorRgCondomino() {
        return orgaoEmissorRgCondomino;
    }

    /**
     * @param orgaoEmissorRgCondomino the orgaoEmissorRgCondomino to set
     */
    public void setOrgaoEmissorRgCondomino(String orgaoEmissorRgCondomino) {
        this.orgaoEmissorRgCondomino = orgaoEmissorRgCondomino;
    }

    /**
     * @return the nomeCondomino
     */
    public String getNomeCondomino() {
        return nomeCondomino;
    }

    /**
     * @param nomeCondomino the nomeCondomino to set
     */
    public void setNomeCondomino(String nomeCondomino) {
        this.nomeCondomino = nomeCondomino;
    }

    /**
     * @return the sexoCondomino
     */
    public Integer getSexoCondomino() {
        return sexoCondomino;
    }

    /**
     * @param sexoCondomino the sexoCondomino to set
     */
    public void setSexoCondomino(Integer sexoCondomino) {
        this.sexoCondomino = sexoCondomino;
    }

    /**
     * @return the telefoneCondomino
     */
    public String getTelefoneCondomino() {
        return telefoneCondomino;
    }

    /**
     * @param telefoneCondomino the telefoneCondomino to set
     */
    public void setTelefoneCondomino(String telefoneCondomino) {
        this.telefoneCondomino = telefoneCondomino;
    }

    /**
     * @return the celularCondomino
     */
    public String getCelularCondomino() {
        return celularCondomino;
    }

    /**
     * @param celularCondomino the celularCondomino to set
     */
    public void setCelularCondomino(String celularCondomino) {
        this.celularCondomino = celularCondomino;
    }

    /**
     * @return the tipoParentescoCondomino
     */
    public Integer getTipoParentescoCondomino() {
        return tipoParentescoCondomino;
    }

    /**
     * @param tipoParentescoCondomino the tipoParentescoCondomino to set
     */
    public void setTipoParentescoCondomino(Integer tipoParentescoCondomino) {
        this.tipoParentescoCondomino = tipoParentescoCondomino;
    }

    /**
     * @return the situacaCondomino
     */
    public Integer getSituacaCondomino() {
        return situacaCondomino;
    }

    /**
     * @param situacaCondomino the situacaCondomino to set
     */
    public void setSituacaCondomino(Integer situacaCondomino) {
        this.situacaCondomino = situacaCondomino;
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
        listCondominio = cc.list();
        return listCondominio;
    }

    /**
     * @return the listPraca
     */
    public List<Praca> getListPraca() {
        if (condominoPK.getCdCondominio() != null && !condominoPK.getCdCondominio().trim().isEmpty()) {
            String hql = "FROM Praca WHERE pracaPK.cdCondominio = '" + condominoPK.getCdCondominio()
                    + "'";
            listPraca = pc.consultaHQL(hql);
        }
        return listPraca;
    }

    /**
     * @return the listTorre
     */
    public List<Torre> getListTorre() {
        if (condominoPK.getCdCondominio() != null && !condominoPK.getCdCondominio().trim().isEmpty()) {
                String hql = "FROM  Torre WHERE torrePK.cdCondominio = '" + condominoPK.getCdCondominio()
                        + "'";
                listTorre = tc.consultaHQL(hql);
        }
        return listTorre;
    }
    
    /**
     * @return the listUnidade
     */
    public List<Unidade> getListUnidade() {
        if (condominoPK.getCdCondominio() != null && !condominoPK.getCdCondominio().trim().isEmpty()) {
                    String hql = "FROM Unidade WHERE unidadePK.cdCondominio = '" + condominoPK.getCdCondominio()
                        + "'";
                listUnidade = uc.consultaHQL(hql);
        }
        return listUnidade;
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
     * @return the condominoSelecinado
     */
    public Condomino getCondominoSelecinado() {
        return condominoSelecinado;
    }

    /**
     * @param condominoSelecinado the condominoSelecinado to set
     */
    public void setCondominoSelecinado(Condomino condominoSelecinado) {
        this.condominoSelecinado = condominoSelecinado;
    }

    /**
     * @return the condominoSelecinadoPK
     */
    public CondominoPK getCondominoSelecinadoPK() {
        return condominoSelecinadoPK;
    }

    /**
     * @param condominoSelecinadoPK the condominoSelecinadoPK to set
     */
    public void setCondominoSelecinadoPK(CondominoPK condominoSelecinadoPK) {
        this.condominoSelecinadoPK = condominoSelecinadoPK;
    }

    /**
     * @return the condomino
     */
    public Condomino getCondomino() {
        return condomino;
    }

    /**
     * @param condomino the condomino to set
     */
    public void setCondomino(Condomino condomino) {
        this.condomino = condomino;
    }

    /**
     * @return the condominoPK
     */
    public CondominoPK getCondominoPK() {
        return condominoPK;
    }

    /**
     * @param condominoPK the condominoPK to set
     */
    public void setCondominoPK(CondominoPK condominoPK) {
        this.condominoPK = condominoPK;
    }

    /**
     * @return the listarCondomino
     */
    public DataModel<Condomino> getListarCondomino() {
        List<Condomino> lista = list();
        listarCondomino = new ListDataModel<Condomino>(lista);
        return listarCondomino;
    }

    /**
     * @param listarCondomino the listarCondomino to set
     */
    public void setListarCondomino(DataModel<Condomino> listarCondomino) {
        this.listarCondomino = listarCondomino;
    }

    /**
     * @return the enumSituacao
     */
    public List<SituacaoCadastral> getEnumSituacao() {
        return enumSituacao;
    }

    /**
     * @return the enumSexo
     */
    public List<Sexo> getEnumSexo() {
        return enumSexo;
    }

    /**
     * @return the enumGrauParentesco
     */
    public List<GrauParentesco> getEnumGrauParentesco() {
        return enumGrauParentesco;
    }

    /**
     * Método que limpa os campos do formulário para inclusão de um novo
     * registro
     *
     * @return retorna a página atual que requisitou
     */
    public String adicionarForm() {
        setActiveIndex(2);
        condomino = new Condomino();
        condominoPK = new CondominoPK();
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
        condomino.setCondominoPK(condominoPK);
        condomino.setUsuarioCadastro(getUsuarioConectado());
        condomino.setDataCadastro(Date.valueOf(dat.getData()));
        condomino.setHoraCadastro(Time.valueOf(hs.getHora()));
        create(condomino);
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
        Condomino e = getById(condominoPK);
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
        condomino.setRg(rgCondomino);
        condomino.setDataEmissaoRg(Date.valueOf(dataEmissaoRgCondomino));
        condomino.setOrgaoEmissorRg(orgaoEmissorRgCondomino);
        condomino.setNome(nomeCondomino);
        condomino.setSexo(sexoCondomino);
        condomino.setTelefone(telefoneCondomino);
        condomino.setCelular(celularCondomino);
        condomino.setTipoParentesco(tipoParentescoCondomino);
        condomino.setSituacao(situacaCondomino);
        condomino.setUsuarioModificacao(usuarioConectado);
        condomino.setDataModificacao(Date.valueOf(dat.getData()));
        condomino.setHoraModificacao(Time.valueOf(hs.getHora()));
        save(condomino);
        return atual;
    }

    /**
     * Obtém o valor da linha selecionada da tabela, busca os dados do registro
     * e atualizada o objeto para edição
     *
     * @param e Objeto contendo o envendo do JFS
     */
    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((Condomino) e.getObject()).getCondominoPK().toString());
        condomino = getById(((Condomino) e.getObject()).getCondominoPK());
        condominoPK.setCdCondominio(condomino.getCondominoPK().getCdCondominio());
        setRgCondomino(condomino.getRg());
        setDataEmissaoRgCondomino(dat.getDataConv(condomino.getDataEmissaoRg()));
        setOrgaoEmissorRgCondomino(condomino.getOrgaoEmissorRg());
        setNomeCondomino(condomino.getNome());
        setSexoCondomino(condomino.getSexo());
        setTelefoneCondomino(condomino.getTelefone());
        setCelularCondomino(condomino.getCelular());
        setTipoParentescoCondomino(condomino.getTipoParentesco());
        setSituacaCondomino(condomino.getSituacao());
        System.out.println("Objeto Condomino: " + condomino.toString());
    }

    /**
     * Evento que obter o valor trocado do condominio e buscar a praca de acordo
     * com o registro
     */
    public void onCondominoChange() {
        System.out.println("Condominio trocado: " + condominoPK.getCdCondominio());
        getListPraca();
    }
    
    /**
     * Evento que obter o valor trocado da praca e buscar a torre de acordo
     * com o registro
     */
    public void onPracaChange() {
        System.out.println("Condominio trocado: " + condominoPK.getCdCondominio());
        getListTorre();
    }
    
    /**
     * Evento que obter o valor trocado da torre e buscar a unidae de acordo
     * com o registro
     */
    public void onTorreChange() {
        System.out.println("Condominio trocado: " + condominoPK.getCdCondominio());
        getListUnidade();
    }
}