<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
	Design by Free CSS Templates
	http://www.freecsstemplates.org
	Released for free under a Creative Commons Attribution 2.5 License
-->
<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="DAO.*" %>
<%@ page import ="Bean.*" %>
<%@ page import ="Conexao.*" %>
<%@ page import ="Controlador.*" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
<title>Classificados WEB</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div id="outer">
	
  <div id="header"> 
    <h1><a href="#">Classificados WEB</a></h1>
    <h2>Gest�o de Classificados pela Internet</h2>
  </div>
   <div id="menu"> 
    <ul>
      <li class="first"><a href="index.html" accesskey="1" title="">In�cio</a></li>
	  <li class="first"><a href="cad-gerenciar_cliente.jsp" accesskey="2" title="">Clientes</a></li>
	  <li class="first"><a href="cad-gerenciar_tipoanuncio.jsp" accesskey="3" title="">Tipo de An�ncio</a></li>
	  <li class="first"><a href="cad-gerenciar_funcionario.jsp" accesskey="4" title="">Funcion�rios</a></li>
	  <li class="first"><a href="cad-gerenciar_sessao.jsp" accesskey="1" title="">Sess�o</a></li>
      <li></li>
    </ul>
  </div>

<div id="content">
		<div id="primaryContentContainer">
			<div id="primaryContent">
				
        <h2>Gerenciar </h2>
        <%String mensagem = (String) request.getAttribute("lista");%>
        <%=mensagem%>
        Status da Opera&ccedil;&atilde;o: <strong><font color="#000000"<%=mensagem%>!!!!</font></strong><br />
        <br />

        <p><a href="javascript:history.back()">[ VOLTAR ]</a></p>
        </div>
		</div>
			<div id="secondaryContent">
			
      <h3><a href="index.html" accesskey="1" title="">In�cio</a></h3>
	  <h3><a href="cad-gerenciar_cliente.jsp" accesskey="2" title="">Clientes</a></h3>
	  <h3><a href="cad-gerenciar_tipoanuncio.jsp" accesskey="3" title="">Tipo de An�ncio</a></h3>
	  <h3><a href="cad-gerenciar_funcionario.jsp" accesskey="4" title="">Funcion�rios</a></h3>
	  <h3><a href="cad-gerenciar_sessao.jsp" accesskey="1" title="">Sess�o</a></h3>
    </div>
  </div>
	<div id="footer">
		
    <p>&nbsp;</p>
	</div>
</div>
</body>
</html>
