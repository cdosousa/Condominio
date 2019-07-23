package com.condomino.domain;

import com.condomino.domain.MoradorPK;
import com.condomino.domain.Unidade;
import com.condomino.domain.Veiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-23T14:26:46")
@StaticMetamodel(Morador.class)
public class Morador_ { 

    public static volatile SingularAttribute<Morador, String> telefone;
    public static volatile SingularAttribute<Morador, Integer> situacao;
    public static volatile ListAttribute<Morador, Veiculo> veiculoList;
    public static volatile SingularAttribute<Morador, String> cdUnidade;
    public static volatile SingularAttribute<Morador, Date> horaModificacao;
    public static volatile SingularAttribute<Morador, String> orgaoEmissorRg;
    public static volatile SingularAttribute<Morador, String> cdTorre;
    public static volatile SingularAttribute<Morador, Date> dataEmissaoRg;
    public static volatile SingularAttribute<Morador, String> usuarioModificacao;
    public static volatile SingularAttribute<Morador, String> nome;
    public static volatile SingularAttribute<Morador, Unidade> unidade;
    public static volatile SingularAttribute<Morador, Date> dataModificacao;
    public static volatile SingularAttribute<Morador, String> rg;
    public static volatile SingularAttribute<Morador, MoradorPK> moradorPK;
    public static volatile SingularAttribute<Morador, String> cpf;
    public static volatile SingularAttribute<Morador, String> celular;
    public static volatile SingularAttribute<Morador, Integer> tipoParentesco;
    public static volatile SingularAttribute<Morador, Integer> sexo;
    public static volatile SingularAttribute<Morador, Date> horaCadastro;
    public static volatile SingularAttribute<Morador, String> usuarioCadastro;
    public static volatile SingularAttribute<Morador, Date> dataCadastro;

}