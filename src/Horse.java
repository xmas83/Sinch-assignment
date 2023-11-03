class Horse extends Animal {
    public Horse(String name, int age) {
        super("Horse", name, age);
    }

    @Override
    public void speak() {
        System.out.println(getName() + " neighs");
    }
}