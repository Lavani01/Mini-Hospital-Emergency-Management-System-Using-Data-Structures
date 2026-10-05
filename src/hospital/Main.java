package hospital;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static PatientBST patientBST = new PatientBST();
    private static PatientQueue emergencyQueue = new PatientQueue(20);
    private static TreatmentStack treatmentStack = new TreatmentStack(20);

    private static VisitHistory[] visitHistories = new VisitHistory[100];

    public static void main(String[] args) {

        int choice = -1;

        do {

            displayMenu();

            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    displayAllPatients();
                    break;

                case 5:
                    addToEmergencyQueue();
                    break;

                case 6:
                    treatNextPatient();
                    break;

                case 7:
                    displayWaitingPatients();
                    break;

                case 8:
                    completeTreatment();
                    break;

                case 9:
                    viewTreatmentHistory();
                    break;

                case 10:
                    addPatientVisit();
                    break;

                case 11:
                    removePatientVisit();
                    break;

                case 12:
                    searchPatientVisit();
                    break;

                case 13:
                    displayPatientVisitHistory();
                    break;

                case 0:
                    System.out.println("\nThank you for using the system.");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    // ==========================================
    // MENU
    // ==========================================

    private static void displayMenu() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("   MINI HOSPITAL EMERGENCY MANAGEMENT");
        System.out.println("========================================");
        System.out.println("1. Register New Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. Treat Next Emergency Patient");
        System.out.println("7. Display Waiting Patients");
        System.out.println("8. Complete Treatment");
        System.out.println("9. View Treatment History");
        System.out.println("10. Add Patient Visit");
        System.out.println("11. Remove Patient Visit");
        System.out.println("12. Search Patient Visit");
        System.out.println("13. Display Patient Visit History");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    // ==========================================
    // 1. REGISTER PATIENT
    // ==========================================

    private static void registerPatient() {

        System.out.println("\n--- Register New Patient ---");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (patientBST.search(id) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
            id,
            name,
            age,
            contact,
            condition
        );

        patientBST.insert(patient);

        System.out.println("Patient registered successfully.");
    }

    // ==========================================
    // 2. SEARCH PATIENT
    // ==========================================

    private static void searchPatient() {

        System.out.println("\n--- Search Patient ---");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();

        Patient patient = patientBST.search(id);

        if (patient != null) {
            System.out.println("\nPatient Found");
            System.out.println("----------------------------------------");
            patient.displayPatient();
        } else {
            System.out.println("Patient not found.");
        }
    }

    // ==========================================
    // 3. DELETE PATIENT
    // ==========================================

    private static void deletePatient() {

        System.out.println("\n--- Delete Patient ---");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        patientBST.delete(id);
    }

    // ==========================================
    // 4. DISPLAY ALL PATIENTS
    // ==========================================

    private static void displayAllPatients() {

        System.out.println("\n--- All Registered Patients ---");

        patientBST.inOrderTraversal();
    }

    // ==========================================
    // 5. ADD TO EMERGENCY QUEUE
    // ==========================================

    private static void addToEmergencyQueue() {

        System.out.println("\n--- Add Patient to Emergency Queue ---");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        emergencyQueue.enqueue(patient);
    }

    // ==========================================
    // 6. TREAT NEXT PATIENT
    // ==========================================

    private static void treatNextPatient() {

        System.out.println("\n--- Treat Next Emergency Patient ---");

        Patient patient = emergencyQueue.dequeue();

        if (patient == null) {
            System.out.println("No patients waiting for treatment.");
            return;
        }

        System.out.println("\nNow treating patient:");
        patient.displayPatient();
    }

    // ==========================================
    // 7. DISPLAY WAITING PATIENTS
    // ==========================================

    private static void displayWaitingPatients() {

        System.out.println("\n--- Emergency Waiting Queue ---");

        emergencyQueue.displayQueue();
    }

    // ==========================================
    // 8. COMPLETE TREATMENT
    // ==========================================

    private static void completeTreatment() {

        System.out.println("\n--- Complete Treatment ---");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        System.out.print("Enter Treatment Date: ");
        String date = scanner.nextLine();

        TreatmentRecord record = new TreatmentRecord(
                patient.getPatientId(),
                patient.getPatientName(),
                doctor,
                treatment,
                date
        );

        treatmentStack.push(record);

        System.out.println("Treatment completed successfully.");
    }

    // ==========================================
    // 9. VIEW TREATMENT HISTORY
    // ==========================================

    private static void viewTreatmentHistory() {

        System.out.println("\n--- Treatment History ---");

        treatmentStack.displayStack();
    }

    // ==========================================
    // GET VISIT HISTORY
    // ==========================================

    private static VisitHistory getVisitHistory(int patientId) {

        int index = Math.abs(patientId) % visitHistories.length;

        if (visitHistories[index] == null) {
            visitHistories[index] = new VisitHistory();
        }

        return visitHistories[index];
    }

    // ==========================================
    // 10. ADD PATIENT VISIT
    // ==========================================

    private static void addPatientVisit() {

        System.out.println("\n--- Add Patient Visit ---");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID: ");
        int visitId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
                visitId,
                date,
                doctor,
                diagnosis,
                treatment
        );

        VisitHistory history = getVisitHistory(patientId);

        history.addVisit(visit);
    }

    // ==========================================
    // 11. REMOVE PATIENT VISIT
    // ==========================================

    private static void removePatientVisit() {

        System.out.println("\n--- Remove Patient Visit ---");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID: ");
        int visitId = scanner.nextInt();

        VisitHistory history = getVisitHistory(patientId);

        history.removeVisit(visitId);
    }

    // ==========================================
    // 12. SEARCH PATIENT VISIT
    // ==========================================

    private static void searchPatientVisit() {

        System.out.println("\n--- Search Patient Visit ---");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID: ");
        int visitId = scanner.nextInt();

        VisitHistory history = getVisitHistory(patientId);

        Visit visit = history.searchVisit(visitId);

        if (visit != null) {
            System.out.println("\nVisit Found:");
            visit.displayVisit();
        } else {
            System.out.println("Visit not found.");
        }
    }

    // ==========================================
    // 13. DISPLAY PATIENT VISIT HISTORY
    // ==========================================

    private static void displayPatientVisitHistory() {

        System.out.println("\n--- Patient Visit History ---");

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();

        Patient patient = patientBST.search(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        VisitHistory history = getVisitHistory(patientId);

        history.displayHistory();
    }
}