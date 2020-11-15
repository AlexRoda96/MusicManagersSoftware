import com.musicmanagerssoftware.gui.controllers.MainController;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.gui.views.MainView;

public class Main {

    public static void main(final String[] args) throws Exception {
       MainView view = new MainView();
       Model model = new Model();
       MainController controller = new MainController(view,model);
    }
}