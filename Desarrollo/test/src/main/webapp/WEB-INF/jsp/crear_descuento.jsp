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
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.11/jquery-ui.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.js"></script
  </head>
  <body>
  	<div class="section secondary-section " id="portfolio">
        <div class="triangle"></div>
        <div class="container">
            <div class=" title">
                <h1>Cree un nuevo curso</h1>
            </div>
        </div>
    </div>
    
    <div class="section primary-section" id="service">
        <div class="container">
        	<div class="title">
                <h1>Por favor, diligencie la siguiente información</h1>
            </div>
            <div class="row-fluid">
            	<div class="centered service">
            		<form id="crear_curso" method="POST" action="/api/cursos/curso">
            			<label for="nombre">Nombre Descuento</label> 
            			<input class="form-control" type="text" id="nombre" name="nombre" />
            			<label for="modalidad">Modalidad</label> 
            			<input class="form-control" type="text" id="modalidad" name="modalidad" readonly value="<c:out value='${curso.modalidad}'/>"/>
            			<label for="pais">País</label> 
            			<input class="form-control" type="text" id="pais" name="pais" />
            			<label for="descuento_label">Descuento</label> 
            			<input class="form-control" type="text" id="descuento_label" name="descuento_label" readonly value="<c:out value='${descuento_label}'/>"/>
            			<input class="form-control" type="hidden" id="descuento" name="descuento" readonly value="<c:out value='${descuento}'/>"/>
            			<label for="curso">Curso</label> 
            			<input class="form-control" type="hidden" id="id_curso" name="id_curso" readonly value="<c:out value='${curso.id}'/>"/>
            			<input class="form-control" type="text" id="curso" name="curso" readonly value="<c:out value='${curso.nombre}'/>"/>
            			<br>
            			<button class="form-control btn" type="button" id="guardar_descuento" > Guardar </button>
            		</form>
            	</div>
            </div>
        </div>
    </div>	
  </body>
</html>

<script>
	$(document).ready(function(){
		$( "#fecha_final" ).datepicker();
	});

	$("#guardar_descuento").click(function(event){
		event.preventDefault();
		var nombre = $("#nombre").val();
		var pais = $("#pais").val();
		var descuento = $("#descuento").val();
		var id_curso = $("#id_curso").val();
		var modalidad = $("#modalidad").val();
		var data = { nombre: nombre, pais: pais, descuento: descuento, id_curso: id_curso, modalidad:modalidad};
		$.ajax({
		     type: 'POST',  
			 contentType: 'application/json; charset=utf-8',
		     dataType: 'json',
		     url: '/api/descuentos/descuento',  
		     data: JSON.stringify(data),
		     success: function(res){
		     		$(location).attr('href','/');
		     },
		     error: function(){
		     	alert("verifique sus datos");
		     }
   		});
	});
	
	
	
</script>
