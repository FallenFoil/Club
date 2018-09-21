package view;

import model.Fee;
import model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;


public class Membros extends JFrame { //esta classe é por sim um frame

    private JPanel pl = new JPanel();

    public Membros(Map<Member,List<Fee>> x) {//objetivo da classe, devolver todos eles em lista

        super("Membros do Cesium");
        setSize(700, 700);
        setResizable(false);

        this.pl.setLayout(new GridLayout(x.size(), 1));

        try {
            for (int i = 0; i < x.size(); i++) {

                JButton l = new JButton();
                List<Member> n = x.keySet().stream().collect(Collectors.toList());

                l.setText(n.get(i).getName());
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

