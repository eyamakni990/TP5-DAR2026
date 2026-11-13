
package rmiClient;

import metier.Compte;
import rmiService.IBanque;

import javax.naming.Context;
import javax.naming.InitialContext;

public class BanqueClient {

    public static void main(String[] args) {
        try {
            // Recherche de l'objet distant avec JNDI
            Context ctx = new InitialContext();

            IBanque banque = (IBanque) ctx.lookup("Banque");

            // Création d'un compte
            Compte c1 = new Compte(1, 1500.0);

            String resultat = banque.creerCompte(c1);
            System.out.println(resultat);

            // Consultation du compte
            String info = banque.getInfoCompte(1);

            System.out.println("Informations du compte :");
            System.out.println(info);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
