package com.condomino.domain;

import com.condomino.domain.Condominio;
import com.condomino.domain.Praca;
import com.condomino.domain.TorrePK;
import com.condomino.domain.Unidade;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-23T14:26:46")
@StaticMetamodel(Torre.class)
public class Torre_ { 

    public static volatile SingularAttribute<Torre, Integer> situacao;
    public static volatile SingularAttribute<Torre, Praca> praca;
    public static volatile ListAttribute<Torre, Unidade> unidadeList;
    public static volatile SingularAttribute<Torre, Date> horaModificacao;
    public static volatile SingularAttribute<Torre, String> usuarioModificacao;
    public static volatile SingularAttribute<Torre, String> nome;
    public static volatile SingularAttribute<Torre, Date> dataModificacao;
    public static volatile SingularAttribute<Torre, Condominio> condominio;
    public static volatile SingularAttribute<Torre, String> cdPraca;
    public static volatile SingularAttribute<Torre, Date> horaCadastro;
    public static volatile SingularAttribute<Torre, TorrePK> torrePK;
    public static volatile SingularAttribute<Torre, String> usuarioCadastro;
    public static volatile SingularAttribute<Torre, Date> dataCadastro;

}