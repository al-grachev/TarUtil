package com.lab2;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

final class FileMergeUtil {

    private FileMergeUtil(){}

    static void merge(final List<String> inputFileNameList, final String outputFileName) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFileName));
        for (final String inputFileName : inputFileNameList) {
            final List<String> strings = new BufferedReader(new FileReader(new File(inputFileName))).lines()
                    .collect(Collectors.toList());
            bufferedWriter.write(inputFileName + "->");
            bufferedWriter.newLine();
            for (int i = 0; i < strings.size(); i++) {
                final String string = strings.get(i);
                bufferedWriter.write(string);
                bufferedWriter.newLine();
                if (i == strings.size() - 1){
                    bufferedWriter.write("<-");
                    bufferedWriter.close();
                }
            }
        }
    }
}