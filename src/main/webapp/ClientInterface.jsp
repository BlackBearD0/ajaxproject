<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Profile </title>
   
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    <link rel="stylesheet" href="assets/vendor/owl-carousel/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/vendor/owl-carousel/css/owl.theme.default.min.css">
    <link href="assets/vendor/jqvmap/css/jqvmap.min.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
     <link href="assets/vendor/datatables/css/jquery.dataTables.min.css" rel="stylesheet">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script type="text/javascript" src="scriptjs/reservation.js"></script>
</head>
<body>
<%@include file="jsp files/header.jsp" %>







 <div class="content-body">
           
           
            <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Reservations list</h4>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">make reservation</button>
                                <input type="hidden" class="form-control" placeholder="ez125h" id="id" value= "${ sessionScope.id }"	disabled>
                             
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table id="example" class="display" style="min-width: 845px">
                                    
                                        <thead>
                                            <tr>
                                                <th>N°</th>
                                                <th>Room</th>
                                                <th>date</th>
                                                <th>Check in</th>
                                                <th>Check out</th>
                                                <th> actions </th>
                                            </tr>
                                        </thead>
                                        <tbody id="content">
                                            
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                            	  <th>N°</th>
                                                <th>Room</th>
                                                <th>date</th>
                                                <th>Check in</th>
                                                <th>Check out</th>
                                                <th> actions </th>
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
                                                    <h5 class="modal-title">Make Reservation</h5>
                                                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span>
                                                    </button>
                                                </div>
                                                <form id="form1">
                                                <div class="modal-body">
                                                 
                                        <div class="form-row">
                                           
                                            <div class="form-group col-md-6">
                                             <label>Room</label>
                                            <select class="form-control form-control" id="room">
                                             
                                            </select>
                                            </div>
                                       
                                            <div class="form-group col-md-6">
                                                <label>date</label>
                                                <input type="date" class="form-control" id="date">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>check in  </label>
                                                <input type="number" min="0" max="23.59" class="form-control" id="heureD">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>check out </label>
                                                <input type="number"  min="0" max="23.59" class="form-control" id="heureF">
                                            </div>
                                        </div>
                                    
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                                    <button type="submit" class="btn btn-primary" id="save">Save</button>
                                                </div>
                                                 </form> 
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