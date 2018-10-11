<%-- 
    Document   : AjouterCompte
    Created on : 10 oct. 2018, 16:06:06
    Author     : Ilangovane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" 
        import="model.Client" 
        import="model.BankBranch"
        import="java.util.List"
        %>
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
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">

        <!-- Custom styles for our template -->
        <link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
        <link rel="stylesheet" href="assets/css/main.css">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->
    </head>
    <% List<Client> listeClients = (List<Client>) request.getAttribute("listeClients");
        List<BankBranch> listeBanks = (List<BankBranch>) request.getAttribute("listeBanque");%>

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

            <ol class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li class="active">Ajouter un compte</li>
            </ol>

            <div class="row">

                <!-- Article main content -->
                <article class="col-xs-12 maincontent">
                    <header class="page-header">
                        <h1 class="page-title">Ajouter un compte</h1>
                    </header>

                    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <h3 class="thin text-center">Ajouter un compte</h3>
                                <hr>

                                <form method="post" action="ajouter">
                                    <div class="top-margin">
                                        <label>Numéro de compte <span class="text-danger">*</span></label>
                                        <input type="text" name="numeroCompte" class="form-control">
                                    </div>
                                    <div class="top-margin">
                                        <label>Libelle<span class="text-danger">*</span></label>
                                        <input type="text" name="libelle" class="form-control">
                                    </div>
                                    <div class="top-margin">
                                        <label>IBAN <span class="text-danger">*</span></label>
                                        <input type="text" name="IBAN" class="form-control">
                                    </div>

                                    <div class="top-margin">
                                        <label>Solde<span class="text-danger">*</span></label>
                                        <input type="text" name="solde" class="form-control">
                                    </div>

                                    <div class="top-margin">
                                        <label>Agence <span class="text-danger">*</span></label>
                                        <SELECT name="Agence" size="1" class="form-control">
                                            <%for (int j = 0; j < listeBanks.size(); ++j) {%>
                                            <option value="<%=listeBanks.get(j).getCodeAgence()%>"><%= listeBanks.get(j).getCodeAgence()%></option>
                                            <% } %>
                                        </SELECT>
                                    </div>
                                    <hr>
                                    <div class="top-margin">
                                        <b>Sélectionner les clients de ce compte (2 maximum)</b>
                                        <%for (int j = 0; j < listeClients.size(); ++j) {%>
                                        <div class="top-margin">
                                            <INPUT TYPE="checkbox" name="checkClient" value=<%=listeClients.get(j).getNumeroClient()%>> 
                                            <%=listeClients.get(j).getNom() + " " + listeClients.get(j).getPrenom()%>
                                        </div>  
                                        <% }%>

                                    </div>
                                    <hr>
                                    <div class="row">	
                                        <div class="col-lg-4 text-right">
                                            <button class="btn btn-action" name="btnAjout" value="ajoutCpt" type="submit">Ajouter</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>

                </article>
                <!-- /Article -->

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
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Excepturi, dolores, quibusdam architecto voluptatem amet fugiat nesciunt placeat provident cumque accusamus itaque voluptate modi quidem dolore optio velit hic iusto vero praesentium repellat commodi ad id expedita cupiditate repellendus possimus unde?</p>
                                <p>Eius consequatur nihil quibusdam! Laborum, rerum, quis, inventore ipsa autem repellat provident assumenda labore soluta minima alias temporibus facere distinctio quas adipisci nam sunt explicabo officia tenetur at ea quos doloribus dolorum voluptate reprehenderit architecto sint libero illo et hic.</p>
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
