import view.Menu;
import data.DataFacade;
import model.ModelFacade;
import data.ClubDataManager;
import model.Club;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;


public class Main /* implements Observer*/ {
    //Inicializacao dos facades
    private static DataFacade df = new ClubDataManager();
    private static ModelFacade c = new Club(df);

    public static void main(String []args){
        Club.setInstance();
        c = Club.getInstance();
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(Exception e){
            System.err.println("Error on changing the theme!");
        }

        new Menu(c);
    }

    /* Hipotese a considerar, NAO IMPLEMENTADA MESMO RETIRANDO O COMENTARIO
    public void update(Observable ob, Object o){
        Main.df.saveData(c, "test.dss");
    }
    */
}
