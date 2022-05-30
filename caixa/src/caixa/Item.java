package caixa;

public class Item {
	
	
	/**
	 * Declaração dos campos da classe
	 */
	
	private String nome;
	private double preco;
	private double quantidade;
	
	
	/**
	 * Construtor sem parâmetro
	 */
	public Item() {
		this.nome=null;
		this.preco=0.0d;
		this.quantidade=0;
		
	}
	
	/**
	 * Construtor com parâmetro
	 */
	public Item(String nome, double preco, double quantidade) {
		this.nome=nome;
		this.preco=preco;
		this.quantidade=quantidade;
		
	}
	
	/**
	 * Método get para retornar o nome do item
	 */
	public String get_nome() {
		return this.nome;
	}
	
	
	/**
	 * Método get para retornar o preço do item
	 */
	public double get_preco() {
		return this.preco;
	}
	
	/**
	 * Método get para retornar a quantidade do item
	 */
	public double get_quantidade() {
		return this.quantidade;
	}
	
	/**
	 * Método set para editar o nome do item
	 */
	public void  set_nome(String nome) {
		this.nome=nome;
		
	}
	

	/**
	 * Método set para editar o preço do item
	 */
	public void  set_preco(double preco) {
		this.preco=preco;
	}
	
	/**
	 * Método que retorna um texto contendo as informações do item
	 * @return Texto contendo os dados do item consumido
	 */			
	public String toString () {
    	String texto;
    	texto = "";
    	texto += quantidade + " ";
    	texto +=  nome;
    	texto += " R$"+  String.format("%.2f", preco)+"/un";
    	
    	return texto;
    }	      

}