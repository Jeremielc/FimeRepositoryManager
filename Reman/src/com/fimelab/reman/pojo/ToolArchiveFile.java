package com.fimelab.reman.pojo;

import java.util.StringTokenizer;

public class ToolArchiveFile implements Comparable<ToolArchiveFile> {
    private String toolName, toolVersion, toolStatus, toolPath, qualificationReportPath, publicationDate;
    private boolean archived, qualified;

    public ToolArchiveFile() {

    }

    public ToolArchiveFile(String toolName, String toolVersion, String toolStatus) {
        this.toolName = toolName;
        this.toolVersion = toolVersion;
        this.toolStatus = toolStatus;
    }

    public ToolArchiveFile(String toolName, String toolVersion, String toolStatus, String toolPath, String qualificationReportPath, String publicationDate, boolean archived, boolean qualified) {
        this.toolName = toolName;
        this.toolVersion = toolVersion;
        this.toolStatus = toolStatus;
        this.toolPath = toolPath;
        this.qualificationReportPath = qualificationReportPath;
        this.publicationDate = publicationDate;
        this.archived = archived;
        this.qualified = qualified;
    }

    @Override
    public int compareTo(ToolArchiveFile o) {
        if (this.getToolName().equals(o.getToolName()) && !this.getToolVersion().equals(o.getToolVersion())) {
            Integer currentItem, foreignItem;
            String ver1 = this.getToolVersion(), ver2 = o.getToolVersion();
            do {
                StringTokenizer st1 = new StringTokenizer(ver1, ".");
                StringTokenizer st2 = new StringTokenizer(ver2, ".");

                currentItem = Integer.parseInt(st1.hasMoreElements() ? st1.nextToken() : "0");
                foreignItem = Integer.parseInt(st2.hasMoreElements() ? st2.nextToken() : "0");

                if (currentItem > foreignItem) {
                    return -1;
                } else if (currentItem < foreignItem) {
                    return 1;
                } else {
                    ver1 = st1.hasMoreTokens() ? ver1.substring(2) : "0";
                    ver2 = st2.hasMoreTokens() ? ver2.substring(2) : "0";
                }
            } while (currentItem.intValue() == foreignItem.intValue());
        } else {
            return this.getToolPath().compareTo(o.getToolPath());
        }

        return 0;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolVersion() {
        return toolVersion;
    }

    public void setToolVersion(String toolVersion) {
        this.toolVersion = toolVersion;
    }

    public String getToolStatus() {
        return toolStatus;
    }

    public void setToolStatus(String toolStatus) {
        this.toolStatus = toolStatus;
    }

    public String getToolPath() {
        return toolPath;
    }

    public void setToolPath(String toolPath) {
        this.toolPath = toolPath;
    }

    public String getQualificationReportPath() {
        return qualificationReportPath;
    }

    public void setQualificationReportPath(String qualificationReportPath) {
        this.qualificationReportPath = qualificationReportPath;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isQualified() {
        return qualified;
    }

    public void setQualified(boolean qualified) {
        this.qualified = qualified;
    }
}
