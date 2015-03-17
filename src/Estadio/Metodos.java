package Estadio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * ** @author DAVID ***
 */
public class Metodos {

    PrintWriter fich;
    Scanner sc;
    String nombF = "Libreria.txt";
    String delim = ",";
    String linea;
    ArrayList<Entrada> entrada;
    int bucle;

    public void add() {

        try {
            fich = new PrintWriter(new FileWriter(new File(nombF), true));
            sc = new Scanner(new File(nombF));
            do {
                entrada = new ArrayList();
                String n = JOptionPane.showInputDialog("Nombre?");
                String d = JOptionPane.showInputDialog("Dni?");
                int nu = Integer.parseInt(JOptionPane.showInputDialog("Numero de asientos?"));

                Entrada l = new Entrada(n, d, nu);
                entrada.add(l);
                fich.println(l);
                bucle = JOptionPane.showConfirmDialog(null, "Añadir mas?");
            } while (bucle == 0);

        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
            sc.close();
        }
    }

    public void consultar() {
        String nombre;
        int precio = 0;
        String n = "";
        try {
            sc = new Scanner(new File(nombF)).useDelimiter(delim);
            do {
                int aux = 0;
                entrada = new ArrayList();

                while (sc.hasNextLine()) {
                    linea = sc.nextLine();
                    String[] l = linea.split(",");
                    for (int i = 0; i < l.length; i += 4) {
                        entrada.add(new Entrada(l[i], l[i + 1], Integer.parseInt(l[i + 3])));
                    }
                }
                nombre = JOptionPane.showInputDialog("Nombre Persona");
                for (Entrada l : entrada) {
                    if (l.getNom().replace(' ', '-').equalsIgnoreCase(nombre.replace(' ', '-'))) {
                        precio = l.getNumA();
                        n = l.getDni();
                        aux = 1;
                    }
                }
                if (aux == 1) {
                    JOptionPane.showMessageDialog(null, n + " - Precio: " + precio + "€");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe la persona: " + nombre + ", en la Base de Datos.");
                }
                bucle = JOptionPane.showConfirmDialog(null, "Buscar mas?");
            } while (bucle == 0);

        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }
    }

    public void visualizar() {
        entrada = new ArrayList();
        String ac = "";
        try {
            sc = new Scanner(new File(nombF)).useDelimiter(delim);
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                String[] l = linea.split(",");
                for (int i = 0; i < l.length; i += 4) {
                    entrada.add(new Entrada(l[i], l[i + 1], Integer.parseInt(l[i + 3])));
                }
            }
            for (int j = 0; j < entrada.size(); j++) {
                ac = ac + ("Entrada " + (j + 1) + "---> " + "Nombre: " + entrada.get(j).getNom() + " Dni: " + entrada.get(j).getDni() + "Numero de asientos: " + entrada.get(j).getNumA() + "€" + "\n");
            }
            JOptionPane.showMessageDialog(null, ac);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }
    }

    public void darBaja() {
        entrada = new ArrayList();
        try {
            int preg = JOptionPane.showConfirmDialog(null, "Seguro que quieres borrar?");
            if (preg == 0) {
                sc = new Scanner(new File(nombF)).useDelimiter(delim);
                fich = new PrintWriter(new FileWriter(new File(nombF), true));
                while (sc.hasNextLine()) {
                    linea = sc.nextLine();
                    String[] l = linea.split(",");
                    for (int i = 0; i < l.length; i += 4) {
                        entrada.add(new Entrada(l[i], l[i + 1], Integer.parseInt(l[i + 3])));
                    }
                }
                sc.close();
                fich.close();
                File f = new File(nombF);
                f.delete();
                f.createNewFile();
                fich = new PrintWriter(new FileWriter(new File(nombF), true));
                for (int i = 0; i < entrada.size(); i++) {

                    fich.println(entrada.get(i));

                }
                JOptionPane.showMessageDialog(null, "Borrado Completado");
            }
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
            sc.close();
        }
    }

    public void editarInfo() {
        entrada = new ArrayList();
        int cont;
        try {
            sc = new Scanner(new File(nombF)).useDelimiter(delim);
            fich = new PrintWriter(new FileWriter(new File(nombF), true));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                String[] l = linea.split(",");
                for (int i = 0; i < l.length; i += 3) {
                    entrada.add(new Entrada(l[i], l[i + 1], Integer.parseInt(l[i + 2])));
                }
            }
            sc.close();
            fich.close();
            do {
                cont = 0;
                String preg = JOptionPane.showInputDialog("Dni");
                for (int i = 0; i < entrada.size(); i++) {
                    if (entrada.get(i).getNom().equalsIgnoreCase(preg)) {
                        String ent = JOptionPane.showInputDialog("Nombre: " + entrada.get(i).getNom() + " Dni: " + entrada.get(i).getDni() + "Numero de asientos: " + entrada.get(i).getDni());
                        //entrada.get(i).getNumA(Integer.parseInt(ent));
                        cont = 1;
                        break;
                    } else {
                        cont = 0;
                    }
                }
                if (cont == 1) {
                    File f = new File(nombF);
                    f.delete();
                    f.createNewFile();
                    fich = new PrintWriter(new FileWriter(new File(nombF), true));
                    for (int j = 0; j < entrada.size(); j++) {

                        fich.println(entrada.get(j));

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No existe el dni: " + preg + ", en la Base de Datos");
                }
                bucle = JOptionPane.showConfirmDialog(null, "Buscar mas?");
            } while (bucle == 0);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
            sc.close();
        }
    }

    public void ordenar() {
        entrada = new ArrayList();
        try {
            sc = new Scanner(new File(nombF)).useDelimiter(delim);
            fich = new PrintWriter(new FileWriter(new File(nombF), true));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                String[] l = linea.split(",");
                for (int i = 0; i < l.length; i += 4) {
                    entrada.add(new Entrada(l[i], l[i + 1], Integer.parseInt(l[i + 3])));
                }
            }
            Collections.sort(entrada);
            sc.close();
            fich.close();
            File f = new File(nombF);
            f.delete();
            f.createNewFile();
            fich = new PrintWriter(new FileWriter(new File(nombF), true));
            for (int i = 0; i < entrada.size(); i++) {

                fich.println(entrada.get(i));

            }
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
            sc.close();
        }
    }

    public void buscar() {
        String nombreA;
        String autor = "";
        String n = "";
        try {
            do {
                int aux = 0;
                entrada = new ArrayList();
                sc = new Scanner(new File(nombF)).useDelimiter(delim);
                fich = new PrintWriter(new FileWriter(new File(nombF), true));
                while (sc.hasNextLine()) {
                    linea = sc.nextLine();
                    String[] l = linea.split(",");
                    for (int i = 0; i < l.length; i += 4) {
                        entrada.add(new Entrada(l[i], l[i + 1], Integer.parseInt(l[i + 3])));
                    }
                }
                nombreA = JOptionPane.showInputDialog("Nombre del Autor");
                for (Entrada l : entrada) {
                    if (l.getNom().equalsIgnoreCase(nombreA)) {
                        autor = l.getDni();
                        n = n + "\n" + l.getNom();
                        aux = 1;
                    }
                }
                if (aux == 1) {
                    JOptionPane.showMessageDialog(null, "Autor: " + autor + "\n" + "Libros: " + n);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe el autor: " + nombreA + ", en la Base de Datos.");
                }
                bucle = JOptionPane.showConfirmDialog(null, "Buscar mas?");
            } while (bucle == 0);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
            fich.close();
        }
    }
}

