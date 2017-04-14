<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.Writer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//TR" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="tr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	  
    <title>HeCommerce! | </title>

    <!-- Bootstrap -->
    <link href="../../resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../resources/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../resources/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="../../resources/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
    <!-- Select2 -->
    <link href="../../resources/vendors/select2/dist/css/select2.min.css" rel="stylesheet">
    <!-- Switchery -->
    <link href="../../resources/vendors/switchery/dist/switchery.min.css" rel="stylesheet">
    <!-- starrr -->
    <link href="../../resources/vendors/starrr/dist/starrr.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
	<link rel=".../stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css" />
	<link rel=".../stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />

    <!-- Custom Theme Style -->
    <link href="../../resources/build/css/custom.min.css" rel="stylesheet">
    
    
    <!-- Include Required Prerequisites -->
	<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
	<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<!-- Include Date Range Picker -->
	<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
    
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>  -->
    
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Gentelella Alela!</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Hoşgeldiniz,</span>
                <h2>Administrator</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Kullanıcı İşlemleri <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="register">Yeni Müşteri Hesabı</a></li>
                      <li><a href="list">Müşteri Listesi</a></li>
                    </ul>
                  </li>

                </ul>
              </div>
            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="images/img.jpg" alt="">John Doe
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;"> Profile</a></li>
                    <li>
                      <a href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Settings</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">Help</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Çıkış yap</a></li>
                  </ul>
                </li>

                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">6</span>
                  </a>
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Form Elements</h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>
            <div class="clearfix"></div>
            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
               <div class="x_panel">
                  <div class="x_title">
                    <h2>Yeni Müşteri Hesabı Oluştur <small>müşteri detayları</small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
					
				<!-- start form for validation -->
				
					<form id="demo-form" data-parsley-validate action="register" method="POST" accept-charset="utf-8">
					<div class="col-md-4 col-xs-12">
										
						<p>
						<label for="username">Kullanıcı Adı * :</label>
						<input type="text" id="username" class="form-control" name="username" required="required"/>
						</p>
						
						<p>
						<label for="email">E-posta Adresi * :</label>
						<input type="email" id="email" class="form-control" name="email" data-parsley-trigger="change" required="required"/>
						</p>
						
						<p>
						<label for="password">Şifre * :</label>
						<input type="text" id="password" class="form-control" name="password" data-parsley-trigger="change" required="required"/>
						</p>						
						
						<p>
						<label for="firstname">İsim * :</label>
						<input type="text" id="firstname" class="form-control" name="firstname" required="required"/>
						</p>
						
						<p>
						<label for="lastname">Soyisim * :</label>
						<input type="text" id="lastname" class="form-control" name="lastname" required="required"/>
						</p>
						<p>
						<label for="company">Şirket ismi :</label>
						<input type="text" id="company" class="form-control" name="company" />
						</p>					
						<p>
						<label>Cinsiyet *:</label>
						<br/>
						<input type="radio" class="flat" name="gender" id="gender1" value="1" checked="" /> <label for="gender1"> Bay</label>
						</p>
						<p>
						<input type="radio" class="flat" name="gender" id="gender2" value="2" /> <label for="gender2"> Bayan</label>
						</p>						
					
				

					</div>

					<div class="col-md-4 col-xs-12">
					
						
						<label>Doğum Tarihi:</label> <br />
						<fieldset>
						<div class="control-group">
						<div class="controls">
						<div class="col-md-12 xdisplay_inputx form-group has-feedback">
						<input type="text" class="form-control has-feedback-left" name="birthday" id="birthday" 
						placeholder="Doğum Tarihi" aria-describedby="inputSuccess2Status3" required="required" />
						<span class="fa fa-calendar-o form-control-feedback left" aria-hidden="true"></span>
						<span id="inputSuccess2Status3" class="sr-only">(success)</span>
						</div>
						</div>
						</div>
						</fieldset>
						<script type="text/javascript">
						$('input[name="birthday"]').daterangepicker(
								{        
									singleDatePicker: true,
									showDropdowns: true,
								    locale: {
								      format: 'DD-MM-YYYY'
								    }
								});
						</script>						
						
						<p>
						<label for="website">Web site :</label>
						<input type="text" id="website" class="form-control" name="website" />
						</p>
						
						<p>
						<label for="outstandingallowamount">Aylık Harcama Limiti * :</label>
						<input type="number" id="outstandingallowamount" class="form-control" name="outstandingallowamount" data-parsley-trigger="change" required="required" />
						</p>
						<p>
						<label for="maxpaymentdays">Ödeme Süresi * :</label>
						<input type="number" id="maxpaymentdays" class="form-control" name="maxpaymentdays" data-parsley-trigger="change" required="required"/>						
						</p>
						
						<p>			
						<label for="showpublicprices">Fiyatları Göster:</label>
						<input type="checkbox" name="showpublicprices" id="showpublicprices" value="1" class="js-switch" checked/>
						</p>
						
						<p>
						<label for="active">Hesap Aktif Mi:</label> 
						<input type="checkbox" name="active" id="active" value="1" class="js-switch" checked/>
						</p>
						
						<p>
						<label for="isguest">Ziyaretçi Mi:</label>
						<input type="checkbox" name="isguest" id="isguest" value="1" class="js-switch" /> 
						</p>

						<p>
						<label for="deleted">Silinmiş Hesap Mı:</label>
						<input type="checkbox" name="deleted" id="deleted" value="1" class="js-switch" /> 
						</p>
						
						<p>
						<label for="newsletter">E-Bültene Abone Mi:</label>
						<input type="checkbox" name="newsletter" id="newsletter" value="1" class="js-switch" /> 
						</p>						

						<label for="note">Müşteri Notu:</label>
						<textarea id="note" class="form-control" name="note"></textarea>
												
					</div>
					<div class="col-md-4 col-xs-12">
						
						<p>						
						<label for="city">İl * :</label>
						<select id="city" class="dropdown-toggle" name="city">
							<option value="">İl Seçiniz</option>
						<c:forEach var="i" items="${cities }">
					    	<option value="<c:out value="${i.getId_city()}"/>"><c:out value="${i.getName()}"/> &nbsp;&nbsp;&nbsp;</option>
						</c:forEach>
						</select>
						</p>
						
						<p>
						<label for="district">İlçe * :</label>
							<select id="district" name="district">
								<option>İlçe Seçiniz</option>
							</select>				
						</p>
						
						<script>
						$(document).ready(function() {
						$('#city').change(function(event) {
							var city = $("select#city").val();
							$.get('districtlist', {
								cityValue : city
							}, function(jsonResponse) {
						
							var select = $('#district');
							select.find('option').remove();
						 	  $.each(jsonResponse, function(index, value) {
							  $('<option>').val(value.id_district).text(value.name).appendTo(select);
						      });
							});
							});
						});	
						</script>	
						<p>
						<label for="postcode">Posta Kodu:</label> 
						<input type="text" name="postcode" id="postcode" class="form-control" />
						</p>

						<p>			
						<label for="address1">Adres 1:</label>
						<input type="text" name="address1" id="address1" class="form-control" />
						</p>
						
						<p>
						<label for="address2">Adres 2:</label> 
						<input type="text" name="address2" id="address2" class="form-control" />
						</p>
				


					<br/>
					<button type="submit" class="btn btn-success">Müşteri Hesabı Oluştur</button>
					<button type="reset" class="btn btn-primary">Formu Temizle</button>
					<p style="font-size: 16px; color: red;">
						<% 
							String errors = "";
							if(request.getAttribute("errors") != null){
								errors = (String) request.getAttribute("errors");
								out.print(errors);
							}
						
						%>
					</p>
					</div>					
					
					
					
				</form>
				
				<!-- end form for validations -->                    

               </div>
             </div>              
           </div>


           
          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            HeCommerce
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>
    </div>

    <!-- jQuery -->
    <script src="../../resources/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../../resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../../resources/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../../resources/vendors/nprogress/nprogress.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="../../resources/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="../../resources/vendors/iCheck/icheck.min.js"></script>

    <!-- bootstrap-wysiwyg -->
    <script src="../../resources/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
    <script src="../../resources/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
    <script src="../../resources/vendors/google-code-prettify/src/prettify.js"></script>
    <!-- jQuery Tags Input -->
    <script src="../../resources/vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
    <!-- Switchery -->
    <script src="../../resources/vendors/switchery/dist/switchery.min.js"></script>
    <!-- Select2 -->
    <script src="../../resources/vendors/select2/dist/js/select2.full.min.js"></script>
    <!-- Parsley -->
    <script src="../../resources/vendors/parsleyjs/dist/parsley.min.js"></script>
    <!-- Autosize -->
    <script src="../../resources/vendors/autosize/dist/autosize.min.js"></script>
    <!-- jQuery autocomplete -->
    <script src="../../resources/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
    <!-- starrr -->
    <script src="../../resources/vendors/starrr/dist/starrr.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="../../resources/build/js/custom.min.js"></script>
	
  </body>
</html>