class Portable {
    public void sonne(Sonnerie s) {
        s.sonne();
    }
}

class Sonnerie {
    public void sonne() {
        System.out.println("Z");
    }
}

class DoubleSonnerie extends Sonnerie {
    public void sonne() {
        System.out.println("Z Z");
    }
}
