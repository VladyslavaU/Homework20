import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    private final String DESCRIPTION;
    private final List<Question> QUESTIONS;

    public Test(String text) {
        this.DESCRIPTION = findDescription(text);
        this.QUESTIONS = getQuestionsFromFile(parseQuestions(text));

    }

    public List<Question> getQuestions() {
        return this.QUESTIONS;
    }

    public String findDescription(String text) {
        List<String> questions = new ArrayList<>(Arrays.asList(text.split("\n")));
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).contains("@Description")) {
                return questions.get(i + 1);
            }
        }
        return "No name";
    }

    public List<String> parseQuestions(String text) {
        return new ArrayList<>(Arrays.asList(text.split("@Question")));
    }

    public static Question createQuestion(List<String> parsedText) {
        Question question = new Question();
        question.setQuestion(parsedText.get(1));
        for (int i = 2; i < parsedText.size(); i++) {
            if (parsedText.get(i).contains("<code>")) {
                ++i;
                while (!parsedText.get(i).contains("</code")) {
                    question.addLineOfCode(parsedText.get(i));
                    i++;
                }
            } else if (parsedText.get(i).contains("@Key")) {
                question.setCorrect(Integer.parseInt(parsedText.get(i).replaceAll("\\D", "")) - 1);
            } else {
                question.addOption(parsedText.get(i));
            }
        }
        return question;
    }

    public List<Question> getQuestionsFromFile(List<String> parsedText) {
        List<Question> questions = new ArrayList<>();
        for (int i = 1; i < parsedText.size(); i++) {
            List<String> text = Arrays.asList(parsedText.get(i).split("\n"));
            Question question = createQuestion(text);
            questions.add(question);
        }
        return questions;
    }

    @Override
    public String toString() {
        return "Description: " + this.DESCRIPTION +
                QUESTIONS.toString();
    }
}
