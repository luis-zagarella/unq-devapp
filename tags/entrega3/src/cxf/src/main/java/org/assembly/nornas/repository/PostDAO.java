/**
 * 
 */
package org.assembly.nornas.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;
import org.assembly.nornas.fixture.PostFixture;
import org.assembly.nornas.model.Post;

/**
 * @author Cristian
 * 
 */
public class PostDAO implements PostRepository {

    private List<Post> posts;

    public PostDAO() {
        posts = PostFixture.createPosts();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.assembly.nornas.repository.PostRepository#getcount()
     */
    @Override
    public Integer getcount(final String tag) {
        List<Post> result = this.getPostsByTag(tag);
        return result.size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.assembly.nornas.repository.PostRepository#getTags()
     */
    @Override
    public Set<String> getTags() {
        Set<String> tags = new HashSet<String>();
        for (Post post : posts) {
            tags.addAll(post.getTags());
        }

        return tags;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.assembly.nornas.repository.PostRepository#getPosts(int, int,
     * java.lang.String)
     */
    @Override
    public List<Post> getPosts(final int from, final int number, final String tag) {
        List<Post> result = this.getPostsByTag(tag);
        int to = from + number > result.size() ? result.size() : from + number;
        return result.subList(from, to);
    }

    private List<Post> getPostsByTag(final String tag) {
        List<Post> result = new ArrayList<Post>();
        if (!StringUtils.isEmpty(tag)) {
            for (Post post : posts) {
                if (post.getTags().contains(tag)) {
                    result.add(post);
                }
            }
        } else {
            result.addAll(posts);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Post> getPosts(final String author) {
        return (List<Post>) CollectionUtils.select(posts, new Predicate() {

            @Override
            public boolean evaluate(final Object arg0) {
                return ((Post) arg0).getAuthor().equals(author);
            }
        });
        // return posts.
    }
}
