/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HammingCoder;

import java.util.Scanner;
import java.util.ArrayList;
import java.security.SecureRandom;
public class Channel {
    static Scanner input = new Scanner(System.in);

    static ArrayList codeword; 
    public static void main(String[] args)
    {
       

        
    }   
    public static void flipBit(ArrayList codeword)
    {
        SecureRandom random = new SecureRandom();
        int bitToFlip = 0;
        //System.out.print("size"+codeword.size()); 
        bitToFlip = random.nextInt(codeword.size()-1);
       if((int)codeword.get(bitToFlip)==1)
            codeword.set(bitToFlip, 0);
       else
            codeword.set(bitToFlip, 1);
                
        System.out.print("Error Codeword: ");
        for (int i = 0; i < codeword.size(); i++)
        {
            System.out.print(codeword.get(i));
            
        }
        System.out.println("");
    }
    public static ArrayList getCode()
    {
         Encoder code = new Encoder();
        codeword = new ArrayList();
        
        
        codeword.addAll(code.getCodeword());
        System.out.print("Codeword: ");
        for (int i = 0; i < codeword.size(); i++)
        {
            System.out.print(codeword.get(i));
            
        }
        System.out.println("");
        int toFlip = 0;
        System.out.print("do you want to flip a bit 1 = Yes 0 = No "); 
        toFlip = input.nextInt();
        if(toFlip == 1)
        {
        flipBit(codeword);
        }
            return codeword; 
    }
}
