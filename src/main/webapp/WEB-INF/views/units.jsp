<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        .unit { display: flex; align-items: center; margin: 10px; }
        .unit img { width: 50px; height: 50px; margin-right: 10px; }
    </style>
</head>
<body>
<h1>TFT 유닛 목록</h1>

<div>
    <c:forEach var="unit" items="${units}">
        <div class="unit">
            <img src="${unit.image}" alt="${unit.name} 이미지">
            <strong>${unit.name} (${unit.cost}코스트)</strong>
            <br>
            <span>특성: 
                <c:forEach var="trait" items="${unit.traits}">
                    ${trait} 
                </c:forEach>
            </span>
        </div>
    </c:forEach>
</div>

</body>
</html>