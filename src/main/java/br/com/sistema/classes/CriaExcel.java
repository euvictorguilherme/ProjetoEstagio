package br.com.sistema.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
  
public class CriaExcel {
        
       private static final String fileName = "C:/test/novo.xls";
  
       public static void criaExcel(HashMap<String, Integer> mapPalavras) throws IOException {//Função para ler arquivo e gerar o Excel
  
             HSSFWorkbook workbook = new HSSFWorkbook();
             HSSFSheet sheetOcorrencias = workbook.createSheet("ocorrencias");
             
             int rownum = 0;
             for (Map.Entry<String, Integer> entry : mapPalavras.entrySet()) {
                 Row row = sheetOcorrencias.createRow(rownum++);
                 int cellnum = 0;
                 Cell cellPalavra = row.createCell(cellnum++);
                 cellPalavra.setCellValue(entry.getKey());
                 Cell cellFrequencia = row.createCell(cellnum++);
                 cellFrequencia.setCellValue(entry.getValue());
      
             }
               
             try {
                 FileOutputStream out = 
                         new FileOutputStream(new File(CriaExcel.fileName));
                 workbook.write(out);
                 out.close();
                 System.out.println("Arquivo Excel criado com sucesso!");
                   
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
                    System.out.println("Arquivo não encontrado!");
             } catch (IOException e) {
                 e.printStackTrace();
                    System.out.println("Erro na edição do arquivo!");
             }
  
       }
  
}
