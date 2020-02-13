/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speedexam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class FileIO {
    public static void writefile(ArrayList a,String s){
    
        try {
            FileOutputStream file=new FileOutputStream(s);
            ObjectOutputStream f=new ObjectOutputStream(file);
            for(Object o:a)
                f.writeObject(o);
            f.close();
            file.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
     public static void readfile(ArrayList a,String s){
       a.clear();
        try {
            FileInputStream file=new FileInputStream(s);
            ObjectInputStream f=new ObjectInputStream(file);
            Object obj=null;
            while((obj=f.readObject())!=null)
            {
                a.add(obj);
            }
            f.close();
            file.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        
    }
    
}
