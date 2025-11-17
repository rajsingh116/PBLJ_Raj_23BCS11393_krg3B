class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class CustomExceptionDemo {

    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is below 18 — Not Allowed!");
        } else {
            System.out.println("Age is valid — Access Granted.");
        }
    }
    public static void main(String[] args) {
        try {
            checkAge(20);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
