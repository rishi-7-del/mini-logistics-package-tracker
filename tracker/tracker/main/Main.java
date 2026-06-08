package tracker.main;

import tracker.util.Colors;
import tracker.engine.TrackingSystem;
import tracker.model.Package;
import tracker.util.FileHandler;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\n                        Welcome to\n");

// BIG GREEN LOGISTICS
System.out.println(Colors.GREEN +
"██╗      ██████╗  ██████╗ ██╗███████╗████████╗██╗ ██████╗ ███████╗\n" +
"██║     ██╔═══██╗██╔════╝ ██║██╔════╝╚══██╔══╝██║██╔════╝ ██╔════╝\n" +
"██║     ██║   ██║██║  ███╗██║███████╗   ██║   ██║██║  ███╗███████╗\n" +
"██║     ██║   ██║██║   ██║██║╚════██║   ██║   ██║██║   ██║╚════██║\n" +
"███████╗╚██████╔╝╚██████╔╝██║███████║   ██║   ██║╚██████╔╝███████║\n" +
"╚══════╝ ╚═════╝  ╚═════╝ ╚═╝╚══════╝   ╚═╝   ╚═╝ ╚═════╝ ╚══════╝"+ Colors.RESET);

// NORMAL TEXT BELOW
System.out.println("\n        Management System" + Colors.RED + "  (Package Tracking Module)"+ Colors.RESET);

        Scanner sc = new Scanner(System.in);

        List<Package> packages = FileHandler.loadPackages("packages.txt");
        TrackingSystem system = new TrackingSystem(packages);

        while (true) {
            System.out.println("\n1. View All Packages");
            System.out.println("2. Move Package to Next Step");
            System.out.println("3. Search Package");
            System.out.println("4. Filter by Status");
            System.out.println("5. Add New Package");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    system.displayAllPackages();
                    break;

                case 2:
                    System.out.print("Enter Package ID: ");
                    system.movePackageForward(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter Package ID: ");
                    system.searchPackage(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter status: ");
                    system.filterByStatus(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Destination: ");
                    String dest = sc.nextLine();
                    System.out.print("Enter Type (Normal/Express): ");
                    String type = sc.nextLine();

                    system.addPackage(id, name, dest, type);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}