package com.github.mullerdaniil.formulaFinder.finder;

import java.util.Map;

public class FormulaSolution {
    private final Map<String, Double> variableValues;
    private final double formulaValue;

    public FormulaSolution(Map<String, Double> variableValues, double formulaValue) {
        this.variableValues = variableValues;
        this.formulaValue = formulaValue;
    }

    public double getFormulaValue() {
        return formulaValue;
    }

    public double getVariableValue(String variableName) {
        return variableValues.get(variableName);
    }
}
