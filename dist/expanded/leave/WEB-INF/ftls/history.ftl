<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

    <title>personal information Information</title>
    <script type="text/javascript" src="${requestContext.contextPath}/javascripts/jquery-1.5.2.min.js"></script>

    <!-- Le styles -->

    <link href="${requestContext.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
    <style>
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
    <link rel="apple-touch-icon-precomposed" href="${requestContext.contextPath}/assets/ico/apple-touch-icon-57-precomposed.png">
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
            <a class="brand" href="#">Leave Information In The Latest Month</a>

            <div class="nav-collapse">
                <ul class="nav">

                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">
    <section id="gridCustomization">
        <div class="page-header">
            <h1>Personal information</h1>
        </div>
         <div class="row">
             <div class="span5">
                 <table class="table table-striped">
                     <tbody>
                     <tr>
                         <th>ID</th>
                         <td>${employee.id?c}</td>
                     </tr>
                     <tr>
                         <th>Name</th>
                         <td>${employee.name}</td>
                     </tr>
                     <tr>
                         <th>Tenner</th>
                         <td>${employee.getPresentTenner()}</td>
                     </tr>
                     <tr>
                         <th>Annual leave(year)</th>
                         <td>${employee.getRightActualRateByYear()}</td>
                     </tr>

                     <tr>
                         <th>Annual leave(at present)</th>
                         <td>${employee.getAnnualLeaveAtPresent()}</td>
                     </tr>
                     <tr>
                         <th>Annual leave(remaining)</th>
                         <td>${employee.getRemainingAnnualLeave()}</td>
                     </tr>
                     </tbody>
                 </table>
             </div>
         </div>

        <div class="page-header">
            <h1>Leave List</h1>
        </div>
        <table class="table table-bordered table-striped"">
            <thead>
            <tr>
                <th>Date</th>
                <th>Sub Proj</th>
                <th>Hours</th>
                <th>Task</th>
            </tr>
            </thead>
            <tbody>

            <#list leaves as leave>
                <tr>
                    <td> ${leave.leaveDate.getMonthOfYear()?c} / ${leave.leaveDate.getDayOfMonth()?c}
                        /${leave.leaveDate.getYear()?c}
                    </td>
                    <td>${leave.subProj}</td>
                    <td>${leave.hours}</td>
                    <td>${leave.task}</td>
                </tr>
            </#list>
            </tbody>
        </table>

    </section>
</div>
</body>
</html>

