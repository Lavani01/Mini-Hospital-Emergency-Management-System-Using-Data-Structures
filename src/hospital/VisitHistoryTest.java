package hospital;

public class VisitHistoryTest {

    public static void main(String[] args) {

        VisitHistory history = new VisitHistory();

        // Create visits
        Visit visit1 = new Visit(
                501,
                "2026-06-10",
                "Dr. Perera",
                "Fever",
                "Medication"
        );

        Visit visit2 = new Visit(
                502,
                "2026-07-05",
                "Dr. Fernando",
                "Headache",
                "Pain relief treatment"
        );

        Visit visit3 = new Visit(
                503,
                "2026-08-15",
                "Dr. Silva",
                "Asthma",
                "Inhaler treatment"
        );

        // Add visits
        System.out.println("Adding patient visits...\n");

        history.addVisit(visit1);
        history.addVisit(visit2);
        history.addVisit(visit3);

        // Display
        history.displayHistory();

        // Search
        System.out.println("\nSearching for Visit ID 502...");

        Visit found = history.searchVisit(502);

        if (found != null) {
            System.out.println("Visit found:");
            found.displayVisit();
        } else {
            System.out.println("Visit not found.");
        }

        // Remove
        System.out.println("\nRemoving Visit ID 502...");

        history.removeVisit(502);

        // Display after removal
        System.out.println("\nHistory after removal:");

        history.displayHistory();

        // Test empty history
        System.out.println("\nRemoving remaining visits...");

        history.removeVisit(501);
        history.removeVisit(503);

        System.out.println("\nDisplaying empty history:");

        history.displayHistory();
    }
}