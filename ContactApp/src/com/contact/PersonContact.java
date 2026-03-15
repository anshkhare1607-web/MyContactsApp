package com.contact;
import com.tag.*;

// person contact class
public class PersonContact extends Contact {

    public PersonContact(ContactBuilder builder) {
        super(builder);
    }

    //Override
    public String toString() {

        StringBuilder phoneList = new StringBuilder();
        for (PhoneNumber phone : phones) {
            phoneList.append(phone.getNumber()).append(", ");
        }

        StringBuilder emailList = new StringBuilder();
        for (EmailAddress email : emails) {
            emailList.append(email.getEmail()).append(", ");
        }
        
        StringBuilder tagList = new StringBuilder();
        for (Tag t : getTags()) {
            tagList.append(t.getName()).append(", ");
        }

        return "\n===== CONTACT DETAILS =====" +
               "\nContact Type: Person" +
               "\nID: " + id +
               "\nName: " + name +
               "\nPhones: " + phoneList +
               "\nEmails: " + emailList +
               "\nTags: " + tagList +
               "\nContact Frequency: " + getContactCount() +
               "\nCreated At: " + createdAt;
    }
}