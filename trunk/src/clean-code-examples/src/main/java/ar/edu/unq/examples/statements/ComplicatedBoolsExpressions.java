package ar.edu.unq.examples.statements;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unq.examples.statements.support.CharacterType;

@SuppressWarnings("unused")
public class ComplicatedBoolsExpressions {

    public boolean isBigger(final int a, final int b) {
        boolean result;

        if (a > b) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public boolean isBigger2(final int a, final int b) {
        return a > b;
    }

    private final Map<Character, CharacterType> characterTypes = new HashMap<Character, CharacterType>();

    CharacterType sinExplainingBooleanMethods(final Character inputCharacter) {
        CharacterType characterType = null;

        if (inputCharacter < Character.SPACE_SEPARATOR) {
            characterType = CharacterType.Control;
        } else if (inputCharacter == ' ' || inputCharacter == ',' || inputCharacter == '.' || inputCharacter == '!'
                || inputCharacter == '(' || inputCharacter == ')' || inputCharacter == ':' || inputCharacter == ';'
                || inputCharacter == '?' || inputCharacter == '_' || inputCharacter == '-') {
            characterType = CharacterType.Puntuaction;
        } else if ('0' <= inputCharacter && inputCharacter <= '9') {
            characterType = CharacterType.Digit;
        } else if ('a' <= inputCharacter && inputCharacter <= 'z' || 'A' <= inputCharacter && inputCharacter <= 'Z') {
            characterType = CharacterType.Letter;
        }

        return characterType;
    }

    CharacterType conExplainingBooleanMethods(final Character inputCharacter) {
        CharacterType characterType = null;

        if (this.isControl(inputCharacter)) {
            characterType = CharacterType.Control;
        } else if (this.isPuntuaction(inputCharacter)) {
            characterType = CharacterType.Puntuaction;
        } else if (this.isDigit(inputCharacter)) {
            characterType = CharacterType.Digit;
        } else if (this.isLetter(inputCharacter)) {
            characterType = CharacterType.Letter;
        }

        return characterType;
    }

    CharacterType conTableDrivenMethods(final Character inputCharacter) {
        return characterTypes.get(inputCharacter);
    }

    private void initCharacterTypesTable() {
        this.setLetterCharacters();
        this.setDigitCharacters();
        this.setPuntuactionCharacters();
        this.setControlCharacters();
    }

    private void setDigitCharacters() {
        for (int i = 0; i < 10; i++) {
            characterTypes.put((char) i, CharacterType.Digit);
        }
    }

    private void setPuntuactionCharacters() {
        throw new UnsupportedOperationException();
    }

    private void setLetterCharacters() {
        throw new UnsupportedOperationException();
    }

    private void setControlCharacters() {
        throw new UnsupportedOperationException();
    }

    private boolean isLetter(final Character inputCharacter) {
        return 'a' <= inputCharacter && inputCharacter <= 'z' || 'A' <= inputCharacter && inputCharacter <= 'Z';
    }

    private boolean isDigit(final Character inputCharacter) {
        return '0' <= inputCharacter && inputCharacter <= '9';
    }

    private boolean isPuntuaction(final Character inputCharacter) {
        return inputCharacter == ' ' || inputCharacter == ',' || inputCharacter == '.' || inputCharacter == '!'
                || inputCharacter == '(' || inputCharacter == ')' || inputCharacter == ':' || inputCharacter == ';'
                || inputCharacter == '?' || inputCharacter == '_' || inputCharacter == '-';
    }

    private boolean isControl(final Character inputCharacter) {
        return inputCharacter < Character.SPACE_SEPARATOR;
    }
}
