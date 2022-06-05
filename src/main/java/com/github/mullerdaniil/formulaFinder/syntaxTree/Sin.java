package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public class Sin extends UnarySyntaxTreeNode {
    private final FormulaSyntaxTreeNode argument;

    public Sin(FormulaSyntaxTreeNode argument) {
        super(argument);
        this.argument = argument;
    }

    @Override
    public double evaluate(FormulaSolution formulaSolution) {
        return Math.sin(argument.evaluate(formulaSolution));
    }

    @Override
    public String toString() {
        return "sin(" + argument + ")";
    }
}
