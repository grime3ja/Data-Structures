import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class UniqueWords {

    public static void main(String[] args) {

        final long START = System.currentTimeMillis();
        final long END = System.currentTimeMillis();

        System.out.println(arrayCount("The quick brown fox jumps over the lazy dog"));


        System.out.println(hashCount("The quick brown fox jumps over the lazy dog"));

        System.out.println( hashCount() );

        System.out.println( treeCount() );

        System.out.println("Total execution time: " + (END - START));

    }

    public static int arrayCount(String s) {

        boolean[] count = new boolean[127];
        int different = 0;
        for (int i = 0; i < s.length(); i++) {

            count[s.charAt(i)] = true;

        }

        for (int i = 0; i < count.length; i++) {

            if (count[i] == true) {

                different++;

            }

        }
        return different;

    }

    public static int hashCount(String s) {

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < s.length(); i++) {

            set.add((int)s.charAt(i));

        }
        return set.size();

    }

    public static int hashCount() {

        HashSet<String> set = new HashSet<String>();
        try {

            Scanner scan = new Scanner(new File("./src/count.txt"));
            while (scan.hasNext()) {

                set.add(scan.next());

            }

        } 
        catch (FileNotFoundException e) {

            System.out.println("An error has occured");
            e.printStackTrace();

        }
        return set.size();

    }

    public static int treeCount() {

        TreeSet<String> set = new TreeSet<String>();
        try {

            Scanner scan = new Scanner(new File("./src/count.txt"));
            while (scan.hasNext()) {

                set.add(scan.next());

            }

        } 
        catch (FileNotFoundException e) {

            System.out.println("An error has occured");
            e.printStackTrace();

        }
        return set.size();

    }

}