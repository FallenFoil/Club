package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Quotas {

    private List<JTextField> x;
    private JFrame n;

    public Quotas(model.Fee f) {
        this.x = new ArrayList<>();
        this.n = new JFrame("Quotas");
        JPanel fee = new JPanel();
        this.n.setResizable(true);
        this.n.setSize(300, 300);


        for (Map.Entry<LocalDate,Boolean> now : f.getPayDay().entrySet()) {
            //aceder ao LocalDate -> now.getKey
            //aceder ao Boolean -> now.getValue
            JTextField m = new JTextField();
            fee.add(m);
            m.setText(now.getKey().toString() + " --- Pago : " + now.getValue());

            m.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String x = m.getText();
                    Scanner s = new Scanner(x);
                    String bool = "";
                    while(s.next() != ":");
                    bool = s.next();
                    System.out.println(bool);

                }
            });
        }
        this.n.add(fee);
    }

    public JFrame getFrame(){
        return this.n;
    }
}
