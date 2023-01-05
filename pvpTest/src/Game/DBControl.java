package Game;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 44485
 */
public class DBControl {

    static short primary;
    
    static String sql = "select * from info";
    static DBHelper db1 = new DBHelper(sql);

    static ArrayList<String> uname = new ArrayList();
    static ArrayList<String> pword = new ArrayList();
    static ArrayList<Integer> win = new ArrayList();
    static ArrayList<Integer> lose = new ArrayList();
    

    public DBControl() {
        sql = "select * from info";
        db1 = new DBHelper(sql);
        primary = (short) uname.size();
    }

    public static void updateInfo() throws SQLException {
        //refresh database
        int i = 0;
        ResultSet ret = db1.pst.executeQuery();
        uname = new ArrayList();
        pword = new ArrayList();
        win = new ArrayList();
        lose = new ArrayList();
        while (ret.next()) {
            i++;
            uname.add(ret.getString(2));
            pword.add(ret.getString(3));
            win.add(ret.getInt(4));
            lose.add(ret.getInt(5));
        }
        
        primary = (short) uname.size();
        //System.out.println(i);
        //ret.close();

    }

    public static ArrayList<String> getUser() {
        return uname;
    }

    public static int findUsername(String usr) {
        int i = 0;
        for (i = 0; i < uname.size(); i++) {
            System.out.println("checking: " + uname.get(i));
            if (uname.get(i).equals(usr)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean checkPassword(int i, String password) {
        if (pword.get(i).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void changeData(String name, int stat) throws SQLException {
        //change data in a cell
        System.out.println("Requested: " + name);
        int i = findUsername(name);
        System.out.println(i);
        String execute = "UPDATE info";
        int times = 0;
        if (stat == 0) {
            times = win.get(i);
            times++;
            execute += " SET win = " + times + " WHERE id = " + (i);

        } else {
            times = lose.get(i);
            times++;
            execute += " SET lose = " + times + " WHERE id = " + (i);
        }

        PreparedStatement ps = db1.conn.prepareStatement(execute);
        ps.executeUpdate();
        
    }

    public static int getWin(String name) {
        int i = findUsername(name);
        return win.get(i);
    }

    public static int getLose(String name) {
        int i = findUsername(name);
        return lose.get(i);
    }

    public static void addAccount(String username, String password) throws SQLException, ClassNotFoundException {
        //add row
        PreparedStatement stmt = db1.conn.prepareStatement("insert into info values(?,?,?,?,?)");
        Class.forName(db1.name);
        stmt.setShort(1, primary);
        stmt.setString(2, username);
        stmt.setString(3, password);
        stmt.setInt(4, 0);
        stmt.setInt(5, 0);
        stmt.executeUpdate();
        primary++;
    }
}
