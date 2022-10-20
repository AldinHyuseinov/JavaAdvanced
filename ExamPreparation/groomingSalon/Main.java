package ExamPreparation.groomingSalon;

public class Main {
    public static void main(String[] args) {
        GroomingSalon salon = new GroomingSalon(20);

        Pet cat1 = new Pet("Rijko", 2, "Koko");

        Pet horse = new Pet("idk just a white horse on the field", 3, "Мангасар с каруца");

        Pet dog = new Pet("Ellias", 5, "Tim");

// Print Pet
        System.out.println(dog); // Ellias 5 - (Tim)

// Add Pet
        salon.add(dog);

// Remove Pet
        System.out.println(salon.remove("Ellias")); // true
        System.out.println(salon.remove("Pufa")); // false

        Pet cat = new Pet("Bella", 2, "Mia");
        Pet bunny = new Pet("Zak", 4, "Jon");

        salon.add(cat);
        salon.add(bunny);

// Get Pet
        Pet pet = salon.getPet("Bella", "Mia");
        System.out.println(pet); // Bella 2 - (Mia)

// Count
        System.out.println(salon.getCount());

// Get Statistics
        System.out.println(salon.getStatistics());

    }
}
