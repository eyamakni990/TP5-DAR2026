
package rmiClient;

import rmiService.IConversion;
import java.rmi.Naming;

public class ConversionClient {

    public static void main(String[] args) {

        try {
            // Chercher la référence de l'objet distant
            IConversion od = (IConversion)Naming.lookup("rmi://localhost:1099/BK");

            // Invoquer la méthode distante
            double resultat = od.convertirMontant(500);

            System.out.println("Montant en euros : 500 €");
            System.out.println("Montant en dinars : " + resultat + " TND");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
