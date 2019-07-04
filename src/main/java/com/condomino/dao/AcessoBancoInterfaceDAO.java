/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Cristiano de Oliveira Sousa criado em 20/05/2019
 */
public interface AcessoBancoInterfaceDAO<T, ID extends Serializable> {

    public Class<T> getObjectClass();

    public T create(T objeto);

    public T save(T objeto);

    public void delete(T objeto);

    public void deleteItem(T objeto);

    public List<T> list();

    public List<T> listCriterio(String subClazz, Map<String, Object> filtrosConsulta, int tipoConsulta);

    public T getById(Serializable id);

    public T getById(Serializable id, boolean lock);

    public List<T> consultaHQL(String consulta);

    public void cancel();
}