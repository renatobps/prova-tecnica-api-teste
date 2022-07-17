package br.com.sicredi.simulacao.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Simulacao.class)
public abstract class Simulacao_ {

	public static volatile SingularAttribute<Simulacao, Integer> parcelas;
	public static volatile SingularAttribute<Simulacao, Boolean> seguro;
	public static volatile SingularAttribute<Simulacao, String> cpf;
	public static volatile SingularAttribute<Simulacao, BigDecimal> valor;
	public static volatile SingularAttribute<Simulacao, String> nome;
	public static volatile SingularAttribute<Simulacao, Long> id;
	public static volatile SingularAttribute<Simulacao, String> email;

	public static final String PARCELAS = "parcelas";
	public static final String SEGURO = "seguro";
	public static final String CPF = "cpf";
	public static final String VALOR = "valor";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String EMAIL = "email";

}

