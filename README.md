# Why to use
### What it does
Given a set of variables $x_1, x_2, ..., x_n$
Given a function $f(x_1, x_2, ..., x_n)=???$
Given a set of operations:
$$+, -, *, /, x^2, x^y, ...$$
Given a list of solutions:
$$f(p_1, p_2, ..., p_n)=p$$
$$f(q_1, q_2, ..., q_n)=q$$
$$... etc$$
The program goes through $k$ randomly generated formulas and finds formula(s) satisfying the solutions

### Example
Suppose, you have a function $f(a,b)= ???$ and you know some solutions:
$$f(3,4)=25$$
$$f(10,8)=164$$
Also, you know that you can use only $+$, $x^2$(square) as operations
So, using this program you can generate 1000 (for instance) random formulas and maybe there will be a formula satisfying the solutions.

# How to use
### Example
```java
List<String> variables = Arrays.asList("a", "b");  
  
List<Integer> allowedOperations = Arrays.asList(FormulaFinder.ADDITION, FormulaFinder.SQUARE);  
  
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
  
FormulaFinder formulaFinder = new FormulaFinder(variables, allowedOperations);  
  
double accuracy = 0.001;  
int syntaxTreeHeight = 3;  
int experiments = 1_000;  
  
List<FormulaSyntaxTreeNode> formulas = formulaFinder.findFormulasRandomly(solutions, accuracy, syntaxTreeHeight, experiments);  
if (formulas == null) {  
  System.out.println("Nothing found :(");  
} else {  
  System.out.println("Formulas (" + formulas.size() + " found):");  
  for (FormulaSyntaxTreeNode formula : formulas) {  
  System.out.println(formula);  
 }}
```
### In details
1. Set up the variables
```java
List<String> variables = Arrays.asList("a", "b"); 
```

2. Set up the allowed operations
```java
List<Integer> allowedOperations = Arrays.asList(FormulaFinder.ADDITION, FormulaFinder.SQUARE);  
```
3. Set up the solutions (a solution consists of ```Map<String, Double>``` (values of variables) and ```double``` value (expected value, value of the function))
```java
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
```
4. Initialize a formula finder
```java
FormulaFinder formulaFinder = new FormulaFinder(variables, allowedOperations);  
```
5. Set up the parameters (```accuracy``` - to accept the formula, ```syntaxTreeHeight``` - allowed height of the formula syntax tree, ```experiments``` - number of attempts to find the formula)
```java
double accuracy = 0.001;  
int syntaxTreeHeight = 3;  
int experiments = 1_000;  
```
6. Call the method
```java
List<FormulaSyntaxTreeNode> formulas = formulaFinder.findFormulasRandomly(solutions, accuracy, syntaxTreeHeight, experiments); 
```
7. Output of the program
```java
Formulas (21 found):
((a)^2)+((b)^2)
((a)^2)+((b)^2)
((b)^2)+((a)^2)
((b)^2)+((a)^2)
((b)^2)+((a)^2)
((b)^2)+((a)^2)
((a)^2)+((b)^2)
((a)^2)+((b)^2)
((a)^2)+((b)^2)
((b)^2)+((a)^2)
((b)^2)+((a)^2)
((a)^2)+((b)^2)
((b)^2)+((a)^2)
((a)^2)+((b)^2)
((a)^2)+((b)^2)
((a)^2)+((b)^2)
((b)^2)+((a)^2)
((b)^2)+((a)^2)
((a)^2)+((b)^2)
((a)^2)+((b)^2)
((a)^2)+((b)^2)
```

### Supported operations
```java
+, -, *, /,
sqrt(x), x, x^2, x^y,
sin(x), cos(x), tan(x),
-x, abs(x), ln(x), log(x)
```
