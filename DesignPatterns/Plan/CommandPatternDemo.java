package DesignPatterns.Plan;


interface Command {
    void execute();
}

class CustomerService {
    public void addCustomer() {
        System.out.println("Customer added.");
    }
}

class AddCustomerCommand implements Command {
    private CustomerService service;

    public AddCustomerCommand(CustomerService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.addCustomer();
    }
}

class Button {
    private Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}

public class CommandPatternDemo {
    public static void main(String[] args) {
        CustomerService service = new CustomerService();
        Command command = new AddCustomerCommand(service);
        Button button = new Button(command);

        button.click(); 
    }
}