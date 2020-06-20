<%@ page import="java.sql.*"%>
<%@ page isELIgnored="false"%>
<html>
<head>


<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%-- <title>Document Singing</title>
	<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link> --%>
</head>

</head>
<body>
<div class="maincontent-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12" align="center">
					<div class="product-content-right">
						<div class="woocommerce" align="center">
							<!-- <div class="woocommerce-info">Returning customer? <a class="showlogin" data-toggle="collapse" href="#login-form-wrap" aria-expanded="false" aria-controls="login-form-wrap">Click here to login</a>
                            </div> -->

							<form id="login-form-wrap"
								action="${pageContext.request.contextPath}/admin"
								method="post">


								<p>If you have shopped with us before, please enter your
									details in the boxes below. If you are a new customer please
									proceed to the Billing &amp; Shipping section.</p>

								<p class="form-row form-row-first">
									<label for="username">Username or email <span
										class="required">*</span>
									</label> <input type="text" id="username" name="username"
										class="input-text">
								</p>
								<p class="form-row form-row-last">
									<label for="password">Password <span class="required">*</span>
									</label> <input type="password" id="password" name="password"
										class="input-text">
								</p>
								<div class="clear"></div>


								<p class="form-row">
									<input type="submit" value="Login" name="login" class="button">
									<label class="inline" for="rememberme"><input
										type="checkbox" value="forever" id="rememberme"
										name="rememberme"> Remember me </label>
								</p>
								<p class="lost_password">
									<a href="#">Lost your password?</a>
								</p>

								<div class="clear"></div>
							</form>



						</div>
					</div>
				</div>



			</div>
		</div>
	</div>
	</body>
</html>