<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <title>Recommendation</title>

        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <a class="navbar-brand" href="#">Trip Planning Assistant</a>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="findlistings">Listing</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="findusers">User</a>
                </li>
            </ul>
        </nav>

        <div class="container p-3 my-3 border">
            <div class="row p-3 my-3">
                <div class="col-md-3">
                    <img class="img-fluid" src="${listingCard.getThumbnailUrl()}"
                         alt="Listing Image">
                </div>
                <div class="col-md-9">
                    <h5>${listingCard.getName()}</h5>
                    <p>${listingCard.getRoomType()} in ${listingCard.getCity()}</p>
                    <p>
                        ${listingCard.getAccommodates()} guests,
                        ${listingCard.getBedroomCount()} bedroom,
                        ${listingCard.getBedCount()} bed,
                        ${listingCard.getBathroomCount()} bath
                    </p>
                    <p>${listingCard.getFeatures()}</p>
                    <p>
                        <i class="fa fa-smile-o" style="color:red"></i>
                        ${listingCard.getRatingScore()}(${listingCard.getReviewCount()})
                    </p>
                    <p>${listingCard.getDailyPrice()}/night</p>
                    <a href="${listingCard.getListingUrl()}"
                       class="btn btn-primary" target="_blank">
                        Make Reservation at Airbnb!!!
                    </a>
                    <button onclick="goBack()" class="btn btn-primary">Back</button>
                </div>
            </div>

            <h1>Search Recommendations for ListingID: ${fn:escapeXml(param.listingId)}</h1>

            <div class="container p-3 my-3">
                <form action="recommendation?listingId=${listingCard.getListingId()}" method="post">
                    <div class="form-group">
                        <label for="distance">distance:</label>
                        <input type="number" class="form-control" id="distance"
                               placeholder="Please put the radius in 'meters' for searching"
                               name="distance" value="${fn:escapeXml(param.distance)}">
                    </div>

                    <button type="submit" class="btn btn-primary">Search</button>
                    <a href="recommendation?listingId=${fn:escapeXml(param.listingId)}"
                       class="btn btn-primary">
                        Reset
                    </a>
                </form>

                <c:if test="${messages.showToast}">
                    <div class="toast" data-autohide="false">
                        <div class="toast-header">
                            <strong class="mr-auto text-primary">Search Result</strong>
                            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast">&times;</button>
                        </div>
                        <div class="toast-body">
                                ${messages.resultMessage}
                        </div>
                    </div>
                </c:if>
            </div>

            <h1>Matching Recommendations</h1>

            <div class="card-columns">
                <c:forEach items="${recommendationCards}" var="recommendationCard" >
                    <div class="card text-center">
                        <div class="card-body">
                            <h5 class="card-title">${recommendationCard.getName()}</h5>
                            <p class="card-text text-muted">
                                <i class="fa fa-smile-o" style="color:red"></i>
                                    ${recommendationCard.getStars()}(${recommendationCard.getReviewCount()})
                            </p>
                            <p class="card-text text-muted">
                                    ${recommendationCard.getCategories()}
                            </p>
                            <br/>
                            <p class="card-text text-muted">
                                    ${recommendationCard.getAddress()}
                            </p>
                            <p>Distance: ${recommendationCard.getDistance()}m</p>
                        </div>
                        <div class="card-footer text-muted">
                            <a href="https://www.yelp.com/biz/${recommendationCard.getBusinessId()}"
                               class="btn btn-primary" target="_blank">
                                More Details at Yelp!!!
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>

    <script>
        $(document).ready(function(){
            $('.toast').toast('show');
        });
    </script>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</html>
