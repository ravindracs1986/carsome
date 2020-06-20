<%@ page isELIgnored="false"%>
<%@page
	import="javax.servlet.*,javax.servlet.http.*,java.sql.*,java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

</head>
<body>
	<!-- End main content area start-->
	
	<h1 style="text-align: center;margin-top: 5px;text-decoration: underline">
		<b>Carsome inspection slot Details</b>
	</h1>

	<div class="maincontent-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="product-content-right">
						<!-- save blogs start -->
						<div class="woocommerce">
							<div class="woocommerce-info"><b>Want to book inspection slot?</b></div>
							<p style="-webkit-text-decoration-color: red; text-decoration-color: red;text-decoration: underline red;">Note:inspection slot can book for next 3 weeks counting from next day</p>
							<form class="checkout_coupon" >

								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="category">Category:</label> <select id="category" class="form-control" name="category">
											<option selected>Please Select</option>
											<option value="WEK">WEEKDAYS</option>
											<option value="SAT">SATURDAY</option>

										</select>
									</div>
									<div class="form-group col-md-6">
										<label for="dates">Dates:</label> <select id="dates" class="form-control" name="dates">
											<option selected>Please-Select</option>
											<!-- <option value="WEK">WEEKDAYS</option>
											<option value="SAT">SATURDAY</option> -->

										</select>
									</div>
								</div>
								<input type="submit" value="Show Slots"
									class="button btn btn-primary" style="margin: 10px 10px 10px 995px;" id="showSlotId"/><br>

							</form>
						</div>
					<!-- showing slots starts -->
					<div id="timeslotDiv" style="display:none">
					<form class="checkout_coupon" name="bookForm" id="bookFormId" onsubmit="return validateForm()" method="post" action="${pageContext.request.contextPath}/saveslots">
						<div class="woocommerce-info">Choose slots by clicking the corresponding slot in the layout below:</div>
		                    <div class="woocommerce" >
		                    	<!-- 	<h1>show slots</h1> -->
		                    	
		                    	<div class="form-group col-md-6">
										<label for="times">Times:</label> <select id="times" class="form-control" name="times">
											<option selected>Please-Select</option>
											<!-- <option value="T1">WEEKDAYS</option>
											<option value="T2">SATURDAY</option> --> 

										</select>
								</div>
								
								<div class="form-row">
		                    		<div class="form-group col-md-6">
				                         <label for="userName">User Name:</label>
				                         <input type="text" class="form-control" name="userName" id="userNameId" placeholder="User Name">
				                     </div>
				                      <div class="form-group col-md-6">
				                         <label for="userEmail">User Email:</label>
				                         <input type="text" class="form-control" name="userEmail" id="userEmailId" placeholder="User Email">
				                     </div>
                			    </div>
		                    	
		                    	<div class="form-row">
		                    		<div class="form-group col-md-6">
				                         <label for="userEmail">User Phone:</label>
				                         <input type="text" class="form-control" name="userPhone" id="userPhoneId" placeholder="User Phone">
				                     </div>
                			    </div>	
		                    	
		                    
		                <!-- showing slots end -->  
		               <!-- <button type="button" class="button btn btn-primary" style="margin: 10px 10px 10px 966px;" value="BookSlot" id="bookSlotId">BookSlot</button>  -->
		                 <input type="submit" value="BookSlot"
									class="button btn btn-primary" style="margin: 10px 10px 10px 1011px;" id="bookSlotId1"/><br> 
		                 
					</div><!-- second div -->
					<input type="hidden" id="slotCategory" name="slotCategory" value="">
					<input type="hidden" id="slotDate" name="slotDate" value="">
					<input type="hidden" id="slotTime" name="slotTime" value="">
					</form>
					 <div id="msgLogin">
		                <% //out.println(MsgLogin); %>
		            </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</div>
<script>

$(document).ready(function(){
	

function getContextPath() {
	   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	}
 $('#category').on('change', function(){
	        var selectedCategory = $("#category option:selected").val();
	        var data = {}
	        data["category"] = selectedCategory;
	        var tempUrl=getContextPath()+"/findslotDates?category="+selectedCategory
	        $.ajax({
	             type: "POST",
	             contentType: "application/json",
	             url: tempUrl,
	             data: JSON.stringify(data),
	             dataType: 'json',
	             timeout: 600000,
	             success: function (data) {
	            	 console.log("data: ", data);
	            	 //$("#dates").html(data);
	            	  var len = data.length;
	                    $("#dates option[value!='']").remove(); // keep first 
	                    for (var i = 0; i < len; i++) {
	                        var id = data[i]+"_"+i;
	                        var dat = data[i];
	                        $("#dates").append("<option value='" + id + "'>" + dat + "</option>");
	                    }
	            	 
	             },
	             error: function (e) {
	            	 console.log("ERROR: ", e);
	                
	             }
		});

	    });
  
}); 

function getContextPath1() {
	   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	}
$("#showSlotId").on("click", function(){
	  
	  var category = $("#category option:selected").val();
	  var dateSlot = $("#dates option:selected").val();
	  var data = {}
      data["category"] = category;
	  data["dateSlot"] = dateSlot;
      var tempUrl=getContextPath1()+"/findslots?category="+category+"&dateSlot="+dateSlot;
      $.ajax({
           type: "POST",
           contentType: "application/json",
           url: tempUrl,
           data: JSON.stringify(data),
           dataType: 'json',
           timeout: 600000,
           success: function (response) {
          	var len = response.length;
                  $("#times option[value!='']").remove(); // keep first 
                  for (var i = 0; i < len; i++) {
                      var id = response[i].starTime+"-"+response[i].endTime+"_"+i;
                      var tm = response[i].starTime+"-"+response[i].endTime;
                      $("#times").append("<option value='" + id + "'>" + tm + "</option>");
                  } 
                  $("#timeslotDiv").show();
           },
           error: function (e) {
          	 console.log("ERROR: ", e);
          	 $("#timeslotDiv").hide();
           }
	});
	  
});
$("form").submit(function(e){
    e.preventDefault();
});

function validateForm() {
	 var A = document.forms["bookForm"]["userName"].value;
	  var B = document.forms["bookForm"]["userEmail"].value;
	  var C = document.forms["bookForm"]["userPhone"].value;
	  if (A == "") {
		    alert("Please Enter UserName");
		    return false;
		  }
	  if (B == "") {
		    alert("Please Enter UserEmail");
		    return false;
		  }
	  if (C == "") {
		    alert("Please Enter UserPhone");
		    return false;
		  }
	return true;  
}

$(document).on("click","#bookSlotId1",function(){
    var result = validateForm();
    var selectedCategory = $("#category option:selected").val();
	var selectedDate = $("#dates option:selected").val();
	var selectedTime = $("#times option:selected").val();
    if(result=="true" || result==true){
    	$('input[name="slotCategory"]').val(selectedCategory);
    	$('input[name="slotDate"]').val(selectedDate);
    	$('input[name="slotTime"]').val(selectedTime);
        $("#bookFormId").submit();
    }
    else{
        $("#MsgLogin").html(result);
    }

});
</script>


</body>
</html>