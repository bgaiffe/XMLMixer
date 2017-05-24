package inputsReading;

import inputDag.InputDag;

import java.io.FileReader;

import xmlNodes.*;

// We read a dag stored in a file.
// each line in the file reads :
// nodeName \t arc \t nodeName
// with arc = <El atts> or </El> or <?PI ... ?> or <!-- Comment --> or "some text" Pb : si il y a des retours charriots dans le texte ? on les encode &#x0a; ?
// sinon, on n'est pas loin d'un compReader isn't it ?

public class DagReader extends InputsReader{
	
	FileReader fichier;
	
	public DagReader(String dagFileName) throws Exception{
		// we will have to build xmlNodes
		this.fichier = new FileReader(dagFileName);
	}

	@Override
	public boolean read() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InputDag getDag() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
