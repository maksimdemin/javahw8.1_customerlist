import java.util.Scanner;

public class Main
{
    private static String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static String  helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        for(;;)
        {
            try {
                String command = scanner.nextLine().trim();
                    String[] tokens = command.split("\\s+", 2);
                if (tokens[0].equals("add")) {
                    if (tokens.length != 2) {
                    throw new ArrayIndexOutOfBoundsException("Wrong format. Correct format: add Василий Петров vasily.petrov@gmail.com +79215637722");
                }
//                    try {
                        executor.addCustomer(tokens[1]);
//                    } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException ex) {
//                        System.out.println(ex.getMessage());
//                    }
                }
                else if (tokens[0].equals("list")) {
//                    try {
                        executor.listCustomers();
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
                } else if (tokens[0].equals("remove")) {
//                    try {
                        executor.removeCustomer(tokens[1]);
//                    } catch (ArrayIndexOutOfBoundsException ex) {
//                        System.out.println("Wrong format. Correct format: remove Василий Петров");
//                    } catch (IllegalArgumentException ex) {
//                        System.out.println(ex.getMessage());
//                    }
                } else if (tokens[0].equals("count")) {
//                    try {
                        System.out.println("There are " + executor.getCount() + " customers");
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
                } else if (tokens[0].equals("help")) {
                    System.out.println(helpText);
                } else {
                    System.out.println(commandError);
                }
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
