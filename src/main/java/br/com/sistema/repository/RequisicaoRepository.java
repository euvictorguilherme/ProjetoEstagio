package br.com.sistema.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.sistema.models.Requisicao;

public interface RequisicaoRepository extends CrudRepository<Requisicao,String> {

}
