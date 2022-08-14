package br.com.rafaelpf.rfprod.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de OrdemProducao
 *
 * @author Rafael Padilha Ferraz
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ordem_producao")
public class OrdemProducao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "data_criacao")
	private Date dataCriacao;

	@Column(name = "data_inicio")
	private Date dataInicio;

	@Column(name = "data_fim")
	private Date dataFim;
	private String status;

}
