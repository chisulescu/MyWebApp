package ro.gebs.myproject.client.person.presenter;

import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import ro.gebs.myproject.shared.user.User;

public class PersonPresenter implements Presenter {

    private User user;
    private Display display;

    public interface Display{

        public void clear();
        public void setName(String name);
        public Widget asWidget();
        public  void setPresenter(PersonPresenter presenter);

    }


    public PersonPresenter(User user, Display display){

        this.user=user;
        this.display=display;

        bind();
    }

    @Override
    public void go(Panel panel) {

        panel.add(display.asWidget());

    }


    @Override
    public void bind() {

        display.setPresenter(this);
        display.setName(user.getNume());

    }

    public void showFullName() {
        display.setName(user.getFullName());
    }

    public void clearDisplay() {display.clear();}
}
