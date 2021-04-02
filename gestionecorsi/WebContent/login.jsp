<div class="row justify-content-md-center" id="section1"
 style="background-color: #2F4F4F">
 <div class="d-flex justify-content-center h-100" style="margin-top: 3.5%; margin-bottom: 3.5%;">
  <div class="card">
   <div class="card-header">
    <h3>Login</h3>
   </div>
   <div class="card-body">
    <form method="post" action="<%=request.getContextPath()%>/controllo">
     <div class="input-group form-group">
      <div class="input-group-prepend">
       <span class="input-group-text"><i class="fas fa-user"></i></span>
      </div>
      <input type="text" class="form-control" placeholder="Nome..." name="nome">
     </div>
     <div class="input-group form-group">
      <div class="input-group-prepend">
       <span class="input-group-text"><i class="fas fa-user"></i></span>
      </div>
      <input type="text" class="form-control" placeholder="Cognome..." name="cognome">
     </div>
     <div class="input-group form-group">
      <div class="input-group-prepend">
       <span class="input-group-text"><i class="fas fa-key"></i></span>
      </div>
      <input type="password" class="form-control" placeholder="Codice..." name="codice">
     </div>
     <div class="form-group">
      <input type="submit" value="Login"
       class="btn float-right login_btn" style="border-radius: 0">
     </div>
    </form>
   </div>
<div class="card-footer" style="margin-bottom: 23px;">

				<div class="d-flex justify-content-center">
					<a href="#section">Torna alla home</a>
				</div>
			</div>
  </div>
 </div>
</div>