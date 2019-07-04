/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle.converter;

import com.parametros.modelo.enums.TipoPessoa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data criado em 04/07/2019
 */
//@FacesConverter(value"situacaoConverter")
@FacesConverter(forClass = TipoPessoa.class)
public class TipoPessoaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()){
            return (TipoPessoa) component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value instanceof TipoPessoa){
           TipoPessoa sc = (TipoPessoa) value;
           if(sc != null && sc instanceof TipoPessoa && sc.getCod() != null){
               component.getAttributes().put(sc.getCod().toString(), sc);
               return sc.getCod().toString();
           }
       }
       return "";
    }
}