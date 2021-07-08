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
                <h1>Consultar Curso</h1>
            </div>
        </div>
    </div>
    
    <div class="section primary-section" id="service">
        <div class="container">
        	<div class="title">
                <h1>Editar Curso</h1>
            </div>
            <div class="row-fluid">
            	<div class="centered service">
            		<form id="crear_curso" method="POST" action="/api/cursos/curso">
            			<label for="nombre">Nombre Curso</label> 
            			<input class="form-control" type="text" id="nombre" name="nombre" value="<c:out value='${curso.nombre}'/>" />
            			<label for="descripcion">Descripción</label> 
            			<input class="form-control" type="text" id="descripcion" name="descripcion" value="<c:out value='${curso.descripcion}'/>" />
            			<label for="dirigido_a">¿A quien va dirigido el curso?</label> 
            			<input class="form-control" type="text" id="dirigido_a" name="dirigido_a" value="<c:out value='${curso.dirigido_a}'/>" />
            			<label for="costo">Precio</label> 
            			<input class="form-control" type="number" id="costo" name="costo" value="<c:out value='${curso.costo}'/>" />
            			<label for="horas">Horas semanales</label> 
            			<input class="form-control" type="number" id="horas" name="horas" value="<c:out value='${curso.horas}'/>" />
            			<label for="modalidad">Modalidad</label> 
            			<select id="modalidad" name="modalidad" class="form-control select">
            				<c:forEach items="${modalidades}" var="modalidad">
            					<option id="${modalidad.id}" value="${modalidad.id}" <c:if test = "${curso.modalidad == modalidad.id }"> selected </c:if> > ${modalidad.nombre} </option>
            				</c:forEach>
            			</select>
            			<input class="form-control" type="hidden" id="id" name="id" value="<c:out value='${curso.id}'/>" />
            			<br>
            			<button class="form-control btn" type="button" id="editar_curso" > Editar Curso </button>
            		</form>
            	</div>
            </div>
        </div>
    </div>	
  </body>
</html>

<script>
	$("#editar_curso").click(function(event){
		event.preventDefault();
		var nombre = $("#nombre").val();
		var descripcion = $("#descripcion").val();
		var dirigido_a = $("#dirigido_a").val();
		var costo = $("#costo").val();
		var horas = $("#horas").val();
		var modalidad = $("#modalidad").val();
		var id = $("#id").val();
		var data = { nombre: nombre, descripcion:descripcion, dirigido_a:dirigido_a, costo:costo, horas:horas, modalidad:modalidad};
		$.ajax({
		     type: 'PUT',  
			 contentType: 'application/json; charset=utf-8',
		     dataType: 'json',
		     url: '/api/cursos/curso/' + id,  
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
