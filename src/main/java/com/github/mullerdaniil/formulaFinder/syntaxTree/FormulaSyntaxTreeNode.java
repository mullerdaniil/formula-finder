package com.github.mullerdaniil.formulaFinder.syntaxTree;

import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;

public abstract class FormulaSyntaxTreeNode {
    public abstract double evaluate(FormulaSolution formulaSolution);
}
