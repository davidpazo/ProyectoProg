package Estadio;

import javax.swing.JOptionPane;

/**** @author DAVID ****/
public class Estadio {

    public static void main(String[] args) {
         Metodos obx = new Metodos();
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("opciones: \n1 --> Añadir\n2 --> Visualizar\n3 --> Consultar Reserva\n4 --> Dar baja\n5 --> Ordenar\n6 --> Editar Reserva\n7 --> Buscar\n8 --> Salir"));
            switch (op) {
                case 1:
                    obx.add();
                    break;
                case 2:
                    obx.visualizar();
                    break;
                case 3:
                    obx.consultar();
                    break;
                case 4:
                    obx.darBaja();
                    break;
                case 5:
                    obx.ordenar();
                    break;
                case 6:
                    obx.editarInfo();
                    break;
                case 7:
                    obx.buscar();
                    break;
                case 8:
                    System.exit(0);
            }
        } while (op != 0 && op != 8);
    }

    }
    

