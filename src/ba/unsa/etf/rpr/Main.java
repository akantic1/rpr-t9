package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String ispisiGradove(){
        String s = "";
        GeografijaDAO gd = new GeografijaDAO();
        ArrayList<Grad> gradovi = gd.gradovi();
        ArrayList<Drzava> drzave = gd.drzavaId();

        for(Grad g: gradovi){
            for(Drzava d: drzave) {
                if(g.getDrzava().getId() == d.getId())
                    s += g.getNaziv() + " (" + d.getNaziv() + ") - " + g.getBrojStanovnika() + "\n";
            }
        }

        return s;
    }

    static void glavniGrad(){
        System.out.println("Unesite drzavu: ");
        String unos;
        Scanner ulaz = new Scanner(System.in);
        unos = ulaz.nextLine();

        GeografijaDAO gd = new GeografijaDAO();

        Grad g = gd.glavniGrad(unos);
        if(g == null) System.out.println("Nepostojeća država");
        else System.out.println("Glavni grad države " + unos + " je " + g.getNaziv());
    }
    public static void main(String[] args) {
        System.out.println("Gradovi su:\n" + ispisiGradove());
        glavniGrad();
    }
}
