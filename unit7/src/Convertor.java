/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 44485
 */
public class Convertor {
    double fNumber;
    double eRate[][];
    
    public void setExchangeRate(){
        eRate=new double[4][4];
        eRate[0][1]=13757;
        eRate[0][2]=6.3;
        eRate[0][3]=0.705;
        eRate[1][2]=0.0004566;
        eRate[1][3]=0.00005124;
        eRate[2][3]=0.1124;
        for(int i=0;i<eRate.length;i++){
            for(int j=0;j<eRate.length;j++){
                if(i==j)
                    eRate[i][j]=1;
            }
        }
    }
    public void setAll(double fNumber){
        this.fNumber=fNumber;
    }
    
    public double getSnumber(int fCurrency,int sCurrency){
       
        if(eRate[fCurrency][sCurrency]<1){
            if(eRate[fCurrency][sCurrency]==0){
                 System.out.println("0:"+eRate[sCurrency][fCurrency]);
                return fNumber*eRate[sCurrency][fCurrency];
            }else{
                 System.out.println(">0:"+eRate[fCurrency][sCurrency]);
            return fNumber/eRate[fCurrency][sCurrency];
            }
        }
        else
            return fNumber*eRate[fCurrency][sCurrency];
    }
}
