/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Random;
/**
 *
 * @author 1602366
*/
public class JavaApplication1 {
   static boolean is_prime(double x){
       if(x<30)
           return false;
        int count=0,flag=1;
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0)
                return false;
        }
        return true;
    }

    
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        double p,q;
        Random rand=new Random();
        while(true){
            p=rand.nextInt(100);
            boolean x=is_prime(p);
            if(x)
                break;
        }
        while(true){
            q=rand.nextInt(100);
            boolean x=is_prime(q);
            if(x)
                break;
        }
        System.out.println(p+"   "+q);
        double n=p*q,phi=(p-1)*(q-1);
        int e=0;
        for(double i=phi;i>=0;i--){
            if(is_prime(i))
            {
                e=(int)i;
                
                break;
            }
                
        }
        
        System.out.println("Public key is: n=="+n+" e=="+e);
        FileReader fr=new FileReader("C:\\Users\\nEW u\\Desktop\\en.txt");
        FileWriter fw=new FileWriter("C:\\Users\\nEW u\\Desktop\\en1.txt");
        double ch=fr.read();int c=0;
        //System.out.print(ch);
        while(ch!=-1.0){
            
            if(ch!=13&&ch!=10){
                System.out.print(ch+" ");
            ch=ch-31.0;
            
                int cf=(int)ch;
                int ns=(int)n;
                String chl=Integer.toString(cf);
                String chk=Integer.toString(ns);
                //String cx="1234.6";
            BigInteger a=new BigInteger(chl);
            BigInteger n1=new BigInteger(chk);
            
            
            a=a.pow(e);
            a=a.mod(n1);
            System.out.println(a);
           String number=a.toString();
           int def=4-number.length();
           for(int i=0;i<def;i++){
               fw.append("$");
               //System.out.print("$");
           }//******'$' is for 0 only.
           for(int i=0;i<number.length();i++){
              
               int m=Integer.parseInt(number.substring(i, i+1));
               m=m+40;
               //subtract 40 when extracted.
               fw.append((char)m);
               //System.out.print((char)m);
                          
                             
           }
            }
            else{
                for(int j=0;j<8;j++)
                    fw.append("#");
            }
           //System.out.print("\n");
            
            ch=fr.read();
            //fw.append((char)a));
            
            
        }
        //Calculation of 'd'
        double d;
        int k=1;
        while(true){
         d = ( ( k * phi ) +1)/e;
         if(((int)d*e)%phi==1)
             break;
         k++;
    }
        System.out.print("Private key:-"+(int)d);
        
       fr.close();
       fw.close();

    }
    
}
