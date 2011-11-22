/**
 * 
 */
package org.assembly.nornas.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


/**
 * @author Cristian
 * 
 *         class represents a post
 * 
 */
@XmlRootElement(name="post")
public class Post {
	
	private String title;

	private String content;

	private Date publishDate;
	
	private Date creationDate;

	private StatePost state = StatePost.DRAFT;

	private String author;
	
	private Boolean commentAllow = Boolean.FALSE;
	
	private List<String> tags = new ArrayList<String>();

	
	public Post(String title, String content, String author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.creationDate = Calendar.getInstance().getTime();
	}

	public Post(String title, String content, StatePost state,
			String author) {
		this(title, content, author);
		this.state = state;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public StatePost getState() {
		return state;
	}

	public void setState(StatePost state) {
		this.state = state;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Boolean getCommentAllow() {
		return commentAllow;
	}

	public void setCommentAllow(Boolean commentAllow) {
		this.commentAllow = commentAllow;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!obj.getClass().isAssignableFrom(getClass()))
			return false;

		Post otherPost = (Post) obj;

		return new EqualsBuilder()
				.append(this.getTitle(), otherPost.getTitle()).append(
						this.getAuthor(), otherPost.getAuthor()).append(
						this.getCreationDate(), otherPost.getCreationDate()).append(
						this.getState(), otherPost.getState()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getTitle()).append(
				this.getAuthor()).append(this.getCreationDate())
				.append(this.getState()).toHashCode();
	}


}
