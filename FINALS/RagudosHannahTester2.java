/**
 * Name: Ragudos, Hannah T.
 * Class Code and Schedule: 9301 TF 7:30-10:30
 * Activity: Individual Final Exercise
 * Programming Date: March 28, 2023 - April 14, 2023
 * Specifications:
 * <p>
 *     This class, named "RagudosHannahTester2", is a GUI class for an Area Calculation Tool for Geometric Shapes.
 *     It extends the JFrame class and provides a user interface for selecting different shapes and calculating
 *     their respective areas. The class includes a main menu bar with one main menu item and sub-menu items for
 *     each of the shapes: Circle, Triangle, Cylinder, Square, Rectangle, and Rectangular Solid. The class has
 *     six separate JFrame objects for each shape, each with its own input form for taking the required input values
 *     and calculating the area of the selected shape. The class also includes a JPanel object called "mainPanel"
 *     which is used for displaying the main interface of the tool. The main panel has a background gradient color
 *     and is laid out using the BoxLayout manager in the Y_AXIS direction. The purpose of this class is to provide
 *     a user-friendly interface for calculating the area of different geometric shapes, allowing the user to select
 *     the shape of interest and input the required values in a separate JFrame object for each shape.
 * </p>
 */

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/**
 * The class extends the JFrame class and includes menu items for selecting
 * different shapes, including Circle, Triangle, Cylinder, Square, Rectangle,
 * and Rectangular Solid. The class also includes separate JFrames for each
 * shape for displaying the respective input forms and calculating and
 * displaying the area of the selected shape.
 */

public class RagudosHannahTester2 extends JFrame {

    private JMenu mainMenuChoice1;
    private JMenuItem itemCircle;
    private JMenuItem itemTriangle;
    private JMenuItem itemCylinder;
    private JMenuItem itemSquare;
    private JMenuItem itemRectangle;
    private JMenuItem itemRectangularSolid;

    private JFrame frameForCircle;
    private JFrame frameForTriangle;
    private JFrame frameForCylinder;
    private JFrame frameForSquare;
    private JFrame frameForRectangle;
    private JFrame frameForRectangularSolid;
    private Shape shape;

    /**
     * The main class for the Area Calculation Tool for Geometric Shapes.
     * It creates an instance of the "RagudosHannahTester2" class and initializes the GUI components.
     * The main method of this class is responsible for creating the main JFrame window of the tool.
     * The method catches any exception that may occur during the initialization process and prints the stack trace.
     */
    public static void main(String[] args) {
        RagudosHannahTester2 program;
        try {
            program = new RagudosHannahTester2();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This constructor initializes the GUI components for the Area Calculation Tool for Geometric Shapes.
     * @throws Exception if there is an error initializing the GUI components
     */
    public RagudosHannahTester2() throws Exception {
        // Title of the main JFrame window
        setTitle("Area and Volume Calculation Tool for Geometric Figures");

        // Set a custom icon for the JFrame
        try {
            URL iconURL = new URL("https://cdn-icons-png.flaticon.com/512/780/780730.png");
            ImageIcon icon = new ImageIcon(iconURL);
            setIconImage(icon.getImage());
        } catch (Exception e) {
            System.err.println("Error loading icon: " + e.getMessage());
        }

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                int panelWidth = getWidth();
                int panelHeight = getHeight();
                Color color1 = new Color(4, 18, 28);
                Color color2 = new Color(6, 27, 43);
                Color color3 = new Color(5, 35, 59);
                Color color4 = new Color(6, 42, 76);
                Color color5 = new Color(15, 50, 93);
                Color color6 = new Color(16, 68, 116);
                Color color7 = new Color(13, 86, 139);
                Color color8 = new Color(0, 106, 162);
                Color color9 = new Color(0, 142, 191);
                Color color10 = new Color(18, 215, 230);
                Color color11 = new Color(95, 251, 241);
                Color[] colors = {color1, color2, color3, color4, color5, color6, color7, color8, color9, color10, color11};
                float[] fractions = {0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
                LinearGradientPaint gradient = new LinearGradientPaint(0, 0, 0, panelHeight, fractions, colors);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, panelWidth, panelHeight);
                g2d.dispose();
            }
        };
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Create header panel with gradient background
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                int panelWidth = getWidth();
                int panelHeight = getHeight();
                Color startColor = new Color(255, 255, 255, 255); // 99% transparent white
                Color endColor = new Color(255, 255, 255, 2); // 98% transparent white
                GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, panelHeight, endColor);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, panelWidth, panelHeight);
                g2d.dispose();
            }
        };
        headerPanel.setLayout(new BorderLayout());

        // Add header panel to main panel
        mainPanel.add(headerPanel);

        // Create title label
        JLabel titleLabel = new JLabel("Geometric Figure Area and Volume Calculator");
        titleLabel.setFont(new Font("Helvetica Neue", Font.BOLD | Font.ITALIC, 32));
        titleLabel.setForeground(Color.WHITE); // Use light font color
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the label

        // Add color outline to the title label text
        Border outline = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(95, 251, 241), 1),
                BorderFactory.createEmptyBorder(5, 10, 15, 10));
        JPanel outlinePanel = new JPanel(new BorderLayout());
        outlinePanel.setBorder(outline);
        outlinePanel.setOpaque(false);
        outlinePanel.add(titleLabel, BorderLayout.CENTER);

        // Create a container to center the title label
        JPanel titleContainer = new JPanel();
        titleContainer.setLayout(new BoxLayout(titleContainer, BoxLayout.PAGE_AXIS));
        titleContainer.setOpaque(false);
        titleContainer.add(Box.createVerticalGlue());
        titleContainer.add(outlinePanel);
        titleContainer.add(Box.createVerticalGlue());

        // Create a container to center the title container
        JPanel centerContainer = new JPanel(new GridBagLayout());
        centerContainer.setOpaque(false);
        centerContainer.add(titleContainer, new GridBagConstraints());

        // Add center container to main panel
        mainPanel.add(centerContainer);

        // Add main labels
        JLabel mainLabel1 = new JLabel("Hello User!");
        JLabel mainLabel2 = new JLabel("This application helps you compute the area of a simple geometric figure.");
        JLabel mainLabel3 = new JLabel("Click the Geometric Figure Menu below.");

        mainLabel1.setFont(new Font("Helvetica Neue", Font.BOLD, 17));
        mainLabel2.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
        mainLabel3.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));

        mainLabel1.setForeground(Color.WHITE); // Use light font color
        mainLabel2.setForeground(Color.WHITE);
        mainLabel3.setForeground(Color.WHITE);

        mainPanel.add(mainLabel1);
        mainPanel.add(mainLabel2);
        mainPanel.add(mainLabel3);

        // Add white borderline
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        // Use alignment and whitespace to organize interface
        mainLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainLabel1.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        mainLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainLabel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        mainLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainLabel3.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(menuBar.getWidth(), 70));
        menuBar.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainMenuChoice1 = new JMenu("Geometric Figures");
        mainMenuChoice1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        mainMenuChoice1.setForeground(new Color(4, 18, 28));

        // Selection for Circle
        itemCircle = new JMenuItem("Circle");
        itemCircle.addActionListener((e) -> {
            try {
                showCircleUI();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Selection for Triangle
        itemTriangle = new JMenuItem("Triangle");
        itemTriangle.addActionListener((e) -> {
            try {
                showTriangleUI();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        });

        // Add the Circle and Triangle to the Geometric Figures Main Menu
        mainMenuChoice1.add(itemCircle);
        mainMenuChoice1.add(itemTriangle);

        // Create submenu for Three-Dimensional Shape
        JMenu subMenu3D = new JMenu("Three-Dimensional Shape");
        subMenu3D.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        subMenu3D.setForeground(new Color(4, 18, 28));

        // Selection for Cylinder
        itemCylinder = new JMenuItem("Cylinder");
        itemCylinder.addActionListener((e) -> {
            try {
                showCylinderUI();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Selection for Rectangular Solid
        itemRectangularSolid = new JMenuItem("Rectangular Solid");
        itemRectangularSolid.addActionListener((e) -> {
            try {
                showRectangularSolidUI();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Add the Cylinder and Rectangular Solid to the Three-Dimensional Shape submenu
        subMenu3D.add(itemCylinder);
        subMenu3D.add(itemRectangularSolid);

        // Create submenu for Four-sided Polygon
        JMenu subMenu4Sided = new JMenu("Four-sided Polygon");
        subMenu4Sided.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        subMenu4Sided.setForeground(new Color(4, 18, 28));

        // Selection for Square
        itemSquare = new JMenuItem("Square");
        itemSquare.addActionListener((e) -> {
            try {
                showSquareUI();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Selection for Rectangle
        itemRectangle = new JMenuItem("Rectangle");
        itemRectangle.addActionListener((e) -> {
            try {
                showRectangleUI();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Add the Square and Rectangle to the Four-sided Polygon submenu
        subMenu4Sided.add(itemSquare);
        subMenu4Sided.add(itemRectangle);

        // Add the submenus to the main menu choice
        mainMenuChoice1.add(subMenu3D);
        mainMenuChoice1.add(subMenu4Sided);

        menuBar.add(mainMenuChoice1);

        // Add menu bar to main panel
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(menuBar);
        mainPanel.add(Box.createVerticalStrut(60));

        // Create JLabel
        JLabel calendarLabel = new JLabel("Current Date and Time:", JLabel.CENTER);
        calendarLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
        calendarLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        calendarLabel.setForeground(Color.WHITE);

        // Add calendar label to main panel
        mainPanel.add(calendarLabel);

        // Get current date and time
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy 'at' h:mm:ss a");
        String dateTime = dateFormat.format(calendar.getTime());

        // Create label for displaying the current date and time
        JLabel dateTimeLabel = new JLabel(dateTime, JLabel.CENTER);
        dateTimeLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        dateTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dateTimeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        dateTimeLabel.setForeground(Color.WHITE);

        // Add calendar and date time labels to main panel
        mainPanel.add(calendarLabel);
        mainPanel.add(dateTimeLabel);

        // Create footer panel with white transparent background
        JPanel footerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                int panelWidth = getWidth();
                int panelHeight = getHeight();
                Color startColor = new Color(255, 255, 255, 255);
                Color endColor = new Color(255, 255, 255, 2);
                GradientPaint gradient = new GradientPaint(0, 0, endColor, 0, panelHeight, startColor);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, panelWidth, panelHeight);
                g2d.dispose();
            }
        };
        footerPanel.setLayout(new BorderLayout());

        // Create footer label
        JLabel footerLabel = new JLabel("©2023 Hannah Ragudos", JLabel.CENTER);
        footerLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 11));
        footerLabel.setForeground(new Color(4, 18, 28));
        footerLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        footerPanel.add(footerLabel, BorderLayout.CENTER);

        // Set preferred height for footer panel
        footerPanel.setPreferredSize(new Dimension(footerPanel.getWidth(), 1));

        // Add footer panel to main panel
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(footerPanel);

        // Add main panel to frame
        add(mainPanel);

        // Set frame properties
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);

    }

    /**
     * This method shows the UI for the Circle shape.
     * It creates a new JFrame object called "frameForCircle"
     * @throws Exception if there is any exception while creating or showing the UI
     */
    private void showCircleUI() throws Exception {
        if (frameForCircle == null) {
            frameForCircle = new JFrame("Circle");
            frameForCircle.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            // Create circle panel
            CirclePanel circlePanel = new CirclePanel();
            circlePanel.setBackground(new Color(254, 254, 254));
            frameForCircle.add(circlePanel);

            // Set icon
            URL iconUrl = new URL("https://cdn-icons-png.flaticon.com/512/3810/3810065.png");
            ImageIcon icon = new ImageIcon(iconUrl);
            frameForCircle.setIconImage(icon.getImage());

            // Set default size and center frame
            frameForCircle.pack();
            frameForCircle.setMinimumSize(new Dimension(700, 200));
            frameForCircle.setLocationRelativeTo(null);

            // Move the JFrame down by 30 pixels
            Point currentLocation = frameForCircle.getLocation();
            frameForCircle.setLocation(currentLocation.x, currentLocation.y + 30);
        }
        frameForCircle.setVisible(true);
    }

    /**
     * This method shows the UI for the Triangle shape.
     * It creates a new JFrame object called "frameForTriangle"
     * @throws Exception if there is any exception while creating or showing the UI
     */
    private void showTriangleUI() throws Exception {
        if (frameForTriangle == null) {
            frameForTriangle = new JFrame("Triangle");
            frameForTriangle.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            // Create triangle panel
            TrianglePanel trianglePanel = new TrianglePanel();
            trianglePanel.setBackground(new Color(254, 254, 254));
            frameForTriangle.add(trianglePanel);

            // Set icon
            URL iconUrl = new URL("https://cdn-icons-png.flaticon.com/512/3810/3810071.png");
            ImageIcon icon = new ImageIcon(iconUrl);
            frameForTriangle.setIconImage(icon.getImage());

            //Set default size and center frame
            frameForTriangle.pack();
            frameForTriangle.setMinimumSize(new Dimension(700, 200));
            frameForTriangle.setLocationRelativeTo(null);

            // Move the JFrame down by 90 pixels
            Point currentLocation = frameForTriangle.getLocation();
            frameForTriangle.setLocation(currentLocation.x, currentLocation.y + 90);
        }
        frameForTriangle.setVisible(true);
    }

    /**
     * This method shows the UI for the Cylinder shape.
     * It creates a new JFrame object called "frameForCylinder"
     * @throws Exception if there is any exception while creating or showing the UI
     */
    private void showCylinderUI() throws Exception {
        if (frameForCylinder == null) {
            frameForCylinder = new JFrame("Cylinder");
            frameForCylinder.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            // Create cylinder panel
            CylinderPanel cylinderPanel = new CylinderPanel();
            cylinderPanel.setBackground(new Color(254, 254, 254));
            frameForCylinder.add(cylinderPanel);

            // Set icon
            URL iconUrl = new URL("https://cdn-icons-png.flaticon.com/512/2675/2675192.png");
            ImageIcon icon = new ImageIcon(iconUrl);
            frameForCylinder.setIconImage(icon.getImage());

            //Set default size and center frame
            frameForCylinder.pack();
            frameForCylinder.setMinimumSize(new Dimension(700, 200));
            frameForCylinder.setLocationRelativeTo(null);

            // Move the JFrame down by 70 pixels
            Point currentLocation = frameForCylinder.getLocation();
            frameForCylinder.setLocation(currentLocation.x, currentLocation.y + 70);
        }
        frameForCylinder.setVisible(true);
    }

    /**
     * This method shows the UI for the Square shape.
     * It creates a new JFrame object called "frameForSquare"
     * @throws Exception if there is any exception while creating or showing the UI
     */
    private void showSquareUI() throws Exception {
        if (frameForSquare == null) {
            frameForSquare = new JFrame("Square");
            frameForSquare.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            // Create square panel
            SquarePanel squarePanel = new SquarePanel();
            squarePanel.setBackground(new Color(254, 254, 254));
            frameForSquare.add(squarePanel);

            // Set icon
            URL iconUrl = new URL("https://cdn-icons-png.flaticon.com/128/3810/3810066.png");
            ImageIcon icon = new ImageIcon(iconUrl);
            frameForSquare.setIconImage(icon.getImage());

            //Set default size and center frame
            frameForSquare.pack();
            frameForSquare.setMinimumSize(new Dimension(700, 200));
            frameForSquare.setLocationRelativeTo(null);

            // Move the JFrame down by 30 pixels
            Point currentLocation = frameForSquare.getLocation();
            frameForSquare.setLocation(currentLocation.x, currentLocation.y + 30);

        }
        frameForSquare.setVisible(true);
    }

    /**
     * This method shows the UI for the Rectangle shape.
     * It creates a new JFrame object called "frameForRectangle"
     * @throws Exception if there is any exception while creating or showing the UI
     */
    private void showRectangleUI() throws Exception {
        if (frameForRectangle == null) {
            frameForRectangle = new JFrame("Rectangle");
            frameForRectangle.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            // Create rectangle panel
            RectanglePanel rectanglePanel = new RectanglePanel();
            rectanglePanel.setBackground(new Color(254, 254, 254));
            frameForRectangle.add(rectanglePanel);

            // Set icon
            URL iconUrl = new URL("https://cdn-icons-png.flaticon.com/512/5853/5853969.png");
            ImageIcon icon = new ImageIcon(iconUrl);
            frameForSquare.setIconImage(icon.getImage());

            //Set default size and center frame
            frameForRectangle.pack();
            frameForRectangle.setMinimumSize(new Dimension(700, 200));
            frameForRectangle.setLocationRelativeTo(null);

            // Move the JFrame down by 70 pixels
            Point currentLocation = frameForRectangle.getLocation();
            frameForRectangle.setLocation(currentLocation.x, currentLocation.y + 70);

        }
        frameForRectangle.setVisible(true);
    }

    /**
     * This method shows the UI for the Rectangular Solid shape.
     * It creates a new JFrame object called "frameForRectangularSolid"
     * @throws Exception if there is any exception while creating or showing the UI
     */
    private void showRectangularSolidUI() throws Exception {
        if (frameForRectangularSolid == null) {
            frameForRectangularSolid = new JFrame("Rectangular Solid");
            frameForRectangularSolid.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            // Create rectangular solid panel
            RectangularSolidPanel rectangularSolidPanel = new RectangularSolidPanel();
            rectangularSolidPanel.setBackground(new Color(254, 254, 254));
            frameForRectangularSolid.add(rectangularSolidPanel);

            // Set icon
            URL iconUrl = new URL(" https://cdn-icons-png.flaticon.com/512/3873/3873833.png");
            ImageIcon icon = new ImageIcon(iconUrl);
            frameForRectangularSolid.setIconImage(icon.getImage());


            //Set default size and center frame
            frameForRectangularSolid.pack();
            frameForRectangularSolid.setMinimumSize(new Dimension(700, 200));
            frameForRectangularSolid.setLocationRelativeTo(null);

            // Move the JFrame down by 70 pixels
            Point currentLocation = frameForRectangularSolid.getLocation();
            frameForRectangularSolid.setLocation(currentLocation.x, currentLocation.y + 70);

        }
        frameForRectangularSolid.setVisible(true);
    }

    /**
     * A JPanel that contains a form for calculating the area of a circle.
     * Includes a text field for entering the radius, a "Calculate" button, and a label for displaying the area.
     * When the button is clicked, the area is calculated and displayed in the label.
     * Displays an error message if the input is invalid.
     */
    private class CirclePanel extends JPanel {
        private JTextField radiusTextField;
        private JLabel areaLabel;

        public CirclePanel() {
            // Set Layout
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // Create title label
            JLabel titleLabel = new JLabel("Circle Area Calculator", JLabel.CENTER);
            titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
            titleLabel.setForeground(new Color(4, 18, 28));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(titleLabel);
            add(Box.createVerticalStrut(20));

            // Create radius input
            JLabel radiusLabel = new JLabel("Enter the radius:", JLabel.CENTER);
            radiusLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            radiusLabel.setForeground(new Color(4, 18, 28));
            radiusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(radiusLabel);
            add(Box.createVerticalStrut(10));

            radiusTextField = new JTextField(10);
            radiusTextField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            radiusTextField.setHorizontalAlignment(JTextField.CENTER);
            radiusTextField.setMaximumSize(new Dimension(300, 40));
            radiusTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(radiusTextField);
            add(Box.createVerticalStrut(20));

            // Create calculate button
            JButton calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            calculateButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double radius = Double.parseDouble(radiusTextField.getText());
                        shape = new Circle("My Circle", radius);
                        if (shape instanceof Circle) {
                            areaLabel.setText("The area of " + ((Circle) shape).toString() + " is " +
                                    ((Circle) shape).area() + " square units.");
                        } else {
                            areaLabel.setText("No circle has been instantiated.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frameForCircle, "Please enter a valid radius.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            calculateButton.setForeground(new Color(4, 18, 28));
            add(calculateButton);
            add(Box.createVerticalStrut(20));

            // Create area label
            areaLabel = new JLabel("", JLabel.CENTER);
            areaLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            areaLabel.setForeground(new Color(4, 18, 28));
            areaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(areaLabel);
            add(Box.createVerticalStrut(20));
        }
    }


    /**
     * A JPanel that contains a form for calculating the area of a triangle.
     * Includes three text fields for entering the lengths of the sides,
     * a "Calculate" button, and a label for displaying the area.
     * When the button is clicked, the area is calculated using the Heron's formula and displayed in the label.
     * Displays an error message if the input is invalid or cannot form a triangle.
     */
    public class TrianglePanel extends JPanel {
        private JTextField side1TextField;
        private JTextField side2TextField;
        private JTextField side3TextField;
        private JLabel areaLabel;

        public TrianglePanel() {
            // Set layout
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // Create title label
            JLabel titleLabel = new JLabel("Triangle Area Calculator", JLabel.CENTER);
            titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
            titleLabel.setForeground(new Color(4, 18, 28));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(titleLabel);
            add(Box.createVerticalStrut(20));

            // Create side1 input
            JLabel side1Label = new JLabel("Enter side 1:", JLabel.CENTER);
            side1Label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            side1Label.setForeground(new Color(4, 18, 28));
            side1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(side1Label);
            add(Box.createVerticalStrut(10));

            side1TextField = new JTextField(10);
            side1TextField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            side1TextField.setMaximumSize(new Dimension(300, 40));
            side1TextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            side1TextField.setHorizontalAlignment(JTextField.CENTER);
            add(side1TextField);
            add(Box.createVerticalStrut(20));

            // Create side2 input
            JLabel side2Label = new JLabel("Enter side 2:", JLabel.CENTER);
            side2Label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            side2Label.setForeground(new Color(4, 18, 28));
            side2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(side2Label);
            add(Box.createVerticalStrut(10));
            side2TextField = new JTextField(10);
            side2TextField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            side2TextField.setMaximumSize(new Dimension(300, 40));
            side2TextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            side2TextField.setHorizontalAlignment(JTextField.CENTER);
            add(side2TextField);
            add(Box.createVerticalStrut(20));

            // Create side3 input
            JLabel side3Label = new JLabel("Enter side 3:", JLabel.CENTER);
            side3Label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            side3Label.setForeground(new Color(4, 18, 28));
            add(side3Label);
            add(Box.createVerticalStrut(10));

            side3TextField = new JTextField(10);
            side3TextField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            side3TextField.setMaximumSize(new Dimension(300, 40));
            side3TextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            side3TextField.setHorizontalAlignment(JTextField.CENTER);
            add(side3TextField);
            add(Box.createVerticalStrut(20));

            // Create calculate button
            JButton calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double side1 = Double.parseDouble(side1TextField.getText());
                        double side2 = Double.parseDouble(side2TextField.getText());
                        double side3 = Double.parseDouble(side3TextField.getText());
                        shape = new Triangle("My Triangle", side1, side2, side3);
                        if (shape instanceof Triangle) {
                            areaLabel.setText("The area of " + ((Triangle) shape).toString() + " is " +
                                    ((Triangle) shape).area() + " square units.");
                        } else {
                            areaLabel.setText("No triangle has been instantiated.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frameForTriangle, "Please enter valid values for" +
                                " all three sides.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(frameForTriangle, ex.getMessage(), "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            add(calculateButton);
            calculateButton.setForeground(new Color(4, 18, 28)); // Set font color
            add(Box.createVerticalStrut(20));

            // Create area label
            areaLabel = new JLabel("", JLabel.CENTER);
            areaLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            areaLabel.setForeground(new Color(4, 18, 28)); // Set font color
            areaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(areaLabel);
            add(Box.createVerticalStrut(20));
        }
    }

    /**
     * A JPanel that contains a form for calculating the volume of a cylinder.
     * Includes two text fields for entering the radius and height,
     * a "Calculate" button, and a label for displaying the volume.
     * When the button is clicked, the volume is calculated and displayed in the label.
     * Displays an error message if the input is invalid.
     */
    public class CylinderPanel extends JPanel {
        private JTextField radiusTextField;
        private JTextField heightTextField;
        private JLabel volumeLabel;

        public CylinderPanel() {
            // Set layout
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // Create title label
            JLabel titleLabel = new JLabel("Cylinder Volume Calculator", JLabel.CENTER);
            titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
            titleLabel.setForeground(new Color(4, 18, 28));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(titleLabel);
            add(Box.createVerticalStrut(20));

            // Create radius input
            JLabel radiusLabel = new JLabel("Enter radius:", JLabel.CENTER);
            radiusLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            radiusLabel.setForeground(new Color(4, 18, 28));
            radiusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(radiusLabel);
            add(Box.createVerticalStrut(10));

            radiusTextField = new JTextField(10);
            radiusTextField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            radiusTextField.setMaximumSize(new Dimension(300, 40));
            radiusTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            radiusTextField.setHorizontalAlignment(JTextField.CENTER);
            add(radiusTextField);
            add(Box.createVerticalStrut(20));

            // Create height input
            JLabel heightLabel = new JLabel("Enter height:", JLabel.CENTER);
            heightLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            heightLabel.setForeground(new Color(4, 18, 28));
            heightLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(heightLabel);
            add(Box.createVerticalStrut(10));

            heightTextField = new JTextField(10);
            heightTextField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            heightTextField.setMaximumSize(new Dimension(300, 40));
            heightTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            heightTextField.setHorizontalAlignment(JTextField.CENTER);
            add(heightTextField);
            add(Box.createVerticalStrut(20));

            // Create calculate button
            JButton calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double radius = Double.parseDouble(radiusTextField.getText());
                        double height = Double.parseDouble(heightTextField.getText());
                        Cylinder cylinder = new Cylinder("Cylinder", radius, height);
                        volumeLabel.setText("The volume of " + cylinder.toString() + " is " +
                                cylinder.volume() + " cubic units.");

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(CylinderPanel.this, "Please enter" +
                                " valid numbers for radius and height.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            add(calculateButton);
            calculateButton.setForeground(new Color(4, 18, 28));
            add(Box.createVerticalStrut(20));

            // Create volume label
            volumeLabel = new JLabel("", JLabel.CENTER);
            volumeLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            volumeLabel.setForeground(new Color(4, 18, 28));
            volumeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(volumeLabel);
            add(Box.createVerticalStrut(20));
        }
    }

    /**
     * A JPanel that contains a form for calculating the area of a square.
     * Includes a text field for entering the side length,
     * a "Calculate" button, and a label for displaying the area.
     * When the button is clicked, the area is calculated and displayed in the label.
     * Displays an error message if the input is invalid.
     */
        private class SquarePanel extends JPanel {
            private JTextField sideLengthTextField;
            private JLabel areaLabel;

            public SquarePanel() {
                // Set layout
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                // Create title label
                JLabel titleLabel = new JLabel("Square Area Calculator", JLabel.CENTER);
                titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
                titleLabel.setForeground(new Color(4, 18, 28));
                titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(titleLabel);
                add(Box.createVerticalStrut(20));

                // Create side length input
                JLabel sideLengthLabel = new JLabel("Enter side length:", JLabel.CENTER);
                sideLengthLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
                sideLengthLabel.setForeground(new Color(4, 18, 28));
                sideLengthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(sideLengthLabel);
                add(Box.createVerticalStrut(10));

                sideLengthTextField = new JTextField(10);
                sideLengthTextField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
                sideLengthTextField.setMaximumSize(new Dimension(300, 40));
                sideLengthTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
                sideLengthTextField.setHorizontalAlignment(JTextField.CENTER);
                add(sideLengthTextField);
                add(Box.createVerticalStrut(20));

                // Create calculator button
                JButton calculateButton = new JButton("Calculate");
                calculateButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                calculateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            double sideLength = Double.parseDouble(sideLengthTextField.getText());
                            shape = new Square("Square", sideLength);
                            if (shape instanceof Square) {
                                areaLabel.setText("The area of " + ((Square) shape).toString() + " is " +
                                        ((Square) shape).area() + " square units.");
                            } else {
                                areaLabel.setText("No square has been instantiated.");
                            }

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frameForSquare, "Please enter a valid side length.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                add(calculateButton);
                calculateButton.setForeground(new Color(4, 18, 28));
                add(Box.createVerticalStrut(20));

                // Create area label
                areaLabel = new JLabel("", JLabel.CENTER);
                areaLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
                areaLabel.setForeground(new Color(4, 18, 28));
                areaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(areaLabel);
                add(Box.createVerticalStrut(20));
            }
        }

    /**
     * A JPanel that contains a form for calculating the area of a rectangle.
     * Includes two text fields for entering the width and height,
     * a "Calculate" button, and a label for displaying the area.
     * When the button is clicked, the area is calculated and displayed in the label.
     * Displays an error message if the input is invalid.
     */
    public class RectanglePanel extends JPanel {
        private JTextField widthTextField;
        private JTextField heightTextField;
        private JLabel areaLabel;

        public RectanglePanel() {
            // Set layout
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // Create title label
            JLabel titleLabel = new JLabel("Rectangle Area Calculator", JLabel.CENTER);
            titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
            titleLabel.setForeground(new Color(4, 18, 28));
            add(titleLabel);
            add(Box.createVerticalStrut(20));

            // Create width input
            JLabel widthLabel = new JLabel("Enter width:", JLabel.CENTER);
            widthLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            widthLabel.setForeground(new Color(4, 18, 28));
            widthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(widthLabel);
            add(Box.createVerticalStrut(10));

            widthTextField = new JTextField(10);
            widthTextField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            widthTextField.setHorizontalAlignment(JTextField.CENTER);
            widthTextField.setMaximumSize(new Dimension(300, 40));
            widthTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(widthTextField);
            add(Box.createVerticalStrut(20));

            // Create height input
            JLabel heightLabel = new JLabel("Enter height:", JLabel.CENTER);
            heightLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            heightLabel.setForeground(new Color(4, 18, 28));
            add(heightLabel);
            add(Box.createVerticalStrut(10));

            heightTextField = new JTextField(10);
            heightTextField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            heightTextField.setHorizontalAlignment(JTextField.CENTER);
            heightTextField.setMaximumSize(new Dimension(300, 40));
            heightTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(heightTextField);
            add(Box.createVerticalStrut(20));

            // Create calculate button
            JButton calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            calculateButton.addActionListener(e -> {
                try {
                    double width = Double.parseDouble(widthTextField.getText());
                    double height = Double.parseDouble(heightTextField.getText());
                    shape = new Rectangle("Rectangle", width, height);
                    if (shape instanceof Rectangle) {
                        areaLabel.setText("The area of " + ((Rectangle) shape) + " is " +
                                ((Rectangle) shape).area() + " square units.");
                    } else {
                        areaLabel.setText("No rectangle has been instantiated.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frameForRectangle, "Please enter valid values" +
                            " for width and height.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            add(calculateButton);
            calculateButton.setForeground(new Color(4, 18, 28));
            add(Box.createVerticalStrut(20));

            // Create area label
            areaLabel = new JLabel("", JLabel.CENTER);
            areaLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            areaLabel.setForeground(new Color(4, 18, 28));
            areaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(areaLabel);
            add(Box.createVerticalStrut(20));
        }
    }

    /**
     * A JPanel that contains a form for calculating the volume of a rectangular solid.
     * Includes three text fields for entering the length, width, and height,
     * a "Calculate" button, and a label for displaying the volume.
     * When the button is clicked, the volume is calculated and displayed in the label.
     * Displays an error message if the input is invalid.
     */
    public class RectangularSolidPanel extends JPanel {
        private RectangularSolid shape;
        private JTextField lengthTextField;
        private JTextField widthTextField;
        private JTextField heightTextField;
        private JLabel volumeLabel;

        public RectangularSolidPanel() {
            // Set layout
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // Create title label
            JLabel titleLabel = new JLabel("Rectangular Solid Volume Calculator", JLabel.CENTER);
            titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
            titleLabel.setForeground(new Color(4, 18, 28));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(titleLabel);
            add(Box.createVerticalStrut(20));

            // Create length input
            JLabel lengthLabel = new JLabel("Enter length:", JLabel.CENTER);
            lengthLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            lengthLabel.setForeground(new Color(4, 18, 28));
            lengthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(lengthLabel);
            add(Box.createVerticalStrut(10));

            lengthTextField = new JTextField(10);
            lengthTextField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            lengthTextField.setMaximumSize(new Dimension(300, 40));
            lengthTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            lengthTextField.setHorizontalAlignment(JTextField.CENTER);
            add(lengthTextField);
            add(Box.createVerticalStrut(20));

            // Create width input
            JLabel widthLabel = new JLabel("Enter width:", JLabel.CENTER);
            widthLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            widthLabel.setForeground(new Color(4, 18, 28));
            widthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(widthLabel);
            add(Box.createVerticalStrut(10));

            widthTextField = new JTextField(10);
            widthTextField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            widthTextField.setMaximumSize(new Dimension(300, 40));
            widthTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            widthTextField.setHorizontalAlignment(JTextField.CENTER);
            add(widthTextField);
            add(Box.createVerticalStrut(20));

            // Create height input
            JLabel heightLabel = new JLabel("Enter height:", JLabel.CENTER);
            heightLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            heightLabel.setForeground(new Color(4, 18, 28));
            heightLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(heightLabel);
            add(Box.createVerticalStrut(10));

            heightTextField = new JTextField(10);
            heightTextField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            heightTextField.setMaximumSize(new Dimension(300, 40));
            heightTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
            heightTextField.setHorizontalAlignment(JTextField.CENTER);
            add(heightTextField);
            add(Box.createVerticalStrut(20));

            // Create calculate button
            JButton calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            calculateButton.addActionListener(e -> {
                try {
                    double length = Double.parseDouble(lengthTextField.getText());
                    double width = Double.parseDouble(widthTextField.getText());
                    double height = Double.parseDouble(heightTextField.getText());
                    shape = new RectangularSolid("My Rectangular Solid", length, width, height);
                    volumeLabel.setText("The volume of " + shape + " is "
                            + shape.volume() + " cubic units.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(RectangularSolidPanel.this,
                            "Please enter valid values for length, width, and height.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            add(calculateButton);
            calculateButton.setForeground(new Color(4, 18, 28));
            add(Box.createVerticalStrut(20));

            // Create volume label
            volumeLabel = new JLabel("", JLabel.CENTER);
            volumeLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            volumeLabel.setForeground(new Color(4, 18, 28));
            volumeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(volumeLabel);
        }

        /**
         * This method is the entry point of the program. It creates a new instance of the "RagudosHannahTester2" class
         * and runs it on the Event Dispatch Thread (EDT) using the SwingUtilities.invokeLater() method.
         * If an exception occurs during the creation of the instance, it prints the stack trace to the console.
         */
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                try {
                    new RagudosHannahTester2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

