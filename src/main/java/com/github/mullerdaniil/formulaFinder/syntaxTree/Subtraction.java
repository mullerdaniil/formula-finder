package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public class Subtraction extends BinarySyntaxTreeNode {
    private final FormulaSyntaxTreeNode argument1;
    private final FormulaSyntaxTreeNode argument2;

    public Subtraction(FormulaSyntaxTreeNode argument1, FormulaSyntaxTreeNode argument2) {
        super(argument1, argument2);
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    @Override
    public double evaluate(FormulaSolution formulaSolution) {
        return argument1.evaluate(formulaSolution) - argument2.evaluate(formulaSolution);
    }

    @Override
    public String toString() {
        return "(" + argument1 + ")-(" + argument2 + ")";
    }
}
