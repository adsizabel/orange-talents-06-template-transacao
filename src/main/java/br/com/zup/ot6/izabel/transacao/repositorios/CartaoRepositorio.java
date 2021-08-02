package br.com.zup.ot6.izabel.transacao.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.ot6.izabel.transacao.entidades.Cartao;

public interface CartaoRepositorio extends JpaRepository<Cartao, String>{

}
