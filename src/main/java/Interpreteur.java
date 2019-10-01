import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Interpreteur {

    Scanner sc;
    File f;


    Interpreteur(String path){

        this.f = new File(path);

        try {
            sc = new Scanner(this.f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void interpreter(Sac sac){
        int poids;
        int valeur;

        for(int i=0;sc.hasNextInt();i++)
        {
            if(i == 0){
                sac.capacity = sc.nextInt();
            }
            if(i != 0){

                //System.out.println(line +" tmp :" + tmp);
                poids = sc.nextInt();
                valeur =  sc.nextInt();
               // System.out.println("poids: "+ poids + " valeur: "+valeur+" ratio = "+ poids/valeur);
                //Objet o = new Objet(poids, valeur);
                sac.maison.add(new Objet(poids,valeur));
               // sac.affiche_maison();
            }
        }

    }

}
