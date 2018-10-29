package br.com.sistema.classes;
import java.io.BufferedReader;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class ContaOcorrencias {
 
    public static void conta( FileReader txtFile) throws Exception {//classe que conta as occorencias e salva em um Map; (apenas TXT)
         
    String curLine; //recebe cada linha lida do arquivo texto
         
    Map<String,Integer> mapPalavras; //mapa: Palavra -> Frequencia  
                                     //usado para contabilizar as 
                                     //frequencias das palavras
         
    mapPalavras = new HashMap<String,Integer>();
         

        BufferedReader txtBuffer = new BufferedReader( txtFile);
 

    // loop que processa cada linha do arquivo texto
  
 
        //pega a primeira linha do arquivo
        curLine = txtBuffer.readLine();
       
         
        while (curLine != null) {
             
            //      quebra a linha em tokens (palavras) utilizando 
            //      expressão regular. 
            //
            //      O programa usa uma forma simplificada p/ obter os tokens.
            //      São considerados tokens:
            //      - uma sequência de 1 a n números
            //      - uma sequência de 1 a n letras
 
            //primeiro converte tudo para minúsculo
            String minusculo = curLine.toLowerCase();
             
            //depois aplica a expressão regular
            Pattern p = Pattern.compile("(\\d+)|([a-záéíóúçãõôê]+)");
            Matcher m = p.matcher(minusculo);
 
             
            
            // neste loop pegamos cada palavra e atualizamos o mapa de frequências
             
            while(m.find())
            {
              String token = m.group(); //pega um token   
              Integer freq = mapPalavras.get(token); //verifica se esse 
                                     //token já está no mapa    
                 
                if (freq != null) { //se palavra existe, atualiza a frequencia
                    mapPalavras.put(token, freq+1);
                }
                else { // se palavra não existe, insiro com um novo id e freq=1.
                    mapPalavras.put(token,1);
                }
            }
             
        //pega a próxima linha do arquivo
            curLine = txtBuffer.readLine();
        }
         
        txtBuffer.close();
 
  
    //imprime o mapa de frequencias

     for (Map.Entry<String, Integer> entry : mapPalavras.entrySet()) {
        System.out.println(entry.getKey() + "\tfreq=" + entry.getValue());
     }
 
   }
 
}