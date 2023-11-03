class Peacock extends Animal {
    public Peacock(String name, int age) {
        super("Peacock", name, age);
    }

    @Override
    public void speak() {
        System.out.println(getName() + " displays its colorful feathers");
    }
}