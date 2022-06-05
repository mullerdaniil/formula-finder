package com.github.mullerdaniil.formulaFinder;

import com.github.mullerdaniil.formulaFinder.finder.FormulaFinder;
import com.github.mullerdaniil.formulaFinder.finder.FormulaSolution;
import com.github.mullerdaniil.formulaFinder.syntaxTree.FormulaSyntaxTreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormulaFinderDriverClass {
    public static void main(String[] args) {
        example2();
    }

    public static void example1() {
        FormulaFinder formulaFinder = new FormulaFinder(Arrays.asList("a", "b"),
                Arrays.asList(FormulaFinder.ADDITION, FormulaFinder.SQUARE));

        List<FormulaSolution> solutions = Arrays.asList(
                new FormulaSolution(Map.of(
                        "a", 3.0,
                        "b", 4.0
                ), 25.0),
                new FormulaSolution(Map.of(
                        "a", 25.5,
                        "b", 10.0
                ), 750.25)
        );

        List<FormulaSyntaxTreeNode> formulas = formulaFinder.findFormulasRandomly(solutions, 0.001, 3, 1_000);
        if (formulas == null) {
            System.out.println("Nothing found :(");
        } else {
            System.out.println("Formulas:");
            for (FormulaSyntaxTreeNode formula : formulas) {
                System.out.println(formula);
            }
        }
    }

    public static void example2() {
        List<String> varibles = Arrays.asList(
            "E", "R1", "R2", "R3", "R4", "Rn"
        );

        List<Integer> allowedOperations = Arrays.asList(
            FormulaFinder.ADDITION,
            FormulaFinder.SUBTRACTION,
            FormulaFinder.MULTIPLICATION,
            FormulaFinder.DIVISION
        );

        Map<String, Double> variableValues1 = new HashMap<>();
        variableValues1.put("E", 5.0);
        variableValues1.put("R1", 819.0);
        variableValues1.put("R2", 18_000.0);
        variableValues1.put("R3", 4_300.0);
        variableValues1.put("R4", 160_000.0);
        variableValues1.put("Rn", 4_700.0);

        Map<String, Double> variableValues2 = new HashMap<>();
        variableValues2.put("E", 6.0);
        variableValues2.put("R1", 16_000.0);
        variableValues2.put("R2", 3_000.0);
        variableValues2.put("R3", 430_000.0);
        variableValues2.put("R4", 360.0);
        variableValues2.put("Rn", 16_000.0);

        List<FormulaSolution> solutions = Arrays.asList(
                new FormulaSolution(variableValues1, 0.8899565345),
                new FormulaSolution(variableValues2, 2.008969)
        );

        FormulaFinder formulaFinder = new FormulaFinder(varibles, allowedOperations);
        FormulaSyntaxTreeNode formula = formulaFinder.findAnyFormulaRandomly(solutions, 0.001, 5, 50_000_000);

        if (formula == null) {
            System.out.println("Nothing was found :(");
        } else {
            System.out.println("Formula:");
            System.out.println(formula);
        }
    }
}
