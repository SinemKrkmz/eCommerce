<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>DataTables | Gentelella</title>

    <!-- Bootstrap -->
    <link href="../../resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../resources/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../resources/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="../../resources/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../../resources/build/css/custom.min.css" rel="stylesheet">
    
    
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col menu_fixed">
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
                <span>Welcome,</span>
                <h2>John Doe</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Müşteri İşlemleri <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="register">Yeni Müşteri Ekle</a></li>
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
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
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
                <h3>Users <small>Some examples to get you started</small></h3>
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
                    <h2>Müşteri Listesi <small>tüm liste</small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      The Buttons extension for DataTables provides a common set of options, 
                      API methods and styling to display buttons on a page that will interact with a DataTable. 
                      The core library provides the based framework upon which plug-ins can built.
                    </p>

                    <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap table-hover" cellspacing="0" width="100%">
                      <thead>
                        <tr>
                          <th>
                          	<th>#Edit</th>
                          </th>
                          <th>İsim Soyisim</th>
                          <th>Kullanıcı Adı</th>
                          <th>E-posta Adresi</th>
                          <th>Cinsiyet</th>
                          <th>Şirketi</th>
                          <th>Doğum Günü</th>
						  <th>Web Site</th>
                          <th>Alışveriş Limiti</th>
                          <th>Ödeme Süresi</th>
                          <th>Notu</th>
                          <th>IP Adresi</th>
                          <th>E-Bülten</th>
                          <th>E-Bülten</th>
                          <th>Aktif Hesap</th>
                          <th>Ziyaretçi</th>
                          <th>Silinmiş</th>
                          <th>Kayıt Tarihi</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach var="customer" items="${customers }">
                       	<tr>
                       	  <td>
	                          <th>
	                            <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i> View </a>
	                            <a href="#" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit </a>
	                            <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Delete </a>
	                          </th>
                          </td>                       	
                          <td><c:out value="${customer.getFirstName()}"></c:out> <c:out value="${customer.getLastName()}"></c:out></td>
                          <td><c:out value="${customer.getUsername()}"></c:out></td>
                          <td><c:out value="${customer.getEmail()}"></c:out></td>
                          <td><c:out value="${customer.getGender().getName()}"></c:out></td>
                          <td><c:out value="${customer.getCompany()}"></c:out></td>
                          <td><c:out value="${customer.getBirthday()}"></c:out></td>
                          <td><c:out value="${customer.getWebsite()}"></c:out></td>
                          <td><c:out value="${customer.getOutstandingAllowAmount()}"></c:out></td>
                          <td><c:out value="${customer.getMaxPaymentDays()}"></c:out></td>
                          <td><c:out value="${customer.getNote()}"></c:out></td>
                          <td><c:out value="${customer.getIpRegistrationNewsletter()}"></c:out></td>
                          <td><c:out value="${customer.getNewsletter()}"></c:out></td>
                          <td><c:out value="${customer.getShowPublicPrices()}"></c:out></td>
                          <td><c:out value="${customer.getActive()}"></c:out></td>
                          <td><c:out value="${customer.getIsGuest()}"></c:out></td>
                          <td><c:out value="${customer.getDeleted()}"></c:out></td>
                          <td><c:out value="${customer.getDateAdded()}"></c:out></td>
                        </tr>
                      </c:forEach>
                      </tbody>
                    </table>
                  </div>
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

    <!-- jQuery -->
    <script src="../../resources/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../../resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../../resources/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../../resources/vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="../../resources/vendors/iCheck/icheck.min.js"></script>
	<!-- Datatables -->
    <script src="../../resources/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="../../resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="../../resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="../../resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="../../resources/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="../../resources/vendors/jszip/dist/jszip.min.js"></script>


    <!-- Custom Theme Scripts -->
    <script src="../../resources/build/js/custom.min.js"></script>   

  </body>
</html>