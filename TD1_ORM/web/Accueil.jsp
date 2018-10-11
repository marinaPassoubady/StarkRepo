<%-- 
    Document   : Accueil
    Created on : 10 oct. 2018, 15:49:47
    Author     : Ilangovane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport"    content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">

        <title>Banque Progressus</title>

        <link rel="shortcut icon" href="assets/images/gt_favicon.png">

        <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="./assets/css/font-awesome.min.css">

        <!-- Custom styles for our template -->
        <link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
        <link rel="stylesheet" href="assets/css/main.css">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <!-- Fixed navbar -->
        <div class="navbar navbar-inverse navbar-fixed-top headroom" >
            <div class="container">
                <div class="navbar-header">
                    <!-- Button for smallest screens -->
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                    <a class="navbar-brand" href="index.html"><img src="assets/images/logo.png" alt="Progressus HTML5 template"></a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav pull-right">
                        <li><a href="index.html">Home</a></li>		
                        <li><a href="contact.html">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div> 
        <!-- /.navbar -->

        <header id="head" class="secondary"></header>

        <!-- container -->
        <div class="container">

            <div class="row">

                <!-- Article main content -->

                <!-- container -->
                <div class="container">
                    <ol class="breadcrumb">
                        <li><a href="">Home</a></li>
                        <li class="active">Gérer les comptes</li>
                    </ol>
                    <div class="row">
                        </br>    
                        <a class="btn btn-action btn-lg" href="ajouter" role="button">Ajouter un compte</a>
                        <a class="btn btn-action btn-lg" href="AjouterClient.jsp" role="button">Ajouter un client</a>

                        <!-- Article main content -->
                        <header class="page-header">
                            <h2>Liste des contrats</h2>
                        </header>
                        </br>
                        <article class="col-md-9 maincontent">
                            <article >
                                <div class="jumbotron top-space">
                                    <div class="top-margin">
                                        <label>Numéro de compte : </label>
                                        <p>123456789102 </p>
                                    </div>
                                    <div class="top-margin">
                                        <label>Libellé: </label>
                                        <p> Compte professionnel </p>
                                    </div>
                                    <div class="top-margin">
                                        <label>IBAN </label>
                                        <p> 12443 34546 435345 43  </p>
                                    </div>
                                    <div class="top-margin">
                                        <label>Adresse de l'agence</label>
                                        <p>17 rue tolbiac, 75013 Paris</p>
                                    </div>
                                    <div class="top-margin">
                                        <label>Solde du compte</label>
                                        <p>1 000 000 000€</p>
                                    </div>
                                    <div class="top-margin">
                                        <label>Liste clients</label>
                                        <p> Marina Passoubady, Sothiya Jeyakuamran</p>
                                    </div>
                                    <p><a class="btn btn-action btn-lg"  href="" role="button">Ajouter un client</a>                 <a class="btn btn-action btn-lg"  role="button" href=""target="_blank">Modifier</a>          <a class="btn btn-action btn-lg" href="" role="button">Supprimer</a></p>
                                </div>
                            </article>

                        </article>


                    </div>
                </div>


                <!-- /Sidebar -->

            </div>
        </div>	<!-- /container -->


        <footer id="footer" class="top-space">

            <div class="footer1">
                <div class="container">
                    <div class="row">

                        <div class="col-md-3 widget">
                            <h3 class="widget-title">Contact</h3>
                            <div class="widget-body">
                                <p>+234 23 9873237<br>
                                    <a href="mailto:#">some.email@somewhere.com</a><br>
                                    <br>
                                    234 Hidden Pond Road, Ashland City, TN 37015
                                </p>	
                            </div>
                        </div>

                        <div class="col-md-3 widget">
                            <h3 class="widget-title">Follow me</h3>
                            <div class="widget-body">
                                <p class="follow-me-icons clearfix">
                                    <a href=""><i class="fa fa-twitter fa-2"></i></a>
                                    <a href=""><i class="fa fa-dribbble fa-2"></i></a>
                                    <a href=""><i class="fa fa-github fa-2"></i></a>
                                    <a href=""><i class="fa fa-facebook fa-2"></i></a>
                                </p>	
                            </div>
                        </div>

                        <div class="col-md-6 widget">
                            <h3 class="widget-title">Text widget</h3>
                            <div class="widget-body">
                            </div>
                        </div>

                    </div> <!-- /row of widgets -->
                </div>
            </div>

            <div class="footer2">
                <div class="container">
                    <div class="row">

                        <div class="col-md-6 widget">
                            <div class="widget-body">
                                <p class="simplenav">
                                    <a href="#">Home</a> | 
                                    <a href="about.html">About</a> |
                                    <a href="sidebar-right.html">Sidebar</a> |
                                    <a href="contact.html">Contact</a> |
                                    <b><a href="signup.html">Sign up</a></b>
                                </p>
                            </div>
                        </div>

                        <div class="col-md-6 widget">
                            <div class="widget-body">
                                <p class="text-right">
                                    Copyright &copy; 2014, Your name. Designed by <a href="http://gettemplate.com/" rel="designer">gettemplate</a> 
                                </p>
                            </div>
                        </div>

                    </div> <!-- /row of widgets -->
                </div>
            </div>
        </footer>	





        <!-- JavaScript libs are placed at the end of the document so the pages load faster -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="assets/js/headroom.min.js"></script>
        <script src="assets/js/jQuery.headroom.min.js"></script>
        <script src="assets/js/template.js"></script>
    </body>
</html>
