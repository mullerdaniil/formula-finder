package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public class Cos extends UnarySyntaxTreeNode {
    private final FormulaSyntaxTreeNode argument;

    public Cos(FormulaSyntaxTreeNode argument) {
        super(argument);
        this.argument = argument;
    }

    @Override
    public double evaluate(FormulaSolution formulaSolution) {
        return Math.cos(argument.evaluate(formulaSolution));
    }

    @Override
    public String toString() {
        return "cos(" + argument + ")";
    }
}
