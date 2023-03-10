<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<body>
	<!-- Pre-loader start -->
	<jsp:include page="theme-loader.jsp"></jsp:include>
	<!-- Pre-loader end -->
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">
			<jsp:include page="navbar.jsp"></jsp:include>
			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">
					<jsp:include page="navbarmainmenu.jsp"></jsp:include>
					<div class="pcoded-content">
						<!-- Page-header start -->
						<jsp:include page="page-header.jsp"></jsp:include>
						<!-- Page-header end -->
						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">
								<div class="page-wrapper">
									<!-- Page-body start -->
									<div class="page-body">

										<div class="row">
											<div class="col-sm-12">
												<!-- Basic Form Inputs card start -->
												<div class="card">
													<div class="card-header">
														<h5>Cadastro de Usuário</h5>
														</span>
													</div>
													<div class="card-block">

														<form class="form-material" action="<%= request.getContextPath() %>/ServletUsuarioController" method="post">
															<div class="form-group form-default form-static-label">
																<input type="text" name="id" id="id" 
																	class="form-control" placeholder="Id do usuário" 
																	readonly="readonly"> <span class="form-bar"></span> <label
																	class="float-label">Id:</label>
															</div>
															<div class="form-group form-default form-static-label">
																<input type="text" name="nome" id="nome"
																	class="form-control" required="required" autocomplete="off"
																	placeholder="Nome de Usuário"> <span
																	class="form-bar"></span> <label class="float-label">Nome</label>
															</div>
															<div class="form-group form-default form-static-label">
																<input type="email" name="email" id="email"
																	class="form-control" placeholder="Email do Usuário"
																	required="required"> <span class="form-bar"></span> <label
																	class="float-label">Email:</label>
															</div>
															<div class="form-group form-default form-static-label">
																<input type="text" name="login" id="login"
																	class="form-control" placeholder="Senha do Usuário"
																	required="required" autocomplete="off"> <span class="form-bar"></span> <label
																	class="float-label">Login:</label>
															</div>
															<div class="form-group form-default form-static-label">
																<input type="password" name="senha" id="senha"
																	class="form-control" placeholder="Senha do Usuário"
																	required="required" autocomplete="off"> <span class="form-bar"></span> <label
																	class="float-label">Senha:</label>
															</div>
															

															<button class="btn btn-primary waves-effect waves-light">Novo</button>
															<button class="btn btn-success waves-effect waves-light">Salvar</button>
															<button class="btn btn-info waves-effect waves-light">Excluir</button>
															<button class="btn btn-warning waves-effect waves-light">Warning
																Button</button>
															<button class="btn btn-danger waves-effect waves-light">Danger
																Button</button>
															<button class="btn btn-inverse waves-effect waves-light">Inverse
																Button</button>
															<button
																class="btn btn-disabled disabled waves-effect waves-light">Disabled
																Button</button>

														</form>



													</div>
												</div>
											</div>
										</div>




									</div>
									<!-- Page-body end -->
								</div>
								<div id="styleSelector"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="javascriptfile.jsp"></jsp:include>
</body>
</html>
