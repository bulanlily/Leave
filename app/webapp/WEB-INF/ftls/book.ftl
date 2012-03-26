<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

    <title>REA Dashboard</title>


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
            <a class="brand" href="#">DashBoard</a>

        </div>
    </div>
</div>

<div class="container">
    <section id="gridCustomization">
        <div class="page-header">
            <h1>${proName}</h1>
        </div>


        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Week 1</th>
                <th>Week 2</th>
                <th>Week 3</th>
                <th>Week 4</th>
                <th>Week 5</th>
            </tr>
            </thead>
            <tbody>
            <#list peopleList as people>
                <tr>
                    <td>
                        ${people.name}
                    </td>
                    <td>${people.getDaysInFirstWeek()}</td>
                    <td>${people.getDaysInSecondWeek()}</td>
                    <td>${people.getDaysInThirdWeek()}</td>
                    <td>${people.getDaysInForthWeek()}</td>
                    <td>${people.getDaysInFifthWeek()}</td>
                </tr>

            </#list>
            </tbody>
        </table>

    </section>
</div>

</body>
</html>

