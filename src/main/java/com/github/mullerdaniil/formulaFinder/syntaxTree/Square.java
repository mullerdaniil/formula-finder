package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public class Square extends UnarySyntaxTreeNode {
    private final FormulaSyntaxTreeNode argument;

    public Square(FormulaSyntaxTreeNode argument) {
        super(argument);
        this.argument = argument;
    }

    @Override
    public double evaluate(FormulaSolution formulaSolution) {
        return Math.pow(argument.evaluate(formulaSolution), 2);
    }

    @Override
    public String toString() {
        return "(" + argument + ")^2";
    }
}
