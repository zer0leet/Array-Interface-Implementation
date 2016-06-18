package com.leapfrog.aii;

import com.leapfrog.aii.DAOImpl.PersonsDAOImpl;
import com.leapfrog.aii.entity.Persons;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PersonsDAOImpl pdao = new PersonsDAOImpl();
        System.out.println("Lets start the procedure ");
        while (true) {
            System.out.println("1. Add new Record \n2. Delete a record \n3. Update \n4. Search by ID \n5 .Search by any (first, last, full name, email, address ) \n6. Print all datas \n7. Exit the Program");
            System.out.print("Now please enter one of the options : ");
            int input = sc.nextInt();
            System.out.println("- - - - - - - - - -");

            switch (input) {
                case 1: {
                    while (true) {
                        int idd = pdao.getID();
                        System.out.print("Enter the first name : ");
                        String fstNme = sc.next();
                        System.out.print("Enter the last name : ");
                        String lstNme = sc.next();
                        System.out.print("Enter the email address : ");
                        String eml;
                        while (true) {
                            eml = sc.next();
                            if (!pdao.doesEmailExists(eml)) {
                                break;
                            }
                            System.out.print("Not valid, already registered, Enter a new Email address : ");
                        }

                        System.out.print("Enter the address : ");
                        String add = sc.next();
                        pdao.insert(new Persons(idd, fstNme, lstNme, eml, add));
                        System.out.println("- - - - - - - - - - - - - - - - - - - - ");
                        System.out.println("Do you Want to add more datas [y/n] ? : ");
                        String yon = sc.next();
                        if (yon.equalsIgnoreCase("n")) {
                            break;
                        }

                    }
                    break;
                }

                case 2: {
                    while (true) {
                        System.out.println("Enter the id to be deleted : ");
                        int id = sc.nextInt();
                        System.out.print("Are you sure you want to delete the " + id + " ID [y/n] ? :  ");
                        String yon = sc.next();
                        if (yon.equalsIgnoreCase("y")) {
                            System.out.println(pdao.delete(id));
                            System.out.println("- - - - - - - - - - - - - - - - - - - - ");

                        }
                        System.out.print("Do you want to continue deleting records [Y/N] ? : ");
                        String yon2 = sc.next();
                        if (yon2.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    break;

                }

                case 3: {
                    System.out.println("Enter the id to be updated : ");
                    int idd = sc.nextInt();
                    System.out.println(pdao.update(idd));
                    System.out.println("- - - - - - - - - - - - - - - - - - - - ");
                    break;
                }

                case 4: {
                    System.out.print("Enter the id to be searched : ");
                    int id = sc.nextInt();
                    if(pdao.getById(id) != null) {
                     System.out.println((pdao.getById(id)).getFullInfo());
                    } else {
                        System.out.println("Record does not exist");
                    }
                        System.out.println("- - - - - - - - - - - - - - - - - - - - ");

                    break;

                }

                case 5: {
                    System.out.print("Enter any field's string to be searched by : ");
                    String s = sc.next();
                    pdao.getByAny(s);
                    System.out.println("- - - - - - - - - - - - - - - - - - - - ");

                    break;
                }

                case 6: {
                    ArrayList<Persons> plist = pdao.getAll();
                    for (Persons p : plist) {
                        System.out.println(p.getFullInfo());

                    }

                    System.out.println("- - - - - - - - - - - - - - - - - - - - ");

                    break;
                }

                case 7: {
                    System.exit(0);

                }

                default:
                    System.out.println("you entered the wrong choice :) ");
                    System.out.println("- - - - - - - - - - - - - - - - - - - - ");

            }

        }

    }

}
