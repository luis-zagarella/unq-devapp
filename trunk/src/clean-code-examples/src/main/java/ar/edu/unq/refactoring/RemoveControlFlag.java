package ar.edu.unq.refactoring;

/**
 * Sucede cuando algun programador respeto aquella regla de la programacion
 * estructurada que decia que una funcion solo debia tener un unico punto de
 * salida.
 * 
 * En metodos cortos varias salidas muchas veces son mas faciles de enteder.
 */
public class RemoveControlFlag {

	private String[] names;

	public boolean exist_v1(String nameToFind) {
		boolean found = false;
		for (String name : names) {
			if (name.equals(nameToFind)) {
				found = true;
			}
		}
		return found;
	}

	public boolean exist_v11(String nameToFind) {
		boolean found = false;
		for (int i = 0; i < names.length && !found; i++) {
			found = names[i].equals(nameToFind);
		}
		return found;
	}

	public boolean exist_v2(String nameToFind) {
		for (String name : names) {
			if (name.equals(nameToFind)) {
				return true;
			}
		}
		return false;
	}

	// @formatter:off
	public boolean exist_v3(String nameToFind) {
		for (String name : names) {
			if (name.equals(nameToFind)) return true;
		}
		return false;
	}

}
