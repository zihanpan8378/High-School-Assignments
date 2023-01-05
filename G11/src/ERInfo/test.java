/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERInfo;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DiseaseRecord dr = new DiseaseRecord();

        for (int i = 0; i < dr.d.length; i++) {
            System.out.println("\nDisease " + (i + 1));
            System.out.println("Enter disease name: ");
            String name = in.next();
            System.out.println("Enter time: ");
            int time = in.nextInt();
            dr.add(new DiseaseInformation(name, time));
        }

        System.out.println("\ngetNumberOfDistinctDiseaseNames");
        System.out.println(dr.getNumberOfDistinctDiseaseNames());

        System.out.println("\ndisplayDiseaseInfo");
        dr.displayDiseaseInfo();

        System.out.println("\ngetLongestEstimatedTime");
        System.out.println(dr.getLongestEstimatedTime());

        System.out.println("\ngetShortestEstimatedTime");
        System.out.println(dr.getShortestEstimatedTime());

        System.out.println("\ngetAverageTime");
        System.out.println(dr.getAverageTime());

        System.out.println("\ngetLongestDisseaseName");
        System.out.println(dr.getLongestDisseaseName());

        System.out.println("\ngetDisseasesWithOddIndexTime");
        for (int i = 0; i < dr.getDisseasesWithOddIndexTime().length; i++) {
            if (dr.getDisseasesWithOddIndexTime()[i] != null) {
                System.out.println(dr.getDisseasesWithOddIndexTime()[i]);
            }
        }

        System.out.println("\ngetSameEstimatedTime");
        for (int i = 0; i < dr.getSameEstimatedTime().length; i++) {
            if (dr.getSameEstimatedTime()[i] != null) {
                System.out.println(i + 1);
                System.out.println(dr.getSameEstimatedTime()[i]);
            }
        }

        System.out.println("\ngetDiseasesWithOddTimes");
        for (int i = 0; i < dr.getDiseasesWithOddTimes().length; i++) {
            if (dr.getDiseasesWithOddTimes()[i] != null) {
                System.out.println(dr.getDiseasesWithOddTimes()[i]);
            }
        }
    }
}