package entities.enumeration;

/**
 * 
 * @author aymen
 *
 *Pending Commande en cours de validation apres l'ajout (automatique)
 *Cancelled Commande annuler par le client (possible dans le cas pedding) (par demande)
 *Ready (commande validé par le restaurant et en cours de preparation)(par demande)
 *Inprogress (en cours de livraison) (par demande)
 *Delivred(pares le livraison) (par demande)
 *paid (apres le payement) (automatique)
 */

public enum OrderState {
	Pending,Cancelled,Ready,InProgress,Delivered
}
