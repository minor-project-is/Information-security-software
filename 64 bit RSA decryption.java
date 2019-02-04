/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

/**
 *
 * @author 1602366
 */
public class JavaApplication10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
             BigInteger d=new BigInteger("61650691");
             BigInteger n=new BigInteger("77082281");
     FileReader fr = new FileReader("C:\\Users\\nEW u\\Desktop\\en1.txt");
        FileWriter fw=new FileWriter("C:\\Users\\nEW u\\Desktop\\en2.txt");
        int ch=fr.read();String number;
        while(ch!=-1){
          
          if(ch!=35){
            number="";
            
            for(int i=0;i<19;i++){
            System.out.print((char)ch);
            if(ch!=36)
            ch=ch-40;
            else
                ch=0;
            number=number+ch;
            ch=fr.read();
            
            }
             if(ch!=36)
            ch=ch-40;
            else
                ch=0;
            number=number+ch;
            //number=number+(char)ch;
            System.out.println(number);
            BigInteger a=new BigInteger(number);
           // BigInteger n1=new BigInteger(Integer.toString(n));
            a=a.modPow(d, n);
            //a=a.pow(d);
            //a=a.mod(n);
            System.out.println(a);
            int x=Integer.parseInt(a.toString());
            x=x+31;
            fw.append((char)x);
            if(ch!=36)
            ch=ch-40;
            else
                ch=0;
          }
          else{
              for(int i=0;i<19;i++)
                  ch=fr.read();
              fw.append((char)10);
              for(int i=0;i<20;i++)
                  ch=fr.read();
              fw.append((char)13);
          }
            ch=fr.read();
            
        }
        fr.close();
        fw.close();
    }
    
}
