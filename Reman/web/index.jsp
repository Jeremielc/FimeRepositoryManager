<%@ page import="com.fimelab.reman.pojo.ToolArchiveFile" %>
<%@ page import="com.fimelab.reman.controller.HomePageController" %>
<%@ page import="java.util.Set" %>
<jsp:include page="html/header.jsp" />
<jsp:include page="html/navbar.jsp" />

<div class="container">
    <!-- Section -->
    <section id="intro" class="intro-section">
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <table class="table table-striped table-condensed">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Version</th>
                            <th>Status</th>
                            <th>Qualified</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            /*HomePageController hpc = new HomePageController();
                            Set<ToolArchiveFile> tools = hpc.getTools();

                            for (ToolArchiveFile taf : tools) {
                                out.println("                        <tr>");
                                out.println("                            <td>" + taf.getToolName() + "</td>");
                                out.println("                            <td>" + taf.getToolVersion() + "</td>");
                                out.println("                            <td>" + taf.getToolStatus() + "</td>");
                                out.println("                            <td><input type=\"checkbox\" value=\"" + taf.isQualified() + "\"></td>");
                                out.println("                            <td>");
                                out.println("                                <form method=\"get\" action=\"/Reman/home/download\">");
                                out.println("                                    <button class=\"btn btn-success\" type=\"submit\">Download</button>");
                                out.println("                                </form>");
                                out.println("                            </td>");
                                out.println("                        </tr>");
                            }*/
                        %>
                        <tr>
                            <td>testTool</td>
                            <td>1.0</td>
                            <td>stabe</td>
                            <td>
                                <input title="qualified" type="checkbox" value="" />
                            </td>
                            <td>
                                <form method="post" action="Reman/home/download">
                                    <button name="filename" value="testTool-v1.0-stable.zip" class="btn btn-success" type="submit">Download</button>
                                </form>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</div>

<jsp:include page="html/footer.jsp" />