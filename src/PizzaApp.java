public class PizzaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizzeria pizzeria = new Pizzeria();

        // Создаем некоторые пиццы
        Pizza margherita = new Pizza("Маргарита", 8.5);
        Pizza pepperoni = new Pizza("Пепперони", 10.0);

        System.out.println("Добро пожаловать в пиццерию!");

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Сделать заказ");
            System.out.println("2. Обработать следующий заказ");
            System.out.println("3. Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Введите ваше имя:");
                    String name = scanner.nextLine();
                    User user = new User(name);

                    System.out.println("Выберите пиццу: 1. Маргарита 2. Пепперони");
                    int pizzaChoice = scanner.nextInt();
                    scanner.nextLine();

                    Pizza selectedPizza;
                    if (pizzaChoice == 1) {
                        selectedPizza = margherita;
                    } else if (pizzaChoice == 2) {
                        selectedPizza = pepperoni;
                    } else {
                        System.out.println("Некорректный выбор, заказ отменен.");
                        continue;
                    }

                    pizzeria.createOrder(user, selectedPizza);
                    break;

                case 2:
                    pizzeria.processNextOrder();
                    break;

                case 3:
                    System.out.println("Спасибо за визит!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Некорректный выбор, попробуйте снова.");
            }
        }
    }
}