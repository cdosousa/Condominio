/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle.converter;

import com.parametros.modelo.enums.GrauParentesco;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data criado em 16/07/2019
 */
@FacesConverter(forClass = GrauParentesco.class)
public class GrauParentescoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()){
            return (GrauParentesco) component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value instanceof GrauParentesco){
           GrauParentesco gp = (GrauParentesco) value;
           if(gp != null && gp instanceof GrauParentesco && gp.getCod() != null){
               component.getAttributes().put(gp.getCod().toString(), gp);
               return gp.getCod().toString();
           }
       }
       return "";
    }
}