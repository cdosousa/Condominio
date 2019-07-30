/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle.converter;

import com.parametros.modelo.enums.TipoVisita;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data criado em 25/07/2019
 */
@FacesConverter(forClass = TipoVisita.class)
public class TipoVisitaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()){
            return (TipoVisita) component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value instanceof TipoVisita){
           TipoVisita pt = (TipoVisita) value;
           if(pt != null && pt instanceof TipoVisita && pt.getCod() != null){
               component.getAttributes().put(pt.getCod().toString(), pt);
               return pt.getCod().toString();
           }
       }
       return "";
    }
}