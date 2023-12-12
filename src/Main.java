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
                    break;
                }
                case 2: {
                    task2();
                    break;
                }
                case 3: {
                    task3();
                    break;
                }
                case 4: {
                    task4();
                }
                case 5: {
                    task5();
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

    public static void task3() {
        Scanner scanner = new Scanner(System.in);

        //Ввод текста
        System.out.print("Введите текст для обработки: ");
        String text = scanner.nextLine();

        //Ввод слова для поиска
        System.out.print("Введите слово для поиска: ");
        String wordForSearching = scanner.nextLine();

        //Ввод слова для замены
        System.out.print("Введите слово для замены: ");
        String wordForChange = scanner.nextLine();

        //Массив для хранения слов, полученных из введенного текста, путём разделения
        String[] textArr = text.split(",\\s|\\s");

        //Переменная для хранения результата
        StringBuilder resultStr = new StringBuilder();

        //Алгоритм поиска wordForChange в строке
        for (String arrWord : textArr) {
            if (arrWord.equals(wordForSearching)) {
                arrWord = wordForChange;
                resultStr.append(arrWord).append(" ");
            } else {
                resultStr.append(arrWord).append(" ");
            }
        }

        //Вывод результата
        System.out.println(resultStr);

    }

    //Пользователь вводит с клавиатуры строку. Проверьте
    //является ли введенная строка палиндромом. Палинслева направо и справа налево. Например, кок; А роза
    //упала на лапу Азора; доход; А буду я у дуба.
    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        //Ввод текста
        System.out.print("Введите текст для проверки на принадлежность палиндрому: ");
        String text = scanner.nextLine();

        //Массив для хранения слов, полученных из введенного текста, путём разделения
        String[] textArr = text.split(",\\s|\\s");

        //Переменная, для хранения строки без пробелов
        StringBuilder textWithoutSpaces = new StringBuilder();
        StringBuilder reversedText = new StringBuilder();

        for (String s : textArr) {
            textWithoutSpaces.append(s);
        }

        for (int i = textWithoutSpaces.length(); i > 0; i--) {
            reversedText.append(textWithoutSpaces.charAt(i - 1));
        }

        //Вывод получившихся значений в консоль
        System.out.println(reversedText);
        System.out.println(textWithoutSpaces);

        //Проверка на полиндром
        if (reversedText.compareTo(textWithoutSpaces) == 0) {
            System.out.println("Введенная строка является палиндромом!");
        } else {
            System.out.println("Введенная строка не является палиндромом!");
        }
    }

    public static void task5() {
        //Есть некоторый текст. Реализуйте следующую функциональность
        //■ Изменить текст таким образом, чтобы каждое предложение начиналось с большой буквы;
        //■ Посчитайте сколько раз цифры встречаются в тексте;
        //■ Посчитайте сколько раз знаки препинания встречаются в тексте;
        //■ Посчитайте количество предложений в тексте
        String text = "пользователь вводит с клавиатуры строку. проверьте яв1111ляется ли введенная строка палиндромом. палинслева направо и справа налево. например, кок; А роза упала на лапу Азора; доход; А буду я у дуба";
//        String textWithoutSpaces = text.replace(" ", "");
//        System.out.println(textWithoutSpaces);
        StringBuilder resultString = new StringBuilder();

        int numsCounter = 0;
        int letterCounter = 0;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                numsCounter++;
            }
            if (!Character.isLetter(text.charAt(i))) {
                letterCounter++;
            }
            if (i == 0) {
                resultString.append(Character.toUpperCase(text.charAt(i)));
            }

            if (i < 2 && i != 0) {
                resultString.append(text.charAt(i));
            }

            if (i >= 2) {
                if (text.charAt(i - 2) == '.') {
                    resultString.append(Character.toUpperCase(text.charAt(i)));
                } else {
                    resultString.append(text.charAt(i));
                }
            }
        }
        System.out.println(resultString);
        System.out.println("Знаков препинания: " + letterCounter);
        System.out.println("Цифр: " + numsCounter);
    }
}
