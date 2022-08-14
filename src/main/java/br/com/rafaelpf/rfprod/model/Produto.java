package br.com.rafaelpf.rfprod.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de Produto
 *
 * @author Rafael Padilha Ferraz
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String categoria;
	private String classe;
	private Integer condutores;
	private BigDecimal bitola;
	private String cor;

}
