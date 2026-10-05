package hospital;

public class TreatmentStack {

    private TreatmentRecord[] stack;
    private int top;

    // Constructor
    public TreatmentStack(int capacity) {

        stack = new TreatmentRecord[capacity];
        top = -1;
    }

    // Push - add a completed treatment
    public void push(TreatmentRecord record) {

        if (isFull()) {
            System.out.println("Treatment history stack is full.");
            return;
        }

        top++;
        stack[top] = record;

        System.out.println(
            "Treatment record for Patient " +
            record.getPatientId() +
            " added to treatment history."
        );
    }

    // Pop - remove the most recent treatment
    public TreatmentRecord pop() {

        if (isEmpty()) {
            System.out.println("Treatment history stack is empty.");
            return null;
        }

        TreatmentRecord record = stack[top];

        stack[top] = null;
        top--;

        System.out.println(
            "Most recent treatment record for Patient " +
            record.getPatientId() +
            " removed."
        );

        return record;
    }

    // Display treatment records
    public void displayStack() {

        if (isEmpty()) {
            System.out.println("No treatment records available.");
            return;
        }

        System.out.println("\nTreatment History");
        System.out.println("----------------------------------------");

        // Display from top to bottom
        for (int i = top; i >= 0; i--) {

            stack[i].displayTreatment();
        }
    }

    // Check whether stack is empty
    public boolean isEmpty() {

        return top == -1;
    }

    // Check whether stack is full
    public boolean isFull() {

        return top == stack.length - 1;
    }

    // Return number of records
    public int getSize() {

        return top + 1;
    }
}