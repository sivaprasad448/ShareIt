package org.shareit.vehicle.rest.resource.podcast;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.beanutils.BeanUtils;
import org.shareit.vehicle.rest.dao.VehicleEntity;
import org.shareit.vehicle.rest.helpers.DateISO8601Adapter;

/**
 * Vehicle resource placeholder for json/xml representation 
 * 
 * @author ama
 *
 */
@SuppressWarnings("restriction")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Vehicle implements Serializable {

	private static final long serialVersionUID = -8039686696076337053L;

	@XmlElement(name = "id")	
	private Long id;
	
	@XmlElement(name = "title")	
	private String title;
		
	@XmlElement(name = "linkOnPodcastpedia")	
	private String linkOnPodcastpedia;
	
	@XmlElement(name = "feed")	
	private String feed;
	
	@XmlElement(name = "description")
	@VehicleDetailedView	
	private String description; 
		
	@XmlElement(name = "insertionDate")
	@XmlJavaTypeAdapter(DateISO8601Adapter.class)	
	@VehicleDetailedView
	private Date insertionDate;

	public Vehicle(VehicleEntity vehicleEntity){
		try {
			BeanUtils.copyProperties(this, vehicleEntity);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Vehicle(String title, String linkOnPodcastpedia, String feed,
			String description) {
		
		this.title = title;
		this.linkOnPodcastpedia = linkOnPodcastpedia;
		this.feed = feed;
		this.description = description;
		
	}
	
	public Vehicle(){}
		
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLinkOnPodcastpedia() {
		return linkOnPodcastpedia;
	}

	public void setLinkOnPodcastpedia(String linkOnPodcastpedia) {
		this.linkOnPodcastpedia = linkOnPodcastpedia;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}
	
	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}
		
}
