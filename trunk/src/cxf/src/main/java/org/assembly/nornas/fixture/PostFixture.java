/**
 * 
 */
package org.assembly.nornas.fixture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assembly.nornas.model.Post;
import org.assembly.nornas.model.StatePost;



/**
 * @author Cristian
 * 
 * Fixture of author
 *
 */
public class PostFixture {

	public static List<Post> createPosts() {
		List<Post> posts = new ArrayList<Post>();
		posts.add(PostFixture.createPostsPublished("titulo1","contenido1","tecnologia","ocio","otro"));
		posts.add(PostFixture.createPostsDraft("titulo2","contenido2","tecnologia","ocio"));
		posts.add(PostFixture.createPostsPublished("titulo3","contenido3","tecnologia","ocio"));
		posts.add(PostFixture.createPostsPublished("titulo4","contenido4","tecnologia","ocio"));
		posts.add(PostFixture.createPostsDraft("titulo5","contenido5","tecnologia","ocio"));
		posts.add(PostFixture.createPostsPublished("titulo6","contenido6","tecnologia","ocio"));
		posts.add(PostFixture.createPostsPublished("titulo7","contenido7","tecnologia"));
		posts.add(PostFixture.createPostsPublished("titulo8","contenido8","tecnologia"));
		posts.add(PostFixture.createPostsDraft("titulo9","contenido9","otro"));
		posts.add(PostFixture.createPostsPublished("titulo10","contenido10","otro"));
		posts.add(PostFixture.createPostsPublished("titulo11","contenido11","ocio","otro"));
		posts.add(PostFixture.createPostsPublished("titulo12","contenido12","ocio","otro"));
		posts.add(PostFixture.createPostsPublished("titulo13","contenido13","ocio","otro"));
		posts.add(PostFixture.createPostsPublished("titulo14","contenido14","ocio","otro"));
		return posts;
	}

	public static Post createPostsPublished(String title, String content, String ... tags) {
		Post post = new Post(title, content, "Pepe");
		post.setState(StatePost.PUBLISHED);
		post.setTags(Arrays.asList(tags));
		return post;
	}

	public static Post createPostsDraft(String title, String content, String ... tags) {
		Post post = new Post(title, content, "Pepe");
		post.setState(StatePost.DRAFT);
		post.setTags(Arrays.asList(tags));
		return post;
	}

	
}
