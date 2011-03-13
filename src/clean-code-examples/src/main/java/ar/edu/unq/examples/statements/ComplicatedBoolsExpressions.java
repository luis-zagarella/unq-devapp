package ar.edu.unq.examples.statements;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unq.examples.statements.support.CharacterType;

@SuppressWarnings("unused")
public class ComplicatedBoolsExpressions {

	public boolean isBigger(int a, int b) {
		boolean result;

		if (a > b) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	public boolean isBigger2(int a, int b) {
		return a > b;
	}

	private final Map<Character, CharacterType> characterTypes = new HashMap<Character, CharacterType>();

	CharacterType sinExplainingBooleanMethods(Character inputCharacter) {
		CharacterType characterType = null;

		if (inputCharacter < Character.SPACE_SEPARATOR) {
			characterType = CharacterType.Control;
		} else if (inputCharacter == ' ' || inputCharacter == ',' || inputCharacter == '.' || inputCharacter == '!'
				|| inputCharacter == '(' || inputCharacter == ')' || inputCharacter == ':' || inputCharacter == ';'
				|| inputCharacter == '?' || inputCharacter == '_' || inputCharacter == '-') {
			characterType = CharacterType.Puntuaction;
		} else if ('0' <= inputCharacter && inputCharacter <= '9') {
			characterType = CharacterType.Digit;
		} else if (('a' <= inputCharacter && inputCharacter <= 'z') || 'A' <= inputCharacter && inputCharacter <= 'Z') {
			characterType = CharacterType.Letter;
		}

		return characterType;
	}

	CharacterType conExplainingBooleanMethods(Character inputCharacter) {
		CharacterType characterType = null;

		if (isControl(inputCharacter)) {
			characterType = CharacterType.Control;
		} else if (isPuntuaction(inputCharacter)) {
			characterType = CharacterType.Puntuaction;
		} else if (isDigit(inputCharacter)) {
			characterType = CharacterType.Digit;
		} else if (isLetter(inputCharacter)) {
			characterType = CharacterType.Letter;
		}

		return characterType;
	}

	CharacterType conTableDrivenMethods(Character inputCharacter) {
		return characterTypes.get(inputCharacter);
	}

	private void initCharacterTypesTable() {
		setLetterCharacters();
		setDigitCharacters();
		setPuntuactionCharacters();
		setControlCharacters();
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

	private boolean isLetter(Character inputCharacter) {
		return ('a' <= inputCharacter && inputCharacter <= 'z') || 'A' <= inputCharacter && inputCharacter <= 'Z';
	}

	private boolean isDigit(Character inputCharacter) {
		return '0' <= inputCharacter && inputCharacter <= '9';
	}

	private boolean isPuntuaction(Character inputCharacter) {
		return inputCharacter == ' ' || inputCharacter == ',' || inputCharacter == '.' || inputCharacter == '!'
				|| inputCharacter == '(' || inputCharacter == ')' || inputCharacter == ':' || inputCharacter == ';'
				|| inputCharacter == '?' || inputCharacter == '_' || inputCharacter == '-';
	}

	private boolean isControl(Character inputCharacter) {
		return inputCharacter < Character.SPACE_SEPARATOR;
	}
}
