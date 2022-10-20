package DefiningClasses.Google;

public class Children {
    private String childName;
    private String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    public String toString() {
        return childName + " " + childBirthday + "\n";
    }
}
