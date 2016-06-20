package com.mkyong.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "channels")
public class Channels {

	@Id
	private String id;

	List<ChannelDetails> subscribedChannels;

	List<ChannelDetails> publishingChannels;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public List<ChannelDetails> getSubscribedChannels() {
        return subscribedChannels;
    }

    public void setSubscribedChannels(List<ChannelDetails> subscribedChannels) {
        this.subscribedChannels = subscribedChannels;
    }

    public List<ChannelDetails> getPublishingChannels() {
        return publishingChannels;
    }

    public void setPublishingChannels(List<ChannelDetails> publishingChannels) {
        this.publishingChannels = publishingChannels;
    }

    

	
}