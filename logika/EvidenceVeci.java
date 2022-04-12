package logika;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class EvidenceVeci {

    private Collection<Vec> seznam;
    public EvidenceVeci(){seznam = new HashSet<>();
    }

    /**
     *     Metoda vkládající danou věc do evidence
     *     @param vec
     *     @return true pokud byla přidána
     */


    public boolean vlozVec(Vec vec){
        seznam.add(vec);
        return true;
    }

    /**
     * Metoda vracící seznam veci v prostoru
     * @param prostor
     * @return vyber
     */

    public Collection<String> vratSeznamVeciVMistnosti(Prostor prostor) {
        Collection<String> vyber = new ArrayList<>();
        for (Vec vec:seznam){
            if(prostor.equals(vec.getProstor())){
                vyber.add(vec.getNazev());
            }
        }

        return vyber;
    }

    /**
     * Metoda vracící predmet v místnosti pokud tam je
     * @param prostor
     * @param predmet
     * @return vec pokud se predmet nachazí, null pokud se nenachází
     */

    public Vec jePredmetVMistnosti(Prostor prostor, String predmet){
        for (Vec vec:seznam){
            if(vec.getProstor() == prostor && vec.getNazev().equals(predmet)){
                return vec;
            }
        }
        return null;
    }

    /**
     * Metoda vracící predmet v rucce
     * @return vec v ruce, Null - žadný předmet v ruce není
     */

    public Vec predmetVRuce(){
        for (Vec vec:seznam){
            if(vec.getProstor() == null){
                return vec;
            }
        }
        return null;
    }

    /**
     * Metoda vracící daný předmět podle jeho názvu
     * @param nazev
     * @return vec s daným názvem, null pokud předmet neexistuje
     */

    public Vec getUrcityPredmet(String nazev){
        for (Vec vec:seznam){
            if(vec.getNazev().equals(nazev)){
                return vec;
            }
        }
        return null;
    }


}
