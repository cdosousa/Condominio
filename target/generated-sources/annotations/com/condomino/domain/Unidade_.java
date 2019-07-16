package com.condomino.domain;

import com.condomino.domain.Condominio;
import com.condomino.domain.Praca;
import com.condomino.domain.Proprietario;
import com.condomino.domain.Torre;
import com.condomino.domain.UnidadePK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-16T09:28:05")
@StaticMetamodel(Unidade.class)
public class Unidade_ { 

    public static volatile SingularAttribute<Unidade, String> andar;
    public static volatile SingularAttribute<Unidade, Integer> situacao;
    public static volatile SingularAttribute<Unidade, Praca> praca;
    public static volatile SingularAttribute<Unidade, Date> horaModificacao;
    public static volatile SingularAttribute<Unidade, UnidadePK> unidadePK;
    public static volatile SingularAttribute<Unidade, String> usuarioModificacao;
    public static volatile SingularAttribute<Unidade, Date> dataModificacao;
    public static volatile SingularAttribute<Unidade, Condominio> condominio;
    public static volatile SingularAttribute<Unidade, String> cdPraca;
    public static volatile SingularAttribute<Unidade, Proprietario> cpfCnpjProprietario;
    public static volatile SingularAttribute<Unidade, Date> horaCadastro;
    public static volatile SingularAttribute<Unidade, Torre> torre;
    public static volatile SingularAttribute<Unidade, String> usuarioCadastro;
    public static volatile SingularAttribute<Unidade, Date> dataCadastro;

}