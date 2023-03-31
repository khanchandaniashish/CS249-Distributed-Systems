package edu.sjsu.cs249.zooleader;

import java.io.*;

/**
 * @author ashish
 */
public class Persister {

    FileOutputStream f;
    ObjectOutputStream o;

    String filePath;

    public Persister(String filePrefix) throws IOException {
        this.filePath = filePrefix+"_myObjects1.txt";
        File f = new File(filePath);
        f.createNewFile();
    }

    void persist(LunchPerk lunchPerk) throws IOException {
        f = new FileOutputStream(filePath);
        o = new ObjectOutputStream(f);
        o.writeObject(lunchPerk);
        o.close();
    }

    LunchPerk getLunch()  {
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(filePath);
            ObjectInputStream oi = new ObjectInputStream(fi);
            return (LunchPerk)oi.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new LunchPerk();
    }
}
