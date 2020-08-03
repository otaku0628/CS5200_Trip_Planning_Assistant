<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Find Listings</title>

        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
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
            <h1>Search for Airbnb Listing</h1>

            <div class="container p-3 my-3">
                <form action="findlistings" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="city">city: (Required)</label>
                            <input type="text" class="form-control" id="city"
                                   placeholder="Search city here" name="city"
                                   value="${fn:escapeXml(param.city)}">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="country">country: (Required)</label>
                            <select class="form-control" id="country" name="country">
                                <option value="" selected disabled>-- select an option --</option>
                                <c:forEach items="${countryArray}" var="country" >
                                    <option>${country}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="zipCode">zipCode: (Optional)</label>
                            <input type="text" class="form-control" id="zipCode"
                                   placeholder="Search zipCode here" name="zipCode"
                                   value="${fn:escapeXml(param.zipCode)}">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="name">name: (Optional)</label>
                            <input type="text" class="form-control" id="name"
                                   placeholder="Search name here" name="name"
                                   value="${fn:escapeXml(param.name)}">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="cancellationPolicy">cancellationPolicy: (Optional)</label>
                            <select class="form-control" id="cancellationPolicy" name="cancellationPolicy">
                                <option value="" selected disabled>-- select an option --</option>
                                <c:forEach items="${cancellationPolicyArray}" var="cancellationPolicy" >
                                    <option>${cancellationPolicy}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="roomType">roomType: (Optional)</label>
                            <select class="form-control" id="roomType" name="roomType">
                                <option value="" selected disabled>-- select an option --</option>
                                <c:forEach items="${roomTypeArray}" var="roomType" >
                                    <option>${roomType}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="maxPrice">maxPrice:</label>
                            <input type="number" class="form-control" id="maxPrice"
                                   placeholder="(Optional)" name="maxPrice"
                                   value="${fn:escapeXml(param.maxPrice)}">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="minPrice">minPrice:</label>
                            <input type="number" class="form-control" id="minPrice"
                                   placeholder="(Optional)" name="minPrice"
                                   value="${fn:escapeXml(param.minPrice)}">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="accommodates">accommodates:</label>
                            <input type="number" class="form-control" id="accommodates"
                                   placeholder="(Optional)" name="accommodates"
                                   value="${fn:escapeXml(param.accommodates)}">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="bathroomCount">bathroomCount:</label>
                            <input type="number" class="form-control" id="bathroomCount"
                                   placeholder="(Optional)" name="bathroomCount"
                                   value="${fn:escapeXml(param.bathroomCount)}">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="bedroomCount">bedroomCount:</label>
                            <input type="number" class="form-control" id="bedroomCount"
                                   placeholder="(Optional)" name="bedroomCount"
                                   value="${fn:escapeXml(param.bedroomCount)}">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="bedCount">bedCount:</label>
                            <input type="number" class="form-control" id="bedCount"
                                   placeholder="(Optional)" name="bedCount"
                                   value="${fn:escapeXml(param.bedCount)}">
                        </div>
                    </div>

                    <button type="submit" class="btn btn-primary">Search</button>
                    <a href="findlistings" class="btn btn-primary">Reset</a>
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

            <h1>Matching Listings</h1>

            <div class="card-columns">
                <c:forEach items="${listingCards}" var="listingCard" >
                    <div class="card text-center">
                        <img class="card-img-top" src="${listingCard.getThumbnailUrl()}"
                             alt="Listing Thumbnail">
                        <div class="card-body">
                            <p class="card-text text-muted">
                                    ${listingCard.getRoomType()} in ${listingCard.getCity()}
                            </p>
                            <h5 class="card-title">${listingCard.getName()}</h5>
                            <p class="card-text text-muted">
                                    ${listingCard.getAccommodates()} guests,
                                    ${listingCard.getBedroomCount()} bedroom,
                                    ${listingCard.getBedCount()} bed,
                                    ${listingCard.getBathroomCount()} bath
                            </p>
                            <p class="card-text text-muted">${listingCard.getFeatures()}</p>
                            <br/>
                            <p class="card-text text-muted">
                                <i class="fa fa-smile-o" style="color:red"></i>
                                    ${listingCard.getRatingScore()}(${listingCard.getReviewCount()})
                            </p>
                        </div>
                        <div class="card-footer text-muted">
                            <p>${listingCard.getDailyPrice()}/night</p>
                            <a href="recommendation?listingId=${listingCard.getListingId()}"
                               class="btn btn-primary">Recommendations</a>
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
</html>
