package boundaries.swing;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import model.User;

public class UserListWindow extends JFrame {

    private static final String WINDOW_TITLE = "User List";

    private static final long serialVersionUID = 1L;

    private ChatGUI chatGUI = ChatGUI.getInstance();
    private JList<User> usersList;
    private JLabel myName;

    public UserListWindow() {
        initComponents();
    }

    private void initComponents() {
        JPanel header = initHeaderComponents();
        initListComponents();

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(header);
        this.add(usersList);
        this.pack();
        this.setVisible(true);
        this.setTitle(WINDOW_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel initHeaderComponents() {
        // TODO : getname from welcomewindow
        myName = new JLabel("An");
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        header.add(new JLabel("Welcome back,"), BorderLayout.PAGE_START);
        header.add(myName, BorderLayout.LINE_START);
        return header;
    }

    private void initListComponents() {
        User[] users = {new User("pokemon"), new User("pikachu")};
        usersList = new JList<User>(users);
        usersList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = usersList.locationToIndex(e.getPoint());
                    chatGUI.createChatWindow(usersList.getModel().getElementAt(index))
;
                }
            }
        });
    }

}
