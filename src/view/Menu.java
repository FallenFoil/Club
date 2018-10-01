package view;


import model.ModelFacade;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.stream.Collectors;

public class Menu {

    private ModelFacade cesium;
    private JPanel fstPN;
    private JButton secundaryBT;
    private JList numberList;
    private JList nameList;
    private JButton primaryBT;
    private JPanel lists;


    public Menu(ModelFacade Cesium) {

        this.cesium = Cesium;

        JFrame menu = new JFrame("App Cesium");
        menu.setContentPane(this.fstPN);

        JScrollPane scrollPanel = new JScrollPane(lists);
        menu.getContentPane().add(scrollPanel);

        secundaryButton();

        primaryButton();

        DefaultListModel numberModelo = new DefaultListModel();
        DefaultListModel nameModelo = new DefaultListModel();
        for (Integer a : cesium.getInfo()) {
            numberModelo.addElement(a);
            nameModelo.addElement(cesium.getMemberName(a));
        }

        numberList.setModel(numberModelo);
        nameList.setModel(nameModelo);

        WindowListener exitListener = exitL();
        mouseL();
        menu.addWindowListener(exitListener);
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    private void primaryButton(){
        this.primaryBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Layout x = new Layout(cesium, numberList, nameList);
            }
        });
    }

    private void secundaryButton(){
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

                        if(cesium.removeMember(txt.getText())){
                            DefaultListModel numberModelo = new DefaultListModel();
                            DefaultListModel nameModelo = new DefaultListModel();
                            for (Integer  a : cesium.getInfo()) {
                                numberModelo.addElement(a);
                                nameModelo.addElement(cesium.getMemberName(a));
                            }
                            numberList.setModel(numberModelo);
                            nameList.setModel(nameModelo);
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
    }

    private void mouseL(){
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = nameList.locationToIndex(e.getPoint());

                    //cria um Layout a partir de um determinado membro
                    new Layout(cesium,numberList,nameList,cesium.getInfo().get(index));

                }
            }
        };
        nameList.addMouseListener(mouseListener);
    }

    private WindowListener exitL(){
        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cesium.save();
            }
        };
        numberList.addComponentListener(new ComponentAdapter() { } );
        nameList.addComponentListener(new ComponentAdapter() { } );
        return exitListener;
    }
}
