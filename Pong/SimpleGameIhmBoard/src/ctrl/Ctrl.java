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

    public final static int TAILLE_CELLULE_EN_PIXELS = 20;

    public Ctrl() {
        this.refIhm = null;
        this.refWrk = null;
    }

    public void start() {
        refIhm.ihmStart();
        demo();
    }

    public void demo() {

        refIhm.setBoardDimensions(0, 0);
        refIhm.setTimeTitle("Temps restant");
        refIhm.setBoardDimensions(236, 236, 4);
        //couleur de fond
        refIhm.clearBoardContent(CellContent.BLUE);
        //ajout de couleur a une cellule
        refIhm.setBoardContent(100, 20, CellContent.WHITE);
        refIhm.setBoardContent(101, 20, CellContent.WHITE);
        refIhm.setBoardContent(102, 20, CellContent.WHITE);
        refIhm.setBoardContent(103, 20, CellContent.WHITE);
        refIhm.setBoardContent(104, 20, CellContent.WHITE);
        refIhm.setBoardContent(105, 20, CellContent.WHITE);
        refIhm.setBoardContent(106, 20, CellContent.WHITE);
        refIhm.setBoardContent(107, 20, CellContent.WHITE);
        refIhm.setBoardContent(108, 20, CellContent.WHITE);
        refIhm.setBoardContent(109, 20, CellContent.WHITE);

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
