package DesignPatterns.Plan;

abstract class Task {
    public final void execute() {
        auditTrail();
        doExecute();
    }

    private void auditTrail() {
        System.out.println("Audit trail: Task executed.");
    }

    protected abstract void doExecute();
}

class TransferMoneyTask extends Task {
    @Override
    protected void doExecute() {
        System.out.println("Transferring money...");
    }
}

class GenerateReportTask extends Task {
    @Override
    protected void doExecute() {
        System.out.println("Generating report...");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        Task task = new TransferMoneyTask();
        task.execute();

        Task reportTask = new GenerateReportTask();
        reportTask.execute();
    }
}