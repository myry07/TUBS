package extendsExercise3;

public class Notepad extends Computer {
    private String color;

    public Notepad(String cpu, int memory, int disk) {
        super(cpu, memory,disk);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
