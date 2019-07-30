package com.condomino.domain;

import com.condomino.domain.Morador;
import com.condomino.domain.Unidade;
import com.condomino.domain.VisitaPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-30T11:26:30")
@StaticMetamodel(Visita.class)
public class Visita_ { 

    public static volatile SingularAttribute<Visita, Integer> situacao;
    public static volatile SingularAttribute<Visita, String> cdUnidade;
    public static volatile SingularAttribute<Visita, Integer> tipoVisita;
    public static volatile SingularAttribute<Visita, Date> horaModificacao;
    public static volatile SingularAttribute<Visita, VisitaPK> visitaPK;
    public static volatile SingularAttribute<Visita, Date> horaEntrada;
    public static volatile SingularAttribute<Visita, String> cdTorre;
    public static volatile SingularAttribute<Visita, String> usuarioModificacao;
    public static volatile SingularAttribute<Visita, Unidade> unidade;
    public static volatile SingularAttribute<Visita, Date> dataSaida;
    public static volatile SingularAttribute<Visita, Date> dataModificacao;
    public static volatile SingularAttribute<Visita, Morador> morador;
    public static volatile SingularAttribute<Visita, Date> dataEntrada;
    public static volatile SingularAttribute<Visita, Date> horaSaida;
    public static volatile SingularAttribute<Visita, Date> horaCadastro;
    public static volatile SingularAttribute<Visita, String> usuarioCadastro;
    public static volatile SingularAttribute<Visita, Date> dataCadastro;
    public static volatile SingularAttribute<Visita, String> cdMorador;

}