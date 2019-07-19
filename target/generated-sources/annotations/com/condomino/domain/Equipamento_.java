package com.condomino.domain;

import com.condomino.domain.EquipamentoPK;
import com.condomino.domain.Praca;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-19T11:17:48")
@StaticMetamodel(Equipamento.class)
public class Equipamento_ { 

    public static volatile SingularAttribute<Equipamento, Date> dataModificacao;
    public static volatile SingularAttribute<Equipamento, Integer> situacao;
    public static volatile SingularAttribute<Equipamento, Praca> praca;
    public static volatile SingularAttribute<Equipamento, EquipamentoPK> equipamentoPK;
    public static volatile SingularAttribute<Equipamento, Date> horaModificacao;
    public static volatile SingularAttribute<Equipamento, String> usuarioModificacao;
    public static volatile SingularAttribute<Equipamento, String> nome;
    public static volatile SingularAttribute<Equipamento, Date> horaCadastro;
    public static volatile SingularAttribute<Equipamento, String> usuarioCadastro;
    public static volatile SingularAttribute<Equipamento, Date> dataCadastro;

}