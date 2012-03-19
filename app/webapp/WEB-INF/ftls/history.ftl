<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>People who did not commit timesheet on time.</title>


    <script type="text/javascript" src="/wallofshame/javascripts/jquery-1.5.2.min.js"></script>
</head>


<body>
<h1 class="title">Leave Information In The Latest Month</h1>
<ul>
    ID:     ${employee.id?c}  <br/>
    Name:   ${employee.name}  <br/>
    Tenner: ${employee.getTenner()}  <br/>
    Annual leave(year):          ${employee.getRightActuralRateByYear()}  <br/>
    Annual leave(at Present):    ${employee.getAnnualLeaveAtPresent()}  <br/>
    Annual leave(remainning):    ${employee.getRemainingAnnualLeave()}  <br/>

    LeaveList:   <br/>
    <#list leaves as leave>
        ${leave.leaveDate} | ${leave.subProj}  | ${leave.task} | ${leave.hours} <br/>

    </#list>
</ul>
</body>
</html>

