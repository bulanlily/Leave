<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="refresh" content="10;url=/wallofshame/${country}.html"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>People who did not commit timesheet on time.</title>


    <script type="text/javascript" src="/wallofshame/javascripts/jquery-1.5.2.min.js"></script>
</head>


<body>
<h1 class="title">Leave Information In The Latest Month</h1>
<ul>

    <#list employees as employee>
    <a href = "history/${employee.id?c}">
       <li> ${employee.id?c} | ${employee.name}  | ${employee.office}
       | ${employee.dateOfJob.getYear()?c} / ${employee.dateOfJob.getMonthOfYear()?c} / ${employee.dateOfJob.getDayOfMonth()?c} /
        | ${employee.getRemainingAnnualLeave()} <br/>
       </li>
    </a>
    </#list>
</ul>
</body>
</html>

