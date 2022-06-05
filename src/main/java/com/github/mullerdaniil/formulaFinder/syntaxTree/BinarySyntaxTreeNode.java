package com.github.mullerdaniil.formulaFinder.syntaxTree;

public abstract class BinarySyntaxTreeNode extends FormulaSyntaxTreeNode {
    private final FormulaSyntaxTreeNode argument1;
    private final FormulaSyntaxTreeNode argument2;

    public BinarySyntaxTreeNode(FormulaSyntaxTreeNode argument1, FormulaSyntaxTreeNode argument2) {
        this.argument1 = argument1;
        this.argument2 = argument2;
    }
}
