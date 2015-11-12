package poomine;
import java.util.Scanner;

/**
 * Created by default on 12-Nov-15.
 */
public class Start {

    public static void main(String[] args) {

        Scanner skanner = new Scanner(System.in);

        String sona = "hammasratas";
        int sonaPikkus = sona.length();

        char[] peidetudSona = new char[sonaPikkus];
        boolean[] kasPeidetud = new boolean[sonaPikkus];
        char[] kasutajaNaeb = new char[sonaPikkus];
        String[] joonistus = {
                "____________",
                "||         |",
                "||         O",
                "||        /|/",
                "||       o |o",
                "==        //"
        };


        int valedVastused = 0;

        for (int i = 0; i<sonaPikkus; i++) {
            peidetudSona[i] = sona.charAt(i);
        }

        System.out.println("See on Poomisemäng. Teil tuleb ära arvata peidetud sõna.\n" +
                "Äraarvamine toimub tähtede kaupa.");

        boolean voitisVoiKaotas = false;

        while (valedVastused <5) {
            int kasVoitis = 0;

            for (int i = 0; i<sonaPikkus; i++) {
                if (kasPeidetud[i] == false)
                    kasutajaNaeb[i] = '_';
                if (kasPeidetud[i] == true) {
                    kasutajaNaeb[i] = peidetudSona[i];
                    kasVoitis++;
                }
            }

            if (valedVastused > 0)
                for (int i = 0; i<=valedVastused; i++) {
                    System.out.println(joonistus[i]);
                }
            System.out.println();

            for (int i = 0; i<sonaPikkus; i++) {
                System.out.print(kasutajaNaeb[i] + " ");
            }
            System.out.println();
            if (kasVoitis == sona.length()) {
                voitisVoiKaotas = true;
                break;
            }

            System.out.println();
            System.out.print("Teie pakkumine: ");

            String kasutajaArvabString = skanner.nextLine();

            while (kasutajaArvabString.length() > 1) {
                System.out.println("Arvame ikka tähekaupa, mitte sõnadena!!!");
                System.out.print("Teie pakkumine: ");
                kasutajaArvabString = skanner.nextLine();
            }
            char kasutajaArvab = kasutajaArvabString.charAt(0);

            if (sona.contains(kasutajaArvabString) == true) {
                for (int i = 0; i<sonaPikkus; i++) {
                    if (peidetudSona[i] == kasutajaArvab) {
                        kasutajaNaeb[i] = peidetudSona[i];
                        kasPeidetud[i] = true;
                    }

                }
                System.out.println("Arvasite õigesti. Teeme teie arvatud tähed lahti.");
            } else {
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
