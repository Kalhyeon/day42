<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
  <div id="page">
    <h1>글 작성</h1>
    <form action="/day42/board/write" method="post">
      <div class="mb-3 mt-3">
        <label for="title" class="form-label">제목:</label>
        <input type="text" class="form-control" placeholder="제목 입력" name="title">
      </div>
      <div class="mb-3 mt-3">
        <label for="nickname" class="form-label">작성자:</label>
        <input type="text" class="form-control" id="nickname" placeholder="글쓴이 닉네임" name="nickname">
      </div>
      <div class="mb-3 mt-3">
        <label for="password" class="form-label">비밀번호:</label>
        <input type="password" class="form-control" id="password" placeholder="비밀번호" name="password">
      </div>
      <div class="mb-3 mt-3">
        <textarea class="form-control" rows="5" id="content" name="content" placeholder="글을 입력하세요"></textarea>
      </div>
      <button class="btn btn-outline-danger">작성하기</button>
      <a type="button" class="btn btn-outline-primary" href="/day42/board/list">HOME</a>
    </form>
  </div>
</body>
</html>