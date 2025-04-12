package todo.service;

import todo.entity.Step;
import exception.InvalidEntityException;

import java.util.HashMap;
import java.util.Map;

public class StepService {

    private static Map<Integer, Step> stepData= new HashMap<>();

    public static void saveStep(int taskRef, String title) {
        Step step = new Step(title, taskRef);
        stepData.put(step.hashCode(), step);
    }

    public static void setStepAsCompleted(int stepId) throws InvalidEntityException {
        Step step = stepData.get(stepId);

        if (step == null) {
            throw new InvalidEntityException("گامی با این شناسه یافت نشد!");
        }

        step.setStatus(Step.Status.Completed);
        stepData.put(stepId, step);
    }

    public static void setStepAsNotStarted(int stepId) throws InvalidEntityException {
        Step step = stepData.get(stepId);

        if (step == null) {
            throw new InvalidEntityException("گامی با این شناسه یافت نشد!");
        }

        step.setStatus(Step.Status.NotStarted);
        stepData.put(stepId, step);
    }

    public static void addStep(int stepId, Step step) {
        stepData.put(stepId, step);
    }
}
