package br.com.rafaelpf.rfprod.model;

import java.math.BigDecimal;
import java.sql.Date;

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
 * Classe de Funcionários
 * @author Rafael Padilha Ferraz
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String sobrenome;

	@Column(name = "data_nascimento")
	private Date dataNascimento;
	private String cpf;
	private String celular;
	private String email;
	private String endereco;
	private BigDecimal salario;

	@ManyToOne // Funcionario N:1 Maquina
	@JoinColumn(name = "id_maquina")
	private Maquina maquina;

}
