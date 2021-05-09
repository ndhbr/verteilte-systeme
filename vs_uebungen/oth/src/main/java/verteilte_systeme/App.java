package verteilte_systeme;

import verteilte_systeme.uebung_01.Uebung_01;
import verteilte_systeme.uebung_02.Uebung_02;
import verteilte_systeme.uebung_03.Uebung_03;
import verteilte_systeme.uebung_04.Uebung_04;
import verteilte_systeme.uebung_05.Uebung_05;
import verteilte_systeme.uebung_06.Uebung_06;
import verteilte_systeme.uebung_06_2.Uebung_06_2;
import verteilte_systeme.uebung_06_3.Uebung_06_3;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        if (args.length > 0) {
            int uebungsNr = Integer.parseInt(args[0]);
            String[] slicedArgs = cutFirstElementOfArray(args);

            // select sheet
            switch (uebungsNr) {
                default:
                case 1:
                    new Uebung_01(slicedArgs);
                    break;
                case 2:
                    new Uebung_02(slicedArgs);
                    break;
                case 3:
                    new Uebung_03(slicedArgs);
                    break;
                case 4:
                    new Uebung_04(slicedArgs);
                    break;
                case 5:
                    new Uebung_05(slicedArgs);
                    break;
                case 6:
                    new Uebung_06(slicedArgs);
                    break;
                case 62:
                    new Uebung_06_2(slicedArgs);
                    break;
                case 63:
                    new Uebung_06_3(slicedArgs);
                    break;
            }
        }
    }

    /**
     * Cuts the first element of array and returns the array with length - 1
     * 
     * @param args
     * @return
     */
    public static String[] cutFirstElementOfArray(String[] args) {
        int n = args.length - 1;
        String[] slicedArgs = new String[n];

        System.arraycopy(args, 1, slicedArgs, 0, n);

        return slicedArgs;
    }
}
