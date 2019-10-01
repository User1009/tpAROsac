public class Objet implements Comparable<Objet>{

        int weight;
        int value;
        double ratio;
        double pris;

        Objet(int weight, int value){
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value/weight;
        }
        Objet(){}


        void pris_dans_le_sac(double pris){
            this.pris = pris;
        }

    @Override
    public int compareTo(Objet o) {
        return Double.compare(this.ratio, o.ratio);
    }
}
