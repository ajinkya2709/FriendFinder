<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="friendFinder">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Spring and Angularjs Tutorial</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./resources/static/css/app.css">
</head>
<body>
<h2>Spring and Angularjs Tutorial</h2>

    <div ui-view></div>
<%--</div>--%>
<div class="home-section">
    <ul class="menu-list">
        <li><a href="#/gallery">Photo Gallery</a></li>
        <li><a href="#/contactus">Contact</a></li>
    </ul>
</div>

<script src="./webjars/angularjs/1.4.8/angular.js"></script>
<script src="./webjars/angularjs/1.4.8/angular-resource.js"></script>
<script src="./webjars/angularjs/1.4.8/angular-route.js"></script>
<script src="./webjars/ngStorage/0.3.0/ngStorage.min.js"></script>
<script src="./webjars/angular-resource/1.6.1/angular-resource.min.js"></script>
<script src="./webjars/angular-ui-router/0.2.18/angular-ui-router.min.js"></script>
<script src="./webjars/angular-facebook/0.2.3/lib/angular-facebook.js"></script>
<script src="./resources/static/js/app.js"></script>
<script src="./resources/static/js/Angular-app/routes/routes.js"></script>
<%--<script src="./resources/static/js/Angular-app/services/auth_interceptor.js"></script>--%>
<script src="resources/static/js/Angular-app/controllers/controller.js"></script>
<link rel="stylesheet" href="./webjars/bootstrap/3.3.6/css/bootstrap.css">
</body>
</html>
