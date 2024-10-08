public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(15000);

        while (true) {
            try {
                account.withDraw(6000);
                System.out.println("Вы сняли со счёта 6000 сом. Остаток: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                try {
                    account.withDraw((int) e.getRemainingAmount());
                    System.out.println("Вы сняли остаток: " + account.getAmount());
                } catch (LimitException ex) {
                    ex.printStackTrace();
                }
                break;
            }
        }
    }
}