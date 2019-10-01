
import java.util.ArrayList;
import java.util.Collections;

public class Sac {
    public int capacity;
    ArrayList<Objet> maison = new ArrayList<>();
    private ArrayList<Objet> sac = new ArrayList<>();
    private int meilleureValeur;


    private Sac(int capacity) {
        this.capacity = capacity;
    }

    private Sac(){}

    private void tri(){
        Collections.sort(maison);
        Collections.reverse(maison);
    }

     void affiche_maison(){
        for (Objet o: maison) {
            System.out.println("ratio de l'objet "+ maison.indexOf(o)+" dans la maison =" + o.ratio);
        }
    }

    private int vol(){
        int tmpCapacity=capacity;
        int valeur_total = 0;
        for (Objet o: maison) {
            if(tmpCapacity >= o.weight){
                tmpCapacity -= o.weight;
                o.pris_dans_le_sac(1.0);
                sac.add(o);
               // System.out.println(" objet entier + nouvelle capacité" + capacity);
            }

            if(tmpCapacity < o.weight && tmpCapacity > 0 && !sac.contains(o)){
                double tmp = (double)tmpCapacity/(double) o.weight;
                tmpCapacity = 0;
                o.pris_dans_le_sac(tmp);
                sac.add(o);
                valeur_total += o.value;
            }

            if(capacity < o.weight && capacity == 0 && !sac.contains(o)){
                o.pris_dans_le_sac(0.0);
                valeur_total += o.value;
            }
        }
    return valeur_total;
    }

    public void BB(ArrayList<Objet> listeObjet, int i, int valeur, int capacite){

        if(i == listeObjet.size()) {

            if (valeur > meilleureValeur)
                meilleureValeur = valeur;

        }
        else{
            if(listeObjet.get(i).weight <= capacite) {
                BB(listeObjet, i + 1, valeur + listeObjet.get(i).value, capacite - listeObjet.get(i).weight);
            }

            BB(listeObjet, i+1, valeur, capacite);

        }

    }
    private void affiche_sac(){
        System.out.print("La composition du sac est : ");
        for (Objet o: sac) {
            System.out.println(" objet " + sac.indexOf(o) + " poids: "+ o.weight+ " valeur: "+ o.value+ "   " + o.pris);
        }
    }

    public static void main(String args[]){

        Sac test = new Sac();

        Interpreteur i = new Interpreteur("/amuhome/h15005699/IdeaProjects/tpAROsac/sacOpt103");
        i.interpreter(test);
        System.out.println("capacite: "+test.capacity);


        //test.affiche_maison();
        test.tri();
        System.out.println();
        test.meilleureValeur=test.vol();
        System.out.println(test.capacity);

        test.BB(test.maison,0,0,test.capacity) ;
        System.out.println("meilleur valeur = " + test.meilleureValeur);

        test.affiche_sac();
    }

}
