# PAO
Proiect PAO

JOC VIDEO

Proiectul meu la PAO va consta într-un simplu joc video, în care te vei plimba pe o matrice si vei interacționa cu elementele din jurul tău.

CLASE:

- JUCATOR     -> CLASA PERSONAJULUI CARE SE VA PLIMBA PE HARTĂ
- OBIECT      -> OBIECT GENERIC CARE POATE FI ARMA/ARMURĂ/CONSUMABIL
- ARMA        -> OBIECT CARE CREȘTE DAUNELE JUCĂTORULUI
- ARMURA      -> OBIECT CARE CREȘTE APĂRAREA JUCĂTORULUI
- CONSUMABIL  -> OBIECT CARE POATE FI FOLOSIT DE JUCĂTOR
- INAMIC      -> CLASA PENTRU INAMIC
- SCHELETE    -> INAMIC SPECIFIC CARE ARE DAUNE RIDICATE
- ZOMBI       -> INAMIC SPECIFIC CARE ARE APĂRARE RIDICATĂ



![image](https://user-images.githubusercontent.com/93475691/230998427-b1f4a9c4-2d78-437d-ba64-8d6495fe362f.png)


ACȚIUNI:

JUCĂTOR:
- IA_OBIECT         -> Jucătorul va lua un obiect
- PROVOACĂ_DAUNE    -> Jucătorul va provoca daune unui inamic
- CALCULEAZĂ_DAUNE  -> Jucătorul va calcula daunele pe care le va primi (În funcție de rezistență)
- ECHIPEAZĂ_ARMURĂ  -> Jucătorul va echipa un set de armură din inventar
- ECHIPEAZĂ_ARMĂ    -> Jucătorul va echipa o armă din inventar
- FOLOSEȘTE_OBIECT  -> Jucătorul va folosi un obiect din inventar
- MISCĂ-TE          -> Jucătorul se va mișca
- BLOCHEAZĂ         -> Jucătorul va bloca următorul atac și va suferi daune scăzute


INAMIC:
- PROVOACĂ_DAUNE    -> Inamicul va provoca daune jucătorului
- CALCULEAZĂ_DAUNE  -> Inamicul va calcula daunele pe care le va primi (În funcție de rezistență)



REGULI:
-Daunele se calculează astfel (Daunele primite - Rezistență = Daune asupra vieții).
-Daunele (în cazul unei blocări) vor fi înjumătățite și apoi se vor calcula conform regulii de a calcula daune.
-Lupta se va face pe ture, fiecare dintre cei 2 adversari vor provoca daune cu rândul.
-În cazul unei blocări, toate celelalte acțiuni sunt interzise pentru tura respectivă.
-Spațiul de stocare al obiectelor este "infinit".


