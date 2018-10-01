package view;

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
    private JFrame layout;
    private JTextField numberTF;
    private JTextField yearTF;
    private JTextField nameTF;
    private JTextField curseTF;
    private JButton feeBT;
    private JButton doneBT;
    private JLabel numero;
    private JLabel nome;
    private JLabel ano;
    private JLabel curso;
    private String member_name;
    private String member_corse;
    private String member_year;
    private int member_ID;
    private Quotas fee;


    public Layout(ModelFacade x, JList numberlist, JList namelist ,Integer membro) {
        this.layout = new JFrame("Membro");
        layout.setSize(350, 300);
        layout.setContentPane(this.layout_panel);
        layout.setLocationRelativeTo(null);
        layout.setVisible(true);

        numberTF.setText(membro.toString());
        nameTF.setText(x.getMemberName(membro));
        yearTF.setText(x.getMemberYear(membro));
        curseTF.setText(x.getMemberCurse(membro));

        doneBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                member_ID = Integer.parseInt(numberTF.getText());
                member_name = nameTF.getText();
                member_year = yearTF.getText();
                member_corse = (curseTF.getText());

                if (x.getInfo().contains(member_ID)) {
                    x.setMember(member_ID, member_name, member_corse, member_year);

                }

                DefaultListModel numberModelo = new DefaultListModel();
                DefaultListModel nameModelo = new DefaultListModel();

                for (Integer a : x.getInfo()) {
                    numberModelo.addElement(a);
                    nameModelo.addElement(x.getMemberName(a));
                }

                numberlist.setModel(numberModelo);
                namelist.setModel(nameModelo);
                layout.dispose();
            }
        });


        feeBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fee = new Quotas(x, membro, true);
            }
        });
    }


    public Layout(ModelFacade x, JList numberlist, JList namelist ) {
        this.layout = new JFrame("Membro");
        layout.setSize(350, 300);
        layout.setContentPane(this.layout_panel);
        layout.setLocationRelativeTo(null);
        layout.setVisible(true);

        doneBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                member_ID = Integer.parseInt(numberTF.getText());
                member_name = nameTF.getText();
                member_corse = curseTF.getText();
                member_year = yearTF.getText();


                if (x.AddMember(member_ID, member_name, member_corse, member_year)) {
                    DefaultListModel numberModelo = new DefaultListModel();
                    DefaultListModel nameModelo = new DefaultListModel();
                    for (Integer a : x.getInfo()) {
                        numberModelo.addElement(a);
                        nameModelo.addElement(x.getMemberName(a));
                    }

                    numberlist.setModel(numberModelo);
                    namelist.setModel(nameModelo);
                    fee = new Quotas(x, member_ID, false);
                    layout.dispose();
                } else {
                    JOptionPane.showMessageDialog(layout, "Digite um número de aluno válido, número atual já existente", "Erro de validação", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }

}
