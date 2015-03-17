package Estadio;

/**
 * ** @author DAVID ***
 */
public class Entrada implements Comparable {

    private String nom = "";
    private String dni = "";
    private int numA;

    public Entrada() {
    }

    public Entrada(String nom, String dni, int numA) {
        this.nom = nom;
        this.dni = dni;
        this.numA = numA;
    }

    public String getNom() {
        return nom;
    }

    public String getDni() {
        return dni;
    }

    public int getNumA() {
        return numA;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNumA(int numA) {
        this.numA = numA;
    }

    public void editarInfo() {

    }

    @Override
    public String toString() {
        return "Entrada{" + "nom=" + nom + ", dni=" + dni + ", numA=" + numA + '}';
    }

    @Override
    public int compareTo(Object o) {
        Entrada obx = (Entrada) o;
        if (this.dni.compareToIgnoreCase(obx.dni) == 0) {
            return 0;
        }else if(this.dni.compareToIgnoreCase(obx.dni)>1)
            return 1;
        else{
            return -1;
        }
    }

}
