package com.company;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {

        int position = findContact(oldContact);

        if (position < 0) {
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        } else if(findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name: " + newContact.getName() + " already exists. Update ERROR");
            return false;
        }

            this.myContacts.set(position, newContact);
            System.out.println(oldContact.getName() + ", was replace with " + newContact.getName());
            return true;

    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        //looping all elements of list
        for (int i = 0; i < this.myContacts.size(); i++) {
            //Contact from list:
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        //does't exists
        return -1;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        } else {
            return null;
        }
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        } else {
            return null;
        }
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.println(contact.getName() + ", was not found");
            return false;
        } else {
            this.myContacts.remove(position);
            System.out.println(contact.getName() + ", was deleted.");
            return true;
        }
    }

    public void printContacts() {
        System.out.println("List:");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println(i + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }

}
