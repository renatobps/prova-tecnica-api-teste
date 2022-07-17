package br.com.sicredi.simulacao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Restricao.class)
public abstract class Restricao_ {

	public static volatile SingularAttribute<Restricao, String> cpf;
	public static volatile SingularAttribute<Restricao, String> tipoRestricao;
	public static volatile SingularAttribute<Restricao, Long> id;

	public static final String CPF = "cpf";
	public static final String TIPO_RESTRICAO = "tipoRestricao";
	public static final String ID = "id";

}

