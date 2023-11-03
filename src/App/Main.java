package App;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final int RANGE_1 = 10000;//грн
    private static final int RANGE_2 = 25000;//грн
    private static final String CURRENCY = "грн";


    static double salary;// дохід працівника
    static double taxDegree;// відсоток залежить від доходу
    static double taxAmount;// сума податку
    static String inputText;//данні введені користувачем

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        System.out.print("Введіть суму доходу: ");
        inputText = scanner.nextLine();


        inputText = inputText.trim();//якщо є по крайні пробіли, обрізаю їх

        //конвертую String to Double
        //Використовую блок try catch для захисту від некоректних данних введенних користувачем
        try {
            salary = Double.parseDouble(inputText);
        } catch (NumberFormatException e) {
            salary = -1;//користувач ввів не число, тому я навмисне провокую подальший вивід
            // повідомлення про некоректні данні
        }


        if (salary >= 0 & salary <= RANGE_1)
            taxDegree = 2.5f;
        else if (salary > RANGE_1 & salary <= RANGE_2)
            taxDegree = 4.3f;
        else if (salary > RANGE_2)
            taxDegree = 6.7f;

        else
            taxDegree = -1;


        if (taxDegree > 0) {
            taxAmount = (salary * taxDegree) / 100;//Розраховую суму податку
            System.out.printf("%nСума податків від %s %s. за ставкою %.1f%% = %.2f %s.%n",
                    inputText, CURRENCY, taxDegree, taxAmount, CURRENCY);
        } else
            System.out.printf("%nВи ввели некоректні данні: %s%n", inputText);
        scanner.close();
    }
}
