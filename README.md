# PAO
Proiect PAO

JOC VIDEO

Proiectul meu la PAO va consta într-un simplu joc video, în care te vei plimba pe o matrice si vei interacționa cu elementele din jurul tău.

*CLASE*:

JUCĂTOR     -> CLASA PENTRU PERSONAJUL CARE SE VA PLIMBA PE HARTĂ
OBIECT      -> CLASA GENERICĂ PENTRU UN OBIECT CARE POATE FI O ARMĂ, ARMURĂ SAU UN CONSUMABIL
ARMA        -> CLASA PENTRU O ARMĂ CARE CREȘTE DAUNELE JUCĂTORULUI
ARMURĂ      -> CLASA PENTRU O ARMURĂ CARE CREȘTE APĂRAREA JUCĂTORULUI
CONSUMABIL  -> CLASA PENTRU UN OBIECT CARE POATE FI FOLOSIT DE JUCĂTOR
INAMIC      -> CLASA PENTRU UN INAMIC
SCHELETE    -> CLASA PENTRU UN INAMIC SPECIFIC CARE ARE DAUNE RIDICATE
ZOMBI       -> CLASA PENTRU UN INAMIC SPECIFIC CARE ARE APĂRARE RIDICATĂ


![image](https://user-images.githubusercontent.com/93475691/230998427-b1f4a9c4-2d78-437d-ba64-8d6495fe362f.png)


*ACȚIUNI:*

    JUCĂTOR:

      IA_OBIECT           -> Jucătorul va lua un obiect.

      PROVOACĂ_DAUNE      -> Jucătorul va provoca daune unui inamic.

      CALCULEAZĂ_DAUNE    -> Jucătorul va calcula daunele pe care le va primi în funcție de rezistență.

      ECHIPEAZĂ_ARMURĂ    -> Jucătorul va echipa un set de armură din inventar.

      ECHIPEAZĂ_ARMĂ      -> Jucătorul va echipa o armă din inventar.

      FOLOSEȘTE_OBIECT    -> Jucătorul va folosi un obiect din inventar.

      MISCĂ-TE            -> Jucătorul se va mișca.

      INSPECTEAZA_OBIECTE -> Jucătorul va inspecta obiectele.

    INAMIC:

      PROVOACĂ_DAUNE      -> Inamicul va provoca daune jucătorului.

      CALCULEAZĂ_DAUNE    -> Inamicul va calcula daunele pe care le va primi în funcție de rezistență.


*REGULI*:

    -Daunele se calculează astfel: Daunele primite - Rezistența = Daunele asupra vieții.

    -Daunele (în cazul unei blocări) vor fi înjumătățite și apoi se vor calcula conform regulii de calcul a daunelor.

    -Lupta se va desfășura pe ture, fiecare dintre cei 2 adversari vor provoca daune cu rândul.

    -În cazul unei blocări, toate celelalte acțiuni sunt interzise pentru tura respectivă.

    -Spațiul de stocare al obiectelor este "infinit".

