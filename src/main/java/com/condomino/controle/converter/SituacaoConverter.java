/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle.converter;

import com.parametros.modelo.enums.SituacaoCadastral;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data criado em 19/06/2019
 */
//@FacesConverter(value"situacaoConverter")
@FacesConverter(forClass = SituacaoCadastral.class)
public class SituacaoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()){
            return (SituacaoCadastral) component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value instanceof SituacaoCadastral){
           SituacaoCadastral sc = (SituacaoCadastral) value;
           if(sc != null && sc instanceof SituacaoCadastral && sc.getCod() != null){
               component.getAttributes().put(sc.getCod().toString(), sc);
               return sc.getCod().toString();
           }
       }
       return "";
    }
}