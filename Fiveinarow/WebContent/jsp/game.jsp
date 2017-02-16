<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.five.beans.Game" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game in progress..</title>
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/css/game.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
</head>
<body>
<p><%=(String)session.getAttribute("user") %></p>
<Script>
this.user = "<%=(String)session.getAttribute("user") %>"
function tableCreate(){
	
    var body = document.body,
        tbl  = document.createElement('table');
    tbl.style.width  = '500px';
    tbl.style.border = '1px solid black';
    tbl.cellSpacing = 12;
    tbl.cellPadding = 12;
    tbl.style.backgroundColor = 'white';
    tbl.style.borderCollapse = 'collapse';
    tbl.setAttribute("id", "tabl");
	
    
    for(var i = 1; i < 20; i++){
        var tr = tbl.insertRow();
        for(var j = 1; j < 20; j++){
                var td = tr.insertCell();
                var id = ""+i+j;
                td.setAttribute("id", id);
                td.style.border = '1px solid black';
        }
    }
    body.appendChild(tbl);
    var cells = tbl.getElementsByTagName("td");
    for(var i=0;i<cells.length;i++){
    	 var elID = cells[i];
    		cells[i].onclick = (function(i){
            return function(){ sendID(i,elID); }
        })(i);
    } 
    document.forms.gameForm.play.style.display = 'none';
}


function sendID(i,elID)
{
	var tbl  = document.getElementById("tabl");
	var cells = tbl.getElementsByTagName("td");
	 
	//alert(i);
	var flag = false;
	var index,res;
	$.ajax({
        url: '<%=application.getContextPath()%>/gamePlay', 
        type: 'POST', 
        dataType: 'text json',
        data: {objarray: i},
        
        success: function(result) {
        	
        	//alert(JSON.stringify(result));
        	var obj = $.parseJSON(JSON.stringify(result));
        	obj = JSON.stringify(obj).replace(/[\[\]']+/g,'');
        	obj = obj.replace(/\{|\}/gi,'');
        	var str = obj+'';
        	var array = str.split(",");
        	for(var i=0;i<array.length; i++){
        		if (array[i].indexOf("Parikshith") !=-1) {
        			var num1 = "",num2 = "",num3 = "";
        			if(!isNaN(parseInt(array[i].charAt(array[i].length-3)))){
        				num3 = array[i].charAt(array[i].length-3);
        			}
					if(!isNaN(parseInt(array[i].charAt(array[i].length-2)))){
						num2 = array[i].charAt(array[i].length-2);
        			}
					if(!isNaN(parseInt(array[i].charAt(array[i].length-1)))){
						num1 = array[i].charAt(array[i].length-1);
					}
        		    index = num3+num2+num1+'';
        		    cells[parseInt(index)].style.backgroundColor = 'black';
        		}
        		if (array[i].indexOf("Kulkarni") !=-1) {
        			var num1 = "",num2 = "",num3 = "";
        			if(!isNaN(parseInt(array[i].charAt(array[i].length-3)))){
        				num3 = array[i].charAt(array[i].length-3);
        			}
					if(!isNaN(parseInt(array[i].charAt(array[i].length-2)))){
						num2 = array[i].charAt(array[i].length-2);
        			}
					if(!isNaN(parseInt(array[i].charAt(array[i].length-1)))){
						num1 = array[i].charAt(array[i].length-1);
					}
        		    index = num3+num2+num1+'';
        		    cells[parseInt(index)].style.backgroundColor = 'blue';
        		} 
        	}
        	flag = true;
        },
        error: function (textStatus) {
        	window.location.href = "jsp/winner.jsp";
        }
   });
}
 function waitFunc() {
    if (!this.flag) {
    	setTimeout(waitFunc, 100);
    }
} 

</script>
<form name="gameForm" action="" method="post">
<input type="hidden" name="requestType" value="gamePlay"></input>
<input type="button" name="play" value="Play" id="play" onClick="tableCreate();"/>
<table id="tbl">


</table>

</form>
</body>
</html>
