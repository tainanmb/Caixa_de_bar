package caixa;


import java.util.ArrayList;
import java.util.Iterator;



public class Table {
	
	/**
	 * Declaração dos campos da classe
	 */
	
	private double numero;
	private ArrayList<Item> consumo;
	
	
	
	
	/**
	 * Construtor sem parâmetro
	 */
	public Table() {
		this.numero=0;
		this.consumo=null;
			
	}
	
	/**
	 * Construtor com parâmetro
	 */
	public Table(double numero, ArrayList<Item> consumo) {
		this.numero=numero;
		this.consumo=consumo;
		
		
	}
	
	/**
	 *  Método get que retorna o número da mesa
	 */
	
	public double get_numero() {
		return this.numero;
	}
	
	/**
	 *  Método get que retorna a lista dos itens consumidos
	 */
	
	public ArrayList<Item> get_consumo() {
		return this.consumo;
	}
	
	/**
	 *  Método get que retorna um item especifico da lista de consumo pela posição
	 */
	
	public Item get_item(int posicao) {

		return this.consumo.get(posicao);
		
	}
	
	
	
	/**
	 * Método que retorna um texto contendo as informações da bebida
	 * @return Texto contendo os dados da bebida
	 */			
	public String toString () {
    	String text;
    	text = "";
    	text +=  "Mesa "+ numero+ "\n"+"\n";
    	Iterator<Item> iterator1 = this.consumo.iterator();
    	while (iterator1.hasNext()) {
    		text += iterator1.next() + "\n";
    	}
 	
    	return text;
    }
	
	


}

