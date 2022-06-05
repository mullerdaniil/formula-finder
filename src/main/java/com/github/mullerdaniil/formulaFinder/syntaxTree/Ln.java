package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public class Ln extends UnarySyntaxTreeNode {
    private final FormulaSyntaxTreeNode argument;

    public Ln(FormulaSyntaxTreeNode argument) {
        super(argument);
        this.argument = argument;
    }

    @Override
    public double evaluate(FormulaSolution formulaSolution) {
        return Math.log(argument.evaluate(formulaSolution));
    }

    @Override
    public String toString() {
        return "ln(" + argument + ")";
    }
}
