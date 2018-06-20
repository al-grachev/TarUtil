package com.lab2;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

final class FileSplitUtil {

    private FileSplitUtil(){}

    static void split(final String inputFileName) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
        final List<String> strings = bufferedReader.lines().collect(Collectors.toList());
        BufferedWriter bufferedWriter;
        for (int i = 0; i < strings.size(); i++){
            String string = strings.get(i);
            if (string.endsWith(".txt->")){
                //Without "->"
                final String path = string.substring(0, string.length() - 2);
                final File outputFile = new File(path);
                bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
                while (i < strings.size() && !string.equals("<-")){
                    string = strings.get(++i);
                    bufferedWriter.write(string);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            }
        }
    }
}