# Karjakoer
School project game of herd management.

Mäng, kus eesmärgiks on karjatada lambad mingi välja sisse, ehk algusväli oleks midagi sellist:
_____________________________________________________________________________________________
|                                                                                           |
|                                                                                           |
|                                ____________________                                       |
|                               |                    |                                      |
|                               |                    |                                      |
|                               |     (sihtmärk)     |                                      |
|                               |                    |                                      |
|                    O          |____________________|                                      |
|                                                                                           |
|                                                                O                          |
|                                         O             O                                   |
|                        O       O             O                  O (lammas)                |
|                                      O                                                    |
|                               O                 O                                         |
|                   O                                           O                           |
|                                                                                           |
|                                                                                           |
|                                                                                           |
|                                         <> (karjakoer siin                                |
|                                                                                           |
|                                                                                           |
_____________________________________________________________________________________________

Karjakoer on kontrollitav hiirega, ehk niikaua kui registreeritakse hiire liikumist kusagile suunda, siis ka liigub karjakoer.

Lambad peavad kõik jõudma sihtmärki (lihtsam teha ruut). 

Kui kõik lambad jõuavad ruutu (nende koordinaadid on ruudu sees), siis mäng lõppeb ja kuvatakse ekraanile aeg, kui kaua kulus. See aeg on mängu skooriks, mille tuleb salvestada logifaili, mis täiendab ennast, lisades parima tulemuse ja viimase tulemuse.
Kui parim tulemus muutub, siis võiks teavitada mängu lõpus sellest mängijat ja salvestada uue parima skoorina.

Mänguväli peab olema resizeable, kuid teha ikkagi otsese mänguvälja mittemuutuvaks, lihtsalt aken muudab siis oma suurust. Vast pole väga suur muutus.
Algsuurus 500x500.
Mängu saab lõpetada vajutades tähte "e".
Mäng algab seisuga, liikumine platsil algab tähega "s".
idee: teha ka näiteks koerale nupu haukumiseks, mis hirmutab lambaid.
idee: teha mingid piiravad takistused, mis genereeritakse suvaliselt platsile.

Order of business:
1. Luua javafx väli, mis on rohelise taustaga ja mis loob sihtmärgi veidi teise värviga (veidi kollakam plats)
2. tekitada player.java, mis talletab oma koordinaate ja kiirust ja mis platsil registreerib hiire liikumist. hiire suund kusagile annab kiirust aja jooksul karjakoerale juurde, cappides mingil mõistliku suurusega, ehk hiir on suunanäitaja, mitte otseselt
3. tekitada lammas.java, mis proovib eemalduda karjakoerast, vb ka kui läheduses (15x15 pikslit) on teine lammas, siis proovib temaga samas suunas joosta. Siin ka kasutada funktsiooni Random, mis aegajalt muudab lamba liikumissuunda väikese kraadi võrra.
4. luua logisüsteem, mis salvestab lõpetamise aja ja lammaste hulga. (võib ka lahendada nii, et võtad mängu alguse (kui vajutatakse "s") ja lahutada maha mängu lõppemise võiduga ja arvutada koos lammaste arvuga viimase skooripunktid).
5. luua mängu alguse ja lõpuekraan. (mängu algusekraan vb võimaldaks ka sisestada lammaste arvu hulka).
6. palvetada jumalat, et see ka töötaks.
