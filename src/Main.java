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
                    break;
                }
                case 5: {
                    task5();
                    break;
                }
                case 6: {
                    task6();
                    break;
                }
                case 7: {
                    task7();
                    break;
                }
                case 8: {
                    task8();
                    break;
                }
                case 9: {
                    task9();
                    break;
                }
                case 10: {
                    task10();
                    break;
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
        System.out.println("Введенное слово встречается: " + repeatCounter + " раз.");
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

    public static void task6() {
        //Пользователь с клавиатуры вводит элементы одномерного массива. Необходимо найти сумму элементов
        //массива, среднеарифметическое, отобразить на экран все
        //элементы массива
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числа через пробел: ");
        String nums = scanner.nextLine();

        //Преобразование строки в массив
        String[] stringsArr = nums.split(" ");

        //переменные для хранения результатов
        int resultSum = 0;
        int average = 0;

        //алгоритм подсчета результатов
        for (String s : stringsArr) {
            resultSum += Integer.parseInt(s);
            average = resultSum / stringsArr.length;
        }

        //Вывод результатов
        System.out.println("Сумма элементов массива равна: " + resultSum);
        System.out.println("Среднее арифметическое элементов массива: " + average);
    }

    public static void task7() {
        //Пользователь с клавиатурывводит элементыодномерного массива и некоторое число. Необходимо посчитать
        //сколько раз данное число присутствует в массиве.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числа через пробел: ");
        String nums = scanner.nextLine();
        System.out.print("Введите число для поиска: ");
        int numberToSearch = scanner.nextInt();

        //Преобразование строки в массив
        String[] stringsArr = nums.split(" ");

        //Счетчик повторений
        int counter = 0;

        //Алгоритм поиска числа по массиву
        for (String s : stringsArr) {
            if (Integer.parseInt(s) == numberToSearch) {
                counter++;
            }
        }

        //Вывод результатов
        if (counter > 4) {
            System.out.println("Введенное число повторяется: " + counter + " раз.");
        } else System.out.println("Введенное число повторяется: " + counter + " раза.");
    }

    public static void task8() {
        //В одномерном массиве, заполненном случайными
        //числами, определить минимальный и максимальный
        //элементы, посчитать количество отрицательных элементов, посчитать количество положительных элементов,
        //посчитать количество нулей. Результаты вывести на
        //экран.
        // Генерация случайного целого числа в диапазоне от min до max (включительно)

        //Пустой массив для наполнения случайными числами
        int[] numsArr = new int[10];

        //Наполнение массива
        for (int i = 0; i < numsArr.length; i++) {
            numsArr[i] = randomNumber();
        }

        Arrays.sort(numsArr);

        //Переменные для хранения результов
        int minNum = numsArr[0];
        int maxNum = numsArr[numsArr.length - 1];
        int negativeNumsCounter = 0;
        int positiveNumsCounter = 0;
        int zerosCounter = 0;

        //Алгоритм подсчета положительных и отрицательных чисел
        for (int i = 0; i < numsArr.length; i++) {
            if (numsArr[i] < 0) {
                negativeNumsCounter++;
            } else if (numsArr[i] > 0) {
                positiveNumsCounter++;
            } else if (numsArr[i] == 0) {
                zerosCounter++;
            }
        }

        //Вывод результатов
        System.out.println(Arrays.toString(numsArr));
        System.out.println("Минимальное значение в массиве: " + minNum
                + "\n" + "Максимальное значение в массиве: " + maxNum
                + "\n" + "Количесто отрицательных чисел: " + negativeNumsCounter
                + "\n" + "Количество положительных чисел: " + positiveNumsCounter
                + "\n" + "Количество нулей: " + zerosCounter
        );
    }

    public static void task9() {
        //В одномерном массиве, заполненном случайными
        //числами вычислить:
        //■ Сумму отрицательных чисел;
        //■ Сумму четных чисел;
        //■ Сумму нечетных чисел;
        //■ Произведение элементов с индексами кратными 3;
        //■ Произведение элементов между минимальным и максимальным элементом;
        //■ Сумму элементов, находящихся между первым и последним положительными элементами.

        //Пустой массив для наполнения случайными числами
        int[] numsArr = new int[10];

        //Наполнение массива
        for (int i = 0; i < numsArr.length; i++) {
            numsArr[i] = randomNumber();
        }

        //Переменные для хранения результатов
        int sumOfNegativeNumbers = 0;
        int sumOfEvenNumbers = 0;
        int sumOfOddNumbers = 0;
        int productOfThirdNumbers = 1;
        int productOfFirstAndLastItems = 1;
        int sumOfItemsBetweenFirstAndLast = 0;

        //Алгоритм вычисления результатов
        for (int i = 0; i < numsArr.length; i++) {
            if (numsArr[i] < 0) {
                sumOfNegativeNumbers += numsArr[i];
            }
            if (i / 2 == 0 && i > 1) {
                sumOfEvenNumbers += numsArr[i];
            }
            if (i / 2 != 0 || i == 1) {
                sumOfOddNumbers += numsArr[i];
            }
            if (i / 3 == 0 && i != 0) {
                productOfThirdNumbers = productOfThirdNumbers * numsArr[i];
            }
            if (i == 0 || i == numsArr.length - 1) {
                productOfFirstAndLastItems = productOfFirstAndLastItems * numsArr[i];
            }
            if (i > 0 && i < numsArr.length - 1) {
                sumOfItemsBetweenFirstAndLast += numsArr[i];
            }
        }

        //Вывод результатов
        System.out.println(Arrays.toString(numsArr));
        System.out.println("Сумма отрицательных чисел: " + sumOfNegativeNumbers
                + "\n" + "Сумма чётных чисел: " + sumOfEvenNumbers
                + "\n" + "Сумма нечетных чисел" + sumOfOddNumbers
                + "\n" + "Произведение каждого третьего числа: " + productOfThirdNumbers
                + "\n" + "Сумма элементов между первым и последним: " + sumOfItemsBetweenFirstAndLast
        );
    }

    public static void task10() {
        //Есть одномерный массив, заполненный случайными
        //числами. На основании данных этого массива нужно:
        //■ Создать одномерный массив, содержащий только
        //четные числа из первого массива;
        //■ Создать одномерный массив, содержащий только
        //нечетные числа из первого массива;
        //■ Создать одномерный массив, содержащий только
        //отрицательные числа из первого массива;
        //■ Создать одномерный массив, содержащий только
        //положительные числа из первого массива

        //Пустой массив для наполнения случайными числами
        int[] numsArr = new int[10];

        //Наполнение массива
        for (int i = 0; i < numsArr.length; i++) {
            numsArr[i] = randomNumber();
        }

        //Пустые массивы для хранения результатов
        int[] evenNumsArr = new int[numsArr.length];
        int[] oddNumsArr = new int[numsArr.length];
        int[] negativeNumsArr = new int[numsArr.length];
        int[] positiveNumsArr = new int[numsArr.length];

        //Формирование результатов
        for (int i = 0; i < numsArr.length; i++) {
            if (numsArr[i] % 2 == 0) {
                evenNumsArr[i] = numsArr[i];
            }
            if (numsArr[i] % 2 != 0) {
                oddNumsArr[i] = numsArr[i];
            }
            if (numsArr[i] < 0) {
                negativeNumsArr[i] = numsArr[i];
            }
            if (numsArr[i] > 0) {
                positiveNumsArr[i] = numsArr[i];
            }
        }

        //Вывод результатов
        System.out.println(Arrays.toString(numsArr));
        System.out.println("Массив, содержащий чётные числа: " + Arrays.toString(evenNumsArr));
        System.out.println("Массив, содержащий нечётные числа: " + Arrays.toString(oddNumsArr));
        System.out.println("Массив, содержащий отрицательные числа: " + Arrays.toString(negativeNumsArr));
        System.out.println("Массив, содержащий положительные числа: " + Arrays.toString(positiveNumsArr));
    }

    //Метод для получения случайного числа
    public static int randomNumber() {
        int min = -100;
        int max = 100;

        // Формула для получения случайного целого числа в указанном диапазоне
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
