package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.enumerator.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {
    
    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    private void beforeEach() {
        reajusteService = new ReajusteService();
        funcionario = new Funcionario("Lucas", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    void reajusteDeveSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerDeQuinzePorCentoQuandoDesempenhoForBom() {
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerDeVintePorCentoQuandoDesempenhoForOtimo() {
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
