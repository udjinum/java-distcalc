package distillercalc;

import java.util.Scanner;

public class DistillerCalculator {

    final static int choiceOne = 1;
    final static int choiceTwo = 2;
    static String mainQuestion = "Выберите, пожалуйста, опцию из списка, указав ее номер (1 или 2):"
            + System.lineSeparator() + "1. Калькулятор расчета ингридиентов для браги"
            + System.lineSeparator() + "2. Калькулятор расчета разбавления дистилята водой"
            + System.lineSeparator() + "Ваш выбор >> ";

    public static void main(String[] args) {
        System.out.print(mainQuestion);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int userChoice = scanner.nextInt();
                if (userChoice == choiceOne) {
                    System.out.println("Вы выбрали опцию с номером: " + userChoice);
                    System.out.print("Чтобы рассчитать количество ингридиентов, " +
                            "укажите, пожалуйста, в литрах общий объем бродильной емкости: ");
                    if (scanner.hasNextInt()) {
                        int volumeFermentationTank = scanner.nextInt();

                        FermentationTank fermentationTank = new FermentationTank()
                                .useVolumeFermentationTank(volumeFermentationTank)
                                .usePercentUsefulVolumeFermentationTank(10);

                        Sugar sugar = new Sugar()
                                .useConcentrationSugar(0.216)
                                .useDensitySugar(1.6);

                        double totalAvailableVolumeFermentationTank =  fermentationTank.getFinalUsefulVolumeFermentationTank(
                                fermentationTank.getVolumeFermentationTank(),
                                fermentationTank.getPercentUsefulVolumeFermentationTank());

                        double weightSugar = totalAvailableVolumeFermentationTank * sugar.getConcentrationSugar();

                        double volumeWater = totalAvailableVolumeFermentationTank - weightSugar / sugar.getDensitySugar();

                        System.out.print("Для получения концентрации сахара в растворе 20%" +
                                " с учетом плотности сахарозы 1,6 г/см3 при полезном объеме бродильной емкости в "
                                + (int)totalAvailableVolumeFermentationTank + " л потребуется добавить "
                                + (int)weightSugar + " кг сахара и "
                                + (int)volumeWater + " л воды.");

                    } else {
                        System.out.print("Скорее всего Вы ввели строку или дробное число, " +
                                "а с такими данными рассчитать ничего не получится.");
                    }
                    scanner.close();
                    break;
                } else if (userChoice == choiceTwo) {
                    System.out.println("Вы выбрали опцию с номером: " + userChoice);
                    System.out.print("Чтобы рассчитать объем воды, необходимой для разбавления имеющегося дистилята " +
                            "укажите, пожалуйста, последовательно следующие значения:"
                            + System.lineSeparator() + "- крепость дистилята в градусах до разбавления;"
                            + System.lineSeparator() + "- крепость дистилята в градусах после разбавления;"
                            + System.lineSeparator() + "- объем дистилята в литрах:"
                            + System.lineSeparator() + ">> ");
                    if (scanner.hasNextInt()) {
                        int strengthAlcoholBeforeDilution = scanner.nextInt();
                        int strengthAlcoholAfterDilution = scanner.nextInt();
                        int volumeAvailableAlcohol = scanner.nextInt();

                        Alcohol alcohol = new Alcohol()
                                .useStrengthAlcoholBefore(strengthAlcoholBeforeDilution)
                                .useStrengthAlcoholAfter(strengthAlcoholAfterDilution)
                                .useVolumeAlcohol(volumeAvailableAlcohol);

                        int volumeWater = (alcohol.getStrengthAlcoholBefore() / alcohol.getStrengthAlcoholAfter()) *
                                alcohol.getVolumeAlcohol() - alcohol.getVolumeAlcohol();

                        System.out.print("Для разбавления имеющегося дистилята крепостью "
                                + alcohol.getStrengthAlcoholBefore() + "% и объемом "
                                + alcohol.getVolumeAlcohol() + " л до крепости " +
                                + alcohol.getStrengthAlcoholAfter() + "% потребуется добавить "
                                + volumeWater + " л воды");
                    } else {
                        System.out.print("Скорее всего Вы ввели строку или дробное число, " +
                                "а с такими данными рассчитать ничего не получится");
                    }
                    scanner.close();
                    break;
                } else {
                    System.out.print("Введите правильный номер опции из списка (1 или 2): ");
                }
            } else {
                System.out.print("Вы ввели строку или дробное число, а надо номер опции из списка (1 или 2): ");
                scanner.next();
            }
        }
    }
}
