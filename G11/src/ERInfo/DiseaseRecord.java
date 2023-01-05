/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERInfo;

/**
 *
 * @author 44869
 */
public class DiseaseRecord {

    DiseaseInformation[] d = new DiseaseInformation[10];
    int count = 0;

    public void add(DiseaseInformation disease) {
        /*for (int i = 0; i < d.length; i++) {
            d[i] = disease;
        }*/

        if (count < d.length) {
            d[count] = disease;
            count++;
        }
    }

    public void displayDiseaseInfo() {
        for (int i = 0; i < d.length; i++) {
            System.out.println("\n" + d[i]);
        }
    }

    public int getNumberOfDistinctDiseaseNames() {
        int num = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] != null) {
                num++;
            }
        }
        for (int i = 0; i < d.length; i++) {
            for (int j = i + 1; j < d.length; j++) {
                if (d[i] != null) {
                    if (d[i].getName().equals(d[j].getName())) {
                        num--;
                        break;
                    }
                }
            }
        }
        return num;
    }

    public int getLongestEstimatedTime() {
        int longest = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i].getTime() > longest) {
                longest = d[i].getTime();
            }
        }
        return longest;
    }

    public int getShortestEstimatedTime() {
        int shortest = getLongestEstimatedTime();
        for (int i = 0; i < d.length; i++) {
            if (d[i].getTime() < shortest) {
                shortest = d[i].getTime();
            }
        }
        return shortest;
    }

    public double getAverageTime() {
        double total = 0, length = 0;
        for (int i = 0; i < d.length; i++) {
            total = total + d[i].getTime();
            length++;
        }
        return total / length;
    }

    public String getLongestDisseaseName() {
        int index = 0;
        int length = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i].getName().length() > length) {
                length = d[i].getName().length();
                index = i;
            }
        }
        return d[index].getName();
    }

    public String[] getDisseasesWithOddIndexTime() {
        String[] array = new String[d.length];
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if ((d[i].getName().length() % 2) != 0) {
                array[num] = d[i].getName();
                num++;
            }
        }
        return array;
    }

    public DiseaseInformation[] getSameEstimatedTime() {
        DiseaseInformation[] array = new DiseaseInformation[d.length];
        for (int i = 0; i < d.length; i++) {
            if (d[i].getTime() >= 5 && d[i].getTime() <= 10) {
                array[i] = d[i];
            }
        }
        return array;
    }

    public String[] getDiseasesWithOddTimes() {
        String[] array = new String[d.length];
        int num = 0;
        for (int i = 0; i < d.length; i++) {
            if ((d[i].getTime() % 2 != 0)) {
                array[num] = d[i].getName();
                num++;
            }
        }
        return array;
    }
}
