<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>TFT 유닛 목록</title>
    <style>
        .unit { display: flex; align-items: center; margin: 10px; }
        .unit img { width: 50px; height: 50px; margin-right: 10px; }
    </style>
</head>
<body>
    <h1>TFT 유닛 목록</h1>
    <c:forEach var="unit" items="${units}">
        <div class="unit">
            <img src="${unit.image}" alt="이미지">
            <span>${unit.name} (${unit.cost}코스트) - ${unit.traits}</span>
        </div>
    </c:forEach>
</body>
</html>