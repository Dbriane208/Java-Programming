import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // Creating the frame
        JFrame myJFrame = new JFrame("Course Details");
        myJFrame.setBackground(Color.decode("#3B598E"));

        // Second panel to store search
        JPanel labelSearch = new JPanel();
        labelSearch.setLayout(new BoxLayout(labelSearch, BoxLayout.X_AXIS));

        JTextField search = new JTextField();
        search.setBackground(Color.WHITE);

        JButton btnSearch = new JButton("search");
        btnSearch.setBackground(Color.BLACK);

        labelSearch.add(search);
        labelSearch.add(btnSearch);

        // Third panel to store the Course Credentials
        JPanel course = new JPanel();
        course.setBackground(Color.decode("#3B598E"));
        course.setLayout(new BoxLayout(course, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Title");
        JTextField titleTxt = new JTextField();
        titleTxt.setBackground(Color.WHITE);
        title.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel courseID = new JLabel("Course ID");
        JTextField courseTxt = new JTextField();
        courseTxt.setBackground(Color.WHITE);
        courseID.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel duration = new JLabel("Duration");
        JTextField durationTxt = new JTextField();
        durationTxt.setBackground(Color.WHITE);
        duration.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel dept = new JLabel("Department");
        JTextField deptTxt = new JTextField();
        deptTxt.setBackground(Color.WHITE);
        dept.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        course.add(title);
        course.add(titleTxt);
        course.add(courseID);
        course.add(courseTxt);
        course.add(duration);
        course.add(durationTxt);
        course.add(dept);
        course.add(deptTxt);

        // Fourth panel to add category
        JPanel category = new JPanel();
        category.setBackground(Color.decode("#3B598E"));
        category.setLayout(new BoxLayout(category, BoxLayout.Y_AXIS)); // Changed 'course' to 'category'

        JRadioButton studentCategory = new JRadioButton("Student");
        JRadioButton courseCategory = new JRadioButton("Course");

        category.add(studentCategory);
        category.add(courseCategory);

        // Fifth panel to store the save, delete and reset buttons
        JPanel Buttons = new JPanel();
        Buttons.setBackground(Color.decode("#3B598E"));
        Buttons.setLayout(new BoxLayout(Buttons, BoxLayout.X_AXIS)); // Changed 'course' to 'Buttons'

        JButton save = new JButton("Save");
        save.setBackground(Color.BLACK);

        JButton delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);

        JButton reset = new JButton("Reset");
        reset.setBackground(Color.BLACK);

        Buttons.add(save);
        Buttons.add(delete);
        Buttons.add(reset);

        // Adding the panels into their respective regions
        myJFrame.add(labelSearch, BorderLayout.NORTH);
        myJFrame.add(course, FlowLayout.CENTER);
        myJFrame.add(category, BorderLayout.EAST);
        myJFrame.add(Buttons, BorderLayout.SOUTH);

        myJFrame.setSize(500, 400);
        myJFrame.setVisible(true);
    }
}
