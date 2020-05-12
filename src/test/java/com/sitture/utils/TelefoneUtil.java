package com.sitture.utils;

import java.util.Random;

public class TelefoneUtil{

	
   private  static int geraNumeroFim(){
		Random r = new Random();
        int nFinal = 0;
      
        nFinal = r.nextInt(10);
     
        return nFinal;
      }
	
	public static String  geraPrefixo() {
		
		  String prefixo = "0";
          Random r = new Random();
	        //Gera o Prefixo
	        switch(r.nextInt(10)){
	            case 1:
	                prefixo = "19";
	                break;
	            case 2:
	                prefixo = "18";
	                break;
	            case 3:
	                prefixo = "17";
	                break;
	            case 4:
	                prefixo = "16";
	                break;
	            case 5:
	                prefixo = "15";
	                break;
	            case 6:
	                prefixo = "14";
	                break;
	            case 7:
	                prefixo = "13";
	                break;
	            case 8:
	                prefixo = "12";
	                break;
	            case 9:
	                prefixo = "11";
	                break;
	        }
	        
	        return prefixo;
	}
    //Gera o prefixo do telefone.
    public static String geraNumeroTelefonico(){
 
    	String pDigitos = "0";
    	Random r = new Random();
    	
      //Gera os primeiros Numeros e Cria a String de Retorno.
          switch(r.nextInt(3)){
            case 0:
                pDigitos = "93251";
                break;
            case 1:
                pDigitos = "93259";
                break;
            case 2:
                pDigitos = "93205";
                break;
        }
     
        return  pDigitos +  geraNumeroFim() + geraNumeroFim() + geraNumeroFim() + geraNumeroFim();
    }

 
}