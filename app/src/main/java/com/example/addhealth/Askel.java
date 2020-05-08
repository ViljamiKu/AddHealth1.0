package com.example.addhealth;



//TÄMÄ LUOKKA EI TÄLLÄ HETKELLÄ OLE KÄYTÖSSÄ!
//Tarkoitus oli tehdä steps ListView joka on jaettu 3 sarakkeeseen seuraavalla tavalla:
//Vasemmalla sarakkeessa on askelTieto (esim: "Hyvä määrä askelia")
//Oikealla olisi ollut sarake jossa askelten määrä (esim. 10 000 askelta) ja
//tämän alapuolella km - määrä. Valitettavasti koko äppi kaatui ennen seminaaria tällä joten tämä ei
//ole käytössä ja tekemäni arraylistin myös poistin kokonaan.

/**
 * Askel luokka, josta oli tarkoitus hakea tiedot StepsActivityyn listviewiin.
 * Ja jaotella omiin sarakkeisiin. Ei käytössä tällä hetkellä.
 * @author Viljami
 *
 * version 1.0 6.5.2020
 */
public class Askel {
    private String askelTieto;
    private String askeleet;
    private String kilometrit;

    public Askel(String askelTieto, String askeleet, String kilometrit) {
        this.askeleet = askeleet;
        this.askelTieto = askelTieto;
        this.kilometrit = kilometrit;
    }
    public String getAskeleet() {
        return askeleet;
    }

    public void setAskeleet(String askeleet) {
        this.askeleet = askeleet;
    }

    public String getAskelTieto() {
        return askelTieto;
    }

    public void setAskelTieto(String askelTieto) {
        this.askelTieto = askelTieto;
    }

    public String getKilometrit() {
        return kilometrit;
    }

    public void setKilometrit(String kilometrit) {
        this.kilometrit = kilometrit;
    }
}
