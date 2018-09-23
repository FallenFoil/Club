package view;

import model.Club;
import model.Member;
import model.ModelFacade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe defenida para criar um membro
 * Cada membro fica com o próprio Layout
 */

public class Layout {
    private JPanel layout_panel;
    private JLabel number;
    private JLabel Adress;
    private JLabel name;
    private JLabel curse;
    private JLabel Year;
    private JTextField numberTF;
    private JTextField adressTF;
    private JTextField yearTF;
    private JTextField nameTF;
    private JTextField curseTF;
    private JButton feeBT;
    private JButton refreshBT;
    private JButton Close;
    private String member_name;
    private int ID;

    public Layout(ModelFacade x, JList list){
        JFrame layout = new JFrame("Membro");
        layout.setSize(350,300);
        layout.setContentPane(this.layout_panel);
        layout.setVisible(true);

        this.numberTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x = numberTF.getText();
                int y = Integer.parseInt(x);
                setId(y);
            }
        });
        nameTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x = nameTF.getText();
                setName(x);
            }
        });
        curseTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x = curseTF.getText();
            }
        });
        yearTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x = yearTF.getText();
            }
        });
        adressTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x = adressTF.getText();
            }
        });

        refreshBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(x.AddMember(new Member(member_name,ID,layout)) == true){
                    DefaultListModel modelo = new DefaultListModel();
                    for (Member cliente : x.getInfo().keySet()) {
                        modelo.addElement(cliente.getID() + "    " + "      " + cliente.getName() );
                    }

                    list.setModel(modelo);
                }
                else {
                    JOptionPane.showMessageDialog( layout,"Digite um número de aluno válido, número atual já existente", "Erro de validação", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.dispose();
            }
        });
    }

    public void setName(String x){
        this.member_name = x;
    }
    public void setId(int x){
        this.ID = x;
    }


}
