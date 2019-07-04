/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.condomino.dao;

import com.condomino.factory.HibernateUtility;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Cristiano de Oliveira Sousa criado em 20/05/2019
 */
public class AcessoBancoDAO<T,ID extends Serializable> implements AcessoBancoInterfaceDAO<T, ID>{

    private final Class<T> oClass;

    public AcessoBancoDAO() {
        this.oClass = (Class<T>) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T create(T objeto) {
        try {
            Object obj = null;
            HibernateUtility.beginTransaction();
            obj = HibernateUtility.getSession().save(objeto);
            HibernateUtility.commitTransaction();
            return (T) obj;
        } catch (HibernateException hibernateException) {
            cancel();
            throw hibernateException;
        }
    }

    @Override
    public Class<T> getObjectClass() {
        return this.oClass;
    }

    @Override
    public T save(T objeto) {
        try {
            Object obj = null;
            HibernateUtility.beginTransaction();
            obj = HibernateUtility.getSession().merge(objeto);
            HibernateUtility.commitTransaction();
            HibernateUtility.closeSession();
            return (T) obj;
        } catch (HibernateException hibernateException) {
            cancel();
            throw hibernateException;
        }
    }

    @Override
    public void delete(T objeto) {
        try {
            HibernateUtility.beginTransaction();
            HibernateUtility.getSession().flush();
            HibernateUtility.getSession().clear();
            HibernateUtility.getSession().delete(objeto);
            HibernateUtility.commitTransaction();
            HibernateUtility.closeSession();
        } catch (HibernateException hibernateException) {
            cancel();
            throw hibernateException;
        }
    }

    @Override
    public void deleteItem(T objeto) {
        try {
            HibernateUtility.beginTransaction();
            HibernateUtility.getSession().delete(objeto);
        } catch (HibernateException hibernateException) {
            cancel();
            throw hibernateException;
        }
    }

    @Override
    public List<T> list() {
        try {
            HibernateUtility.beginTransaction();
            List list = HibernateUtility.getSession().createCriteria(oClass).list();
            //HibernateUtility.closeSession();
            HibernateUtility.commitTransaction();
            return (List<T>) list;
        } catch (HibernateException hibernateException) {
            cancel();
            throw hibernateException;
        }
    }

    @Override
    public T getById(Serializable id) {
        try {
            HibernateUtility.beginTransaction();
            Object obj = HibernateUtility.getSession().get(oClass, id);
            HibernateUtility.commitTransaction();
            return (T) obj;
        } catch (HibernateException hibernateException) {
            cancel();
            throw hibernateException;
        }
    }

    @Override
    public T getById(Serializable id, boolean lock) {
        try {
            if (lock) {
                return (T) HibernateUtility.getSession().get(oClass, id, LockOptions.UPGRADE);
            } else {
                return (T) HibernateUtility.getSession().get(oClass, id);
            }
        } catch (HibernateException hibernateException) {
            cancel();
            throw hibernateException;
        }
    }

    @Override
    public List<T> listCriterio(String subClazz, Map<String, Object> filtrosConsulta, int tipoConsulta) {
        List<T> lista = new ArrayList<T>();
        Set entradas = filtrosConsulta.entrySet();

        try {
            HibernateUtility.beginTransaction();
            Criteria crit = HibernateUtility.getSession().createCriteria(oClass);
            if (subClazz == null) {
                for (Iterator it = entradas.iterator(); it.hasNext();) {
                    Entry object = (Entry) it.next();
                    if (object.getValue() instanceof Enum) {
                        crit.add(Restrictions.eq(object.getKey().toString(), object.getValue()));
                    } else if (tipoConsulta == 0) {
                        crit.add(Restrictions.ilike(object.getKey().toString(), "%" + object.getValue() + "%"));
                    } else if (tipoConsulta == 1) {
                        crit.add(Restrictions.eq(object.getKey().toString(), object.getValue()));
                    } else if (tipoConsulta == 2) {
                        crit.add(Restrictions.gt(object.getKey().toString(), object.getValue()));
                    } else if (tipoConsulta == 3) {
                        crit.add(Restrictions.ge(object.getKey().toString(), object.getValue()));
                    } else if (tipoConsulta == 4) {
                        crit.add(Restrictions.lt(object.getKey().toString(), object.getValue()));
                    } else if (tipoConsulta == 5) {
                        crit.add(Restrictions.le(object.getKey().toString(), object.getValue()));
                    } else if (tipoConsulta == 2) {
                        crit.add(Restrictions.ne(object.getKey().toString(), object.getValue()));
                    }
                }
            } else {
                for (Iterator it = entradas.iterator(); it.hasNext();) {
                    Entry object = (Entry) it.next();
                    //crit.createCriteria(subClazz).add(Restrictions.ilike(object.getKey().toString(), "%" + object.getValue() + "%"));
                    if (object.getValue() instanceof Enum) {
                    } else if (tipoConsulta == 0) {
                        crit.createCriteria(subClazz).add(Restrictions.ilike(object.getKey().toString(), "%" + object.getValue() + "%"));
                    } else if (tipoConsulta == 1) {
                        crit.createCriteria(subClazz).add(Restrictions.eq(object.getKey().toString(), object.getValue()));
                    } else if (tipoConsulta == 2) {
                        crit.createCriteria(subClazz).add(Restrictions.gt(object.getKey().toString(), object.getValue()));
                    } else if (tipoConsulta == 3) {
                        crit.createCriteria(subClazz).add(Restrictions.ge(object.getKey().toString(), object.getValue()));
                    } else if (tipoConsulta == 4) {
                        crit.createCriteria(subClazz).add(Restrictions.lt(object.getKey().toString(), object.getValue()));
                    } else if (tipoConsulta == 5) {
                        crit.createCriteria(subClazz).add(Restrictions.le(object.getKey().toString(), object.getValue()));
                    } else if (tipoConsulta == 2) {
                        crit.createCriteria(subClazz).add(Restrictions.ne(object.getKey().toString(), object.getValue()));
                    }
                }
            }
            crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            crit.setMaxResults(20);
            lista = (List<T>) crit.list();
            HibernateUtility.commitTransaction();
            //HibernateUtility.closeSession();
            return lista;
        } catch (HibernateException hibernateException) {
            cancel();
            throw hibernateException;
        }
    }

    @Override
    public List<T> consultaHQL(String consulta) {
        HibernateUtility.beginTransaction();
        List list = HibernateUtility.getSession().createQuery(consulta).list();
        HibernateUtility.commitTransaction();
        return (List<T>) list;
    }

    @Override
    public void cancel() {
        HibernateUtility.rollbackTransaction();
        HibernateUtility.closeSession();

    }
    
    public List<T> consultaNamedQuery(String namedQuery){
        HibernateUtility.beginTransaction();
        List list = HibernateUtility.getSession().createSQLQuery(namedQuery).list();
        HibernateUtility.commitTransaction();
        return list;
    }

    /**
     * converter valor string com criptograia md5
     *
     * @param valor
     * @return
     */
    public String convertToMd5(String valor) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] valorMD5 = md.digest(valor.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}