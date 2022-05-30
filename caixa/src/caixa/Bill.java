package caixa;

import java.util.Iterator;
import java.util.ArrayList;


public class Bill {
	
	public static String get_bill (Table mesa) {
		ArrayList<Item> consumo = mesa.get_consumo();
		Iterator <Item> it1 = consumo.iterator();
		
		double valor = 0.0d;
		
		
		while (it1.hasNext()) {
			Item item = it1.next();
			double preco = item.get_preco();
			double quantidade = item.get_quantidade();
			valor += preco*quantidade;		
		}
		
		
		double bill = valor;
		
//		String print_bill = "Mesa "+mesa.get_numero()+":"+ "\n"+ "Total a pagar: "+"R$"+String.format("%.2f", bill)+"\n"+
//		"+"+"R$"+String.format("%.2f", bill*0.1)+" (10% - taxa de serviço opcional)"+ "\n"+ "Total com 10%: "+"R$"+String.format("%.2f", bill+(bill*0.10));
		String print_bill = "Mesa ";
		print_bill += mesa.get_numero()+":"+ "\n";
		print_bill += "Total a pagar: "+"R$"+String.format("%.2f", bill)+"\n";
		print_bill += "R$"+String.format("%.2f", bill*0.1)+" (10% - taxa de serviço opcional)"+ "\n";
		print_bill += "Total com 10%: "+"R$"+String.format("%.2f", bill+(bill*0.10));
				
		return print_bill;
	}
	
	

}
