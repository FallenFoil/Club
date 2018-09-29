package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Quotas {

    private List<JTextField> x;
    private JFrame n;

    public Quotas(model.Fee f) {
        this.x = new ArrayList<>();
        this.n = new JFrame("Quotas");
        JPanel fee = new JPanel();
        this.n.setResizable(true);
        this.n.setSize(300, 300);


        for (LocalDate now : f.getPayDay().keySet()) {
            JTextField m = new JTextField();
            fee.add(m);
            m.setText("Data : " + now.toString() + " --- Pago :  Não");
        }

        for (JTextField t : this.x) {
            t.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.setText(t.getText());
                }
            });
        }
        this.n.add(fee);
    }

    public JFrame getFrame(){
        return this.n;
    }
}
