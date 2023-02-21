<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
        </head>

        <body>
            <form action="/join" method="post">
                <div>
                    <input type="text" name="username" placeholder="Enter username" required id="username">
                </div>

                <div class="form-group mb-2">
                    <input type="password" name="password" placeholder="Enter password" required id="password">
                </div>

                <div class="form-group mb-2">
                    <input type="password" placeholder="Enter passwordCheck" required id="passwordCheck">
                </div>
                <div id="passwordCheckAlert"></div>

                <div>
                    <input type="email" name="email" placeholder="Enter email" id="email" required>
                </div>

                <button type="submit">회원가입</button>
            </form>
        </body>

        </html>