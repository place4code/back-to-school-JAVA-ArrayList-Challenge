package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("123 456 789");

    public static void main(String[] args) {

        boolean quit = false;

        startPhone();
        printActions();

        while (!quit) {
            System.out.println("Enter action: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }

    private static void startPhone() {
        System.out.println("Starting phone");
    }

    private static void printActions() {
        System.out.println("\nAvailable options:\npress");
        System.out.println("0 - to quit");
        System.out.println("1 - to print a list of contacts");
        System.out.println("2 - to add a new contact");
        System.out.println("3 - to update a contact");
        System.out.println("4 - to remove a contact");
        System.out.println("5 - to info if exists");
        System.out.println("6 - to print a list of actions");
        System.out.println("Choose your action: ");
    }

     private static void addNewContact() {
        System.out.println("Enter a name");
        String name = scanner.nextLine();
        System.out.println("Enter a number");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("Contact added.");
        } else {
            System.out.println("Cannot add, " + name + " already on file.");
        }
    }

    private static void updateContact() {

        System.out.println("Enter contact name:");

        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);

        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter a new name");
        String newName = scanner.nextLine();
        System.out.println("Enter a new number");
        String newNumber = scanner.nextLine();

        Contact newContact = Contact.createContact(newName, newNumber);

        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record");
        }
    }

    private static void removeContact() {

        System.out.println("Enter contact name to DELETE:");

        String name = scanner.nextLine();
        //find contact to delete:
        Contact contactToDelete = mobilePhone.queryContact(name);

        if (contactToDelete == null) {
            System.out.println("Contact not found");
            return;
        }

        if (mobilePhone.removeContact(contactToDelete)){
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }

    }

    private static void queryContact() {

        System.out.println("Enter contact name to show query:");

        String name = scanner.nextLine();
        //find contact:
        Contact contactToShow = mobilePhone.queryContact(name);

        if (contactToShow == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name: " + contactToShow.getName());
        System.out.println("Phone: " + contactToShow.getPhoneNumber());

    }


}
