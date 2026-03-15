package com.contact;

import java.time.LocalDateTime;
import java.util.*;
import java.util.UUID;
import com.tag.*;

// for contact view
public final class ContactView {

	// no changes allowed
	private final UUID id;
	private final String name;
	private final List<PhoneNumber> phones;
	private final List<EmailAddress> emails;
	private final LocalDateTime createdAt;
	private final int contactCount;
	private final Set<Tag> tags;

	public ContactView(Contact contact) {
		this.id = contact.getId();
		this.name = contact.getName();
		this.phones = contact.getPhones();
		this.emails = contact.getEmails();
		this.createdAt = contact.getCreatedAt();
	    this.contactCount = contact.getContactCount();
	    this.tags = contact.getTags();

	}

	public UUID getId() { return id; }
	public String getName() { return name; }
	public List<PhoneNumber> getPhones() { return phones; }
	public List<EmailAddress> getEmails() { return emails; }
	public LocalDateTime getCreatedAt() { return createdAt; }
	public int getContactCount() {
	    return contactCount;
	}
	public Set<Tag> getTags() {
	    return tags;
	}
}