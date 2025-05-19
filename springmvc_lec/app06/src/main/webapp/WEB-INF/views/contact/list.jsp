<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<title>Contact List</title>
</head>
<body>

  <h1>Contact List</h1>
  
  <div>전체 연락처 : ${count}개</div>
  
  <div>
    <button type="button" onclick="fnWriteForm()" class="btn btn-primary">등록</button>
  </div>
  
  <%-- 리스트의 인덱스가 필요한 경우 varStatus 태그 속성을 만들고, index 값을 꺼냅니다. --%>
  <c:forEach var="contact" items="${contacts}" varStatus="vs">
    <div id="contact${vs.index}" class="contact">
      <a href="${contextPath}/contact/detail.do?contact_id=${contact.contact_id}">${contact.contact_id} : ${contact.last_name}</a>
    </div>
  </c:forEach>
  
  <script>
  
    function fnWriteForm() {
      location.href = '${contextPath}/contact/write.do';
    }
  
    const msg = '${msg}';
    if(msg !== '') {
      alert(msg);
    }
  
  </script>
  
</body>
</html>