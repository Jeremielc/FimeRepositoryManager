package com.fimelab.reman.utils;

import com.fimelab.reman.pojo.ToolArchiveFile;

import java.util.StringTokenizer;

public class FileNameParser {

    public FileNameParser() {

    }

    public ToolArchiveFile parse(String filename) {
        ToolArchiveFile taf = new ToolArchiveFile();

        StringTokenizer st = new StringTokenizer(filename, "-");
        while (st.hasMoreTokens()) {
            taf.setToolName(st.nextToken());
            taf.setToolVersion(st.nextToken().substring(1));
            taf.setToolState(st.nextToken().replaceAll(".zip", ""));
        }

        return taf;
    }
}
