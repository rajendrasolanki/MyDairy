<%-- 
    Document   : index
    Created on : Dec 10, 2016, 1:12:13 PM
    Author     : Rajendra_Solanki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Dairy</title>
        <link rel="stylesheet" href="css/main.css" type="text/css"/>
        <script src="js/angular.min.js"></script>
        <script src="js/angular-route.js"></script>
    </head>
    <body>
        <div ng-app="MyApp" class="mainBox">
            <a href="#"> Home </a>
            <div ng-view>
                
            </div>
            
        </div>
    </body>
    <script src="js/main.js"></script>
</html>
