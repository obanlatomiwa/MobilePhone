package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

//    add a new contact
    public boolean addNewContact(Contacts contact){
        if (findContact(contact.getName()) >= 0){
            System.out.println("This contact exists in the database");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

//    returns the index of the contact
    private int findContact(Contacts contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for (int i=0; i<this.myContacts.size(); i++){
            Contacts contact = this.myContacts.get(i);
            if ( contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contact){
        if (findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if (position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }


    public boolean deleteContact(Contacts contact){
        int foundPosition = findContact(contact);
        if (foundPosition < 0){
            System.out.println("Contact doesn't exist");
            return false;
        }
        this.myContacts.remove(contact);
        System.out.println("Contact " + contact.getName() + " was deleted");
        return true;
    }


    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0){
            System.out.println("Contact doesn't exist");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println("Contact " + oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    public void printContacts(){
        System.out.println("Printing all available contacts");
        for (int i=0; i<this.myContacts.size(); i++){
            System.out.println((i + 1) + "  " + this.myContacts.get(i).getName() + "  ---  " + this.myContacts.get(i).getPhoneNumber());
        }
    }
}
