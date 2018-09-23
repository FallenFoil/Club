package Data;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ClubDataManager implements DataFacade, Serializable {

    public ClubDataManager(){

    }

    public void saveData(Object o, String fich) {
            FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(new File(fich));
        } catch (FileNotFoundException e){
            System.out.println("Ficheiro nao encontrado " + e.getMessage());
        }

        try{
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Data stored.");
    }

    public Object fetchData(String fich){
        Object o = new Object();
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(new File(fich));
        } catch (FileNotFoundException e){
            System.out.println("File not Found: " + e.getMessage());
            return o;
        }

        try{
            ObjectInputStream ois = new ObjectInputStream(fis);
            o = ois.readObject();
            ois.close();
        } catch (Exception e){
            System.out.println("IO Error: " + e.getMessage());
            return o;
        }
        System.out.println("Data fetched.");
        return o;
    }

}
