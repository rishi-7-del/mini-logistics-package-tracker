package tracker.engine;

import tracker.model.Package;
import tracker.thread.DeliveryThread;

import java.util.*;

public class TrackingSystem {

    private List<Package> packages;

    public TrackingSystem(List<Package> packages) {
        this.packages = packages;
    }

    public void displayAllPackages() {
    System.out.println("\nCURRENT STATUS:");
    System.out.println("--------------------------------------------------------------------------");

    // Header
    System.out.printf("%-6s %-20s %-15s %-10s %-20s\n",
            "ID", "Name", "City", "Type", "Status");

    System.out.println("--------------------------------------------------------------------------");

    // Data
    for (Package p : packages) {
        System.out.printf("%-6s %-20s %-15s %-10s %-20s\n",
                p.getId(),
                p.getCustomerName(),
                p.getDestination(),
                p.getDeliveryType(),
                p.getStatus());
    	}
    }

    public void searchPackage(String id) {
        for (Package p : packages) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.println("\nFound:");
                System.out.println(p);
                return;
            }
        }
        System.out.println("Not found!");
    }

    public void movePackageForward(String id) {
        for (Package p : packages) {
            if (p.getId().equalsIgnoreCase(id)) {

                DeliveryThread t = new DeliveryThread(p);
                t.start();

                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Updated:");
                System.out.println(p);
                return;
            }
        }
        System.out.println("Package not found!");
    }

    public void filterByStatus(String statusInput) {
        boolean found = false;

        for (Package p : packages) {
            if (p.getStatus().toString().equalsIgnoreCase(statusInput)) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No packages found.");
        }
    }

    public void addPackage(String id, String name, String destination, String type) {
        packages.add(new Package(id, name, destination, type));
        System.out.println("Package added!");
    }
}