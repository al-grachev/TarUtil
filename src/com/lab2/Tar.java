package com.lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Tar {

    public static void main(final String[] args) throws IOException {
        if (args[0].equals("-u")) {
            final String inputFileName = args[1];
            FileSplitUtil.split(inputFileName);
        } else {
            final List<String> inputFileNameList = new ArrayList<>();
            int i = 0;
            while ((i < args.length) && !args[i].equals("-out")) {
                inputFileNameList.add(args[i]);
                i++;
            }
            if (i == args.length) {
                throw new IllegalArgumentException("Некорректная команда. Повторите попытку");
            } else {
                if (i >= args.length - 1) {
                    throw new IllegalArgumentException("Некорректная команда. Повторите попытку");
                }
                //Get last output file name arg:
                final String outputFileName = args[++i];
                FileMergeUtil.merge(inputFileNameList, outputFileName);
            }
        }
    }
}