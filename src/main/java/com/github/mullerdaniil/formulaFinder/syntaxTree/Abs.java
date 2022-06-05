package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public class Abs extends UnarySyntaxTreeNode {
    private final FormulaSyntaxTreeNode argument;

    public Abs(FormulaSyntaxTreeNode argument) {
        super(argument);
        this.argument = argument;
    }

    @Override
    public double evaluate(FormulaSolution formulaSolution) {
        return Math.abs(argument.evaluate(formulaSolution));
    }

    @Override
    public String toString() {
        return "|" + argument + "|";
    }
}
