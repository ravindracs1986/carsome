<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 
 <html lang="en">

  <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>CarSome</title>
      <link rel="icon" href="assets/img/logo.png">
      <!-- Google Fonts -->
      <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
      <link href='https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
      <link href='https://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
       <!-- <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">    -->
		<link rel="stylesheet" href="assets/css/jquery.dataTables.min.css">
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>
          <tiles:getAsString name="title" />
      </title>
     
          <!-- Bootstrap -->
          <link rel="stylesheet" href="assets/css/bootstrap.min.css">

          <!-- Font Awesome -->
          <link rel="stylesheet" href="assets/css/font-awesome.min.css">

          <!-- Custom CSS -->
          <link rel="stylesheet" href="assets/css/owl.carousel.css">
          <link rel="stylesheet" href="assets/css/style.css">
          <link rel="stylesheet" href="assets/css/responsive.css">
          <script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
           <!-- <script type="text/javascript" src="assets/js/paging.js"></script> -->
  </head>

  <body>
       <header id="header">
           <tiles:insertAttribute name="header" />
       </header>

     		

           <section id="site-content">
               <tiles:insertAttribute name="body" />
           </section>
           
           

           <footer id="footer">
               <tiles:insertAttribute name="footer" />
           </footer>

           <!-- Latest jQuery form server -->
           <script src="https://code.jquery.com/jquery.min.js"></script>

           <!-- Bootstrap JS form CDN -->
           <!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
			<script src="assets/js/bootstrap.min.js"></script>
           <!-- jQuery sticky menu -->
           <script src="assets/js/owl.carousel.min.js"></script>
           <script src="assets/js/jquery.sticky.js"></script>

           <!-- jQuery easing -->
           <script src="assets/js/jquery.easing.1.3.min.js"></script>

           <!-- Main Script -->
           <script src="assets/js/main.js"></script>

           <!-- Slider -->
           <script type="text/javascript" src="assets/js/bxslider.min.js"></script>
           <script type="text/javascript" src="assets/js/script.slider.js"></script>
           
           <script type="text/javascript" src="assets/js/jquery.dataTables.min.js"></script>
	<!-- <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> -->
   </body>

</html>