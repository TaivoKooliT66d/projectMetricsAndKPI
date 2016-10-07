# projectMetricsAndKPI
http://kommuun.koodikool.ee/t/projekt-projekti-meetrikute-analuusimine-ja-statistika-kuvamine/206

# Sissejuhatus
Töötan arendusprogrammijuhina ja mul on vaja pidevalt aru saada, mis seisus on üleüldine programm. Programm koosneb paljudest projektidest, mida veavad läbi erinevad projektijuhid.

Olen alustuseks teinud ära andmemudeli ja ka kasutan projektiplaani importimiseks andmebaasi MPXJ libraryt.4. Andmebaas on TSQLi peal, kuna analüüsis on vaja lisaks kasutada informatsiooni samast andmebaasist aga erinevast tabelist. Kuid antod projekti puhul kasutan ma ilmselt Maria DB

# Eesmärk
Kaardistada ära erinevad meetrikud, et oleks võimalik aru saada:

* Projektide üleüldisest olukorrast - project health
* Leida üles kriitilsed projektid:
** Kas peab tähtajast kinni
** Kui palju on puhvrit alles
** Kas projekt on edenenud
** Kui palju taske ja defekte on projektiga seotud
** Manuaalset lisatud tegevuspunktide jälgimist
** Puhkuste andmebaasiga võrdlus, kas kõik puhkused on projektiplaanis up-to-date, tuua välja erinevused
** Kontrollida, kas projektiplaan vastab ka issue-tracking süsteemile, tuua välja erinevused, mis ei vasta.

#Tehnoloogiad
* Java 8
* Tomcat 8 v Jetty
* Spring Framework
* Kui SQLiga otse päringud tööle saab ja lahenduse esimene iteratsioon hakkab valmis saama, siis Hibernate peale refactor

# Tulemus
* On võimalik näha projektiga seotud pudelikaelu kiiresti ja ruttu
* On võimalik näha inimesele, kes ei oma oskust lugeda projektiplaani, projekti seisukorda
* Äripool saab omale juurde nähtavust.

# Litsents
GNU General Public License
