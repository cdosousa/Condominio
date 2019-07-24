package com.condomino.domain;

import com.condomino.domain.Unidade;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-24T10:57:02")
@StaticMetamodel(Proprietario.class)
public class Proprietario_ { 

    public static volatile SingularAttribute<Proprietario, Integer> tipoPessoa;
    public static volatile SingularAttribute<Proprietario, String> telefone;
    public static volatile SingularAttribute<Proprietario, Integer> situacao;
    public static volatile ListAttribute<Proprietario, Unidade> unidadeList;
    public static volatile SingularAttribute<Proprietario, String> numero;
    public static volatile SingularAttribute<Proprietario, Date> horaModificacao;
    public static volatile SingularAttribute<Proprietario, String> bairro;
    public static volatile SingularAttribute<Proprietario, String> municipio;
    public static volatile SingularAttribute<Proprietario, String> usuarioModificacao;
    public static volatile SingularAttribute<Proprietario, String> cep;
    public static volatile SingularAttribute<Proprietario, Date> dataModificacao;
    public static volatile SingularAttribute<Proprietario, String> uf;
    public static volatile SingularAttribute<Proprietario, String> complemento;
    public static volatile SingularAttribute<Proprietario, String> logradouro;
    public static volatile SingularAttribute<Proprietario, String> celular;
    public static volatile SingularAttribute<Proprietario, String> cpfCnpj;
    public static volatile SingularAttribute<Proprietario, String> nomeRazaoSocial;
    public static volatile SingularAttribute<Proprietario, Date> horaCadastro;
    public static volatile SingularAttribute<Proprietario, String> usuarioCadastro;
    public static volatile SingularAttribute<Proprietario, Date> dataCadastro;

}