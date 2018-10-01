import data.DataFacade;
import model.ModelFacade;
import data.ClubDataManager;
import model.Club;
import view.Menu;
import view.Quotas;

import javax.swing.*;


public class Main{
    private static DataFacade df = new ClubDataManager();
    private static ModelFacade c = new Club(df);

    public static void main(String []args){
        Club.setInstance();
        c = Club.getInstance();
        System.out.println("ola");
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
}
