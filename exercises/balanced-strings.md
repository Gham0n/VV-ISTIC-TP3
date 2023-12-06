# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `)]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators, check if the test cases written so far satisfy _Base Choice Coverage_. If needed, add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

```java
public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                // Unmatched closing symbol or other characters
                return false;
            }
        }

        // The string is balanced if the stack is empty at the end
        return stack.isEmpty();
    }
```

### 1. Input Space Partitioning:

Characteristics: The input space for the isBalanced method can be partitioned based on the different types of characters in the string (e.g., '{', '}', '[', ']', '(', ')') and the placement of these characters.
Partition Blocks:
Opening symbols: {, [, (
Closing symbols: }, ], )
Empty string

### 2. Statement Coverage:

Ensure that each partition block is covered by at least one test case. Test both balanced and unbalanced scenarios.
For example:
"{[()]}": Balanced case with all types of symbols.
"{[()]())}": Unbalanced case with extra closing parenthesis.

### 3. Base Choice Coverage:

If your code has logical conditions with more than two boolean operators, ensure that each possible combination of true/false values for those conditions is covered.
For example, if there's a condition like (A && B || C), ensure test cases covering (true, true), (true, false), (false, true), and (false, false).

### 4. Mutation Tetsing PIT

Voir code
