package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public class Log extends UnarySyntaxTreeNode {
    private final FormulaSyntaxTreeNode argument;

    public Log(FormulaSyntaxTreeNode argument) {
        super(argument);
        this.argument = argument;
    }

    @Override
    public double evaluate(FormulaSolution formulaSolution) {
        return Math.log10(argument.evaluate(formulaSolution));
    }

    @Override
    public String toString() {
        return "log(" + argument + ")";
    }
}
