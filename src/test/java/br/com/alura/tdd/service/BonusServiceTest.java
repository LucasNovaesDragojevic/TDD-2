package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
    
    @Test
    void bonusDeveSerZeroParaFuncionaioComSalarioMuitoAlto() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Lucas", LocalDate.now(), new BigDecimal(20000.00));
        
        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario));
    }

    @Test
    void bonusDeveSerDezPorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Lucas", LocalDate.now(), new BigDecimal(2500.00));
        BigDecimal bonus = bonusService.calcularBonus(funcionario);
    
        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveSerDezPorCentoParaSalarioDeExatamenteDezMilReais() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Lucas", LocalDate.now(), new BigDecimal(10000.00));
        BigDecimal bonus = bonusService.calcularBonus(funcionario);
    
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
