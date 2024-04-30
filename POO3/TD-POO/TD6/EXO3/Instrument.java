package EXO3;

//hierarchie des instruments
abstract class Instrument {
}

// instrument
// premiere distinctions
// Instrument mecanique
abstract class InstrumentMecanique extends Instrument {
}

// Instrument Electronique
abstract class InstrumentElectronique extends Instrument {
}

// Distinction
// Corde (Frappee,pincee,frottee)
abstract class Corde extends InstrumentMecanique {
}

abstract class CordeFrapees extends Corde {
}

abstract class CordePincees extends Corde {
}

abstract class CordeFrottee extends Corde {
}

// Vent (bois,cuivre)
abstract class Vent extends InstrumentMecanique {
}

abstract class VentBois extends Vent {
}

abstract class VentCuivre extends Vent {
}

// Percussion: Peau, bois,metal
abstract class Percussions extends InstrumentMecanique {
}

abstract class PerPeau extends Percussions {
}

abstract class PerBois extends Percussions {
}

abstract class PerMetal extends Percussions {
}

// Type d'amplification
// Electrique
// Mecanique
public interface Amplification {
}

public interface AmplificationElectronique extends Amplification {
}

public interface AmplificationMecanique extends Amplification {
}
interface Clavier{} 

class Orgue extends Vent implements AmplificationMecanique {
} // class concrete

class Piano extends CordeFrapees implements AmplificationMecanique,Clavier {
}

class GuitareElectrique {
}

class Saxophone {
}

class PianoSynthetique {
}
