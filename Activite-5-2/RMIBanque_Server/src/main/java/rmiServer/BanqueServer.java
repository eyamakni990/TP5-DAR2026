
package rmiServer;

import rmiService.BanqueImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class BanqueServer {

    public static void main(String[] args) {
        try {
            // Création du registre RMI
            LocateRegistry.createRegistry(1099);

            // Création de l'objet distant
            BanqueImpl banque = new BanqueImpl();

            // Enregistrement avec JNDI
            Context ctx = new InitialContext();
            ctx.rebind("Banque", banque);

            System.out.println("Serveur RMI Banque démarré avec JNDI...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
