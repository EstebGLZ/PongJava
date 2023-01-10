package wrk;

import ctrl.Ctrl;

/**
 * Infrastructure de base et très simple mettant à disposition une ihm graphique fonctionnelle pour implémenter des
 * jeux.
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 14 sept. 2017
 * @version 0.1
 */
public class Wrk {

    private Ctrl refCtrl;

    public Wrk() {
        this.refCtrl = null;
    }

    public Ctrl getRefCtrl() {
        return refCtrl;
    }

    public void setRefCtrl( Ctrl refCtrl ) {
        this.refCtrl = refCtrl;
    }

}
