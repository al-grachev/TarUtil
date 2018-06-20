import com.lab2.FileMergeUtil;
import com.lab2.FileSplitUtil;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public final class Tests {

    @Test
    public final void split() throws IOException {
        final String fileName = "files/input.txt";
        FileSplitUtil.split(fileName);
        assertTrue(assertFileContains("files/f.txt", "ee", "v"));
        assertTrue(assertFileContains("files/x.txt", "evknwvlnwenvlwe'jk", "qe"));
    }

    @Test
    public final void merge() throws IOException {
        final String outputFileName = "files/output.txt";
        final List<String> inputFileNames = Arrays.asList("files/f.txt", "files/x.txt");
        FileMergeUtil.merge(inputFileNames, outputFileName);
        assertTrue(assertFileContains(outputFileName,
                "files/f.txt->"
                , "ee"
                , "v"
                , "<-"
                , "files/x.txt->"
                , "evknwvlnwenvlwe'jk"
                , "qe"
                , "<-"
        ));
    }

    private boolean assertFileContains(final String fileName, final String... expectedStrings)
            throws FileNotFoundException {
        final List<String> inputStrings = new BufferedReader(new FileReader(fileName)).lines()
                .collect(Collectors.toList());
        if (inputStrings.size() != expectedStrings.length) {
            return false;
        }
        final List<String> expectedList = Arrays.asList(expectedStrings);
        for (int i = 0; i < inputStrings.size(); i++) {
            final String inputString = inputStrings.get(i);
            if (!inputString.equals(expectedList.get(i))) {
                return false;
            }
        }
        return true;
    }
}