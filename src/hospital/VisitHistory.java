package hospital;

public class VisitHistory {

    private VisitNode head;

    // Add a new visit
    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
        } else {

            VisitNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println(
            "Visit " + visit.getVisitId() +
            " added successfully."
        );
    }

    // Search for a visit
    public Visit searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // Remove a visit
    public void removeVisit(int visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        // Remove first visit
        if (head.visit.getVisitId() == visitId) {

            head = head.next;

            System.out.println(
                "Visit " + visitId +
                " removed successfully."
            );

            return;
        }

        VisitNode current = head;

        while (current.next != null) {

            if (current.next.visit.getVisitId() == visitId) {

                current.next = current.next.next;

                System.out.println(
                    "Visit " + visitId +
                    " removed successfully."
                );

                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    // Display all visits
    public void displayHistory() {

        if (head == null) {
            System.out.println("No previous visits available.");
            return;
        }

        System.out.println("\nPatient Visit History");
        System.out.println("----------------------------------------");

        VisitNode current = head;

        while (current != null) {

            current.visit.displayVisit();

            current = current.next;
        }
    }

    // Check whether history is empty
    public boolean isEmpty() {
        return head == null;
    }
}