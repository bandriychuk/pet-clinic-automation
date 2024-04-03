package pet.clinic.api.parameter;

import pet.clinic.api.state.RuntimeState;
import io.cucumber.java.ParameterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

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
            return trimQuotes(value);
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

    private String trimQuotes(String value) {
        // trim beginning and end quotes
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        } else {
            return value;
        }
    }

}
