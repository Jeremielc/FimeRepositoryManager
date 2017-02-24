<%@ page import="com.fimelab.reman.controller.RegisterPageController" %>

<script type="text/javascript">search_word();</script>

<nav class="navbar navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" style="padding-left: 120px" href="../Reman/index.jsp">Reman</a>
        </div>
        <!-- Menu button -->
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="../Reman/index_registered.jsp">Home</a></li>
                <li><a href="../Reman/latest_registered.jsp">Lastest Version</a></li>
                <%
                    if (RegisterPageController.sessions.get(session) != null) {
                        if (RegisterPageController.sessions.get(session).isAdmin()) {
                            out.println("                <li><a href=\"../Reman/upload_registered.jsp\">Upload</a></li>");
                        }
                    }
                %>
            </ul>

            <ul class="nav navbar-nav navbar-right" style="padding-right: 30px">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <% out.print(RegisterPageController.sessions.get(session) != null ? RegisterPageController.sessions.get(session).getCuid() : "You are not supposed to be here"); %>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu" style="padding: 15px;min-width: 200px;">
                    <li>
                        <div class="row">
                            <div class="col-md-12">
                                <form class="form" role="form" method="post" action="Reman/register/disconnect" accept-charset="UTF-8" id="logout-nav">
                                    <div class="form-group" style="margin-bottom: 0px;">
                                        <button type="submit" class="btn btn-custom btn-block">
                                            <span class="glyphicon glyphicon-log-out"></span> Logout</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </li>
                </ul>
            </li>
            </ul>

            <!-- Input Search -->
            <form class="navbar-form navbar-right" role="search">
                <div class="input-group">
                    <input type="search" class="form-control search" placeholder="Search" name="q">
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</nav>