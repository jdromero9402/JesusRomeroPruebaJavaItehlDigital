<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <meta charset=utf-8>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Titulo de la pagina</title>
    <!-- Load Roboto font -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <!-- Load css styles -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/pluton.css" />
    <!--[if IE 7]>
    <link rel="stylesheet" type="text/css" href="css/pluton-ie7.css" />
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="css/jquery.cslider.css" />
    <link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css" />
    <link rel="stylesheet" type="text/css" href="css/animate.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
  </head>
  <body>
  <div class="section secondary-section " id="portfolio">
        <div class="triangle"></div>
        <div class="container">
            <div class=" title">
                <h1>Listado cursos</h1>
            </div>
        </div>
        <div class="section primary-section" id="service">
        <div class="container">
            <div class="row-fluid">
            	<div class="span4">
                    <div class="centered service">
                    	<a href="/consultar_cursos/1">
                    	<button class="btn"> Cursos Privados </button>
                    	</a>
                    </div>
                </div>
                <div class="span4">
                    <div class="centered service">
	                    <a href="/consultar_cursos/2">
                    	<button class="btn"> Cursos Online </button>
                    	</a>
                    </div>
                </div>
                <div class="span4">
                    <div class="centered service">
                    	<a href="/consultar_cursos/3">
                    	<button class="btn"> Cursos OnDemand </button>
                    	</a>
                    </div>
                </div>
            </div>
        </div>
        </div>
  </body>
  
 </html>