import java.util.ArrayList;

public class Question {

    private String question;
    private int correct;
    private String code = "";
    private ArrayList<String> options = new ArrayList<>();

    public Question(String question, ArrayList<String> options, int correct) {
        this.question = question;
        this.options = options;
        this.correct = correct;
    }

    public Question() {

    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getCorrect() {
        return this.correct;
    }

    public void addOption(String option) {
        this.options.add(option);
    }

    public void addLineOfCode(String code) {
        this.code += code + "\n";
    }


    @Override
    public String toString() {
        return "Question: " + question + "\n" +
                "Code: " + code + "\n" +
                "Options: " + options + "\n" +
                "Correct: " + correct;
    }

    public void askQuestion() {
        System.out.println("Вопрос: " + question);
        if (code != null) {
            System.out.println(code);
        }
        System.out.println("Варианты ответа:");
        int i = 1;
        for (String option : options) {
            System.out.println(i + ". " + option);
            i++;
        }
    }
}
