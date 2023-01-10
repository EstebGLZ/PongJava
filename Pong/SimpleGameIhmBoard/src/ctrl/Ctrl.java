package ctrl;

import ihm.CellContent;
import ihm.IhmBoard;
import wrk.Wrk;

/**
 * Infrastructure de base et très simple mettant à disposition une ihm graphique
 * fonctionnelle pour implémenter des jeux.
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 14 sept. 2017
 * @version 0.1
 */
public class Ctrl {

    public final static int TAILLE_CELLULE_EN_PIXELS = 25;

    public Ctrl() {
        this.refIhm = null;
        this.refWrk = null;
    }

    public void start() {
        refIhm.ihmStart();
        demo();
    }
//fdfdgfd
    public void demo() {

        refIhm.setBoardDimensions(0, 0);
        refIhm.setTimeTitle("Temps restant");
        refIhm.setBoardDimensions(236, 236, 4);
        //couleur de fond
        refIhm.clearBoardContent(CellContent.BLUE);
        //ajout de couleur a une cellule
        int celluleDepart1 = 100;
        //ajout du premier pad
        for (int i = 0; i < 36; i++) {
            refIhm.setBoardContent(celluleDepart1, 20, CellContent.WHITE);
            refIhm.setBoardContent(celluleDepart1, 21, CellContent.WHITE);
            celluleDepart1++;
        }
        int celluleDepart2 = 105;
        for (int i = 0; i < 36; i++) {
            refIhm.setBoardContent(celluleDepart2, 216, CellContent.WHITE);
            refIhm.setBoardContent(celluleDepart2, 217, CellContent.WHITE);
            celluleDepart2++;
        }
    }

    public void actionQuitter() {
        if (refIhm.messageQuestion("Voulez-vous vraiment quitter ?")) {
            // Dire à l'ihm de quitter
            refIhm.ihmStop();
        }
    }

    public Wrk getRefWrk() {
        return refWrk;
    }

    public void setRefWrk(Wrk refWrk) {
        this.refWrk = refWrk;
    }

    public IhmBoard getRefIhm() {
        return refIhm;
    }

    public void setRefIhm(IhmBoard refIhm) {
        this.refIhm = refIhm;
    }

    private Wrk refWrk;
    private IhmBoard refIhm;

}
