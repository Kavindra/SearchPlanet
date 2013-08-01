package com.planet;

import java.util.ArrayList;
import java.util.List;

class Resp_Category{
	private int id;
	private String slug;
	private String title;
	private String description;
	private int parent;
	private int post_count;
	
}
class Custom_Field{
	private List<String> acronym;
	private List<String> more_info_link;
	private List<String> datagov_id;
	private List<String> curator_person_name;
	private List<String> curator_person_email;
	private List<String> curator_url;
	private List<String> curator_center;
	private List<String> curator_org_name;
}

class Category{
	private int id;
	private String slug;
	private String title;
	private String description;
	private int parent;
	private int post_count;
}

class Tag{
	private int id;
	private String slug;
	private String title;
	private String description;
	private int post_count;
}

class Post{
	private int id;
	private String slug;
	private String url;
	private String title;
	private String title_plain;
	private String content;
	private String excerpt;
	private String date;
	private String modified;
	private List<Category> categories;
	private List<Tag> tags;
	private Custom_Field custom_fields;
	
	
	public String getExcerpt(){
		return excerpt;
	}
	
	public List<Category> getCategories(){
		
		return categories;
	}
}


public class NasaResponseEntity {
	private String status;
	private int count;
	private int count_total;
	private int pages;
	//private Resp_Category category;
	private List<Post> posts;
	
	public String getStatus(){
		return status;
	}
	
	public List<String> getExcerpts(){
		
		List<String> excerpts = new ArrayList<String>();
		
		for (Post post:posts)
		{
			excerpts.add(post.getExcerpt());
		}
		
		return excerpts;
	}
	
}

