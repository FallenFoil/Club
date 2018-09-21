package view;

import javax.swing.*;
import java.util.List;
import java.awt.*;


public class Membros extends JFrame { //esta classe é por sim um frame

    private JPanel pl = new JPanel();

    public Membros(List<String> x) {//objetivo da classe, devolver todos eles em lista

        super("Membros do Cesium");
        setSize(700, 700);
        setResizable(false);

        this.pl.setLayout(new GridLayout(x.size(), 1));

        try {
            for (int i = 0; i < x.size(); i++) {

                JButton l = new JButton();
                l.setText(x.get(i));
                pl.add(l);
            /*l.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }
            });*/
            }
        }catch (Exception e){ }

        add(pl);
        setVisible(true);
    }
}

