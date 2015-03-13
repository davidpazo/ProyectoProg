package Estadio;
/**** @author DAVID ****/
public class Entrada {
    private String nom="";
    private String dni="";
    private int numA;

    public Entrada(){
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
        
    
    public void editarInfo(){
        
    }
}
