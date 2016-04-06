jQuery.support.cors = true;

$(document).ready(function() {
    $.ajax({
        url: "/api/accounts"
    }).then(function(data) {
     	 $('.customer-id').append(data);
	     $('.customer-name').append(data);
		 
		 var svgContainer = d3.select("body").append("svg").attr("height",1000).attr("width",1000);
	
		 
            var circles = d3.select("svg").selectAll("circle")
                         .data(data)
                         .enter()
                         .append("circle")
						 .attr("r", function(d) { return d.balance/5000 })
				.attr("cx", function(){return (Math.random() * 500)+100})
				.attr("cy", function(){return (Math.random() * 500)+100})
				.attr("stroke","rgb(255,0,0)")
				.attr("stroke-width",2)
				.attr("fill","red")
				.attr("id", function(d){return "acc"+d.id});
				
                     
				
		 
		  var texts = d3.select("svg").selectAll("text")
		  .data(data)
		  .enter()
		  .append("text")
		  .attr("x", function(d) { return d3.select("#acc"+d.id).attr("cx");})
		  .attr("y", function(d) { return d3.select("#acc"+d.id).attr("cy");})
		  .text(function(d) { return "Balance:"+d.balance})
		 
		 
    });
});
