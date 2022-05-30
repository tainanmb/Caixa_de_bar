package caixa;


import java.util.ArrayList;
import java.util.Iterator;



public class Table {
	
	/**
	 * Declara��o dos campos da classe
	 */
	
	private double numero;
	private ArrayList<Item> consumo;
	
	
	
	
	/**
	 * Construtor sem par�metro
	 */
	public Table() {
		this.numero=0;
		this.consumo=null;
			
	}
	
	/**
	 * Construtor com par�metro
	 */
	public Table(double numero, ArrayList<Item> consumo) {
		this.numero=numero;
		this.consumo=consumo;
		
		
	}
	
	/**
	 *  M�todo get que retorna o n�mero da mesa
	 */
	
	public double get_numero() {
		return this.numero;
	}
	
	/**
	 *  M�todo get que retorna a lista dos itens consumidos
	 */
	
	public ArrayList<Item> get_consumo() {
		return this.consumo;
	}
	
	/**
	 *  M�todo get que retorna um item especifico da lista de consumo pela posi��o
	 */
	
	public Item get_item(int posicao) {

		return this.consumo.get(posicao);
		
	}
	
	
	
	/**
	 * M�todo que retorna um texto contendo as informa��es da bebida
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

