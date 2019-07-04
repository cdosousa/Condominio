/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle.converter;

import com.parametros.modelo.enums.PortariaTipo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data criado em 02/07/2019
 */
@FacesConverter(forClass = PortariaTipo.class)
public class TipoPortariaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()){
            return (PortariaTipo) component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value instanceof PortariaTipo){
           PortariaTipo pt = (PortariaTipo) value;
           if(pt != null && pt instanceof PortariaTipo && pt.getCod() != null){
               component.getAttributes().put(pt.getCod().toString(), pt);
               return pt.getCod().toString();
           }
       }
       return "";
    }
}