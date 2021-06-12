import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        startTest(new Test(GetTextFromFile.readFile("C:\\java-new-homework\\Homework20\\test.test")));


    }


    public static void startTest(Test test) {
        System.out.println("Вы готовы начать тест? Введите Y");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (checkReply(answer)) {
            System.out.println("Начинаем тест!");
            int score = 0;
            for (int i = 0; i < test.getQuestions().size(); i++) {
                askQuestion(test, i);
                System.out.println("Введите номер правильного ответа");
                int answerQ = scanner.nextInt();
                if (checkAnswer(test, i, answerQ)) {
                    score++;
                    System.out.println("Правильно!");
                } else {
                    System.out.println("Не правильно!");
                }
            }
            System.out.println("Вы набрали " + score + " из возможных " + test.getQuestions().size() + " баллов.");
            System.out.println("Хотите попробовать еще раз? Введите Y");
            answer = scanner.next();
            if (checkReply(answer)) {
                startTest(test);
            }

        }
    }

    public static boolean checkReply(String reply) {
        return reply.toUpperCase().equals("Y") || reply.toUpperCase().equals("YES");
    }

    public static void askQuestion(Test test, int index) {
        test.getQuestions().get(index).askQuestion();
    }

    public static boolean checkAnswer(Test test, int index, int answer) {
        return test.getQuestions().get(index).getCorrect() == answer - 1;
    }
}