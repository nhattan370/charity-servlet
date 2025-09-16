<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
   <head>
  		<title>Donation website &mdash; Website Donation</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <meta name="author" content="Free-Template.co" />
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/user/assets/images/apps.png">
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/user/assets/css/custom-bs.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/user/assets/css/jquery.fancybox.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/user/assets/css/bootstrap-select.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/user/assets/fonts/icomoon/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/user/assets/fonts/line-icons/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/user/assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/user/assets/css/animate.min.css">
      
        <!-- MAIN CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/user/assets/css/style.css">
        
        <script src="${pageContext.request.contextPath}/assets/user/assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/user/assets/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/user/assets/js/isotope.pkgd.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/user/assets/js/stickyfill.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/user/assets/js/jquery.fancybox.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/user/assets/js/jquery.easing.1.3.js"></script>
    
        <script src="${pageContext.request.contextPath}/assets/user/assets/js/jquery.waypoints.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/user/assets/js/jquery.animateNumber.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/user/assets/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/user/assets/js/bootstrap-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/user/assets/js/custom.js"></script>
    
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	</head>
<body id="top">

<div id="overlayer"></div>
<div class="loader">
    <div class="spinner-border text-primary" role="status">
        <span class="sr-only">Loading...</span>
    </div>
</div>
<c:if test="${not empty sessionScope.donate}">
	<div  class="toast" data-delay="1000" style="position:fixed; top: 100PX; left: 40PX;z-index: 2000;width: 300px">
	    <script>
	        swal({
	             title: "${donate ? 'Donate Successfully!' : 'Donate Failure!'}",
	             text: 'Redirecting...',
	             icon: "${donate ? 'success' : 'error'}",
	             timer: 3000,
	             buttons: true,
	             type: "${donate ? 'success' : 'error'}"
	         })
	    </script>
	</div>
	<c:remove var="donation" scope="session"/>
</c:if>

<div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close mt-3">
                <span class="icon-close2 js-menu-toggle"></span>
            </div>
        </div>
        <div class="site-mobile-menu-body"></div>
    </div> <!-- .site-mobile-menu -->


    <!-- NAVBAR -->
    <header class="site-navbar mt-3">
        <div class="container-fluid">
            <div class="row align-items-center">
              <div class="site-logo col-6"><a href="${pageContext.request.contextPath}">Website Quyên Góp</a></div>
            </div>
          </div>
    </header>

    <!-- HOME -->
    <section class="section-hero overlay inner-page bg-image" style="background-image: url('${pageContext.request.contextPath}/assets/user/assets/images/hero_1.jpg');" id="home-section">
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <h1 class="text-white font-weight-bold">Danh sách các đợt quyên góp</h1>
                </div>
            </div>
        </div>
    </section>
    <section class="site-section">
        <div class="container">

            <div class="row mb-5 justify-content-center">
                <div class="col-md-7 text-center">
                    <h2 class="section-title mb-2" >Các đợt quyên góp</h2>
                </div>
            </div>
            <ul class="job-listings mb-5">
        		<c:forEach var="donation" items="${donations}">
        			<li class="job-listing d-block d-sm-flex pb-3 pb-sm-0 align-items-center "
        				style="cursor:pointer;">
        			<!--  
        			-->
        			
                        <div 
                        	class="job-listing-about d-sm-flex custom-width w-100 justify-content-between mx-4"
        					onClick="window.location.href='${pageContext.request.contextPath}/detail?id=${donation.id}'"        			
                        >
                            <div class="job-listing-position custom-width  mb-3 mb-sm-0" style="padding: 10px;width: 250px">
                                <h2>${donation.name}</h2>
                                <strong>
									<c:choose>
									    <c:when test="${donation.status==1}">
									        <span style="color:#3498db;">Mới tạo</span>
									    </c:when>
									    <c:when test="${donation.status==2}">
									        <span style="color:#2ecc71;">Đang hoạt động</span>
									    </c:when>
									    <c:when test="${donation.status==3}">
									        <span style="color:#e74c3c;">Kết thúc</span>
									    </c:when>
									    <c:when test="${donation.status==4}">
									        <span style="color:#f39c12;">Tạm dừng</span>
									    </c:when>
									</c:choose>
                                </strong>
                            </div>
                            <div class="job-listing-location mb-3 mb-sm-0 custom-width w-10" style="padding: 10px;">
                                Ngày bắt đầu<br>
                                <strong>${donation.startDate}</strong><br>
                            </div>
                            <div class="job-listing-location mb-3 mb-sm-0 custom-width w-10" style="padding: 10px;">
                                Ngày kết thúc<br>
                                <strong>${donation.endDate}</strong><br>
                            </div>
                            <div class="job-listing-location mb-3 mb-sm-0 custom-width w-25" style="padding: 10px;">
                                <span class="icon-room"></span> <span>${donation.organizationName}</span><br>
                                <strong>${donation.phoneNumber}</strong><br>
                            </div>
                            <div class="job-listing-meta custom-width w-20" >
	                            <c:choose>
	                            	<c:when test="${donation.status==2}">
		                            	<button style="margin-top: 20px;  width:113px; height:42px" 
										   class="btn btn-primary py-2" 
										   data-toggle="modal" 
		  								   data-target="#exampleModal${donation.id}"
										   >
										   Quyên góp
										</button>  
	                            	</c:when>
	                            	<c:otherwise>
		                            	<button style="margin-top: 20px;opacity: 0.5; width:113px; height:42px" 
										   class="btn btn-primary py-2" 
										   disabled
										>
										<c:if test="${donation.status==1}">Mới khởi tạo</c:if>
										<c:if test="${donation.status==3}">Tạm dừng</c:if>
										<c:if test="${donation.status==4}">Kết thúc</c:if>
										</button>  
	                            	</c:otherwise>
	                            </c:choose>
								<!--
								<button style="margin-top: 20px" 
							     	class="btn btn-primary py-2" 
							     	data-toggle="modal" 
								   onclick="event.stopPropagation(); $('#exampleModal${donation.id}').modal('show');"								   
							    >
								   Quyên góp
								</button>
								-->
	                            <p style="margin-top: 20px;background-color: white !important;" class="btn py-2">
	                            	<span style="color: white">Quyên góp</span>
	                            </p>
                            </div>
                        </div>
                    </li>
                    <!-- Modal -->
                       <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" id="exampleModal${donation.id}">                        
                       <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel${donation.id}">Quyên góp: <span style="color:#e67e22">${donation.name}</span></h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>                                	
                                </div>
                                <form method="post" action="donate">
                                    <div class="modal-body">
                                        <div class="row">

                                            <div class="col-12">
                                                <label for="addname"
                                                       class="col-form-label">Họ tên:</label>
                                                <input type="text" class="form-control"
                                                       id="addname" name="name" placeholder="" required>
                                                <label for="addmoney"
                                                       class="col-form-label">Số tiền quyên góp:</label>
                                                <input type="number" class="form-control" placeholder=""
                                                       id="addmoney" name="money" required>
                                                <input type="hidden" class="form-control" value="1"
                                                       id="addname" name="idUser" >
                                                <input type="hidden" class="form-control" value="${donation.id}"
                                                       id="addname" name="idDonation" required>

                                                <label for="addname"
                                                       class="col-form-label">Lời nhắn:</label>
                                                <textarea rows="10" cols="3" class="form-control" name="text">

                                                </textarea>
                                            </div>

                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                                            <button type="submit" class="btn btn-primary">Quyên góp</button>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    <!-- Modal -->
                    </div>
        		</c:forEach>
            </ul>

			<!-- Pagination -->
            <div class="row pagination-wrap">
                <div class="col-md-6 text-center text-md-left mb-4 mb-md-0">

                </div>
                <div class="col-md-6 text-center text-md-right">
                    <div class="custom-pagination ml-auto">
                        <a class="prev">Prev</a>
                        <div class="d-inline-block">
                        </div>

                        <a class="next">Next</a>
                    </div>
                </div>
            </div>
			<!-- Pagination -->

        </div>
    </section>
</div>
</body>
</html>