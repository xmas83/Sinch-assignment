class Tiger extends Animal {
    public Tiger(String name, int age) {
        super("Tiger", name, age);
    }

    @Override
    public void speak() {
        System.out.println(getName() + " roars");
    }
}