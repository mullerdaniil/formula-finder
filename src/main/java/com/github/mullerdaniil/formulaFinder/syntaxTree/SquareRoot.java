package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public class SquareRoot extends UnarySyntaxTreeNode {
    private final FormulaSyntaxTreeNode argument;

    public SquareRoot(FormulaSyntaxTreeNode argument) {
        super(argument);
        this.argument = argument;
    }

    @Override
    public double evaluate(FormulaSolution formulaSolution) {
        return Math.sqrt(argument.evaluate(formulaSolution));
    }

    @Override
    public String toString() {
        return "sqrt(" + argument + ")";
    }
}
