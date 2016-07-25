<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Welcome Page</title>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      height:450px;
      margin: auto;
  }  
  </style>
  <link href="bootstrap/css/my.css" rel="stylesheet" type=text/css>
</head>
<body>

<div class="container">

  <div id="myCarousel" class="carousel slide">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li class="item1 active"></li>
      <li class="item2"></li>
      <li class="item3"></li>
      <li class="item4"></li>      
      <li class="item5"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox" align="center" >
      <div class="item active">
        <img  src="./MovieImage/jungle_po.jpg" alt="정글북">
      </div>

      <div class="item">
        <img src="./MovieImage/conjuring2_po.jpg" alt="나우유씨미2">
      </div>
    
      <div class="item">
        <img src="./MovieImage/아이스에이지5_po.jpg" alt="아이스에이지5">
      </div>

      <div class="item">
        <img src="./MovieImage/부산행_po.jpg" alt="부산행">
      </div>
      
      <div class="item">
        <img src="./MovieImage/onepiece_po.jpg" alt="원피스">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<script>
$(document).ready(function(){
    // Activate Carousel
    $("#myCarousel").carousel({interval: 2000});
    
    // Enable Carousel Indicators
    $(".item1").click(function(){
        $("#myCarousel").carousel(0);
    });
    $(".item2").click(function(){
        $("#myCarousel").carousel(1);
    });
    $(".item3").click(function(){
        $("#myCarousel").carousel(2);
    });
    $(".item4").click(function(){
        $("#myCarousel").carousel(3);
    });
    $(".item5").click(function(){
        $("#myCarousel").carousel(4);
    });
    
    // Enable Carousel Controls
    $(".left").click(function(){
        $("#myCarousel").carousel("prev");
    });
    $(".right").click(function(){
        $("#myCarousel").carousel("next");
    });
});
</script>

</body>

<%@include file="./../footer.jsp"%>
</html>
