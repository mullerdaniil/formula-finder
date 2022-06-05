package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public abstract class UnarySyntaxTreeNode extends FormulaSyntaxTreeNode {
    private final FormulaSyntaxTreeNode argument;

    public UnarySyntaxTreeNode(FormulaSyntaxTreeNode argument) {
        this.argument = argument;
    }

    @Override
    public abstract double evaluate(FormulaSolution formulaSolution);
}
