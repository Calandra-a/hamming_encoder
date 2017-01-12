/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HammingCoder;

import java.util.ArrayList;

/**
 *
 * @author calan
 */
public class Decoder {
    static int parityBits;
    static ArrayList codeword;
    public static void main(String[] args) {
        codeword = Channel.getCode();
        parityBits= Encoder.getParity(); 
        ArrayList correctedCode;
        
        Encoder code = new Encoder();
        Channel channel = new Channel();
        correctedCode =  pLine();
        System.out.print("Corrected Codeword: ");
        for (int i = 0; i < codeword.size(); i++)
        {
            System.out.print(codeword.get(i));
            
        }
        System.out.println("");
    }
     public static ArrayList pLine()
    {      
           int errorBit = 0;

          
     
           //calculating what bit to stuff
           ArrayList p = new ArrayList();
           ArrayList newCodeword;

           newCodeword = codeword; 
           //fills p arraylist
           for(int x = 0; x < parityBits; x++)//counts through number of parity bits
           {
               int parity = (int)Math.pow(2, x);//finds parity bit subscript, What to count by
               int i = parity-1;//brings you to parity bit in actual arraylist
               int counter = 1;//
               
             while(i < codeword.size())
             {
                if(counter % 2 == 0)
                {
                    i+= parity;
                }
                else
                {
                    for(int q = 0; q < parity; q++)
                        if(i < codeword.size()){
                        p.add(codeword.get(i));
                    i++;}
                }
                counter++;

             }
             
             int oneCount = 0;
             for (int z = 0; z < p.size(); z++)
             {
                if ((int)p.get(z) == 1)
                {
                    oneCount++;
                    
                }
             }
                if (oneCount % 2 !=0)
                {
                    errorBit += parity; 


                }
               
             p.clear();
           }
           if (errorBit > 0)
           {
               if ((int)codeword.get(errorBit) == 0){
                   codeword.remove(errorBit-1);
                   codeword.add(errorBit-1, 0);
               }
               else{
                    codeword.remove(errorBit-1);
                    codeword.add(errorBit-1,1);
               }
               }
           return codeword;
    }
    
}
