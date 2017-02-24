<%@ page import="com.fimelab.reman.pojo.ToolArchiveFile" %>
<%@ page import="com.fimelab.reman.controller.HomePageController" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.fimelab.reman.controller.RegisterPageController" %>
<jsp:include page="html/header.jsp" />
<jsp:include page="html/navbar_registered.jsp" />

<div class="container">
    <!-- Section -->
    <section id="intro" class="intro-section">
        <div class="container">
            <h1>Active tools</h1>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-striped table-condensed">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th class="col-md-1">Version</th>
                            <th class="col-md-1">Status</th>
                            <th class="col-md-1">Qualified</th>
                            <th>Publication date</th>
                            <th class="col-md-4" colspan="4">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%!
                            private HomePageController hpc = new HomePageController();
                        %>
                        <%
                            Set<ToolArchiveFile> tools = hpc.listActiveArchiveFileFromDatabase();

                            for (ToolArchiveFile taf : tools) {
                                out.println("                        <tr>");
                                out.println("                            <td>" + taf.getToolName() + "</td>");
                                out.println("                            <td>" + taf.getToolVersion() + "</td>");
                                out.println("                            <td>" + taf.getToolStatus() + "</td>");
                                out.println("                            <td>");
                                out.println("                                <input title=\"qualified\" type=\"checkbox\"" + (taf.isQualified() ? " checked=\"checked\" " : " ") + "disabled=\"disabled\"/>");
                                out.println("                            </td>");
                                out.println("                            <td>" + taf.getPublicationDate() + "</td>");
                                out.println("                            <td>");
                                out.println("                                    <form method=\"post\" action=\"Reman/home/download\">");
                                out.println("                                        <button name=\"filename\" value=\"" + taf.getToolPath() + "\" class=\"btn btn-success\" type=\"submit\">Download</button>");
                                out.println("                                    </form>");
                                out.println("                            </td>");
                                if (taf.isQualified()) {
                                    out.println("                            <td colspan=\"1\">");
                                    out.println("                                    <form method=\"post\" action=\"Reman/home/download_report\">");
                                    out.println("                                        <button name=\"filename\" value=\"" + taf.getQualificationReportPath() + "\" class=\"btn btn-warning\" type=\"submit\">Get report</button>");
                                    out.println("                                    </form>");
                                    out.println("                            </td>");
                                } else {
                                    out.println("                            <td style=\"min-width:100px;\" colspan=\"1\">");
                                    out.println("                            </td>");
                                }
                                if (RegisterPageController.sessions.get(session).isAdmin()) {
                                    out.println("                            <td colspan=\"1\">");
                                    out.println("                                    <form method=\"post\" action=\"Reman/latest/archive\">");
                                    out.println("                                        <button name=\"filename\" value=\"" + taf.getToolPath() + "\" class=\"btn btn-info\" type=\"submit\">Archive</button>");
                                    out.println("                                    </form>");
                                    out.println("                            </td>");
                                    out.println("                            <td colspan=\"1\">");
                                    out.println("                                    <form method=\"post\" action=\"Reman/latest/remove\">");
                                    out.println("                                        <button name=\"filename\" value=\"" + taf.getToolPath() + "\" class=\"btn btn-danger\" onclick=\"javascript:return confirm('Are you sure you want to delete this tool ?')\" type=\"submit\">Delete</button>");
                                    out.println("                                    </form>");
                                    out.println("                            </td>");
                                }
                                out.println("                        </tr>");
                            }
                        %>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</div>

<jsp:include page="html/footer.jsp" />