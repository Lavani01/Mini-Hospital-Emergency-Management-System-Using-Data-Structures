package hospital;

public class PatientQueue {

    private Patient[] queue;
    private int front;
    private int rear;
    private int size;

    // Constructor
    public PatientQueue(int capacity) {
        queue = new Patient[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue - add patient to the queue
    public void enqueue(Patient patient) {

        if (isFull()) {
            System.out.println("Emergency queue is full.");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = patient;
        size++;

        System.out.println(
            "Patient " + patient.getPatientId() +
            " added to the emergency queue."
        );
    }

    // Dequeue - remove the next patient
    public Patient dequeue() {

        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = queue[front];

        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;

        System.out.println(
            "Patient " + patient.getPatientId() +
            " removed from the emergency queue for treatment."
        );

        return patient;
    }

    // Display all waiting patients
    public void displayQueue() {

        if (isEmpty()) {
            System.out.println("No patients are currently waiting.");
            return;
        }

        System.out.println("\nPatients Currently Waiting");
        System.out.println("----------------------------------------");

        int index = front;

        for (int i = 0; i < size; i++) {

            Patient patient = queue[index];

            System.out.println(
                "Patient ID   : " + patient.getPatientId()
            );

            System.out.println(
                "Patient Name : " + patient.getPatientName()
            );

            System.out.println(
                "Condition    : " + patient.getMedicalCondition()
            );

            System.out.println("----------------------------------------");

            index = (index + 1) % queue.length;
        }
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check whether queue is full
    public boolean isFull() {
        return size == queue.length;
    }

    // Return current number of patients
    public int getSize() {
        return size;
    }
}