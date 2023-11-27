import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static boolean continueExecution = true;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (continueExecution) {
            //Task roster
            int numberOfTask = taskRoaster();
            switch (numberOfTask) {
                case 1: {
                    task1();
                }
                case 2: {
                    task2();
                }
                default:
                    System.out.println("\nВыберите задание!");
                    break;
            }
            nextTaskQuestion();
        }
    }

    public static int taskRoaster() {
        System.out.print("Выберите задание для проверки: ");
        return scanner.nextInt();
    }

    public static void nextTaskQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Хотите проверить другую задачу?  Да/Нет: ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("да") || choice.equalsIgnoreCase("yes")) {
            continueExecution = true;
        } else if (choice.equalsIgnoreCase("нет") || choice.equalsIgnoreCase("no")) {
            scanner.close();
            continueExecution = false;
        }
    }

    //Пользователь вводит с клавиатуры строку. Произведите поворот строк и полученный результат выведите
    //на экран.
    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        //Ввод строки
        System.out.print("Введите строку, для переворота: ");
        String str = scanner.next();

        char[] reversedStrArray = new char[str.length()];

        //Посимвольный переворот строки
        for (int i = str.length(); i > 0; i--) {
            reversedStrArray[str.length() - i] = str.charAt(i - 1);
        }

        //Вывод преобразованной строки
        System.out.println(reversedStrArray);
    }

    //Пользователь вводит с клавиатуры строку и слово
    //для поиска. Посчитайте сколько раз в строке встречается
    //искомое слово. Полученное число выведите на экран.
    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        //Вввод текста
        System.out.print("Введите исходный текст: ");
        String str = scanner.nextLine();

        //Ввод слова для поиска в строке
        System.out.print("Введите слово для поиска: ");
        String word = scanner.next();

        //Алгоритм поиска слова в тексте

        //Переменная - счётчик повторений
        int repeatCounter = 0;

        //Разделение на отдельные слова
        StringTokenizer stWithoutSpace = new StringTokenizer(str, " ");

        //Цикл сравнения с искомым словом
        while (stWithoutSpace.hasMoreTokens()) {
            //преобразование слова
            String processedWord = stWithoutSpace.nextToken().replaceAll("\\s|,", "");

            //Увеличение счётчика при повторении слова
            if (processedWord.equals(word)) {
                repeatCounter++;
            }

        }
    }
}
