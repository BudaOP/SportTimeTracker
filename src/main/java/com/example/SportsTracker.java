package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SportsTracker {
    private static class Activity {
        String sport;
        int duration;

        public Activity(String sport, int duration) {
            this.sport = sport;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return sport + " - " + duration + " minutes";
        }
    }

    private List<Activity> activities;

    public SportsTracker() {
        activities = new ArrayList<>();
    }

    public void addActivity(String sport, int duration) {
        activities.add(new Activity(sport, duration));
        System.out.println("Activity added: " + sport + " (" + duration + " min)");
    }

    public void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged yet.");
            return;
        }
        System.out.println("\nLogged activities:");
        for (Activity activity : activities) {
            System.out.println(activity);
        }
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public int calculateTotalTime() {
        return activities.stream().mapToInt(a -> a.duration).sum();
    }

    public void getTotalTime() {
        System.out.println("\nTotal time spent on sports: " + calculateTotalTime() + " minutes");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SportsTracker tracker = new SportsTracker();

        while (true) {
            System.out.println("\nSports Time Tracker");
            System.out.println("1. Log activity");
            System.out.println("2. View activities");
            System.out.println("3. Total time spent");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter sport name: ");
                    String sport = scanner.nextLine();
                    System.out.print("Enter duration (minutes): ");
                    int duration = scanner.nextInt();
                    tracker.addActivity(sport, duration);
                    break;
                case 2:
                    tracker.viewActivities();
                    break;
                case 3:
                    tracker.getTotalTime();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
