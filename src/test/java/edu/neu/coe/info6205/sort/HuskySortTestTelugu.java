package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.sort.huskysort.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.huskysort.PureHuskySort;
import edu.neu.coe.info6205.sort.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class HuskySortTestTelugu {

    @Test
    public void sortTeluguWords() {
        String[] unsortedTelugu = new String[]{"నటుడు", "బానందం", "అన్నారు", "కరోనా"};
        String[] sortedTelugu = new String[]{"అన్నారు", "కరోనా", "నటుడు", "బానందం" };

        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(unsortedTelugu);
        System.out.println(Arrays.toString(unsortedTelugu));
        assertArrayEquals(sortedTelugu, unsortedTelugu);
    }

    @Test
    public void sortShuffledTelugu() throws IOException {
        List<String> a = FileUtil.readFile("src/main/resources/shuffledTelugu.txt");
        List<String> b = FileUtil.readFile("src/main/resources/shuffledTelugu.txt");
        String[] aArray = new String[a.size()];
        String[] bArray = new String[b.size()];
        a.toArray(aArray);
        b.toArray(bArray);

        Arrays.sort(bArray);

        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(aArray);
        assertArrayEquals(aArray, bArray);

    }

    @Test
    public void sortShuffledTelugu1000() throws IOException {
        List<String> a = FileUtil.readFile("src/main/resources/1000-telugu-words-shuffled.txt");
        List<String> b = FileUtil.readFile("src/main/resources/1000-telugu-words-shuffled.txt");
        String[] aArray = new String[a.size()];
        String[] bArray = new String[b.size()];
        a.toArray(aArray);
        b.toArray(bArray);

        Arrays.sort(bArray);

        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(aArray);
        for(int i=0;i<1000;i++){
            System.out.println(aArray[i]+" "+bArray[i]);
        }
        assertArrayEquals(aArray, bArray);

    }

}
