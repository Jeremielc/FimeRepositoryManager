package com.fimelab.reman.utils;

import com.fimelab.reman.pojo.ToolArchiveFile;

import java.io.File;
import java.util.StringTokenizer;

public class FileNameParser {

    private static FileNameParser instance = new FileNameParser();

    private FileNameParser() {

    }

    public static FileNameParser getInstance() {
        return FileNameParser.instance;
    }

    public ToolArchiveFile parse(String filename) {
        if (filename != null) {
            ToolArchiveFile taf = new ToolArchiveFile();

            StringTokenizer st = new StringTokenizer(filename, "-");
            while (st.hasMoreTokens()) {
                taf.setToolName(st.nextToken());
                taf.setToolVersion(st.nextToken().substring(1));
                taf.setToolStatus(st.nextToken().replaceAll(".zip", ""));
            }

            return taf;
        } else {
            return new ToolArchiveFile(null, null, null);
        }
    }
}
