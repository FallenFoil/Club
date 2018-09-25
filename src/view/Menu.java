package view;


//// Imports que não deveriam de estar aqui////
import com.sun.org.apache.xpath.internal.operations.Mod;
import data.ClubDataManager;
import model.Club;
import model.Member;
///////////////////////////////////////////////


import data.DataFacade;
import javax.swing.*;
import model.ModelFacade;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class Menu {
    private ModelFacade cesium;
    private JPanel fstPN;
    private JButton secundaryBT;
    private JList list;
    private JButton primaryBT;
    private DataFacade df = new ClubDataManager();
    private List<JFrame> frames = new ArrayList<>();



    public Menu(ModelFacade cesium) {
        this.cesium = cesium;
        JFrame menu = new JFrame("App Cesium");
        menu.setContentPane(this.fstPN);

        this.secundaryBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame m = new JFrame("Eliminar membro");
                m.setResizable(false);
                m.setSize(200, 50);

                JTextField txt = new JTextField(10);
                txt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int i=0;
                        for(Member x : cesium.getInfo().keySet()){
                            if(x.getID() == Integer.parseInt(txt.getText())){
                                frames.remove(i);
                            }
                            i++;
                        }
                        i=0;

                        if(cesium.removeMember(txt.getText()) == true){
                            DefaultListModel modelo = new DefaultListModel();
                            for (Member cliente : cesium.getInfo().keySet()) {
                                modelo.addElement(cliente.getID() + "    " + "      " + cliente.getName() );
                            }

                            list.setModel(modelo);
                        }
                        else {
                            JOptionPane.showMessageDialog( m ,"Digite um número de aluno válido", "Erro de remoção", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                });
                m.add(txt);
                m.setVisible(true);
            }
        });


        this.primaryBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Layout x = new Layout(cesium,list,frames);
                for(int i=0; i<frames.size(); i++){
                    System.out.println(frames.get(i).getX());
                }
            }
        });

        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                df.saveData(cesium, "test.dss");
                    }
        };

        menu.addWindowListener(exitListener);
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.pack();
        menu.setVisible(true);
        list.addComponentListener(new ComponentAdapter() { } );

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    frames.get(index).setVisible(true);
                    System.out.println(index);
                }
            }
        };
        list.addMouseListener(mouseListener);

        menu.addWindowListener(exitListener);
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.pack();
        menu.setVisible(true);
    }
}
