package hospital;

public class QueueTest {

    public static void main(String[] args) {

        // Create emergency queue with capacity of 5
        PatientQueue emergencyQueue = new PatientQueue(5);

        // Create patients
        Patient p1 = new Patient(
                1001,
                "Nimal Silva",
                42,
                "0712345678",
                "Diabetes"
        );

        Patient p2 = new Patient(
                1002,
                "Saman Kumara",
                51,
                "0763456789",
                "Heart Condition"
        );

        Patient p3 = new Patient(
                1003,
                "Kasun Perera",
                35,
                "0771234567",
                "Fever"
        );

        // Enqueue patients
        System.out.println("Adding patients to emergency queue...\n");

        emergencyQueue.enqueue(p1);
        emergencyQueue.enqueue(p2);
        emergencyQueue.enqueue(p3);

        // Display queue
        emergencyQueue.displayQueue();

        // Dequeue first patient
        System.out.println("\nProcessing next patient...\n");

        Patient nextPatient = emergencyQueue.dequeue();

        if (nextPatient != null) {
            System.out.println(
                "Now treating: " +
                nextPatient.getPatientName()
            );
        }

        // Display remaining patients
        System.out.println("\nQueue after treatment:");

        emergencyQueue.displayQueue();

        // Dequeue remaining patients
        System.out.println("\nProcessing remaining patients...\n");

        emergencyQueue.dequeue();
        emergencyQueue.dequeue();

        // Test empty queue
        System.out.println("\nTrying to dequeue from empty queue:");

        emergencyQueue.dequeue();
    }
}