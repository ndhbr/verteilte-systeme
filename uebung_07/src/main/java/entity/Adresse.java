package entity;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Adresse {
    String strasse;
    int plz;
    String ort;

    public Adresse() {}

    public Adresse(String strasse, int plz, String ort) {
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
    }
}
