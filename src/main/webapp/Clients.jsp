<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Clients Managment </title>
   
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    <link rel="stylesheet" href="assets/vendor/owl-carousel/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/vendor/owl-carousel/css/owl.theme.default.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="assets/css/style.css" rel="stylesheet">
     <link href="assets/vendor/datatables/css/jquery.dataTables.min.css" rel="stylesheet">

	  <script type="text/javascript" src="scriptjs/Clients.js"></script>
</head>
<body>
<%@include file="jsp files/header.jsp" %>
<%@include file="jsp files/sideBar.jsp" %>






 <div class="content-body">
           
           
            <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Clients list</h4>
                                 
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table id="example" class="display" style="min-width: 845px">
                                        <thead>
                                            <tr>
                                            	<th>Id</th>
                                                <th>First name</th>
                                                <th>Last name</th>
                                                <th>Phone number</th>
                                                <th>status</th>
                                                <th>Actions</th>
                                            </tr>
                                        </thead>
                                        <tbody id ="content">
                                            
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                               <th>Id</th>
                                                <th>First name</th>
                                                <th>Last name</th>
                                                <th>Phone number</th>
                                                <th>status</th>
                                                <th>Actions</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>       
                </div>
           
          
                                    <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title">Modal title</h5>
                                                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">Modal body text goes here.</div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-primary">Save changes</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
           
           
            
        </div>















<%@include file="jsp files/footer.jsp" %>

 <!-- Required vendors -->
    <script src="assets/vendor/global/global.min.js"></script>
    <script src="assets/js/quixnav-init.js"></script>
    <script src="assets/js/custom.min.js"></script>
     <!-- Datatable -->
    <script src="assets/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="assets/js/plugins-init/datatables.init.js"></script>
    
    
 
</body>
</html>