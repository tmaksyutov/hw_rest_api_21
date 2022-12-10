package models;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;
import java.util.ArrayList;

@RequiredArgsConstructor
@Data
public class Step {

    @Nonnull
    private String name;
    private ArrayList<Object> attachments;
    private ArrayList<Object> steps;
    private boolean leaf;
    private int stepsCount;
    private boolean hasContent;
    @Nonnull
    private String keyword;
    private String spacing;

    public static Step generateRandomStep() {
        Faker faker = new Faker();
        String testStepName = faker.name().nameWithMiddle();
        String testStepKeyWord = faker.animal().name();
        return new Step(testStepName, testStepKeyWord);

    }
}
