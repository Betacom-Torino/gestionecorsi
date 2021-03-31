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
  font-weight: 500;
 
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
			 <h2>Sah, fai che ricominciare da &nbsp; <a href="home.jsp">QUI</a> spero tu sia più fortunato!</h2>
			 </div>
			 
</div>
	
</body>
</html>