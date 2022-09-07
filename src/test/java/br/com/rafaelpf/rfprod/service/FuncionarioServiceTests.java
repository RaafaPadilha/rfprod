package br.com.rafaelpf.rfprod.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.rafaelpf.rfprod.model.Funcionario;
import br.com.rafaelpf.rfprod.model.Maquina;
import br.com.rafaelpf.rfprod.model.Processo;
import br.com.rafaelpf.rfprod.repository.FuncionarioRepository;
import br.com.rafaelpf.rfprod.service.impl.FuncionarioServiceImpl;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTests {

	@Mock
	private FuncionarioRepository funcionarioRepository;

	@InjectMocks
	private FuncionarioServiceImpl funcionarioServiceImpl;

	private Processo processo;
	private Maquina maquina;
	private Funcionario funcionario;

	@BeforeEach
	public void setup() throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		processo = Processo.builder()
			.id(1L)
			.nome("Extrusão")
			.build();

		maquina = Maquina.builder()
			.id(1L)
			.nome("Extrusora Dupla Masterflex")
			.numeracao("EXT-002")
			.descricao("Extrusora dupla Masterflex p/ cobre e alumínio")
			.processo(processo)
			.build();

		funcionario = Funcionario.builder()
			.id(1L)
			.nome("Rafael")
			.sobrenome("Ferraz")
			.dataNascimento(new Date(df.parse("2022-09-05").getTime()))
			.cpf("123.456.789-10")
			.celular("(19) 00000-0000")
			.email("emailteste@teste.com")
			.endereco("Rua teste - Jd. teste")
			.salario(new BigDecimal(2000))
			.maquina(maquina)
			.build();
	}

	@DisplayName("Testar o método novoFuncionario")
	@Test
	public void novoFuncionarioTeste() {
		when(funcionarioRepository.save(funcionario)).thenReturn(funcionario);

		Funcionario novoFuncionario = funcionarioServiceImpl.novoFuncionario(funcionario);

		assertThat(novoFuncionario).isNotNull();
	}

	@DisplayName("Testar o método todosFuncionarios")
	@Test
	public void todosFuncionariosTeste() {
		Processo processo2 = Processo.builder()
			.id(1L)
			.nome("Extrusão")
			.build();

		Maquina maquina2 = Maquina.builder()
			.id(2L)
			.nome("Trefila Horizontal Multifilar")
			.numeracao("TRF-001")
			.descricao("Trefila horizontal multifilar modelo Raichbech 8 fios")
			.processo(processo2)
			.build();

		Funcionario funcionario2 = Funcionario.builder()
			.id(1L)
			.nome("Luan")
			.sobrenome("Tomás Bruno Caldeira")
			.dataNascimento(new Date(1970-06-20))
			.cpf("910.942.428-88")
			.celular("(61) 98796-0504")
			.email("emailteste2@teste.com")
			.endereco("Rua teste2 - Jd. teste2")
			.salario(new BigDecimal(4000))
			.maquina(maquina2)
			.build();

		when(funcionarioRepository.findAll()).thenReturn(List.of(funcionario, funcionario2));

		List<Funcionario> funcionarios = funcionarioServiceImpl.todosFuncionarios();

		assertThat(funcionarios).isNotNull();
		assertThat(funcionarios.size()).isEqualTo(2);
	}

	@DisplayName("Testar o método funcionarioPorId")
	@Test
	public void funcionarioPorIdTeste() {
		when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario));

		Funcionario funcionarioId = funcionarioServiceImpl.funcionarioPorId(funcionario.getId()).get();

		assertThat(funcionarioId).isNotNull();
	}

	@DisplayName("Testar o método excluirFuncionario")
	@Test
	public void excluirFuncionarioTeste() {
		doNothing().when(funcionarioRepository).deleteById(1L);

		funcionarioServiceImpl.excluirFuncionario(1L);

		verify(funcionarioRepository, times(1)).deleteById(1L);
	}

}
