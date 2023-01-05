
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        double[] location = new double[num];
        double[] middle = new double[num - 1];
        double[] size = new double[num - 2];

        for (int i = 0; i < location.length; i++) {
            location[i] = in.nextDouble();
        }

        Arrays.sort(location);

        for (int i = 0; i < middle.length; i++) {
            middle[i] = (location[i + 1] + location[i]) / 2;
        }

        for (int i = 0; i < size.length; i++) {
            size[i] = middle[i + 1] - middle[i];
        }

        Arrays.sort(size);
        
        DecimalFormat fmt = new DecimalFormat("##0.0");
        System.out.println(fmt.format(size[0]));

    }

}
