# Karjakoer
School project game of herd management.

Mäng, kus eesmärgiks on karjatada lambad mingi välja sisse, ehk algusväli oleks midagi sellist:
```
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
```
Karjakoer on kontrollitav hiirega, ehk niikaua kui registreeritakse hiire liikumist kusagile suunda, siis ka liigub karjakoer.

Lambad peavad kõik jõudma sihtmärki. 

Kui kõik lambad jõuavad ruutu (nende koordinaadid on ruudu sees), siis mäng lõppeb ja kuvatakse ekraanile aeg, kui kaua kulus. See aeg on mängu skooriks, mille tuleb salvestada logifaili, mis täiendab ennast, lisades parima tulemuse ja viimase tulemuse.
Kui parim tulemus muutub, siis võiks teavitada mängu lõpus sellest mängijat ja salvestada uue parima skoorina.

Algsuurus 500x500.
Mängu saab lõpetada vajutades tähte "e".
Mäng algab seisuga, liikumine platsil algab tähega "s".
Samuti saab koer space klahviga haukuda.
