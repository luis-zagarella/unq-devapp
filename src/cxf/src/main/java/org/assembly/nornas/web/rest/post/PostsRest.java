/**
 * 
 */
package org.assembly.nornas.web.rest.post;

import java.util.List;
import java.util.Set;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang.StringUtils;
import org.assembly.nornas.model.Post;
import org.assembly.nornas.repository.PostRepository;

/**
 * 
 * 
 * @author cristian
 */
@Path("/posts")
public class PostsRest {
    
    public static final int NUMBER_OF_POST = 10;

    private PostRepository postDAO;

    @GET
    @Path("/{from}")
    @Produces("application/json")
    public List<Post> findPostsPublishedByBlogId(@PathParam("from") final Integer from) {
        List<Post> posts = postDAO.getPosts(from, NUMBER_OF_POST, "");
        return posts;
    }

    @GET
    @Path("/byAuthor/{id}")
    @Produces("application/json")
    public List<Post> findPostsPublishedByAuthorId(@PathParam("id") final String id) {
        List<Post> posts = postDAO.getPosts(id);
        return posts;
    }

    @GET
    @Path("/count")
    @Produces("application/json")
    public Integer countPostsPublishedByBlogId(@DefaultValue(StringUtils.EMPTY) @QueryParam("tag") final String tag) {
        return postDAO.getcount(tag);
    }

    @GET
    @Path("/tags")
    @Produces("application/json")
    public Set<String> getTagsByBlogId() {
        return postDAO.getTags();
    }



    public void setPostDAO(final PostRepository postDAO) {
        this.postDAO = postDAO;
    }
}
