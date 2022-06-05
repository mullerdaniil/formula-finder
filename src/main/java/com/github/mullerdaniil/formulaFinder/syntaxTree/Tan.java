package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public class Tan extends UnarySyntaxTreeNode {
    private final FormulaSyntaxTreeNode argument;

    public Tan(FormulaSyntaxTreeNode argument) {
        super(argument);
        this.argument = argument;
    }

    @Override
    public double evaluate(FormulaSolution formulaSolution) {
        return Math.tan(argument.evaluate(formulaSolution));
    }

    @Override
    public String toString() {
        return "tan(" + argument + ")";
    }
}
