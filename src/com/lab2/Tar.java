package com.lab2;

import java.util.ArrayList;
import java.util.List;

public final class Tar {

    public static void main(final String[] args) {
        if (args[0].equals("-u")) {
            String inputFileName = args[1];
            //Split here -->:
        } else {
            final List<String> inputMultipleFiles = new ArrayList<>();
            int i = 0;
            while ((i < args.length) && !args[i].equals("-out")) {
                inputMultipleFiles.add(args[i]);
                i++;
            }
            if (i == args.length) {
                throw new IllegalArgumentException("Некорректная команда. Повторите попытку");
            } else {
                i++;
                if (i > args.length) {
                    throw new IllegalArgumentException("Некорректная команда. Повторите попытку");
                }
                //Merge here -->:
            }
        }
    }
}