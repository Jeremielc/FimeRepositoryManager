package com.fimelab.reman.pojo;

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
        return this.getToolPath().compareTo(o.getToolPath());
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
