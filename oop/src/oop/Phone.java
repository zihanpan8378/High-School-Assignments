/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author 44869
 */
public class Phone {

    int storageSize1;
    int storageSize2;
    int storageSize3;
    double yearRelease1;
    double yearRelease2;
    double yearRelease3;
    double price1;
    double price2;
    double price3;
    String phone1;
    String phone2;
    String phone3;

    public int getStorageSize1() {
        return storageSize1;
    }

    public void setStorageSize1(int storageSize1) {
        this.storageSize1 = storageSize1;
    }

    public int getStorageSize2() {
        return storageSize2;
    }

    public void setStorageSize2(int storageSize2) {
        this.storageSize2 = storageSize2;
    }

    public int getStorageSize3() {
        return storageSize3;
    }

    public void setStorageSize3(int storageSize3) {
        this.storageSize3 = storageSize3;
    }

    public double getYearRelease1() {
        return yearRelease1;
    }

    public void setYearRelease1(int yearRelease1) {
        this.yearRelease1 = yearRelease1;
    }

    public double getYearRelease2() {
        return yearRelease2;
    }

    public void setYearRelease2(int yearRelease2) {
        this.yearRelease2 = yearRelease2;
    }

    public double getYearRelease3() {
        return yearRelease3;
    }

    public void setYearRelease3(int yearRelease3) {
        this.yearRelease3 = yearRelease3;
    }

    public double getPrice1() {
        return price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    public double getPrice3() {
        return price3;
    }

    public void setPrice3(int price3) {
        this.price3 = price3;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getHighestmemory() {
        if (storageSize1 > storageSize2) {
            if (storageSize3 > storageSize1) {
                return phone3;
            } else {
                return phone1;
            }
        }
        if (storageSize2 > storageSize1) {
            if (storageSize3 > storageSize2) {
                return phone3;
            } else {
                return phone2;
            }
        }
        if (storageSize1 == storageSize2) {
            if (storageSize3 > storageSize1) {
                return phone3;
            } else {
                return phone1 && phone2;
            }
        }
        return "same";
    }

    public String getOldest() {
        if (yearRelease2 > yearRelease1) {
            if (yearRelease1 > yearRelease3) {
                return phone3;
            } else {
                return phone1;
            }
        }
        if (yearRelease1 > yearRelease2) {
            if (yearRelease2 > yearRelease3) {
                return phone3;
            } else {
                return phone2;
            }
        }
        if (yearRelease2 == yearRelease1) {
            if (yearRelease1 > yearRelease3) {
                return phone3;
            } else {
                return phone1 && phone2;
            }
        }
        return "same";
    }

    public String getMostexpensive() {
        if (price1 > price2) {
            if (price3 > price1) {
                return phone3;
            } else {
                return phone1;
            }
        }

        if (price2 > price1) {
            if (price3 > price2) {
                return phone3;
            } else {
                return phone2;
            }
        }
        if (price1 == price2) {
            if (price3 > price1) {
                return phone3;
            } else {
                return 
            }
        }
        return "same";
    }

}
