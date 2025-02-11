import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    public static final String path = "data.ser";
    private static CardLayout cardLayout = new CardLayout();
    private static JPanel cardPanel = new JPanel(cardLayout);
    private static Student currentUser;
    private static Course selectedCourse;
    public static void main(String[] args) {
        deserializeData();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> serializeData(Course.courses)));

        JFrame mainFrame = new JFrame("Course Management");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
        mainFrame.setLayout(new BorderLayout());

        cardPanel.add(createLoginPanel(), "Login");
        cardPanel.add(createErrorPanel(), "errorLoggingIn");

        mainFrame.add(cardPanel, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }

    private static JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 182, 193));

        JLabel titleLabel = new JLabel("Sign in to the application", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(50, 20, 300, 30);
        panel.add(titleLabel);

        JLabel userLabel = new JLabel("Login:");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userLabel.setBounds(50, 60, 100, 20);
        JTextField userField = new JTextField();
        userField.setBounds(150, 60, 200, 20);
        panel.add(userLabel);
        panel.add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passLabel.setBounds(50, 100, 100, 20);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 100, 200, 20);
        panel.add(passLabel);
        panel.add(passField);

        JButton signInButton = new JButton("Sign in");
        signInButton.setBounds(50, 160, 300, 40);
        signInButton.setBackground(new Color(255, 105, 180));
        signInButton.setFont(new Font("Arial", Font.BOLD, 14));
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = Arrays.toString(passField.getPassword());
                // for the demo password is always correct
                String sid = userField.getText();
                try {
                    int id = Integer.parseInt(sid);
                    for (Student s : Student.students) {
                        if (s.userId == id) {
                            currentUser = Student.getByID(id);
                            System.out.println(currentUser);
                            cardPanel.add(createCoursesPanel(), "LoggedIn");
                            cardLayout.show(cardPanel, "LoggedIn");
                            return;
                        }
                    }
                }catch (NumberFormatException ignored){

                }

                cardLayout.show(cardPanel, "errorLoggingIn");
            }
        });
        panel.add(signInButton);

        return panel;
    }
    private static JPanel createErrorPanel() {
        JPanel panel = new JPanel();
        panel.setSize(400, 200);
        panel.setLayout(null);

        panel.setBackground(new Color(255, 182, 193));
        JLabel errorLabel = new JLabel("Login Failed. Try Again.", SwingConstants.CENTER);
        errorLabel.setFont(new Font("Arial", Font.BOLD, 16));
        errorLabel.setBounds(50, 30, 300, 30);
        panel.add(errorLabel);

        JButton retryButton = new JButton("Retry");
        retryButton.setBounds(50, 100, 300, 40);
        retryButton.setBackground(new Color(255, 105, 180));
        retryButton.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(retryButton);
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Login");
            }
        });

        return panel;
    }

    private static JPanel createCoursesPanel() {
        JPanel panel = new JPanel();
        panel.setSize(600, 600);
        panel.setLayout(new BorderLayout());

        String[] columns = {"Course ID", "Course Name", "Time Start", "Time End", "Students Count"};
        List<Course> assignedCourses = currentUser.getAssignedCourses();
        List<Course> allCourses = Course.getAllCourses().values().stream().filter(c -> !assignedCourses.contains(c)).toList();

        Object[][] allData = allCourses.stream().map(course -> new Object[]{
                course.getCourseId(),
                course.getCourseName(),
                course.getTimeStart(),
                course.getTimeEnd(),
                course.numStudents()
        }).toArray(Object[][]::new);

        Object[][] assignedData = assignedCourses.stream().map(course -> new Object[]{
                course.getCourseId(),
                course.getCourseName(),
                course.getTimeStart(),
                course.getTimeEnd(),
                course.numStudents()
        }).toArray(Object[][]::new);

        JTable allTable = new JTable(new DefaultTableModel(allData, columns));
        styleTable(allTable);
        JScrollPane allScrollPane = new JScrollPane(allTable);
        allScrollPane.setBackground(new Color(255, 182, 193));
        allScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255, 105, 180), 2), "All Courses", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.BLACK));

        JTable assignedTable = new JTable(new DefaultTableModel(assignedData, columns));
        styleTable(assignedTable);
        JScrollPane assignedScrollPane = new JScrollPane(assignedTable);
        assignedScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255, 105, 180), 2), "Assigned Courses", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.BLACK));
        assignedScrollPane.setBackground(new Color(255, 182, 193));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, assignedScrollPane, allScrollPane);
        splitPane.setDividerLocation(300);
        splitPane.setResizeWeight(0.5);
        splitPane.setBackground(new Color(255, 182, 193));
        splitPane.setBorder(null);

        allTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = allTable.rowAtPoint(evt.getPoint());
                int col = allTable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    int courseId = (Integer) allTable.getValueAt(row, 0);
                    selectedCourse = Course.getCourse(courseId);
                    cardPanel.add(createConfirmPanel(), "ConfirmCourse");
                    cardLayout.show(cardPanel, "ConfirmCourse");
                }
            }
        });
        panel.add(splitPane, BorderLayout.CENTER);
        return panel;
    }
    private static void styleTable(JTable table) {
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setBackground(new Color(255, 240, 245));
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(new Color(255, 105, 180));
        table.setSelectionForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(255, 182, 193));
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        table.setGridColor(new Color(220, 220, 220));

        // Set custom cell renderer
        table.setDefaultRenderer(Object.class, new TableCellRenderer());
    }
    static class TableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(new Color(255, 240, 245));
            return c;
        }
    }
    private static JPanel createConfirmPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 182, 193));

        JLabel detailsLabel = new JLabel("Confirm Course Enrollment");
        detailsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(detailsLabel, BorderLayout.NORTH);

        JLabel courseDetailsLabel = new JLabel(String.format("ID: %d, Name: %s, Start: %s, End: %s",
                selectedCourse.getCourseId(), selectedCourse.getCourseName(),
                selectedCourse.getTimeStart(), selectedCourse.getTimeEnd()));
        courseDetailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(courseDetailsLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 182, 193));
        JButton yesButton = new JButton("Yes");
        yesButton.setBackground(new Color(255, 105, 180));
        JButton noButton = new JButton("No");
        noButton.setBackground(new Color(255, 105, 180));
        yesButton.addActionListener(e -> {
            System.out.println("Enrolled in course: " + selectedCourse.getCourseName());
            new StudentGroup("Name", selectedCourse).addStudent(currentUser);
            cardPanel.add(createSuccessPanel(), "SuccessEnrollment");
            cardLayout.show(cardPanel, "SuccessEnrollment");
        });
        noButton.addActionListener(e -> cardLayout.show(cardPanel, "LoggedIn"));
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }
    private static JPanel createSuccessPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 182, 193));

        JLabel messageLabel = new JLabel("Congratulations! You have successfully enrolled in the course.", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        messageLabel.setForeground(new Color(0, 102, 204));
        panel.add(messageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 182, 193));
        JButton okayButton = new JButton("OK");
        okayButton.setBackground(new Color(255, 105, 180));
        okayButton.setFont(new Font("Arial", Font.BOLD, 14));
        okayButton.setFocusPainted(false);

        okayButton.addActionListener(e -> cardLayout.show(cardPanel, "Login"));
        buttonPanel.add(okayButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }


    public static void serializeData(Object data) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(data);
            out.writeObject(Course.courses);
            out.writeObject(Student.students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserializeData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            Object data = in.readObject();
            Course.courses = (Map<Integer, Course>) in.readObject();
            Student.students = (List<Student>) in.readObject();
            return data;
        } catch (ClassNotFoundException | IOException e) {
            return createSampleCourses();
        }
    }

    private static Map<Integer, Course> createSampleCourses() {
        Map<Integer, Course> courses = new HashMap<>();
        Course c1 = new Course("Introduction to Java", "Monday, 09:00", "Monday, 11:00");
        Course c2 = new Course("Data Structures3", "Wednesday, 12:00", "Wednesday, 14:00");
        Student s1 = new Student("Filip", "Gocławski", new ContactData("email@example.com", "+48123456789"), "12312312312312");
        Student s2 = new Student("Filip2", "Gocławski2", new ContactData("email@example.com2", "+48123456789"), "12312312312312");
        courses.put(c1.getCourseId(), c1);
        courses.put(c2.getCourseId(), c2);
        StudentGroup studentGroup = new StudentGroup("nowa grupa", c1);
        studentGroup.addStudent(s1);

        return courses;
    }
}
