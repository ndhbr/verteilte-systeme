package verteilte_systeme;

import verteilte_systeme.uebung_01.Uebung_01;
import verteilte_systeme.uebung_02.Uebung_02;
import verteilte_systeme.uebung_03.Uebung_03;

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
            }
        }
    }

    /**
     * Cuts the first element of array and returns the array with length - 1
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
