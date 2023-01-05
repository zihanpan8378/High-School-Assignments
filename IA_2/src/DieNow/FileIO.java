/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DieNow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 40474
 */
public class FileIO {

    public FileIO() {
    }

    /**
     * pre: none
     * post: store information in .csv file, output players' winrates
     * @param w is the name of winner
     * @param l is the name of loser
     */
    public String[] file(String w, String l) {
        String re[] = new String[2];
        List<Info> a = new ArrayList();
        File file = new File("/Users/40474/NetBeansProjects/IA_2/src/DieNow/Files/TestSheet.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created");
            } catch (IOException ex) {
                System.out.println("Input/Output excpetion");
                re[0]="Input/Output excpetion";
            }
        } else {
            System.out.println("File exists");
        }
        FileWriter out;
        BufferedWriter write;
        FileReader in;
        BufferedReader read;
        String s;
        boolean w1 = true;
        boolean l1 = true;
        try {
            in = new FileReader(file);
            read = new BufferedReader(in);
            s = read.readLine();
            while ((s = read.readLine()) != null) {
                String[] temp = s.split(";");
                Info f = new Info();
                f.setName(temp[0]);
                f.setWins(Integer.parseInt(temp[1]));
                f.setLoses(Integer.parseInt(temp[2]));
                f.setWinrate(Double.parseDouble(temp[3]));
                if (f.getName().equals(w)) {
                    f.setWins(f.getWins() + 1);
                    f.setWinrate((double) (f.getWins()) / (double) (f.getWins() + f.getLoses()) * 100);
                    f.setWinrate(Double.parseDouble(String.format("%.1f", f.getWinrate())));
                    w1 = false;
                    re[0] = f(f.toString());
                }
                if (f.getName().equals(l)) {
                    f.setLoses(f.getLoses() + 1);
                    f.setWinrate((double) (f.getWins()) / (double) (f.getWins() + f.getLoses()) * 100);
                    f.setWinrate(Double.parseDouble(String.format("%.1f", f.getWinrate())));
                    l1 = false;
                    re[1] = f(f.toString());
                }
                a.add(f);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Input/Output expection");
        }
        if (w1) {
            Info f = new Info();
            f.setName(w);
            f.setWins(1);
            f.setLoses(0);
            f.setWinrate(1 / (double) 1 * 100);
            a.add(f);
            re[0] = f(f.toString());
        }
        if (l1) {
            Info f = new Info();
            f.setName(l);
            f.setWins(0);
            f.setLoses(1);
            f.setWinrate(0 / (double) 1 * 100);
            a.add(f);
            re[1] = f(f.toString());
        }
        try {
            out = new FileWriter(file);
            write = new BufferedWriter(out);
            write.write("Names;Wins;Loses;WinRate");
            write.newLine();
            while (!a.isEmpty()) {
                write.write(a.get(0).toString());
                write.newLine();
                a.remove(0);
            }
            write.close();
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            ex.getMessage();

        } catch (IOException ex) {
            System.out.println("Input/Output expection");

        }
        return re;
    }

    /**
     * pre: none
     * post: convert a string into an array of string that can be stored in Info
     * @param s is the string that needs to be converted
     */
    public String f(String s) {
        String[] t = s.split(";");
        String n = "";
        for (int i = 0; i < t.length; i++) {
            n += (t[i] + "     ");
        }
        return n;
    }

}
