package view;

//// Imports que não deveriam de estar aqui////
import model.Member;
///////////////////////////////////////////////
import model.ModelFacade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe defenida para criar um membro
 * Cada membro fica com o próprio Layout
 */

public class Layout {
    private boolean used;//significa se o panel foi usado ou não
    private JPanel layout_panel;
    private JFrame layout;
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
    private String member_name;
    private int ID;

    public Layout(ModelFacade x, JList list, List<JFrame> frames){
        this.layout = new JFrame("Membro");
        layout.setSize(350,300);
        layout.setContentPane(this.layout_panel);
        layout.setLocationRelativeTo(null);
        layout.setVisible(true);
        this.used = false;

        refreshBT.addActionListener(new ActionListener() {
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

                String strAdress = adressTF.getText();

                if (!used) {
                    if (x.AddMember(ID, member_name)) {
                        DefaultListModel modelo = new DefaultListModel();
                        for (Member cliente : x.getInfo().keySet()) {
                            modelo.addElement(cliente.getID() + "    " + "      " + cliente.getName());
                        }

                        list.setModel(modelo);
                        setUsed(true);
                        frames.add(layout);
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

                    DefaultListModel modelo = new DefaultListModel();
                    for (Member cliente : x.getInfo().keySet()) {
                        modelo.addElement(cliente.getID() + "    " + "      " + cliente.getName());
                    }

                    list.setModel(modelo);
                    layout.dispose();
                }
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
