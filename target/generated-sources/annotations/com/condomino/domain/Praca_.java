package com.condomino.domain;

import com.condomino.domain.Condominio;
import com.condomino.domain.Equipamento;
import com.condomino.domain.PracaPK;
import com.condomino.domain.Torre;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-05T15:01:11")
@StaticMetamodel(Praca.class)
public class Praca_ { 

    public static volatile SingularAttribute<Praca, Date> dataModificacao;
    public static volatile SingularAttribute<Praca, Integer> situacao;
    public static volatile SingularAttribute<Praca, Date> horaModificacao;
    public static volatile SingularAttribute<Praca, Condominio> condominio;
    public static volatile SingularAttribute<Praca, String> usuarioModificacao;
    public static volatile SingularAttribute<Praca, String> nome;
    public static volatile SingularAttribute<Praca, Date> horaCadastro;
    public static volatile SingularAttribute<Praca, String> usuarioCadastro;
    public static volatile SingularAttribute<Praca, Date> dataCadastro;
    public static volatile ListAttribute<Praca, Torre> torreList;
    public static volatile ListAttribute<Praca, Equipamento> equipamentoList;
    public static volatile SingularAttribute<Praca, PracaPK> pracaPK;

}