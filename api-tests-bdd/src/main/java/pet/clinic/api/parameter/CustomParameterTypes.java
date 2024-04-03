package pet.clinic.api.parameter;

import io.cucumber.java.ParameterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import pet.clinic.api.state.RuntimeState;

import java.time.LocalDate;

/**
 * Custom ParameterTypes that extend standard ones: https://github.com/cucumber/cucumber-expressions#readme
 */
public class CustomParameterTypes {

    @Autowired
    protected RuntimeState runtimeState;

    /**
     * Parameter that support expression language
     */
    @ParameterType("\"[^\"]*\"") // anything withing quotas
    public String elString(String value) {
        if (value == null) {
            return null;
        } else {
            return trimQuotes(value)
                    .replaceAll("-#", runtimeState.getTestPostfix());
        }
    }

    /**
     * Parameter type for boolean value
     */
    @ParameterType(value = "true|True|TRUE|false|False|FALSE")
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }

    @ParameterType("\"[^\"]*\"") // anything withing quotas
    public Object runtimeState(String elValue) {
        if (elValue == null) {
            return null;
        } else {
            ExpressionParser expressionParser = new SpelExpressionParser();
            Expression expression = expressionParser.parseExpression(trimQuotes(elValue), new TemplateParserContext());

            StandardEvaluationContext runtimeStateContext = new StandardEvaluationContext(runtimeState);
            return expression.getValue(runtimeStateContext);
        }
    }

    /**
     * Custom parameter date for LocalDate, transforms:
     * today or now - to current date
     * tomorrow - to date on tomorrow
     * yesterday - to date on yesterday
     * today+N or now+N - to plus N days from the current date
     * today-N or now-N - to minus N days from the current date
     */
    @ParameterType(".*")
    public LocalDate localDate(String value) {
        if (value == null) return null;

        value = trimQuotes(value);

        LocalDate now = LocalDate.ofInstant(runtimeState.getTestDateTime(), runtimeState.getTestTimeZone());
        if ("today".equalsIgnoreCase(value)) {
            return now;
        } else if ("tomorrow".equalsIgnoreCase(value)) {
            return now.plusDays(1);
        } else if ("yesterday".equalsIgnoreCase(value)) {
            return now.minusDays(1);
        } else if (value.startsWith("today+")) {
            return now.plusDays(Integer.parseInt(value.substring(6)));
        } else if (value.startsWith("today-")) {
            return now.minusDays(Integer.parseInt(value.substring(6)));
        } else {
            throw new IllegalArgumentException("Unsupported localDate value: " + value);
        }
    }

    private String trimQuotes(String value) {
        // trim beginning and end quotes
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        } else {
            return value;
        }
    }

}
