package task2;

public final class StudentShort extends Student {

    @Override
    public void showInfo() {
        System.out.printf("[%s] %s — гр. %s%n",
                getStudentId(), getFullName(), getGroup());
    }
}
