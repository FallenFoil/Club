package view;

//// Imports que não deveriam de estar aqui////
import model.Fee;
import model.Member;
///////////////////////////////////////////////
import model.ModelFacade;

import java.time.LocalDate;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Classe defenida para criar um membro
 * Cada membro fica com o próprio Layout
 */

public class Layout {
    private boolean used;//significa se o panel foi usado ou não
    private JPanel layout_panel;
    private JFrame layout;
    private  JLabel number;
    private  JLabel year;
    private  JLabel name;
    private  JLabel curse;
    private JTextField numberTF;
    private JTextField yearTF;
    private JTextField nameTF;
    private JTextField curseTF;
    private JButton feeBT;
    private JButton doneBT;
    private String member_name;
    private int ID;
    private Quotas fee;
                            
    public Layout(ModelFacade x, JList numberlist, JList namelist, List<JFrame> frames , List<Fee> tmp,int tmp_size){
        this.layout = new JFrame("Membro");
        layout.setSize(350,300);
        layout.setContentPane(this.layout_panel);
        layout.setLocationRelativeTo(null);
        layout.setVisible(true);
        this.used = false;

        doneBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str;
                str = numberTF.getText();
                int y = Integer.parseInt(str);
                setId(y);

                str = nameTF.getText();
                setName(str);

                String strCurse = curseTF.getText();

                String strYear = yearTF.getText();


                if (!used) {
                    if (x.AddMember(ID, member_name)) {
                        DefaultListModel numberModelo = new DefaultListModel();
                        DefaultListModel nameModelo = new DefaultListModel();
                        for (Member cliente : x.getInfo().keySet()) {
                            numberModelo.addElement(cliente.getID());
                            nameModelo.addElement(cliente.getName());
                        }

                        numberlist.setModel(numberModelo);
                        namelist.setModel(nameModelo);
                        setUsed(true);
                        frames.add(layout);
                        tmp.add(new Fee(10,LocalDate.now()));
                        fee = new Quotas(tmp.get(tmp.size()-1)); //sempre que é criado cota para um aluno , é criado layout de cotas
                        layout.dispose();
                    } else {
                        JOptionPane.showMessageDialog(layout, "Digite um número de aluno válido, número atual já existente", "Erro de validação", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    for(Member x : x.getInfo().keySet()){
                        if(x.getID()==ID){
                            x.setName(member_name);
                        }
                    }

                    DefaultListModel numberModelo = new DefaultListModel();
                    DefaultListModel nameModelo = new DefaultListModel();
                    for (Member cliente : x.getInfo().keySet()) {
                        numberModelo.addElement(cliente.getID());
                        nameModelo.addElement(cliente.getName());
                    }

                    numberlist.setModel(numberModelo);
                    namelist.setModel(nameModelo);
                    layout.dispose();
                }
            }

        });
        feeBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fee.getFrame().setVisible(true);
                }
        });
    }


    public void setName(String x){
        this.member_name = x;
    }
    public void setId(int x){
        this.ID = x;
    }
    public void setUsed(Boolean x){this.used = x;}

}
