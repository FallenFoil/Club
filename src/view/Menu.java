package view;

import model.ModelFacade;
//// Imports que não deveriam de estar aqui////
import model.Member;
///////////////////////////////////////////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private ModelFacade cesium;
    private JPanel fstPN;
    private JButton secundaryBT;
    private JList list1;
    private JList list2;
    private JButton primaryBT;
    private JPanel lists;
    private List<JFrame> frames = new ArrayList<>();


    public Menu(ModelFacade cesium) {
        this.cesium = cesium;
        JFrame menu = new JFrame("App Cesium");
        menu.setContentPane(this.fstPN);

        JScrollPane scrollPanel = new JScrollPane(lists);
        menu.getContentPane().add(scrollPanel);

        this.secundaryBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame m = new JFrame("Eliminar membro");
                m.setResizable(false);
                m.setSize(300, 200);
                m.setLayout(new GridLayout(3, 1));

                JLabel msg = new JLabel(" Insira o numero de membro a remover:");

                JPanel textFieldPanel = new JPanel(new GridLayout(2, 1));
                JLabel fieldmsg1 = new JLabel("");
                JTextField txt = new JTextField(10);
                txt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }

                });
                textFieldPanel.add(txt);
                textFieldPanel.add(fieldmsg1);

                JPanel donePanel = new JPanel(new GridLayout(1, 3));
                JLabel done1 = new JLabel("");
                JLabel done2 = new JLabel("");
                JButton doneButton = new JButton("Done");
                doneButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent){
                        int i=0;
                        for(Member x : cesium.getInfo().keySet()){
                            if(x.getID() == Integer.parseInt(txt.getText())){
                                frames.remove(i);
                            }
                            i++;
                        }
                        i=0;

                        if(cesium.removeMember(txt.getText())){
                            DefaultListModel numberModelo = new DefaultListModel();
                            DefaultListModel nameModelo = new DefaultListModel();
                            for (Member cliente : cesium.getInfo().keySet()) {
                                numberModelo.addElement(cliente.getID());
                                nameModelo.addElement(cliente.getName());
                            }
                            list1.setModel(numberModelo);
                            list2.setModel(nameModelo);
                        }
                        else {
                            JOptionPane.showMessageDialog( m ,"Digite um número de aluno válido", "Erro de remoção", JOptionPane.ERROR_MESSAGE);
                        }

                        m.dispose();
                    }
                });
                donePanel.add(done1);
                donePanel.add(done2);
                donePanel.add(doneButton);

                m.add(msg);
                m.add(textFieldPanel);
                m.add(donePanel);
                m.setLocationRelativeTo(null);
                m.setVisible(true);
            }
        });


        this.primaryBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Layout x = new Layout(cesium,list1,list2,frames);
                for(int i=0; i<frames.size(); i++){
                    System.out.println(frames.get(i).getX());
                }
            }
        });

        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cesium.save();
            }
        };
        list1.addComponentListener(new ComponentAdapter() { } );
        list2.addComponentListener(new ComponentAdapter() { } );

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index1 = list1.locationToIndex(e.getPoint());
                    int index2 = list2.locationToIndex(e.getPoint());
                    frames.get(index1).setVisible(true);
                    frames.get(index2).setVisible(true);
                    System.out.println(index1);
                    System.out.println(index2);
                }
            }
        };
        list1.addMouseListener(mouseListener);
        list2.addMouseListener(mouseListener);

        menu.addWindowListener(exitListener);
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }
}
