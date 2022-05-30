package caixa;

public class Item {
	
	
	/**
	 * Declara��o dos campos da classe
	 */
	
	private String nome;
	private double preco;
	private double quantidade;
	
	
	/**
	 * Construtor sem par�metro
	 */
	public Item() {
		this.nome=null;
		this.preco=0.0d;
		this.quantidade=0;
		
	}
	
	/**
	 * Construtor com par�metro
	 */
	public Item(String nome, double preco, double quantidade) {
		this.nome=nome;
		this.preco=preco;
		this.quantidade=quantidade;
		
	}
	
	/**
	 * M�todo get para retornar o nome do item
	 */
	public String get_nome() {
		return this.nome;
	}
	
	
	/**
	 * M�todo get para retornar o pre�o do item
	 */
	public double get_preco() {
		return this.preco;
	}
	
	/**
	 * M�todo get para retornar a quantidade do item
	 */
	public double get_quantidade() {
		return this.quantidade;
	}
	
	/**
	 * M�todo set para editar o nome do item
	 */
	public void  set_nome(String nome) {
		this.nome=nome;
		
	}
	

	/**
	 * M�todo set para editar o pre�o do item
	 */
	public void  set_preco(double preco) {
		this.preco=preco;
	}
	
	/**
	 * M�todo que retorna um texto contendo as informa��es do item
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