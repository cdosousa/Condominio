package com.condomino.domain;

import com.condomino.domain.CondominoPK;
import com.condomino.domain.Unidade;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-04T14:58:10")
@StaticMetamodel(Condomino.class)
public class Condomino_ { 

    public static volatile SingularAttribute<Condomino, String> telefone;
    public static volatile SingularAttribute<Condomino, Integer> situacao;
    public static volatile SingularAttribute<Condomino, Date> horaModificacao;
    public static volatile SingularAttribute<Condomino, String> orgaoEmissorRg;
    public static volatile SingularAttribute<Condomino, Date> dataEmissaoRg;
    public static volatile SingularAttribute<Condomino, String> usuarioModificacao;
    public static volatile SingularAttribute<Condomino, String> nome;
    public static volatile SingularAttribute<Condomino, Unidade> unidade;
    public static volatile SingularAttribute<Condomino, CondominoPK> condominoPK;
    public static volatile SingularAttribute<Condomino, Date> dataModificacao;
    public static volatile SingularAttribute<Condomino, String> rg;
    public static volatile SingularAttribute<Condomino, String> celular;
    public static volatile SingularAttribute<Condomino, Integer> tipoParentesco;
    public static volatile SingularAttribute<Condomino, Integer> sexo;
    public static volatile SingularAttribute<Condomino, Date> horaCadastro;
    public static volatile SingularAttribute<Condomino, String> usuarioCadastro;
    public static volatile SingularAttribute<Condomino, Date> dataCadastro;

}