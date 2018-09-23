package view;

import model.Club;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;

public class Menu {
    private Club cesium;
    private JPanel fstPN;
    private JButton secundaryBT;
    private JList list;
    private JButton primaryBT;


    public Menu() {
        this.cesium = Club.getInstance();
        JFrame menu = new JFrame("App Cesium");
        menu.setContentPane(this.fstPN);

        this.secundaryBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame m = new JFrame("Eliminar membro");
                m.setResizable(false);
                m.setSize(200, 50);

                JTextField txt = new JTextField(10);
                txt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(cesium.removeMember(txt.getText()) == true){
                            DefaultListModel modelo = new DefaultListModel();
                            for (Member cliente : cesium.getInfo().keySet()) {
                                modelo.addElement(cliente.getID() + "    " + "      " + cliente.getName() );
                            }
                            list.setModel(modelo);
                        }
                        else {
                            JOptionPane.showMessageDialog( m ,"Digite um número de aluno válido", "Erro de remoção", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                });
                m.add(txt);
                m.setVisible(true);
            }
        });


        this.primaryBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Layout x = new Layout(cesium,list);

            }
        });

                menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                menu.pack();
                menu.setVisible(true);

    }

    public static void main(String []args){
        new Menu();
    }


}
