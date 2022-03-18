<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
시스템명 : XR 통합앱
파 일 명 : default_template.jsp
작 성 자 : syan
작성일자 : 2020.07.27
처리내용 : 업무 공통 Template
History : 2020.07.27. 최초 작성 (syan)
--%>

<jsp:include page="/WEB-INF/views/main/common.jsp"/>

<body>


<div class="container-xxl position-relative bg-white d-flex p-0">

        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        
<tiles:insertAttribute name="left" />
	<div class="content">
			<tiles:insertAttribute name="header" />
		<div class="container-fluid pt-4 px-4">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
</div>
       	
<!-- wrap -->

<!-- //wrap -->

</body>
</html>
<%-- ================================================================================
* 화면 layout 정의 끝
================================================================================ --%>