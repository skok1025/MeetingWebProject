$(document).ready(function(){

	//----------------------------------------- 시계관련 js
	
      var clock;

      $(document).ready(function() {

         // Grab the current date
         var currentDate = new Date();

         // Set some date in the past. In this case, it's always been since
			// Jan 1
         var pastDate  = new Date(currentDate.getFullYear(), 0, 1);

         // Calculate the difference in seconds between the future and
			// current date
         var diff = currentDate.getTime() / 1000 - pastDate.getTime() / 1000;

         // Instantiate a coutdown FlipClock
         clock = $('.clock').FlipClock({
            clockFace: 'TwelveHourClock'
         });
      });
      
      
      $("#introducebt").click(function(){
			$(".mdl-navigation__link").removeClass("is-active");
			$("#introducebt").addClass("is-active");
			$(".demo-list-item").css("transform","translate(0px,0px)");
			$(".demo-list-item").css("opacity","0");
			$(".demo-list-item").hide();
			$("#introducelist").css("transform","translate(0px,200px)");
			$("#introducelist").css("opacity","1");
			$("#introducelist").show();
		});
		$("#matchingbt").click(function(){
			$(".mdl-navigation__link").removeClass("is-active");
			$("#matchingbt").addClass("is-active");
			$(".demo-list-item").css("transform","translate(0px,0px)");
			$(".demo-list-item").css("opacity","0");
			$(".demo-list-item").hide();
			$("#matchinglist").css("transform","translate(0px,200px)");
			$("#matchinglist").css("opacity","1");
			$("#matchinglist").show();
		});
		$("#communitybt").click(function(){
			$(".mdl-navigation__link").removeClass("is-active");
			$("#communitybt").addClass("is-active");
			$(".demo-list-item").css("transform","translate(0px,0px)");
			$(".demo-list-item").css("opacity","0");
			$(".demo-list-item").hide();
			$("#communitylist").css("transform","translate(0px,200px)");
			$("#communitylist").css("opacity","1");
			$("#communitylist").show();
		});
		$("#courtshipbt").click(function(){
			$(".mdl-navigation__link").removeClass("is-active");
			$("#courtshipbt").addClass("is-active");
			$(".demo-list-item").css("transform","translate(0px,0px)");
			$(".demo-list-item").css("opacity","0");
			$(".demo-list-item").hide();
			$("#courtshiplist").css("transform","translate(0px,200px)");
			$("#courtshiplist").css("opacity","1");
			$("#courtshiplist").show();
		});
		$("#lovetestbt").click(function(){
			$(".mdl-navigation__link").removeClass("is-active");
			$("#lovetestbt").addClass("is-active");
			$(".demo-list-item").css("transform","translate(0px,0px)");
			$(".demo-list-item").css("opacity","0");
			$(".demo-list-item").hide();
			$("#lovetestlist").css("transform","translate(0px,200px)");
			$("#lovetestlist").css("opacity","1");
			$("#lovetestlist").show();
			
		});
		$("#mypagebt").click(function(){
			$(".mdl-navigation__link").removeClass("is-active");
			$("#mypagebt").addClass("is-active");
			$(".demo-list-item").css("transform","translate(0px,0px)");
			$(".demo-list-item").css("opacity","0");
			$(".demo-list-item").hide();
			$("#mypagelist").css("transform","translate(0px,200px)");
			$("#mypagelist").css("opacity","1");
			$("#mypagelist").show();
		});
      
      
   });