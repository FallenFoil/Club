package view;

import model.ModelFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Quotas {
    private JFrame n;

    public Quotas(ModelFacade x, int memberID, boolean b){
        this.n = new JFrame("Quotas");
        this.n.setLayout(new GridLayout(13,2));
        this.n.setResizable(true);
        this.n.setSize(300, 300);
        this.n.setLocationRelativeTo(null);
        this.n.setVisible(b);

        Map<LocalDate, Boolean> payments = new HashMap<>(x.getMemberFee(memberID));

        for (Map.Entry<LocalDate,Boolean> now : payments.entrySet()){
            JLabel data = new JLabel(now.getKey().toString());
            this.n.add(data);
            JCheckBox paid = new JCheckBox("Pago", now.getValue());
            this.n.add(paid);
            paid.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    payments.put(now.getKey(), !now.getValue());
                    x.setMemberFee(memberID, payments);
                }
            });
        }

        JLabel blank = new JLabel("");
        this.n.add(blank);
        JButton doneBT = new JButton("Done");
        this.n.add(doneBT);
        doneBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                n.dispose();
            }
        });

    }

    public JFrame getFrame(){
        return this.n;
    }
}
