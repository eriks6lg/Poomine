package poomine;
import java.util.Scanner;

/**
 * Created by default on 12-Nov-15.
 */
public class Start {

    public static void main(String[] args) {

        Scanner skanner = new Scanner(System.in);


        String sona = "hammasratas";                         // Äraarvatav sõna
        int sonaPikkus = sona.length();


        char[] peidetudSona = new char[sonaPikkus];          // Äraarvatav sõna, ainult char arrayna.

        boolean[] kasPeidetud = new boolean[sonaPikkus];     // Iga tähe kohta kehtib true/false
                                                                // false -- täht on peidetud (pole veel arvatud)
                                                                // true -- täht on lahti (arvati ära)

        char[] kasutajaNaeb = new char[sonaPikkus];          // Teine char array, mis kirjeldab, mida kasutaja näeb (peidetud
                                                             // ja lahti olevate tähtede kombinatsioon. Nt "h _ _ _ _ s _ _ _ _ s"

        String[] joonistus = {
                "____________",
                "||         |",
                "||         O",
                "||        /|/",
                "||       o |o",
                "==        //"
        }; // NB! Koosneb 5-st elemendist.


        int valedVastused = 0;                                // Mitu korda kasutaja valesti arvanud on.


        for (int i = 0; i<sonaPikkus; i++) {                  // Teeb sõnast (String) char array
            peidetudSona[i] = sona.charAt(i);
        }


        System.out.println("See on Poomisemäng. Teil tuleb ära arvata peidetud sõna.\n" +
                "Äraarvamine toimub tähtede kaupa.");


        boolean voitisVoiKaotas = false;                      // Kui kasutaja võitis, siis muutub see true-ks.


        while (valedVastused <5) {                            // Kui valesid vastuseid on 5, siis on joonistus valmis ja mängija on kaotanud.

            int kasVoitis = 0;                                // Loendur kontrollimaks, mitu tähte on kasutaja arvamise tõttu lahti tehtud.

            for (int i = 0; i<sonaPikkus; i++) {
                if (kasPeidetud[i] == false)
                    kasutajaNaeb[i] = '_';                    // Kui täht veel peidetud, siis kasutaja jaoks on see täht "_"
                if (kasPeidetud[i] == true) {
                    kasutajaNaeb[i] = peidetudSona[i];        // Kui täht on lahti, siis kasutaja jaoks on see täht nähtaval.
                    kasVoitis++;                              // Loenduri väärtus suureneb.
                }
            }

            if (valedVastused > 0)                            // Kui kasutaja on juba valesti vastanud
                for (int i = 0; i<=valedVastused; i++) {
                    System.out.println(joonistus[i]);         // Joonistus tuleb täpselt nii pikk, kui palju on kasutaja valesti vastanud
                }
            System.out.println();

            for (int i = 0; i<sonaPikkus; i++) {              // Prindib kinniste ja lahtiste tähtede kombinatsiooni kasutajale
                System.out.print(kasutajaNaeb[i] + " ");
            }

            System.out.println();

            if (kasVoitis == sona.length()) {                 // Kasutame loendurit. Kui loenduri väärtus on sõna pikkusega võrdne,
                voitisVoiKaotas = true;                       // st kõik tähed on lahti, on mängija võitnud. Seetõttu muutub ka
                break;                                        // voitisVoiKaotas true-ks. break viskab while loopist välja, sest mäng on läbi.
            }

            System.out.println();

            System.out.print("Teie pakkumine: ");

            String kasutajaArvabString = skanner.nextLine();  // Kasutaja tähe arvamine Stringina.


            while (kasutajaArvabString.length() > 1) {        // Juhul, kui kasutaja sisestab rohkem, kui ühe tähe.
                System.out.println("Arvame ikka tähekaupa, mitte sõnadena!!!");
                System.out.print("Teie pakkumine: ");
                kasutajaArvabString = skanner.nextLine();
            }

            char kasutajaArvab = kasutajaArvabString.charAt(0); // Kasutaja tähe arvamine char-ina.


            if (sona.contains(kasutajaArvabString) == true) { // Kui kasutaja arvatud täht on sõnas olemas, muutub täht lahtiseks.
                for (int i = 0; i<sonaPikkus; i++) {
                    if (peidetudSona[i] == kasutajaArvab) {
                        kasutajaNaeb[i] = peidetudSona[i];
                        kasPeidetud[i] = true;
                    }

                }
                System.out.println("Arvasite õigesti. Teeme teie arvatud tähed lahti.");
            } else {                                           // Kui ei ole olemas, siis valede vastuste väärtus suureneb 1 võrra.
                valedVastused++;
                System.out.println("Kahjuks arvasite valesti. Olete valesti arvanud " + valedVastused + " korda.");
            }


        }
        if (voitisVoiKaotas == true) {
            System.out.println("Palju õnne, olete mängu võitnud!!!");
        } else {
            for (int i = 0; i <= valedVastused; i++) {
                System.out.println(joonistus[i]);
            }
            System.out.println("Kahjuks kaotasite mängu. Ehk läheb järgmisel korral paremini...");
        }
    }
}
