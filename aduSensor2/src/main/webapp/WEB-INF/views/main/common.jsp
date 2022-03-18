<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="ko">


<%-- ================================================================================
* 화면 head
================================================================================ --%>
    <meta charset="utf-8">
    <title>HO!</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="<c:url value='/images/favicon.ico' />" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" type="text/css"  rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" type="text/css"  rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="/lib/owlcarousel/assets/owl.carousel.min.css" type="text/css"  rel="stylesheet">
    <link href="/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" type="text/css"  rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/bootstrap.min.css" type="text/css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="/css/style.css" type="text/css"  rel="stylesheet">
    <link href="/css/personalStyle.css" type="text/css"  rel="stylesheet">
    
    <!-- zTree -->

    
       <!-- JavaScript Libraries -->
   <script src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js' />"></script>
   <script src="<c:url value='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js' />"></script>
   <script src="<c:url value='/lib/chart/chart.min.js' />"></script>
   <script src="<c:url value='/lib/easing/easing.min.js' />"></script>
   <script src="<c:url value='/lib/waypoints/waypoints.min.js' />"></script>
   <script src="<c:url value='/lib/owlcarousel/owl.carousel.min.js' />"></script>
   <script src="<c:url value='/lib/tempusdominus/js/moment.min.js' />"></script>
   <script src="<c:url value='/lib/tempusdominus/js/moment-timezone.min.js' />"></script>
   <script src="<c:url value='/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js' />"></script>

	<script src="<c:url value='/js/jquery.form.js'/>" ></script>
	<script src="<c:url value='/js/jquery-ui.js'/>" ></script>
	<script src="<c:url value='/js/jquery.minicolors.js'/>"></script>
	<script src="<c:url value='/js/jquery-1.12.4.min.js' />"></script>
	<script src="<c:url value='/js/jquery.ztree.core.js'/>"></script>
	
	<link href="/css/zTreeStyle.css" type="text/css" rel="stylesheet">

   <!-- Template Javascript -->
  <%--  <script src="<c:url value='/js/main.js' />"></script> --%>
   <script src="<c:url value='/js/common.js' />"></script>
   
<%-- ================================================================================
* 화면 layout 정의 시작
================================================================================ --%>

<!-- 공통JS -->

<!--[if IE 9]>
    <script type="text/javascript" src="/js/html5shiv.js"></script>
<![endif]-->

</head>