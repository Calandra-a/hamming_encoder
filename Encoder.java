package HammingCoder;
import java.util.ArrayList;
import java.util.Scanner;
public class Encoder {
     static ArrayList encodedWord ;
    public static void main(String[] args) {
  
    }
    

    static int[] dw ={0};
    public static int[] dataword(int val)
    {
        
        if(val == 0){
        int size =0;
        
        Scanner input = new Scanner(System.in); 
  

        System.out.println("enter length of dataword"); 
        size = input.nextInt();
        int[] dataword = new int[size];
        System.out.println("enter next digit of dataword"); 
        
        for (int i = 0; i < size; i++)
        {
            dataword[i] = input.nextInt();
        }
        dw = dataword;

        return dataword;
        }
        if (val == 1)
        {
           
        return dw; 
        }
        else{
            int x[] ={0}; 
            return x; 
        }
        }
    public static int numberOfParityBits(int[] dataword)
    {
        int control = 0;//while loop control, and used in math.pow
                int numberOfParityBits = 0;

        // numbers of bits to be stuffed
           //calculates the number of bits to be stuffed
           while (control > -1)
           {
               if(Math.pow(2, control)<=dataword.length)// takes 2^control and see if it is in the dataword
               {
                    numberOfParityBits++; //increments parirty bits if it is
               }
               else
               {
                    break;//breaks loop when 2^i is nolonger in dataword
               }
            control++;
           }
           
           
        return numberOfParityBits;
    }
    
    public static ArrayList codeword(int[] dataword)
    {        

           
           
           ArrayList codeword = new ArrayList();
           for (int i =0; i< dataword.length; i++)//fills codeword arraylist with dataword
           {
           codeword.add(i, dataword[i]);
           }
            return codeword; 
    }
    
    //Generates arrays of the plucked bits for each P... calculates wheather to stuff a 1 or 0,
    //and stuff the bit into the codeword Then returns the stuffed codeword 
    public static ArrayList pLine(int parityBits, ArrayList codeword)
    {       
           for (int i = 0; i < parityBits;i ++)//inserts a 2 in each party bit location
           {
               int bit = (int)Math.pow(2, i);
               codeword.add(bit - 1, 2);
           }
           
           
           System.out.println();
           //calculating what bit to stuff
           ArrayList p = new ArrayList();
           ArrayList newCodeword;

           newCodeword = codeword; 
           for(int x = 0; x < parityBits; x++)//counts through number of parity bits
           {
               int parity = (int)Math.pow(2, x);//finds parity bit subscript, What to count by
               int i = parity-1;
               int counter = 1;
               
             while(i < codeword.size())
             {
                if(counter %2 == 0)
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
             
             //System.out.println(p.toString());
             int oneCount = 0;
             for (int z = 0; z < p.size(); z++)
             {
                if ((int)p.get(z) == 1)
                {
                    oneCount++;
                // System.out.println("oneCOunt:" + oneCount);
                    
                }
             }
                if (oneCount % 2 ==0)
                {
                    
                    newCodeword.set(parity-1, 0);
                    //System.out.println(parity);
                    //System.out.println(newCodeword);
                }
                else
                {
                  newCodeword.set(parity-1, 1);
                  //System.out.println(parity);
                  //System.out.println(newCodeword);
                }
             
             p.clear();
           }
           return newCodeword;
    }      
    
    //public String getCodeword()
    static int array[];

    public  ArrayList getCodeword()
    {
              array = dataword(0); 
        //System.out.println("dw"+ array);

      encodedWord = pLine(numberOfParityBits(array),codeword(array));
      return encodedWord;//returns class var encoded word for use in the channel/decoder
    }
    public static int getParity()
    {
         array = dataword(1);
    return  numberOfParityBits(array);  
    }
}
    
               
            

