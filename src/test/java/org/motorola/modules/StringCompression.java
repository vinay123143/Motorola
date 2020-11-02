package org.motorola.modules;

public class StringCompression {
	
	
	static String compression(String str){
		   String rtn = "";
		   char lastChar = '!';
		   int counter = 0;
		   for(int i=0; i<str.length(); i++){
		      if(i==0){
		         lastChar = str.charAt(0);
		         String newLetter = Character.toString(lastChar);
		         counter++;
		         rtn = rtn.concat(newLetter);
		      }
		      else{
		         if(str.charAt(i) == lastChar) counter ++;
		         else{
		            rtn = rtn + counter;
		            lastChar = str.charAt(i);
		            String newLetter = Character.toString(lastChar);
		            rtn = rtn.concat(newLetter);
		            counter = 1;
		         }
		      }
		   }
		   rtn = rtn + counter;
		   return rtn;
		}

}
