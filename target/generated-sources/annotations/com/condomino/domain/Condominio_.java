package com.condomino.domain;

import com.condomino.domain.Praca;
import com.condomino.domain.Torre;
import com.condomino.domain.Unidade;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T12:21:09")
@StaticMetamodel(Condominio.class)
public class Condominio_ { 

    public static volatile SingularAttribute<Condominio, String> cidade;
    public static volatile SingularAttribute<Condominio, Integer> situacao;
    public static volatile ListAttribute<Condominio, Unidade> unidadeList;
    public static volatile SingularAttribute<Condominio, String> numero;
    public static volatile SingularAttribute<Condominio, Date> horaModificacao;
    public static volatile ListAttribute<Condominio, Praca> pracaList;
    public static volatile SingularAttribute<Condominio, String> bairro;
    public static volatile SingularAttribute<Condominio, String> usuarioModificacao;
    public static volatile SingularAttribute<Condominio, String> nomeCondominio;
    public static volatile ListAttribute<Condominio, Torre> torreList;
    public static volatile SingularAttribute<Condominio, Date> dataModificacao;
    public static volatile SingularAttribute<Condominio, String> uf;
    public static volatile SingularAttribute<Condominio, String> complemento;
    public static volatile SingularAttribute<Condominio, String> cdCondominio;
    public static volatile SingularAttribute<Condominio, String> logradouro;
    public static volatile SingularAttribute<Condominio, Date> horaCadastro;
    public static volatile SingularAttribute<Condominio, String> usuarioCadastro;
    public static volatile SingularAttribute<Condominio, Date> dataCadastro;

}