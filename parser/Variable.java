package parser;

public class Variable {
    public char letter;
    public boolean value;

    public Variable(char letter) {
        this.letter = letter;
    }

    public static Variable getVariableFrom(String s) {
        char letter = '\0';
        boolean foundVar = false;

        for (int i = 0, length = s.length(); i < length; i++) {
            if (s.charAt(i) == ' ' ||
                s.charAt(i) == Expression.PRIORITY_START ||
                s.charAt(i) == Expression.PRIORITY_END) {
                continue;
            }

            if (isVariable(s.charAt(i))) {
                if (foundVar) return null;
                letter = s.charAt(i);
                foundVar = true;
            } else {
                return null;
            }
        }

        if (letter == '\0') return null;

        return new Variable(letter);
    }

    public static boolean isVariable(char c) {
        return Character.isLetter(c);
    }

    public String toString() {
        return letter + "";
    }
}
