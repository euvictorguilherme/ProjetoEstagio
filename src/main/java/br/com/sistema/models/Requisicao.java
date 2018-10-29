package br.com.sistema.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Requisicao {// classe entidade do banco de dados

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column
	private String operador;
    @Column
	private String tipoDocumento;
    @Column
	private String aplicacaoCaptura;
    @Column
    private String data;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Long getId() {
		return id;
	}
	public Long setId(Long id) {
		return this.id = id;
	}
	
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getAplicacaoCaptura() {
		return aplicacaoCaptura;
	}
	public void setAplicacaoCaptura(String aplicaçãoCaptura) {
		this.aplicacaoCaptura = aplicaçãoCaptura;
	}
	

}
