package com.contact;


// class for organization contact
public class OrganizationContact extends Contact {

    public OrganizationContact(ContactBuilder builder) {
        super(builder);
    }

    //Override
    public String toString() {
    	
    	// for displaying contact details

        StringBuilder phoneList = new StringBuilder();
        for (PhoneNumber phone : phones) {
            phoneList.append(phone.getNumber()).append(", ");
        }

        StringBuilder emailList = new StringBuilder();
        for (EmailAddress email : emails) {
            emailList.append(email.getEmail()).append(", ");
        }

        return "\n===== CONTACT DETAILS =====" +
               "\nContact Type: Organization" +
               "\nID: " + id +
               "\nName: " + name +
               "\nPhones: " + phoneList +
               "\nEmails: " + emailList +
               "\nCreated At: " + createdAt;
    }
}