class Elephant extends Animal {
    public Elephant(String name, int age) {
        super("Elephant", name, age);
    }

    @Override
    public void speak() {
        System.out.println(getName() + " trumpets");
    }
}