package com.fimelab.reman.pojo;

public class ToolArchiveFile {
    private String toolName, toolVersion, toolState, toolPath, qualificationReportPath;
    private boolean archived, qualified;

    public ToolArchiveFile() {

    }

    public ToolArchiveFile(String toolName, String toolVersion, String toolState) {
        this.toolName = toolName;
        this.toolVersion = toolVersion;
        this.toolState = toolState;
    }

    public ToolArchiveFile(String toolName, String toolVersion, String toolState, String toolPath, String qualificationReportPath, boolean archived, boolean qualified) {
        this.toolName = toolName;
        this.toolVersion = toolVersion;
        this.toolState = toolState;
        this.toolPath = toolPath;
        this.qualificationReportPath = qualificationReportPath;
        this.archived = archived;
        this.qualified = qualified;
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

    public String getToolState() {
        return toolState;
    }

    public void setToolState(String toolState) {
        this.toolState = toolState;
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
