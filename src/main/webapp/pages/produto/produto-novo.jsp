<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>

<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Small Business - Start Bootstrap Template</title>
    
    <spring:url value="/resources/css" var="css" />
    <spring:url value="/resources/js" var="js" />
    
    <c:set value="${pageContext.request.contextPath}" var="contextPath"/>
      
    <link href="${css}/bootstrap.css" rel="stylesheet">
    <link href="${css}/small-business.css" rel="stylesheet">

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <img src="http://placehold.it/150x50&text=Logo" alt="">
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${contextPath}/categoria">Categorias</a>
                    </li>
                    <li>
                        <a href="${contextPath}/produto">Produtos</a>
                    </li>
                    <li>
                        <a href="#">Contato</a>
                    </li>
					<li>
                        <a href="#">Tipos de Contato</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	
	
	
    <!-- Page Content -->
    <div class="container">

        <!-- Call to Action Well -->
        <div class="row">
            <div class="col-lg-12">
                <div class="well">
					
					<h2>Produto</h2>
					
					<form:form modelAttribute="produtoModel" action="${contextPath}/produto" method="post">
					
						<spring:hasBindErrors name="produtoModel">
							<div class="alert alert-danger" role="alert">
								<form:errors path="*" class="has-error" />
							</div>
						</spring:hasBindErrors>
					
						<div class="form-group">
							<label class="control-label" for="nome">Nome:</label>
							<form:input path="nome" type="text" name="nome" id="nome" value="" class="form-control" size="50" />
							<font color="red"> <form:errors path="nome"/></font>
                        </div>
                        
                        <form:select path="categoriaModel.idCategoria">
                        	<form:options items="${categorias}" 
                        		itemValue ="idCategoria" itemLabel="nomeCategoria"/>
                        </form:select>
						
                        <div class="form-group">
							<label class="control-label" for="nome">SKU:</label>
							<form:input path="sku" id="sku" value="" class="form-control" size="50" />
							<font color="red"> <form:errors path="sku"/></font>
						</div>
						
						<div class="form-group">
							<label class="control-label" for="descricao">Descrição:</label>
							<form:textarea path="descricao" id="descricao" class="form-control" name="descricao" rows="4" cols="100"/>
							<font color="red"> <form:errors path="descricao"/></font>
						</div>
						
						<div class="form-group">
							<label class="control-label" for=dataLancamento>Data de Lançamento:</label>
							<form:input path="dataLancamento" class="form-control" name="dataLancamento" rows="4" cols="100"/>
							<font color="red"> <form:errors path="dataLancamento"/></font>
						</div>
						
						<div class="form-group">
							<label class="control-label" for="preco">Preço:</label>
							<form:input path="preco" type="text" id="preco" class="form-control" />
							<font color="red"> <form:errors path="preco"/></font>
						</div>
						
						<div class="form-group">
							<label class="control-label" for="caracteristica">Características:</label>
							<form:textarea path="caracteristicas" id="caracteristica" class="form-control" name="caracteristicas" rows="4" cols="100"/>
							<font color="red"> <form:errors path="caracteristicas"/></font>
						</div>
						<hr>
						
						<a class="btn btn-default btn-lg" href="${contextPath}/produto">Cancelar</a>
						<button type="submit" class="btn btn-primary btn-lg">Gravar</button>
                            
                        <br>
                        <br>
					</form:form>
					
					
                </div>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->

     <!-- Footer -->
     <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
            </div>
        </div>
    </footer>

     <!-- jQuery -->
    <script src="${js}/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/bootstrap.min.js"></script>

</body>

</html>
    