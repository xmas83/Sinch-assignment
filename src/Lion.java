class Lion extends Animal {
    public Lion(String name, int age) {
        super("Lion", name, age);
    }

    @Override
    public void speak() {
        System.out.println(getName() + " roars");
    }
}
