import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    /**
     * Форматировать вывод (2 знака после запятой)
     */
    private static String roundTo2(float inputValue) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(inputValue);

    }

    /**
     * Проверка ввода пользователя( целое число)
     */
    private static int getAndCheckInputValueInt(String valueAnnotation) {
        System.out.println(valueAnnotation);
        Scanner in = new Scanner(System.in);
        int userInput = -1;
        if (in.hasNextInt()) {
            userInput = in.nextInt();
            if (userInput < 0) {
                System.out.println("Число должно быть больше нуля");
                userInput = -1;

            }
        } else {
            System.out.println("Значение должно быть целым числом");
        }

        return userInput;
    }

    /**
     * Проверка ввода пользователя(число с плавающей точкой)
     */
    private static float getAndCheckInputValueFloat(String valueAnnotation) {
        System.out.println(valueAnnotation);
        Scanner in = new Scanner(System.in);
        float userInput = -1;
        if (in.hasNextFloat()) {
            userInput = in.nextFloat();
            if (userInput < 0) {
                System.out.println("Число должно быть больше нуля");
                userInput = -1;

            }
        } else {
            System.out.println("Значение должно быть числом с плавающей точкой");
        }

        return userInput;
    }

    /**
     * Найти логарифм по основанию 2 от числа
     */
    private static float log2(float N) {
        return (float) (Math.log(N) / Math.log(2));
    }

    /**
     * Добавить пояснение к результату
     */
    private static String annotateResult(String nameOfTheOutput, float result) {
        return nameOfTheOutput + ": " + roundTo2(result);

    }

    /**
     * Вывести результат в консоль
     */
    private static void printResult(String result) {
        System.out.println(result);
    }

    /**
     * Потенциальный объем программы (задание 1)
     */
    //
    private static float estimatedCodeVolume(int n2) {
        float result = (n2 + 2) * log2(n2 + 2);
        return result;
    }

    /**
     * Потенциальное число ошибок (задание 1)
     */
    private static float estimatedNumberOfErrors(float estimatedCodeVolume, float programmingLanguageTier) {
        return (float) Math.pow(estimatedCodeVolume, 2) / (3000 * programmingLanguageTier);
    }
    //////=========================================================
    // Задание 2
    /////==========================================================

    /**
     * Число модулей программного средства (задание 2)
     */
    private static float numberOfSoftwareModules(int n2) {
        return (float) n2 / 8;
    }

    /**
     * Число модулей программного средства (для многоуровневого ПО) (задание 2)
     */
    private static float numberOfSoftwareModulesMultiLevel(int n2) {
        return (float) ((float) n2 / 8 + n2 / Math.pow(8, 2));
    }

    /**
     * Длина программы (задание 2)
     */
    private static float codeLength(float numberOfSoftwareModules) {
        return 220 * numberOfSoftwareModules + numberOfSoftwareModules * log2(numberOfSoftwareModules);
    }

    /**
     * Найти потенциальный объем программы (задание 2)
     */
    //
    private static float estimatedCodeVolumeTask2(float numberOfSoftwareModules) {

        return numberOfSoftwareModules * 220 * log2(48);
    }

    /**
     * Количество команд ассемблера (задание 2)
     */
    //
    private static float numberOfAssemblyCommands(float codeLength) {

        return 3 * codeLength / 8;
    }

    /**
     * Календарное время программирования (задание 2)
     */
    //
    private static float programmingCalendarTime(float codeLength, int numberOfDevs, int numberOfCommands) {

        return (3 * codeLength / (8 * numberOfDevs * numberOfCommands));
    }

    /**
     * потенциальное число ошибок (задание 2)
     */
    private static float estimatedNumberOfErrorsTask2(float estimatedCodeVolume) {
        return estimatedCodeVolume / 3000;
    }

    /**
     * Начальная надежность ПО (время наработки на отказ) (задание 2)
     */
    private static float solidityOfSoftware(float numberOfHours, float estimatedNumberOfErrors) {
        return (float) (numberOfHours / (2 * Math.log(estimatedNumberOfErrors)));
    }

    //////=========================================================
    // Задание
    /////==========================================================

    public static void programmerRating(
    ) {

        float R0 =
                getAndCheckInputValueFloat("Введите начальный уровень программиста (для задачи =  1000)");
        float programmingLanguageTier =
                getAndCheckInputValueFloat("Введите уровень языка программирования (для задачи =  1,53)");

        int numberOfPrograms = getAndCheckInputValueInt("количество программ написанных программистом");
        //int numberOfPrograms = 4;
        ArrayList<Integer> programsVolumes = new ArrayList<Integer>(0);
        programsVolumes.add(0);
        programsVolumes.add(5);
        programsVolumes.add(7);
        programsVolumes.add(9);
        programsVolumes.add(11);
        ArrayList<Integer> numberOfErrorsInPrograms = new ArrayList<Integer>(0);
        numberOfErrorsInPrograms.add(0);
        numberOfErrorsInPrograms.add(0);
        numberOfErrorsInPrograms.add(2);
        numberOfErrorsInPrograms.add(5);
        numberOfErrorsInPrograms.add(4);
        int orderOfProgram = 1;
        ArrayList<Float> ratingCoef1 = new ArrayList<Float>();
        ArrayList<Float> ratingCoef2 = new ArrayList<Float>();
        ArrayList<Float> ratingCoef3 = new ArrayList<Float>();
        ratingCoef1.add(R0);
        ratingCoef2.add(R0);
        ratingCoef3.add(R0);
        for (int i = 1; i <= numberOfPrograms; i++) {
            float innerPart1 = 0;
            float innerPart2 = 0;
            float innerPart3 = 0;
            for (int j = 1; j <= i; j++) {
                innerPart1 +=
                        programsVolumes.get(j) -
                                (numberOfErrorsInPrograms.get(j) /
                                        (1 / (programmingLanguageTier + ratingCoef1.get(j - 1))));
                innerPart2 +=
                        programsVolumes.get(j) -
                                (numberOfErrorsInPrograms.get(j) /
                                        (1 / (programmingLanguageTier * ratingCoef2.get(j - 1))));
                innerPart3 += programsVolumes.get(j) -
                        (numberOfErrorsInPrograms.get(j) /
                                (1 / programmingLanguageTier + 1 / ratingCoef3.get(j - 1)));
            }
            ratingCoef1.add((float) (ratingCoef1.get(i - 1) * (1 + 0.001 * (innerPart1))));
            ratingCoef2.add((float) (ratingCoef2.get(i - 1) * (1 + 0.001 * (innerPart2))));
            ratingCoef3.add((float) (ratingCoef3.get(i - 1) * (1 + 0.001 * (innerPart3))));
        }
        System.out.println("Полученые результаты для коэффицента 1");
        for (int i = 1; i <= numberOfPrograms; i++) {
            printResult(
                    annotateResult("Итерация № " + i, ratingCoef1.get(i))
            );
        }
        System.out.println("Полученые результаты для коэффицента 2");
        for (int i = 1; i <= numberOfPrograms; i++) {
            printResult(
                    annotateResult("Итерация № " + i, ratingCoef2.get(i))
            );
        }
        System.out.println("Полученые результаты для коэффицента 3");
        for (int i = 1; i <= numberOfPrograms; i++) {
            printResult(
                    annotateResult("Итерация № " + i, ratingCoef3.get(i))
            );
        }
        System.out.println("Исходя из полученных данных вычислим ожидаемое число ошибок");
        float estimatedNumberOfErrorsTask3 = (1 / programmingLanguageTier + 1 / ratingCoef3.get(numberOfPrograms)) * 15;
        printResult(
                annotateResult("Ожидаемое число ошибок: ", estimatedNumberOfErrorsTask3)
        );
    }

    /**
     * Задание №1
     */
    private static void task1() {
        int minimalDifferentOperandsNumber =
                getAndCheckInputValueInt("Введите минимальное число различных операндов (для задачи = 6060)");
        float programmingLanguageTier =
                getAndCheckInputValueFloat("Введите уровень языка программирования (для задачи =  1,53)");
        if (!(minimalDifferentOperandsNumber == -1) && !(programmingLanguageTier == -1)) {

            float estimatedCodeVolumeValue = estimatedCodeVolume(minimalDifferentOperandsNumber);
            float estimatedNumberOfErrorsValue = estimatedNumberOfErrors(estimatedCodeVolumeValue, programmingLanguageTier);
            String estimatedCodeVolumeValueAnnotated =
                    annotateResult("Потенциальный объем программы", estimatedCodeVolumeValue);
            String estimatedNumberOfErrorsValueAnnotated =
                    annotateResult("Потенциальное число ошибок", estimatedNumberOfErrorsValue);
            printResult(estimatedCodeVolumeValueAnnotated);
            printResult(estimatedNumberOfErrorsValueAnnotated);
        }
    }

    /**
     * Задание №2
     */
    private static void task2() {
        int minimalDifferentOperandsNumber = 3000;
        int numberOfDevs = 5;
        int numberOfCommands = 6;

        do {
            minimalDifferentOperandsNumber =
                    getAndCheckInputValueInt("Введите минимальное число различных операндов (для задачи = 6060)");
        } while ((minimalDifferentOperandsNumber == -1));

        do {
            float programmingLanguageTier =
                    getAndCheckInputValueFloat("Введите уровень языка программирования (для задачи =  1,53)");
        } while ((minimalDifferentOperandsNumber == -1));


        do {
            numberOfCommands =
                    getAndCheckInputValueInt(
                            "Введите количество отлаженных в день команд на программиста (10 - 30)");
        }
        while ((numberOfCommands == -1));

        do {
            numberOfDevs = getAndCheckInputValueInt("Введите количество программистов в бригаде");
        } while ((numberOfDevs == -1));


        float numberOfSoftwareModulesValue = numberOfSoftwareModules(minimalDifferentOperandsNumber);
        float numberOfSoftwareModulesMultiLevelValue =
                numberOfSoftwareModulesMultiLevel(minimalDifferentOperandsNumber);
        float codeLengthValue;
        float estimatedCodeVolumeTask2Value;
        if (numberOfSoftwareModulesValue > 8) {
            codeLengthValue = codeLength(numberOfSoftwareModulesMultiLevelValue);
            estimatedCodeVolumeTask2Value = estimatedCodeVolumeTask2(numberOfSoftwareModulesMultiLevelValue);
        } else {
            codeLengthValue = codeLength(numberOfSoftwareModulesValue);
            estimatedCodeVolumeTask2Value = estimatedCodeVolumeTask2(numberOfSoftwareModulesValue);

        }

        float numberOfAssemblyCommandsValue = numberOfAssemblyCommands(codeLengthValue);


        float programmingCalendarTimeValue =
                programmingCalendarTime(codeLengthValue, numberOfDevs, numberOfCommands);
        float estimatedNumberOfErrorsTask2Value =
                estimatedNumberOfErrorsTask2(estimatedCodeVolumeTask2Value);

        float numberOfHours = programmingCalendarTimeValue * 8;

        float solidityOfSoftwareValue = solidityOfSoftware(numberOfHours, estimatedNumberOfErrorsTask2Value);

        String numberOfSoftwareModulesValueAnnotated =
                annotateResult("число модулей программного средства", numberOfSoftwareModulesValue);
        printResult(numberOfSoftwareModulesValueAnnotated);

        String numberOfSoftwareModulesMultiLevelValueAnnotated =
                annotateResult("число модулей программного средства для многоуровнего ПО", numberOfSoftwareModulesMultiLevelValue);
        printResult(numberOfSoftwareModulesMultiLevelValueAnnotated);

        String codeLengthValueAnnotated =
                annotateResult("Расчет длины программы", codeLengthValue);
        printResult(codeLengthValueAnnotated);

        String estimatedCodeVolumeTask2ValueAnnotated =
                annotateResult("Расчет объема программного обеспечения", estimatedCodeVolumeTask2Value);
        printResult(estimatedCodeVolumeTask2ValueAnnotated);

        String numberOfAssemblyCommandsValueAnnotated =
                annotateResult("Расчет количества команд ассемблера", numberOfAssemblyCommandsValue);
        printResult(numberOfAssemblyCommandsValueAnnotated);

        String programmingCalendarTimeValueAnnotated =
                annotateResult("Расчет календарного времени программирования", programmingCalendarTimeValue);
        printResult(programmingCalendarTimeValueAnnotated);

        String estimatedNumberOfErrorsTask2ValueAnnotated =
                annotateResult("Расчет потенциального количества ошибок", estimatedNumberOfErrorsTask2Value);
        printResult(estimatedNumberOfErrorsTask2ValueAnnotated);

        String solidityOfSoftwareValueAnnotated =
                annotateResult("Расчет начальной надёжности ПО", solidityOfSoftwareValue);
        printResult(solidityOfSoftwareValueAnnotated);


    }

    public static void main(String[] args) {
        while (true) {
            task1();
            task2();
            programmerRating();
        }
    }
}