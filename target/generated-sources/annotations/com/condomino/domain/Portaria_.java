package com.condomino.domain;

import com.condomino.domain.Condominio;
import com.condomino.domain.PortariaPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T16:52:59")
@StaticMetamodel(Portaria.class)
public class Portaria_ { 

    public static volatile SingularAttribute<Portaria, Date> dataModificacao;
    public static volatile SingularAttribute<Portaria, PortariaPK> portariaPK;
    public static volatile SingularAttribute<Portaria, Integer> tipo;
    public static volatile SingularAttribute<Portaria, Integer> situacao;
    public static volatile SingularAttribute<Portaria, Date> horaModificacao;
    public static volatile SingularAttribute<Portaria, Condominio> condominio;
    public static volatile SingularAttribute<Portaria, String> usuarioModificacao;
    public static volatile SingularAttribute<Portaria, String> nome;
    public static volatile SingularAttribute<Portaria, Date> horaCadastro;
    public static volatile SingularAttribute<Portaria, String> usuarioCadastro;
    public static volatile SingularAttribute<Portaria, Date> dataCadastro;

}