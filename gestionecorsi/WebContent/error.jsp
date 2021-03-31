<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>

<script src="https://kit.fontawesome.com/4b9ba14b0f.js"></script>

<style>
body {
  position: absolute;
  width: 800px;
  height: 200px;
  z-index: 15;
  top: 20%;
  left: 25%;
  margin: -50px 0 0 -50px;
  background: #2F4F4F;
  color: #F0FFFF;
  font-family: Roboto;
}

a {
  display: inline-block;
  padding: 0.4em 0.9em;
  margin-right: 0.5em;
  margin-bottom: -0.75em;
  border: 2px solid #b9ddfb;
  color:  #F0FFFF;
  font-weight: 700;
 
  text-decoration: none;
  letter-spacing: 0.2em;
  position: relative;
  overflow: hidden;
  transition: 0.3s;
}

a:hover {
    color: #2F4F4F;
}

a:hover:before {
      top: 0;
    }


a:before {
    content: "";
    background: #F0FFFF;
    height: 100%;
    width: 100%;
    position: absolute;
    top: -100%;
    left: 0;
    transition: 0.3s;
    z-index: -1;
  }
  
 .button {
  border: none;
  color: white;
  padding: 12px 15px;
  text-align: center;
  font-weight: bold;
  
  display: inline-block;
  font-size: 18px;
  
  transition-duration: 0.4s;
  cursor: pointer;
  background-color: #2F4F4F;
  color: #F0FFFF; 
  border: 0px solid  #F0FFFF;
}

.button:hover {
  background-color: #F0FFFF;
  color: #2F4F4F;
}
</style>

</head>
<body>
	<div class="container">
		<div class="row justify-content-md-center" style ="font-size: 150px; text-align: center;">
				<i class="fas fa-exclamation-circle"></i>
			</div>
			<div class="row justify-content-md-center" style="text-align: center;">
			<h1>OPS!</h1>
			</div>
			 <div class="row justify-content-md-center" style="text-align: center;">
			
			 <h2><strong>Qualcosa � andato storto</strong> </h2>
			 <h2>Torna alla &nbsp; <a href="home.jsp">HOME</a> e riprova.</h2>
			 </div>
			 <br>
			 	  <hr>
			  <div class="row justify-content-md-center" style="text-align: center;">
		
			  <h3>Oppure torna <button class="button" onclick="window.history.back()">INDIETRO</button> alla pagina precedente</h3>
			  </div>
			 
			 
</div>
	
</body>
</html>