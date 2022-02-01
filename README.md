# Customer

Customer- projektin tarkoituksena on luoda tietokanta, johon on helppo lisätä ja lukea asiakastietoja.
Asiakkaasta tärkeitä tietoja ovat id, etunimi, sukunimi, osoite, postinumero, kaupunki, puhelin ja yksilöivänä tietona käytetty email.
Lisäsin myös dateCreated ja lastModified, jotta luonnissa ja muutoksissa pysyy mukana. Id generoidaan automaattisesti.

Sovellus on deployattu osoitteeseen https://customerharjoitus.herokuapp.com, josta tietoja voi tarkastella. /api/ sivulla perus hakemisto /api/customers näyttää tallennetut tiedot.
Tein samalla kokonaiset crud-toiminnot eli tietoja voi hakea, poistaa, lisätä ja päivittää. Kutsut voi lähettää esimerkiksi Postman-apilla.

Sovelluksessa on yksinkertainen suojaus. Kysyy salasanaa ensimäisellä kerralla, kirjaudu tunnuksilla user/pass.

