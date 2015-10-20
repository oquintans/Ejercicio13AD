/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Serializacion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("serial.txt"));
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("serial.txt"));
            String[] cod = {"p1", "p2", "p3"};
            String[] desc = {"parafusos", "cravos", "tachas"};
            int[] price = {3, 4, 5};
            for (int i = 0; i < cod.length; i++) {
                Product p1 = new Product(cod[i], desc[i], price[i]);
                os.writeObject(p1);
            }
            os.writeObject(null);
            os.close();

            Product p2 = (Product) is.readObject();
            while (p2 != null) {
                System.out.println(p2.toString());
                p2 = (Product) is.readObject();
            }
            is.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
