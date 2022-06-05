package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public class UnaryMinus extends UnarySyntaxTreeNode {
    private final FormulaSyntaxTreeNode argument;

    public UnaryMinus(FormulaSyntaxTreeNode argument) {
        super(argument);
        this.argument = argument;
    }

    @Override
    public double evaluate(FormulaSolution formulaSolution) {
        return -argument.evaluate(formulaSolution);
    }

    @Override
    public String toString() {
        return "-(" + argument + ")";
    }
}
