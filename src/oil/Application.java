package oil;

import javax.swing.*;


public class Application extends JFrame {

    private String ingredients;

    public Application() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        setTitle("Palm oil translator");
        setIconImage(new ImageIcon("src/oil/orangutan.png").getImage());
        setLocationRelativeTo(null);

        changePage(Pages.FIRST_PAGE);
    }

    private void changePage(Pages newPage) {
            JPanel newPanel = new FirstPage(e -> changePage(Pages.SECOND_PAGE));

            switch (newPage) {
                case FIRST_PAGE -> newPanel = new FirstPage(e -> changePage(Pages.SECOND_PAGE));
                case SECOND_PAGE -> newPanel = new SecondPage(e -> changePage(Pages.THIRD_PAGE), this::setIngredients);
                case THIRD_PAGE -> newPanel = new ThirdPage(e -> changePage(Pages.SECOND_PAGE), ingredients);
                default -> System.out.println("Something failed!");
            }

        setContentPane(newPanel);

        newPanel.revalidate();
        newPanel.repaint();

        setVisible(true);
    }

    private void setIngredients(String newIngredients){
        ingredients = newIngredients;
    }
}


