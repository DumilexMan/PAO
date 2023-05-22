import inamici.Schelete;
import inamici.Zombi;
import jucator.Jucator;
import obiecte.Arma;
import obiecte.Armura;
import obiecte.Consumabil;
import util.InstructiuniJoc;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        InstructiuniJoc joc = new InstructiuniJoc();
        joc.joc_nou();

        //inamici

        Schelete schelete1 = new Schelete();

        System.out.println("Schelete generic: \n");
/*
        System.out.println(schelete1.getViata());
        System.out.println(schelete1.getDaune());
        System.out.println(schelete1.getRezistenta());
 */

        System.out.println(schelete1.toString());

        Schelete schelete2 = new Schelete(1, 3, 1);

        System.out.println("\nSchelete custom: \n");

        System.out.println(schelete2.toString());

        Zombi zombi1 = new Zombi();

        System.out.println("\nZombi generic: \n");

        System.out.println(zombi1.toString());

        System.out.println("\nZombi custom: \n");

        Zombi zombi2 = new Zombi(1, 3, 1);

        System.out.println(zombi2.toString());

        System.out.println("\nO sa lovim scheletele cu 5 puncte de daune");

        schelete1.calculeaza_daune(5);

        System.out.println(schelete1.toString());

        System.out.println("\n5-(5-1)=1\nDeci scheletele a ramas cu 1 punct de viata");

        System.out.println("\nO sa lovim zombi-ul cu 5 puncte de daune");

        zombi1.calculeaza_daune(5);

        System.out.println(zombi1.toString());

        System.out.println("\n5-(5-2)=2\nDeci scheletele a ramas cu 2 puncte de viata");

        System.out.println("\nJucator generic: \n");

        Jucator jucator1 = new Jucator();


        /*
        System.out.println(jucator1.getViata());
        System.out.println(jucator1.getRezistenta());
        System.out.println(jucator1.getDaune());
        */
        System.out.println(jucator1.toString());

        System.out.println("\nJucator custom: \n");

        Jucator jucator2 = new Jucator(5,5,5);


        System.out.println(jucator2.toString());

        System.out.println("\nO sa lovim jucatorul");

        jucator1.calculeaza_daune(20);

        System.out.println("\n" + jucator1.toString());

        System.out.println("\nO sa facem un schelete sa loveasca jucatorul");

        schelete1.provoaca_daune(jucator2);

        System.out.println("\n" + jucator2.toString());

        Schelete schelete3 = new Schelete(1, 50, 1);

        System.out.println("\nSchelete custom: ");

        System.out.println(schelete3.toString());

        schelete3.provoaca_daune(jucator2);

        System.out.println(jucator2.toString());

        Jucator jucator3 = new Jucator();

        System.out.println("\nO sa facem jucatorul sa loveasca un schelete");


        System.out.println("\n" + schelete2.toString());

        jucator3.provoaca_daune(schelete2);

        System.out.println("\n" + schelete2.toString());

        Arma arma1 = new Arma(10);

        Armura armura1 = new Armura(10);

        Consumabil consumabil1= new Consumabil(10);


        Jucator jucator4 = new Jucator(0,0,0);

        System.out.println(jucator4.toString());

        System.out.println();

        jucator4.ia_obiect(arma1);
        jucator4.ia_obiect(armura1);
        jucator4.ia_obiect(consumabil1);

        jucator4.inspecteazaObiecte();


        jucator4.ia_obiect(consumabil1);
        jucator4.ia_obiect(consumabil1);
        jucator4.ia_obiect(consumabil1);
        jucator4.ia_obiect(consumabil1);
        jucator4.ia_obiect(consumabil1);

        System.out.println();

        jucator4.inspecteazaObiecte();

        System.out.println("\nO sa aruncam din obiecte.\n");

        jucator4.arunca_obiect(10);
        jucator4.arunca_obiect(10);
        jucator4.arunca_obiect(10);
        jucator4.arunca_obiect(10);
        jucator4.arunca_obiect(10);

        System.out.println();

        jucator4.inspecteazaObiecte();


//pur si simplu o sa afisam calitatea fiecarui obiect pe care il detine jucatorul


//ca sa echipam, avand in vedere ca armurile, armele, si consumabilele se disting doar prin valoare, vom folosi valoarea lor

        System.out.println("\nO sa folosim obiecte.");

        jucator4.echipeaza_Arma(10);
        jucator4.echipeaza_Armura(10);
        jucator4.foloseste_Obiect(10);

        System.out.println();

        System.out.println(jucator4.toString());

        System.out.println("\nO sa incercam sa echipam o arma pe care nu o avem\n");

        jucator4.echipeaza_Arma(100);


//pana acum am vazut cum putem folosi toate functiile mai putin functia misca-te care ii permite jucatorului sa se plimbe prin harta


        System.out.println();
        System.out.println();
        System.out.println();

        jucator1.afiseazaTotiJucatorii();

        System.out.println();
        System.out.println();
        System.out.println();

        schelete1.afiseazaTotiScheletii();

        System.out.println();
        System.out.println();
        System.out.println();

        zombi1.afiseazaTotiZombi();

        System.out.println();
        System.out.println();
        System.out.println();

        jucator1.inspecteazaObiecteCSV();
    }
}