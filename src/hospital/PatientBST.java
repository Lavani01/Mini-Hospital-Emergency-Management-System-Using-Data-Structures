package hospital;

public class PatientBST {

    private PatientNode root;

    // Insert a new patient
    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    private PatientNode insertRecursive(PatientNode current, Patient patient) {

        if (current == null) {
            return new PatientNode(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRecursive(current.left, patient);
        }
        else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertRecursive(current.right, patient);
        }
        else {
            System.out.println("Patient ID already exists.");
        }

        return current;
    }

    // Search for a patient
    public Patient search(int patientId) {

        PatientNode result = searchRecursive(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private PatientNode searchRecursive(PatientNode current, int patientId) {

        if (current == null ||
            current.patient.getPatientId() == patientId) {

            return current;
        }

        if (patientId < current.patient.getPatientId()) {
            return searchRecursive(current.left, patientId);
        }

        return searchRecursive(current.right, patientId);
    }

    // Delete a patient
    public void delete(int patientId) {

        if (search(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        root = deleteRecursive(root, patientId);
        System.out.println("Patient deleted successfully.");
    }

    private PatientNode deleteRecursive(PatientNode current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId < current.patient.getPatientId()) {

            current.left = deleteRecursive(current.left, patientId);

        }
        else if (patientId > current.patient.getPatientId()) {

            current.right = deleteRecursive(current.right, patientId);

        }
        else {

            // Case 1: No child
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (current.left == null) {
                return current.right;
            }

            // Case 3: Only left child
            if (current.right == null) {
                return current.left;
            }

            // Case 4: Two children
            PatientNode successor = findMinimum(current.right);

            current.patient = successor.patient;

            current.right =
                deleteRecursive(current.right,
                                successor.patient.getPatientId());
        }

        return current;
    }

    // Find the smallest node
    private PatientNode findMinimum(PatientNode current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // In-order traversal
    public void inOrderTraversal() {

        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }

        System.out.println("\nPatients in Ascending Patient ID Order");
        System.out.println("----------------------------------------");

        inOrderRecursive(root);
    }

    private void inOrderRecursive(PatientNode current) {

        if (current != null) {

            inOrderRecursive(current.left);

            current.patient.displayPatient();

            inOrderRecursive(current.right);
        }
    }
}