package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public class Variable extends FormulaSyntaxTreeNode {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(FormulaSolution formulaSolution) {
        return formulaSolution.getVariableValue(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
