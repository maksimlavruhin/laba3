package task2;

public final class StudentFull extends Student {

    @Override
    public void showInfo() {
        System.out.println("┌─────────────────────────────────────────────────────────┐");
        System.out.println("│ ID:          " + getStudentId());
        System.out.println("│ Направление: " + getDirection());
        System.out.println("│ ФИО:         " + getFullName());
        System.out.println("│ Группа:      " + getGroup());
        System.out.println("└─────────────────────────────────────────────────────────┘");
    }
}
