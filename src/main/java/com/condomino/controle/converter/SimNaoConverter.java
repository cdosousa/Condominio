/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.controle.converter;

import com.parametros.modelo.enums.SimNao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cristiano de Oliveira Sousa
 * @local OICI Serviços e Desenvolvimento Ltda-EPP
 * @data criado em 24/07/2019
 */
@FacesConverter(forClass = SimNao.class)
public class SimNaoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()){
            return (SimNao) component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value instanceof SimNao){
           SimNao pt = (SimNao) value;
           if(pt != null && pt instanceof SimNao && pt.getCod() != null){
               component.getAttributes().put(pt.getCod().toString(), pt);
               return pt.getCod().toString();
           }
       }
       return "";
    }
}