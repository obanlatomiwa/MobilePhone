package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0817 273 8370");
    public static void main(String[] args) {
	// write your code here
        boolean quit = false;
        startPhone();
        printCommands();

        while (!quit){
            System.out.println("Enter 6 to show available commands");
            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command){
                case 0:
                    System.out.println("System shutting down\n");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addContacts();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    searchForContact();
                    break;

                case 6:
                    printCommands();
                    break;
            }


        }
    }

    public static void startPhone(){
        System.out.println("Starting Phone ...");
    }


    public static void printCommands(){
        System.out.println("\n Available commands:\n press");
        System.out.println(
                "0 - to shutdown\n" +
                "1 - to print a list of a contacts\n" +
                "2 - to add a new contact\n" +
                "3 - to update an existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - check if a contact exist\n" +
                "6 - print a list of available commands\n");
        System.out.println("Choose your command\n");
    }


    private static void addContacts(){
        System.out.println("Please enter contact name");
        String name = scanner.nextLine();
        System.out.println("Please enter contact phone number");
        String phoneNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name,phoneNumber);

        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New Contact with name: " + newContact.getName() + " and phone number: " + newContact.getPhoneNumber() + " was created successfully");
        }else {
            System.out.println("Contact already exists");
        }
    }

    private static void updateContact(){
        System.out.println("Enter contact name to update");
        String nameToUpdate = scanner.nextLine();
        Contacts existingRecord = mobilePhone.queryContact(nameToUpdate);

        if(existingRecord == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name");
        String name = scanner.nextLine();
        System.out.println("Enter new phone number");
        String phoneNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name, phoneNumber);

        if(mobilePhone.updateContact(existingRecord, newContact)){
            System.out.println("Contact successfully updated");
        }else {
            System.out.println("Error updating contact");
        }

    }

    private static void removeContact() {
        System.out.println("Enter contact name to remove");
        String nameToRemove = scanner.nextLine();
        Contacts existingRecord = mobilePhone.queryContact(nameToRemove);

        if (existingRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        if(mobilePhone.deleteContact(existingRecord)){
            System.out.println("Contact successfully deleted");
        }else{
            System.out.println("Error deleting contact");
        }
    }

    private static void searchForContact() {
        System.out.println("Enter contact name to search");
        String nameToRemove = scanner.nextLine();
        Contacts existingRecord = mobilePhone.queryContact(nameToRemove);

        if (existingRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name " + existingRecord.getName() + "phone number " + existingRecord.getPhoneNumber());

    }
}
