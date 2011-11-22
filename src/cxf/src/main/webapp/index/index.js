/*********************************************************************
 *                                                                   *
 *                      javascripts Utils Home                       *
 *                                                                   *
 ********************************************************************/

function addPost(urlPost, tag) {
	var url = urlPost + initPost + "?tag=" + tag;
	var urlCount = urlPost + "count/"  + "?tag=" + tag;
	addPostByUrl(url, urlCount, urlPost, tag);
}

function addPostByUrl(url, urlCount, urlPost, tag) {
	$.getJSON(url, function(data) {
		var div = $('<div/>');

		$.each(data, function(index, post) {
			
			var datePost = new Date(post.publishDate);
			var datePostLabel = datePost.format("fullDate");
			
			div.append('<h3><a  href="#"> <span class="postTitle"> ' + post.title + '</span> by ' + post.author + ' </a>  </h3>');
			var divPost = $('<div/>').append( $('<span class="post">' +   post.content + ' <br/> </span>'));
			
			$.each(post.tags, function(index, tag) {
				divPost.append(
						$("<div>"+ tag +"</div>").button().click(function () {
								initPost = 0;
								addPost(urlPost, tag);
							}
						)
				);
			});
					
			div.append(divPost);
		});

		$('#post').empty();
		div.appendTo('#post');
		div.accordion(); 	
		div.hide();
		div.fadeIn("slow");
	});
}


function addTags(urlPost) {
	var url = urlPost + "tags";

	$.getJSON(url, function(data) {
		var divTag = $('<div/>');

		$.each(data, function(index, tag) {
			divTag.append(
					$("<div>"+tag+"</div>").button().click(function () {
							initPost = 0;
							addPost(urlPost, tag);
						}
					)
			);
		});
		
		$('#tags').empty();
		divTag.appendTo('#tags');		
	});
}



