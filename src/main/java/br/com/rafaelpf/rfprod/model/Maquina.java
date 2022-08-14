package br.com.rafaelpf.rfprod.model;

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
 * Classe de Máquina
 *
 * @author Rafael Padilha Ferraz
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String numeracao;
    private String descricao;

	@ManyToOne // Maquina N:1 Processo
	@JoinColumn(name = "id_processo")
	private Processo processo;

}
