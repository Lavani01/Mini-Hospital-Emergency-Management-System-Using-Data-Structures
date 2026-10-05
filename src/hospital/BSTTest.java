package hospital;

public class BSTTest {

    public static void main(String[] args) {

        PatientBST patientTree = new PatientBST();

        Patient p1 = new Patient(
                1003,
                "Kasun Perera",
                35,
                "0771234567",
                "Fever"
        );

        Patient p2 = new Patient(
                1001,
                "Nimal Silva",
                42,
                "0712345678",
                "Diabetes"
        );

        Patient p3 = new Patient(
                1005,
                "Amal Fernando",
                28,
                "0759876543",
                "Asthma"
        );

        Patient p4 = new Patient(
                1002,
                "Saman Kumara",
                51,
                "0763456789",
                "Heart Condition"
        );

        Patient p5 = new Patient(
                1004,
                "Ruwan Perera",
                24,
                "0784567890",
                "Migraine"
        );

        // Insert patients
        patientTree.insert(p1);
        patientTree.insert(p2);
        patientTree.insert(p3);
        patientTree.insert(p4);
        patientTree.insert(p5);

        // Display patients
        patientTree.inOrderTraversal();

        // Search
        System.out.println("\nSearching for Patient ID 1004...");
        Patient foundPatient = patientTree.search(1004);

        if (foundPatient != null) {
            System.out.println("Patient found:");
            foundPatient.displayPatient();
        }
        else {
            System.out.println("Patient not found.");
        }

        // Delete
        System.out.println("\nDeleting Patient ID 1003...");
        patientTree.delete(1003);

        // Display after deletion
        System.out.println("\nPatients after deletion:");
        patientTree.inOrderTraversal();
    }
}