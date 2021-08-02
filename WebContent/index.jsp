<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.higradius.Response" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>H2HBABBA2606-Mainpage</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/hrc" user="root" password="mayanksql"/>
<sql:query var="rs" dataSource="${db}">select * from mytable</sql:query>
<!-- ADD FORM -->
<div class="add-bg">
	<div class="add">
	<form  class="formAdd" action="addInvoice" method="post">
      <div class="header row"> 
        <div class="col-6">
          <p class="pHead" >Add Invoice</p>
        </div> 
        <div class="col-6">
          <span style="float: right;" class="add-close">X</span>
        </div>
      </div>
      <hr>
      <div class="row">  
        <div class=" col-6">
          <label for="CustomerName">Customer Name<span class="astriks">*</span></label>
          <input name="CustomerName" type="text"  />
        </div>
        <div class="col-6">
          <label for="dates">Date<span class="astriks">*</span></label>
          <input type="date" name="dates" style="float: right;margin-right: 25px;margin-top: 1px;"/>
        </div>
      </div>
        
      <div class="row">  
        <div class="contact col-6">
          <div>
            <label for="CustomerNumber" style="padding-right: 15px;">Customer No.<span class="astriks">*</span></label>
            <input type="text" name="CustomerNumber" style="margin-bottom: 30px;"  />
          </div>
      
          <div>
            <label for="InvoiceNumber" style="padding-right: 32px;">Invoice No.<span class="astriks">*</span></label>
            <input type="number" name="InvoiceNumber" style="margin-bottom: 30px;"  />
          </div>
      
          <div>
            <label for="InvoiceAmount" style="padding-right: 7px;">Invoice Amount<span class="astriks">*</span></label>
            <input type="number" name="InvoiceAmount" style="margin-bottom: 30px;"  />
          </div>
        </div>
        <div class="message col-6">
          <label for="Notes">Notes</label>
          <textarea name="Notes" style="float: right;margin-right: 25px;"></textarea>
        </div>
      </div><!-- row --> 
      <hr>
      <div class="row">  
        <div class="col-6" style="float: left;">
          <button type="submit" class="cancelBtn form-button add-close">
            Cancel
          </button>
        </div>
        <div class="col-6" style="float: right;">
          <button type="submit" class="addBtn form-button">
            Save
          </button>
          <button class="clearBtn form-button" style="margin-right: 5px;">
            Reset
          </button>
        </div>
      </div>
      </form>
	</div>
</div>

<!-- EDIT FORM -->

<div class="edit-bg">
	<div class="edit">
	<form class="formEdit" id="myform" name="myform" method="post">
      <div class="header row"> 
        <div class="col-6">
          <p class="pHead" >Edit Invoice</p>
        </div> 
        <div class="col-6">
          <span style="float: right;" class="edit-close">X</span>
        </div>
      </div>
      <hr>
      <div class="row">  
        <div class="inputs contact col-12">
          <label for="newInvoiceAmount">Invoice Amount</label>
          <input type="number" id="newInvoiceAmount" name="newInvoiceAmount" style="margin-left: 12px;" />
        </div>
      </div> 
      <div class="row">  
        <div class="inputs message col-12">
          <label for="newNotes">Notes</label>
          <textarea name="newNotes" id="newNotes" style="float: right;margin-right: 25px;"></textarea>
        </div>
      </div> 
      <hr>
      <div class="row">  
        <div class="col-6 cancelBtn" style="float: left;">
          <button class="cancelBtn form-button edit-close">
            Cancel
          </button>
        </div>
        <div class="col-6" style="float: right;">
          <button type="submit" class="addBtn form-button">
            Save
          </button>
          <button class="clearBtn form-button" style="margin-right: 5px;">
            Reset
          </button>
        </div>
      </div>
      </form>
	</div>
</div>

<!-- DELETE FORM -->
<div class="del-bg">
	<div class="del">
	<div id="apptForm" class="formDel">
      <div class="header row"> 
        <div class="col-6">
          <p class="pHead" >Delete Record(s)</p>
        </div> 
        <div class="col-6">
          <span style="float: right;" class="del-close">X</span>
        </div>
      </div>
      <hr>
      <div class="row">  
        <div class="col-12">
          <p style="color: white;">
            You'll lose your record(s) after this action. We can't recover them once you delete.<br>
            Are you sure you want to <span style="color: red;">permanently delete</span> them?
          </p>
        </div>
      </div>
      <hr>
      <div class="row">  
        <div class="col-6" style="float: right;">
          <button id="del" onclick="deleteInvoice()" class="addBtn form-button">
            Delete
          </button>
     
          <button class="clearBtn form-button del-close" style="margin-right: 5px;">
            Cancel
          </button>
        </div>
      </div>
      </div>
	</div>
</div>
<!-- TABLE -->
<section>
  <div><img style="margin-left: 0%;" src="./images/Group 20399.svg"> <img class="logo" src="./images/logo.svg">
    <br>
    <h1 class="invList">Invoice List</h1>
  </div>
  <br>
  <div style="text-align: right;position: static;margin-top: -10px;padding-right: 30px;" class="bar">
    <button class="add-btn main-button" id="addBTN">+ Add</button>
    <button class="edit-btn main-button" id="editBTN">&#9998; Edit</button>
    <button class="del-btn main-button" id="delBTN">- Delete</button>
    <input type="text" class="search" style="background: #273D49CC 0% 0% no-repeat padding-box;border: 1px solid #97A1A9;" id="myInput" onkeyup="myFunction()" placeholder="  Search By Invoice Number                    &#x1F50E;&#xFE0E;" title="Search by Invoice Number">
  </div>
  <div class="tbl-content">
    <table id="tbl">
      <thead>
        <tr>
          <th><input type="checkbox" disabled class="check"></th>
          <th>Customer Name</th>
          <th>Customer #</th>
          <th>Invoice #</th>
          <th>Invoice Amount</th>
          <th>Due Date</th>
          <th>Predicted Payment Date</th>
          <th>Predicted Aging Bucket</th>
          <th>Notes</th>
        </tr>
      </thead>
      <tbody id="myTable">
        <c:forEach items="${rs.rows}" var="inv">
	        <tr>
	        <td class="td"><input type="checkbox" id="marked" class="check" name="selected" value="${inv.Invoice_Number_Invoice_}"></td>
	            <td class="td">${inv.Customer_Name}</td>
	            <td class="td">${inv.Customer_Number_Customer_}</td>
	            <td class="td">${inv.Invoice_Number_Invoice_}</td>
	            <td class="td">${inv.Invoice_Amount}</td>
	            <td class="td">${inv.Due_Date}</td>
	            <td class="td">${inv.Predicted_Payment_Date }</td>
	            <td class="td">${inv.Predicted_Aging_Bucket}</td>
	            <td class="td">${inv.Notes }</td>
	        </tr>
	    </c:forEach>
      </tbody>
    </table>
  </div><br/>
</section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script  src="./script.js"></script>
<script>
//sending Invoice_Number to backend via AJAX
function deleteInvoice()
{
	var toDel = [];
	$("input:checkbox[name=selected]:checked").each(function() {
    	toDel.push($(this).val());
    });
    toDel = JSON.stringify(toDel);
    $.ajax({
        url:"delInvoice",
        type:"POST",
        dataType:'json',
        data: {toDelete:toDel},
        success: function(html){
            location.reload();
        },
        error: function(html){
            location.reload();
        }
    });
}

//sending Edit form values to backend via AJAX
$("#myform").submit(function(e) {
	var toEdit;
	$('table #marked:checked').each(function(){
		var rowVal = $(this).closest('tr')
		toEdit = rowVal.find('td:eq(3)').text()
	});
	var amt = jQuery('input[name="newInvoiceAmount"]').val();
	var nts = jQuery('textarea[name="newNotes"]').val();
	
	var finalDATA = toEdit+"$"+amt+"$"+nts+"$";
	
	$.ajax({
        url:"editInvoice",
        type:"POST",
        dataType:'json',
        data: {toEdit:finalDATA},
        success: function(html){
            location.reload();
        },
        error: function(html){
            location.reload();
        }
    });
	e.preventDefault();
});
</script>
</body>
</html>