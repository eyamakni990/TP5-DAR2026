# TP5 – Invocation des méthodes sur des objets distants avec Java RMI

## Activité 5-1 : Service de conversion de devise

- **Établissement :** Faculté des Sciences de Sfax (FSS)
- **Matière :** Développement des Applications Réparties (DAR)
- **Année universitaire :** 2026–2027
- **Enseignantes :** Amal ABID et Zeineb DAOUD
- **Étudiante :** Eya Makni

---

## 1. Présentation du TP

Dans ce TP, on a travaillé avec la technologie **Java RMI (Remote Method Invocation)**, qui permet à une application Java d'appeler des méthodes d'un objet distant, même si cet objet se trouve dans une autre machine virtuelle Java.

J'ai réalisé une application distribuée de conversion de devises permettant de convertir un montant en euros (EUR) en dinars tunisiens (TND).

L'application est composée de deux parties :
- **Serveur RMI :** fournit le service de conversion.
- **Client RMI :** permet d'appeler à distance la méthode de conversion proposée par le serveur.

## 2. Objectifs

À travers ce TP, j'ai appris à :
- Comprendre le fonctionnement de Java RMI.
- Créer une interface distante avec `Remote`.
- Implémenter un objet distant avec `UnicastRemoteObject`.
- Enregistrer un objet distant dans le registre RMI.
- Rechercher un objet distant depuis un client.
- Appeler une méthode distante et récupérer son résultat.

## 4. Réalisation de l'application

### 4.1. Création de l'interface distante IConversion

J'ai créé l'interface `IConversion`, qui hérite de l'interface `Remote`. Elle déclare la méthode `convertirMontant()` qui permet de convertir un montant en euros vers des dinars tunisiens.

```java
public interface IConversion extends Remote {
    double convertirMontant(double mt) throws RemoteException;
}
```

### 4.2. Implémentation du service ConversionImpl

J'ai créé la classe `ConversionImpl`, qui hérite de `UnicastRemoteObject` et implémente l'interface `IConversion`.

J'ai utilisé un taux de conversion fixe pour cette activité :

**1 EUR = 3 TND**

```java
@Override
public double convertirMontant(double mt) throws RemoteException {
    return mt * 3;
}
```

### 4.3. Création du serveur RMI

J'ai développé la classe `ConversionServer` pour démarrer le serveur et publier le service de conversion.

Dans cette classe, j'ai effectué les opérations suivantes :

1. Créer le registre RMI sur le port `1099`.
2. Instancier l'objet distant `ConversionImpl`.
3. Enregistrer l'objet distant sous le nom `BK` à l'aide de `Naming.rebind()`.
4. Afficher un message indiquant que le serveur est démarré.

### 4.4. Création du client RMI

J'ai développé la classe `ConversionClient` pour accéder au service distant.

Le client effectue les opérations suivantes :

1. Rechercher l'objet distant à l'aide de `Naming.lookup()`.
2. Récupérer une référence vers l'interface `IConversion`.
3. Appeler la méthode distante `convertirMontant(500)`.
4. Afficher le montant converti en dinars tunisiens.

## 5. Exécution de l'application

### 5.1. Démarrage du serveur

J'ai ouvert le projet `TP5_RMIConversion_Server` dans IntelliJ IDEA, puis j'ai exécuté la classe `ConversionServer`.

Le serveur a démarré correctement et a enregistré l'objet distant dans le registre RMI sur le port `1099`.

### 5.2. Exécution du client

Après le démarrage du serveur, j'ai ouvert le projet Client et exécuté la classe ConversionClient.

Le client a réussi à retrouver le service distant et à appeler la méthode de conversion.

6. Résultat obtenu

J'ai testé mon application avec un montant de 500 euros.

Le résultat affiché dans la console du client est :

<img width="453" height="258" alt="image" src="https://github.com/user-attachments/assets/913cdbff-4c40-49b5-becb-b2127cd75a6a" />


Le résultat obtenu confirme que la méthode distante a été exécutée correctement et que la communication entre le client et le serveur fonctionne.

7. Conclusion

À travers cette activité, j'ai pu mettre en pratique la technologie Java RMI et comprendre le principe de l'invocation de méthodes sur des objets distants.

J'ai appris à créer une interface distante, à implémenter un service RMI, à enregistrer un objet dans le registre et à accéder à ce service depuis un client.

Enfin, j'ai réussi à tester mon application avec une conversion de 500 euros en 1500 dinars tunisiens. Cette expérience m'a permis de mieux comprendre la communication et les échanges entre des applications distribuées en Java.

