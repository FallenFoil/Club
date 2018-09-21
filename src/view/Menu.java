package view;

import model.Club;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;

public class Menu {
    private JButton eliminarMembroButton;
    private JButton adicionarMembroButton;
    private JButton listaDeMembrosButton;
    private JPanel my_panel;
    private Club cesium;




    public Menu() {
        this.cesium = new Club();
        JFrame menu = new JFrame("App Cesium");

        my_panel.setSize(1000,1000);
        menu.setContentPane(my_panel);


        listaDeMembrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Membros(cesium.getInfo()); //tem Exception defenido
                }catch (Exception l){
                    System.out.println(l);
                };
            }
        });

        eliminarMembroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame m = new JFrame("Eliminar membro");
                m.setResizable(false);
                m.setSize(200, 50);

                JTextField new_member = new JTextField(10);
                new_member.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //ESTOU A ASSUMIR QUE O ID É SEMPRE O , MUDAR ISTO DEPOIS
                        cesium.removeMember(new_member.getText());
                    }
                });

            }
        });


        adicionarMembroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame m = new JFrame("Novo Membro");
                m.setResizable(false);
                m.setSize(200, 50);

                JTextField new_member = new JTextField(10);
                new_member.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //ESTOU A ASSUMIR QUE O ID É SEMPRE O , MUDAR ISTO DEPOIS
                        cesium.AddMember(new Member(new_member.getText(), 0));
                    }
                });

                m.add(new_member);
                m.setVisible(true);

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
