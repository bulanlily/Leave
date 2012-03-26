<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

    <title>Leave Information</title>
    <script type="text/javascript" src="${requestContext.contextPath}/assets/js/jquery.js"></script>
    <script type="text/javascript" src="${requestContext.contextPath}/assets/js/jquery.txt"></script>
    <!-- Le styles -->

    <script type="text/javascript">
        $(function () {
        /*
        Example 1
        */
        $('input#id_search').quicksearch('table#employeetable tbody tr');
        });
    </script>

    <link href="${requestContext.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link href="${requestContext.contextPath}/assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="${requestContext.contextPath}/assets/ico/favicon.ico">

    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="${requestContext.contextPath}/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72"
          href="${requestContext.contextPath}/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed"
          href="${requestContext.contextPath}/assets/ico/apple-touch-icon-57-precomposed.png">
</head>


<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">

            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">LeaveSheet</a>

            <div class="nav-collapse">
                <ul class="nav">
                    <li class="active"><a href="board.html">DashBoard</a></li>
                </ul>
            </div>
            <a class="brand" href="#">${time}</a>


            <!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">
    <section id="gridCustomization">
        <div class="page-header">
            <h1>Leave Information In The Latest Month</h1>
        </div>


        <form action="#">
            <fieldset>
                <input name="search" id="id_search" type="text" placeholder="Find your name here..."> <span
                    style="display: none;" class="loading">Loading...</span>
            </fieldset>
        </form>


        <table id="employeetable" class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Employee ID</th>
                <th>Name</th>
                <th>Base</th>
                <th>Tenner</th>
                <th>Remaining Annual Leave</th>
            </tr>
            </thead>
            <tbody>

            <#list employees as employee>


                <tr>
                    <td>${employee.id?c}</td>
                    <td>${employee.name}</td>
                    <td>${employee.office}</td>
                    <td> ${employee.getPresentTenner()}</td>
                    <td>
                        <a href="history/${employee.id?c}">
                            ${employee.getRemainingAnnualLeave()}
                        </a>
                    </td>
                </tr>


            </#list>
            </tbody>
        </table>
    </section>
</div>

</body>
</html>

