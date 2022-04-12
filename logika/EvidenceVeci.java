package logika;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class EvidenceVeci {

    private Collection<Vec> seznam;
    public EvidenceVeci(){seznam = new HashSet<>();
    }

    public boolean vlozVec(Vec vec){
        seznam.add(vec);
        return true;
    }


    public Collection<String> vratSeznamVeciVMistnosti(Prostor prostor) {
        Collection<String> vyber = new ArrayList<>();
        for (Vec vec:seznam){
            if(prostor.equals(vec.getProstor())){
                vyber.add(vec.getNazev());
            }
        }

        return vyber;
    }

    public Vec jePredmetVMistnosti(Prostor prostor, String predmet){
        for (Vec vec:seznam){
            if(vec.getProstor() == prostor && vec.getNazev().equals(predmet)){
                return vec;
            }
        }
        return null;
    }

    public Vec predmetVRuce(){
        for (Vec vec:seznam){
            if(vec.getProstor() == null){
                return vec;
            }
        }
        return null;
    }

    public Vec getUrcityPredmet(String nazev){
        for (Vec vec:seznam){
            if(vec.getNazev().equals(nazev)){
                return vec;
            }
        }
        return null;
    }


}
