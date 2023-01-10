package app;

import ctrl.Ctrl;
import ihm.IhmBoard;
import wrk.Wrk;

/**
 * Infrastructure de base et très simple mettant à disposition une ihm graphique fonctionnelle pour implémenter des
 * jeux.
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 14 sept. 2017
 * @version 0.1
 */
public class Application {
    dfsdfsdfskdd

    /**
     * LA méthode main() de l'application, là où tout commence mais... tout se finit-il bien là ?
     *
     * @param args les arguments du programme passés sur la ligne de commande
     */
    public static void main( String[] args ) {
        Wrk wrk = new Wrk();
        Ctrl ctrl = new Ctrl();
        IhmBoard ihm = new IhmBoard();

        wrk.setRefCtrl( ctrl );
        ihm.setRefCtrl( ctrl );
        ctrl.setRefIhm( ihm );
        ctrl.setRefWrk( wrk );

        ctrl.start();
    }

}
