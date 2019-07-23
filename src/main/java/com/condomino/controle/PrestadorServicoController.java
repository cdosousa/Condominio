/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle;

import com.condomino.domain.PrestadorServico;
import com.condomino.repositories.PrestadorServicoRepository;
import com.parametros.modelo.DataSistema;
import com.parametros.modelo.HoraSistema;
import com.parametros.modelo.enums.SituacaoCadastral;
import com.parametros.modelo.enums.TipoPessoa;
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
 * @Data...: 23/07/2019
 */
@ManagedBean(name = "prestadorServicoController")
@SessionScoped
public class PrestadorServicoController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Objetos com injeção de depencia da classe
     */
    @Inject
    private PrestadorServicoRepository psr;
    
    /**
     * Variáveis de instância da classe
     */
    private final String listar = "PrestadorServico.xhtml";
    private final String adicionar = "PrestadorServicoAdicionar.xhtml";
    private final String editar = "PrestadorServicoEditar.xhtml";
    private Integer activIndex = 0;

    /**
     * Objetos de instância da classe
     */
    private PrestadorServico prestadorServico;
    private PrestadorServico prestadorServicoSelecionado;
    private DataSistema dat;
    private HoraSistema hs;
    private DataModel<PrestadorServico> listarPrestadorServico;
    private List<SituacaoCadastral> enumSituacao;
    private List<TipoPessoa> enumTipoPessoa;

    @PostConstruct
    public void init() {
        prestadorServicoSelecionado = new PrestadorServico();
        enumSituacao = Arrays.asList(SituacaoCadastral.values());
    }

    public PrestadorServico getPrestadorServico() {
        return prestadorServico;
    }

    public void setPrestadorServico(PrestadorServico prestadorServico) {
        this.prestadorServico = prestadorServico;
    }

    /**
     * @return the prestadorServicoSelecionado
     */
    public PrestadorServico getPrestadorServicoSelecionado() {
        return prestadorServicoSelecionado;
    }

    /**
     * @param prestadorServicoSelecionado the prestadorServicoSelecionado to set
     */
    public void setPrestadorServicoSelecionado(PrestadorServico prestadorServicoSelecionado) {
        this.prestadorServicoSelecionado = prestadorServicoSelecionado;
    }

    public DataModel<PrestadorServico> getListarPrestadorServico() {
        List<PrestadorServico> lista = psr.list();
        listarPrestadorServico = new ListDataModel<PrestadorServico>(lista);
        return listarPrestadorServico;
    }

    public void setListarPrestadorServico(DataModel<PrestadorServico> listarPrestadorServico) {
        this.listarPrestadorServico = listarPrestadorServico;
    }

    public List<SituacaoCadastral> getEnumSituacao() {
        return enumSituacao;
    }

    /**
     * @return the enumTipoPessoa
     */
    public List<TipoPessoa> getEnumTipoPessoa() {
        enumTipoPessoa = Arrays.asList(TipoPessoa.values());
        return enumTipoPessoa;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        prestadorServico.setUsuarioCadastro(usuarioCadastro);
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
     * Retorna a situação cadastral do proprietário
     * @param cod
     * @return String contendo a descrição da situação do proprietário
     */
    public String getSituacao(Integer cod){
        return SituacaoCadastral.toEnum(cod).getDescricao();
    }
   
    /**
     * Retorna o Tipo de Pessoa
     * @param cod
     * @return String contendo a descrição do tipo de pessoa
     */
    public String getTipoPessoa(Integer cod){
        return TipoPessoa.toEnum(cod).getDescricao();
    }
    
    /**
     * Prepara o formulário para receber um novo cadastro
     * @return a página inicial que requisitou
     */
    public String adicionaForm() {
        setActivIndex(2);
        prestadorServico = new PrestadorServico();
        return adicionar;
    }

    public String adicionaRegistro() {
        dat = new DataSistema();
        hs = new HoraSistema();
        setActivIndex(0);
        dat.setData("");
        prestadorServico.setDataCadastro(Date.valueOf(dat.getData()));
        prestadorServico.setHoraCadastro(Time.valueOf(hs.getHora()));
        psr.create(prestadorServico);
        return listar;
    }

    public String excluirRegistro() {
        setActivIndex(0);
        PrestadorServico c = psr.getById(prestadorServico.getCpfCnpj());
        psr.delete(c);
        return listar;
    }

    public String editarRegistro() {
        setActivIndex(1);
        return editar;
    }

    public String salvarRegistro() {
        dat = new DataSistema();
        hs = new HoraSistema();
        setActivIndex(0);
        dat.setData("");
        prestadorServico.setDataModificacao(Date.valueOf(dat.getData()));
        prestadorServico.setHoraModificacao(Time.valueOf(hs.getHora()));
        psr.save(prestadorServico);
        return listar;
    }

    public void onRowSelect(SelectEvent e) {
        System.out.println("Linha Selecionada: " + ((PrestadorServico) e.getObject()).getCpfCnpj());
        setPrestadorServico(psr.getById(((PrestadorServico) e.getObject()).getCpfCnpj()));
    }
}