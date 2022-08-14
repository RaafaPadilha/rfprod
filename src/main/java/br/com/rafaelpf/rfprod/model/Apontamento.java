package br.com.rafaelpf.rfprod.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de Apontamento
 *
 * @author Rafael Padilha Ferraz
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Apontamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_atual")
	private Date dataAtual;

	@Column(name = "hora_inicio")
	private Time horaInicio;

	@Column(name = "hora_fim")
	private Time horaFim;

	@ManyToOne
	@JoinColumn(name = "id_maquina")
	private Maquina maquina;

	@ManyToOne
	@JoinColumn(name = "id_ordem_producao")
	private OrdemProducao ordemProducao;

}
