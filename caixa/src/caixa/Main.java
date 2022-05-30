package caixa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;






public class Main {
	
	public static void main (String[] args) throws IOException {

		// Pre-processamento por arquivo excel
		
		String excelFilePath = "E:\\Workspace\\Java\\caixa_bar\\Arquivos de entrada\\mesa.xlsx";
		FileInputStream inputstream = new FileInputStream(excelFilePath);
		
		
		@SuppressWarnings("resource")
		XSSFWorkbook arquivo = new XSSFWorkbook(inputstream);		
		inputstream.close();
		
		XSSFSheet sheet=  arquivo.getSheet("Mesa1");
		
		
			
		//Leitura das bebidas consumidas
		
		Iterator<Row> rows_iterator = sheet.iterator();
		
		XSSFRow row1 = (XSSFRow) rows_iterator.next();//Lê a linha onde tem o número da mesa
		double mesaN= row1.getCell(1).getNumericCellValue();
		
		rows_iterator.next();//Lê a linha onde tem escrito Itens
		rows_iterator.next();//Lê a linha onde tem escrito os parâmetros dos itens
		
		ArrayList<Item> consumo = new ArrayList<Item> ();
		
		while (rows_iterator.hasNext()) {
			
			XSSFRow row = (XSSFRow) rows_iterator.next();
			
			Iterator<Cell> cell_iterator = row.iterator();
			
			
			while (cell_iterator.hasNext()) {
				
				String nome = cell_iterator.next().getStringCellValue();
				double preco = cell_iterator.next().getNumericCellValue();
				double quantidade = cell_iterator.next().getNumericCellValue();
				
				Item item = new Item (nome, preco, quantidade);
				consumo.add(item);
					
			}				
		}
		
		//Lançamento da mesa
		
			 	 
		 Table mesa1 = new Table (mesaN, consumo);
		 System.out.println("\n"+mesa1.toString());
	
		 //Lancamento da conta
		 
		String conta = Bill.get_bill(mesa1);
		System.out.println(conta);
		
		//Escrevendo os resultados em um arquivo excel
				
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		XSSFSheet sheet2 = workbook.createSheet("Conta");
		
		
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"Mesa", Double.toString(mesa1.get_numero())});
        data.put("2", new Object[] {"Unidades", "Item", "Preço/un"});
        int n = consumo.size();
        int contador = 3;
        for (int i=0; i<n ; i++ ) {
        	double quantidade = mesa1.get_item(i).get_quantidade();
        	String nome = mesa1.get_item(i).get_nome();
        	double preco = mesa1.get_item(i).get_preco();
            data.put (Integer.toString(contador), new Object[] {Double.toString(quantidade), nome, Double.toString(preco)});
            contador++;
        }
        data.put(Integer.toString(contador), new Object[] {conta});
        
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet2.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            
            FileOutputStream out = new FileOutputStream(new File("conta.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Conta foi escrito com sucesso!");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
      //Teste para commit          
    }

 
		
	}
