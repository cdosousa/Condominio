package com.condomino.domain;

import com.condomino.domain.Morador;
import com.condomino.domain.Unidade;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-23T14:26:46")
@StaticMetamodel(Veiculo.class)
public class Veiculo_ { 

    public static volatile SingularAttribute<Veiculo, Integer> situacao;
    public static volatile SingularAttribute<Veiculo, String> cdUnidade;
    public static volatile SingularAttribute<Veiculo, Date> horaModificacao;
    public static volatile SingularAttribute<Veiculo, String> cor;
    public static volatile SingularAttribute<Veiculo, String> cdTorre;
    public static volatile SingularAttribute<Veiculo, String> usuarioModificacao;
    public static volatile SingularAttribute<Veiculo, Unidade> unidade;
    public static volatile SingularAttribute<Veiculo, String> modelo;
    public static volatile SingularAttribute<Veiculo, Date> dataModificacao;
    public static volatile SingularAttribute<Veiculo, String> marca;
    public static volatile SingularAttribute<Veiculo, Morador> morador;
    public static volatile SingularAttribute<Veiculo, String> cdCondominio;
    public static volatile SingularAttribute<Veiculo, Date> horaCadastro;
    public static volatile SingularAttribute<Veiculo, String> usuarioCadastro;
    public static volatile SingularAttribute<Veiculo, Date> dataCadastro;
    public static volatile SingularAttribute<Veiculo, String> cdMorador;
    public static volatile SingularAttribute<Veiculo, String> placa;

}