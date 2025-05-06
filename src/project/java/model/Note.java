package project.java.model;

public class Note {
    private int id;
    private int studentId;
    private double note;

    public Note(int id, int stuedentId, double note){
        this.id = id;
        this.studentId = stuedentId;
        this.note = note;
    }
    public Note(int studentId, double note){
        this.studentId = studentId;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
