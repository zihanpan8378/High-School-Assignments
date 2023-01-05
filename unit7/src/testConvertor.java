/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 44485
 */
public class testConvertor {
    public static void main(String[] args) {
        Convertor Convertor=new Convertor();
        Convertor.setAll(2);
        Convertor.setExchangeRate();
        System.out.println(Convertor.getSnumber(0, 1));
    }
}
