import java.nio.file.Files;
import java.util.HashMap;

public class CustomerStorage
{
    private final String REGEX_EMAIL = "^([A-z0-9_.-]+@[0-9a-z.-]+\\.[a-z]{2,6})$"; // создаем константу для проверки введенного email
    private final String REGEX_PHONE_NUMBER = "^\\+79\\d{9}$"; // создаем константу для проверки введенного номера телефона

    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }


    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new ArrayIndexOutOfBoundsException("Wrong format. Correct format: add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (!components[3].matches(REGEX_PHONE_NUMBER) && !components[2].matches(REGEX_EMAIL)) {
            throw new IllegalArgumentException("Wrong format email and phone number.\n" +
                    "Correct format: phone number - (11 digits) +79999999999\n" +
                    "email - Only latin letters, numbers, underscore (\"_\"), point (\".\"), minus (\"-\") are allowed.");
        }
        if (!components[3].matches(REGEX_PHONE_NUMBER)) {
            throw new IllegalArgumentException("Invalid phone number. Try again. Correct format number (11 digits) +79999999999");
        }
        if (!components[2].matches(REGEX_EMAIL)) {
            throw new IllegalArgumentException("Invalid email. Try again. Only latin letters, numbers, underscore (\"_\"), point (\".\"), minus (\"-\") are allowed.");
        }

        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }



    public void listCustomers() throws Exception {
        if (storage.isEmpty()) {
            throw new Exception("List customers is empty.");
        }
        storage.values().forEach(System.out::println);
    }



    public void removeCustomer(String name)
    {
        if (!storage.containsKey(name)) {
            throw new IllegalArgumentException("This customer does not exist in the database.");
        }
        storage.remove(name);
    }



    public int getCount() throws Exception {
        if (storage.size() == 0) {
            throw new Exception("No customer added.");
        }
        return storage.size();
    }
}