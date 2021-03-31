<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

p {
  width: 100%;
  font-size: 20px;

}

a {
  display: inline-block;
  padding: 0.6em 1em;
  margin-right: 1em;
  margin-bottom: -1em;
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
  padding: 12px 13px;
  text-align: center;
  font-weight: bold;
  text-decoration: none;
  display: inline-block;
  font-size: 18px;
  margin: 2px 1px;
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
		<div class="row justify-content-md-center" style ="font-size: 200px; text-align: center;">
				4<i class="far fa-question-circle fa-spin"></i>4
			</div>
			
			 <div class="row justify-content-md-center" style="text-align: center;">
			
			 <h3><strong>Forse</strong> questa pagina ha un URL che Eclipse non ha voluto trovare</h3>
			 <h3><strong>Forse</strong> si è presa il covid ed è in quarantena</h3>
			 <br>
			 <h2>Sah, ti consiglio di ricominciare dalla &nbsp; <a href="home.jsp">HOME</a> per sicurezza.</h2>
			 </div>
			 <br>
			 	  <hr>
			  <div class="row justify-content-md-center" style="text-align: center;">
		
			  <h3>Altrimenti tenta un viaggio nel tempo e torna <button class="button" onclick="window.history.back()">indietro</button> </h3>
			  </div>
			 
			 
</div>
	
</body>
</html>