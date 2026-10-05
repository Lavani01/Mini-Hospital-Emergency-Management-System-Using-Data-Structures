package hospital;

public class StackTest {

    public static void main(String[] args) {

        // Create treatment stack
        TreatmentStack treatmentStack = new TreatmentStack(5);

        // Create treatment records
        TreatmentRecord t1 = new TreatmentRecord(
                1001,
                "Nimal Silva",
                "Dr. Perera",
                "Medication and observation",
                "2026-09-07"
        );

        TreatmentRecord t2 = new TreatmentRecord(
                1002,
                "Saman Kumara",
                "Dr. Fernando",
                "Cardiac examination",
                "2026-09-07"
        );

        TreatmentRecord t3 = new TreatmentRecord(
                1003,
                "Kasun Perera",
                "Dr. Silva",
                "Fever treatment",
                "2026-09-07"
        );

        // Push treatment records
        System.out.println("Adding completed treatments...\n");

        treatmentStack.push(t1);
        treatmentStack.push(t2);
        treatmentStack.push(t3);

        // Display stack
        treatmentStack.displayStack();

        // Pop most recent treatment
        System.out.println("\nRemoving most recent treatment...\n");

        TreatmentRecord removed = treatmentStack.pop();

        if (removed != null) {

            System.out.println("Removed treatment:");
            removed.displayTreatment();
        }

        // Display remaining records
        System.out.println("\nTreatment history after POP:");

        treatmentStack.displayStack();

        // Remove remaining records
        System.out.println("\nRemoving remaining treatment records...\n");

        treatmentStack.pop();
        treatmentStack.pop();

        // Test empty stack
        System.out.println("\nTrying to POP from an empty stack:");

        treatmentStack.pop();
    }
}