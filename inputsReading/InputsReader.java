package inputsReading;


import inputDag.InputDag;




//the class that is responsible for reading the inputs, namely :
//
//XmlAndCompReader : in case we have an Xml file and a copanion as inputs
//TextAndCompReader : in case we have a text file and a companion file
//DiffReader : in case we have two xml files that we merge
//HorseReader : in we have a file in Horse format that we want tu unHorse.

public abstract class InputsReader{

 abstract public boolean read();
 abstract public InputDag getDag();
}
