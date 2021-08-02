package br.com.zup.ot6.izabel.transacao.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.ot6.izabel.transacao.entidades.Transacao;

public interface TransacaoRepositorio extends JpaRepository<Transacao, String>{

	Page<Transacao> findAllByCartaoId(Pageable paginacao, String id);
}
