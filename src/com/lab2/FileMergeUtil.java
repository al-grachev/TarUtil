package com.lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

final class FileMergeUtil {

    static void merge(final List<String> inputFileNameList, final String outputFileName) throws FileNotFoundException {
        for (final String inputFileName : inputFileNameList) {
            final List<String> strings = new BufferedReader(new FileReader(new File(inputFileName))).lines()
                    .collect(Collectors.toList());


        }
    }
}